package cn.itedus.lottery.domain.strategy.service.algorithm.impl;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds){
        // 用于存储不在抽奖范围内的奖品的总概率值
        BigDecimal differenceDenominator = BigDecimal.ZERO;
        //排除不在抽奖范围的奖品后的集合
        List<AwardRateInfo> differenceAwardRateList=new ArrayList<>();
        // 获取该策略下所有奖品的概率信息
        List<AwardRateInfo> awardRateIntervalList=awardRateInfoMap.get(strategyId);

        for(AwardRateInfo awardRateInfo:awardRateIntervalList){
            String awardId=awardRateInfo.getAwardId();
            if(excludeAwardIds.contains(awardId)){
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator=differenceDenominator.add(awardRateInfo.getAwardRate());
        }
        //前置判断：如果没有可抽奖品，直接返回空字符串;如果只有一个可抽奖品，直接返回该奖品ID
        if(differenceAwardRateList.size()==0) return "";
        if(differenceAwardRateList.size()==1) return differenceAwardRateList.get(0).getAwardId();

        SecureRandom secureRandom=new SecureRandom();
        int randomVal=secureRandom.nextInt(100)+1;

        //循环获取奖品
        String awardId="";
        int cursorVal=0;
        for(AwardRateInfo awardRateInfo:differenceAwardRateList){
            int rateVal=awardRateInfo.getAwardRate().divide(differenceDenominator,2,BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if(randomVal<=cursorVal+rateVal){
                awardId=awardRateInfo.getAwardId();
                break;
            }
            cursorVal+=rateVal;
        }
        return awardId;

    }
}
