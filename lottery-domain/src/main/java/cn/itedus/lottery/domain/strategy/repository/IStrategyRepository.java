package cn.itedus.lottery.domain.strategy.repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVO;


import java.util.List;

public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    AwardBriefVO queryAwardinfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    boolean deductStock(Long strategyId, String awardId);


}
