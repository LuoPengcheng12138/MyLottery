package cn.itedus.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @description:策略详情配置
 * @author：Luopc
 * @date: 2024/11/28
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StrategyDetailVO {
    /*** 策略ID*/
    private Long strategyId;

    /*** 奖品ID*/
    private String awardId;

    /*** 奖品名称*/
    private String awardName;

    /*** 奖品库存*/
    private Integer awardCount;

    /*** 奖品剩余库存*/
    private Integer awardSurplusCount;

    /*** 中奖概率*/
    private BigDecimal awardRate;

    @Override
    public String toString() {
        return "StrategyDetailVO{" +
                "strategyId=" + strategyId +
                ", awardId='" + awardId + '\'' +
                ", awardName='" + awardName + '\'' +
                ", awardCount=" + awardCount +
                ", awardSurplusCount=" + awardSurplusCount +
                ", awardRate=" + awardRate +
                '}';
    }
}


