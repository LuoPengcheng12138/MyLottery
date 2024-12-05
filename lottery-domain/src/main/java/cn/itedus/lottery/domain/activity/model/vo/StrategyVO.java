package cn.itedus.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @description:策略配置
 * @author：Luopc
 * @date: 2024/11/28
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StrategyVO {

    /*** 策略ID*/
    private Long strategyId;

    /*** 策略描述*/
    private String strategyDesc;

    /*** 策略方式「1:单项概率、2:总体概率」*/
    private Integer strategyMode;

    /*** 发放奖品方式「1:即时、2:定时[含活动结束]、3:人工」*/
    private Integer grantType;

    /*** 发放奖品时间*/
    private Date grantDate;

    /*** 扩展信息*/
    private String extInfo;

    /*** 策略详情配置*/
    private List<StrategyDetailVO> strategyDetailList;

    @Override
    public String toString() {
        return "StrategyVO{" +
                "strategyId=" + strategyId +
                ", strategyDesc='" + strategyDesc + '\'' +
                ", strategyMode=" + strategyMode +
                ", grantType=" + grantType +
                ", grantDate=" + grantDate +
                ", extInfo='" + extInfo + '\'' +
                '}';
    }

}


