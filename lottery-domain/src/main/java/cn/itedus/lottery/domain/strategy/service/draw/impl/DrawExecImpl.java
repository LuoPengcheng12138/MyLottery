package cn.itedus.lottery.domain.strategy.service.draw.impl;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.repository.IStrategyRepository;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.service.draw.AbstractDrawBase;
import cn.itedus.lottery.domain.strategy.service.draw.IDrawExec;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId){
        List<String> awardList=strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("执行抽奖策略 strategyId：{}，无库存排除奖品列表ID集合 awardList：{}", strategyId, JSON.toJSONString(awardList));
        return awardList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds){
        //执行抽奖
        String awardId=drawAlgorithm.randomDraw(strategyId,excludeAwardIds);

        //判断抽奖结果
        if(null==awardId){
            return null;
        }
        //数据库行级锁的方式进行扣减库存
        boolean isSuccess=strategyRepository.deductStock(strategyId,awardId);

        return isSuccess?awardId:null;
    }





}
