package cn.itedus.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:变更活动状态对象
 * @author：Luopc
 * @date: 2024/11/28
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlterStateVO {
    /** 活动ID */
    private Long activityId;

    /** 更新前状态 */
    private Integer beforeState;

    /** 更新后状态 */
    private Integer afterState;

    @Override
    public String toString() {
        return "AlterStateVO{" +
                "activityId=" + activityId +
                ", beforeState=" + beforeState +
                ", afterState=" + afterState +
                '}';
    }
}


