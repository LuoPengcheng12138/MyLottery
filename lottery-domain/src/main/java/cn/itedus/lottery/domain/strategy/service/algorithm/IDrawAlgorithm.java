package cn.itedus.lottery.domain.strategy.service.algorithm;

import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

public interface IDrawAlgorithm {
    //程序启动时初始化概率元祖
    void initRateTuple(Long strategyId,Integer strategyMode, List<AwardRateInfo> awardRateInfoList);

    //判断是否已经，做了数据初始化
    boolean isExist(Long StrategyId);

    //生成随机数，索引到对应的奖品信息返回结果
    String randomDraw(Long strategyId,List<String> excludeAwardIds);
}
