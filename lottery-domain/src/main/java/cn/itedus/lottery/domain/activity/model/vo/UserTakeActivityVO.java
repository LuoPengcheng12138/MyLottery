package cn.itedus.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:用户领取活动记录
 * @author：Luopc
 * @date: 2025/2/7
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserTakeActivityVO {
    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动单使用状态 0未使用、1已使用
     * Constants.TaskState
     */
    private Integer state;

    @Override
    public String toString() {
        return "UserTakeActivityVO{" +
                "activityId=" + activityId +
                ", takeId=" + takeId +
                ", strategyId=" + strategyId +
                ", state=" + state +
                '}';
    }

}


