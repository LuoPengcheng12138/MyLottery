package cn.itedus.lottery.application.process.req;
import lombok.*;


/**
 * @description:抽奖请求
 * @author：Luopc
 * @date: 2025/2/6
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DrawProcessReq {
    /** 用户ID */
    private String uId;
    /** 活动ID */
    private Long activityId;

}


