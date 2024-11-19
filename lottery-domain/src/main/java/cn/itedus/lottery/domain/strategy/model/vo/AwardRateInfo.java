package cn.itedus.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.Duration;

@AllArgsConstructor
@Getter
@Setter
public class AwardRateInfo {
    //奖品ID
    private String awardId;
    //中奖概率
    private BigDecimal awardRate;


}
