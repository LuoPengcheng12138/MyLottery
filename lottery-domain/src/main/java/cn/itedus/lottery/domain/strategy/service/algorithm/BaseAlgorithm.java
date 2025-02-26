package cn.itedus.lottery.domain.strategy.service.algorithm;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Luopc
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm {
    // 斐波那契散列增量，逻辑：黄金分割点：(√5 - 1) / 2 = 0.6180339887，Math.pow(2, 32) * 0.6180339887 = 0x61c88647
    private final int HASH_INCREMENT = 0x61c88647;

    // 数组初始化长度
    private final int RATE_TUPLE_LENGTH = 128;

    // 存放概率与奖品对应的散列结果，strategyId -> rateTuple
    protected Map<Long,String[]> rateTupleMap=new ConcurrentHashMap<>();

    // 奖品区间概率值，strategyId -> [awardId->begin、awardId->end]
    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap=new ConcurrentHashMap<>();

    @Override
    public synchronized void initRateTuple(Long strategyId, Integer strategyMode, List<AwardRateInfo> awardRateInfoList){
        // 前置判断
        if (isExist(strategyId)){
            return;
        }
        // 保存奖品概率信息
        awardRateInfoMap.put(strategyId,awardRateInfoList);

        // 非单项概率，不必存入缓存，因为这部分抽奖算法需要实时处理中奖概率。
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }

        String[] rateTuple=rateTupleMap.computeIfAbsent(strategyId,k->new String[RATE_TUPLE_LENGTH]);

        int cursorVal=0;
        for(AwardRateInfo awardRateInfo:awardRateInfoList){
            int rateVal=awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();
            //循环填充
            for(int i=cursorVal+1;i<=cursorVal+rateVal;i++){
                rateTuple[hashIdx(i)]=awardRateInfo.getAwardId();
            }

            cursorVal+=rateVal;
        }

    }

    @Override
    public boolean isExist(Long StrategyId){
        return awardRateInfoMap.containsKey(StrategyId);
    }


    protected int hashIdx(int val){
        int hashCode=val*HASH_INCREMENT+HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }

    protected int generateSecureRandomIntCode(int bound){
        return new SecureRandom().nextInt(bound)+1;
    }

}
