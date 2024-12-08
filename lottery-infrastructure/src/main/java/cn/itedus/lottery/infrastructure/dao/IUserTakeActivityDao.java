package cn.itedus.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.itedus.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:用户领取活动表DAO
 * @author：Luopc
 * @date: 2024/12/8
 */
@Mapper
public interface IUserTakeActivityDao {

    @DBRouter(key="uId")
    void insert(UserTakeActivity userTakeActivity);
}
