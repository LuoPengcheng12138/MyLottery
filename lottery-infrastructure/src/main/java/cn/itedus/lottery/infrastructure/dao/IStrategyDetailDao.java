package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IStrategyDetailDao {
    //查询策略表详细配置
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    //查询无库存策略奖品ID
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    //扣减库存
    int deductStock(StrategyDetail strategyDetailReq);

}
