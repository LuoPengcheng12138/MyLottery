package cn.itedus.lottery.domain.activity.model.req;

import cn.itedus.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/28
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActivityConfigReq {
    /** 活动ID */
    private Long activityId;

    /** 活动配置信息 */
    private ActivityConfigRich activityConfigRich;
}


