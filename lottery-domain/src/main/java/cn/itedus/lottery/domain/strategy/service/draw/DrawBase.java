package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

public class DrawBase extends DrawConfig{
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList){

        IDrawAlgorithm drawAlgorithm=drawAlgorithmMap.get(strategyMode);

        boolean isExistRateTuple=drawAlgorithm.isExistRateTuple(strategyId);
        if(isExistRateTuple) return;

        List<AwardRateInfo> awardRateInfoList=new ArrayList<>(strategyDetailList.size());
        for(StrategyDetail strategyDetail:strategyDetailList){
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(),strategyDetail.getAwardRate()));
        }

        //DefaultRateRandomDrawAlgorithm不需要初始化元组
        //还是需要初始化，不然会报错
        //if(1!=strategyMode) return;
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}
