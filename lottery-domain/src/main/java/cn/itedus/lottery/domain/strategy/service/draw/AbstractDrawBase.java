package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.*;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{

    private Logger logger= LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq req){

        //获取抽奖策略配置数据
        StrategyRich strategyRich=super.queryStrategyRich(req.getStrategyId());
        StrategyBriefVO strategy=strategyRich.getStrategy();
        List<StrategyDetailBriefVO> strategyDetailList=strategyRich.getStrategyDetailList();

        //校验和初始化数据
        this.checkAndInitRateData(req.getStrategyId(),strategy.getStrategyMode(),strategyDetailList);

        // 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等
        List<String> excludeAwardIds=this.queryExcludeAwardIds(req.getStrategyId());

        //执行抽奖算法
        String awardId=this.drawAlgorithm(req.getStrategyId(), drawAlgorithmGroup.get(strategy.getStrategyMode()),excludeAwardIds);

        //包装中奖结果
        return  buildDrawResult(req.getUId(), req.getStrategyId(),awardId,strategy);
    }


    //获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    //执行抽奖算法
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);





    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList){

        IDrawAlgorithm drawAlgorithm=drawAlgorithmGroup.get(strategyMode);

        // 判断已处理过的的数据
        boolean isExistRateTuple=drawAlgorithm.isExist(strategyId);
        if(isExistRateTuple) {
            return;
        }

        List<AwardRateInfo> awardRateInfoList=new ArrayList<>(strategyDetailList.size());
        for(StrategyDetailBriefVO strategyDetail:strategyDetailList){
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(),strategyDetail.getAwardRate()));
        }

        //DefaultRateRandomDrawAlgorithm不需要初始化元组
        //还是需要初始化，不然会报错
        //if(1!=strategyMode) return;
        drawAlgorithm.initRateTuple(strategyId,strategyMode, awardRateInfoList);
    }

    //包装抽奖结果
    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId, StrategyBriefVO strategy) {
        if (null == awardId) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        AwardBriefVO award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(),award.getAwardContent());
        drawAwardInfo.setStrategyMode(strategy.getStrategyMode());
        drawAwardInfo.setGrantType(strategy.getGrantType());
        drawAwardInfo.setGrantDate(strategy.getGrantDate());
        logger.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uId, strategyId, awardId, award.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }
}
