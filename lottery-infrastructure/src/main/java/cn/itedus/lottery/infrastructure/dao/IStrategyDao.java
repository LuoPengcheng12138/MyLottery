package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {
    //查询策略配置
    Strategy queryStrategy(Long strategyId);

    //插入策略配置
    void insert(Strategy req);
}
