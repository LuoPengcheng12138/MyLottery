package cn.itedus.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DrawReq {
    // 用户ID
    private String uId;

    // 策略ID
    private Long strategyId;
}
