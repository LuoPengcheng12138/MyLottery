package cn.itedus.lottery.domain.activity.repository;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.vo.*;

import java.util.List;

/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/28
 */
public interface IActivityRepository {
    //添加活动配置
    void addActivity(ActivityVO activity);

    //添加奖品配置集合
    void addAward(List<AwardVO> awardList);

    //添加策略配置
    void addStrategy(StrategyVO strategy);

    //添加策略明细配置
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    //变更活动状态
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState);

    //查询活动账单信息【库存、状态、日期、个人参与次数】
    ActivityBillVO queryActivityBill(PartakeReq req);

    //扣减活动库存
    int subtractionActivityStock(Long activityId);

}
