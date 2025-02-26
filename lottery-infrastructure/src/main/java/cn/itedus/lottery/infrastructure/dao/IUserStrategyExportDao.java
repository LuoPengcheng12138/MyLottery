package cn.itedus.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.itedus.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:用户策略计算结果表DAO
 * @author：Luopc
 * @date: 2024/12/7
 */
@Mapper
@DBRouterStrategy(splitTable=true)
public interface IUserStrategyExportDao {

    @DBRouter(key="uId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByuId(String uId);

}
