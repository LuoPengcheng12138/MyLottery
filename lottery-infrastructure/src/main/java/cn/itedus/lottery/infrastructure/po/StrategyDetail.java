package cn.itedus.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StrategyDetail {
    // 自增ID
    private Long id;

    // 策略ID
    private Long strategyId;

    // 奖品ID
    private String awardId;

    //奖品名称
    private String awardName;

    // 奖品库存
    private String awardCount;

    //奖品剩余库存
    private Integer awardSurplusCount;

    // 中奖概率
    private BigDecimal awardRate;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date updateTime;
}
