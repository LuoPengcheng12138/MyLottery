package cn.itedus.lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @author Luopc
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DrawResult {
    // 用户ID
    private String uId;

    // 策略ID
    private Long strategyId;

    //中奖状态：0未中奖、1已中奖、2兜底奖 Constants.DrawState
    private Integer drawState= Constants.DrawState.FAIL.getCode();

    private  DrawAwardInfo drawAwardInfo;

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }
}
