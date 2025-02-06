package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @description:中奖奖品信息
 * @author：Luopc
 * @date: 2024/11/19
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DrawAwardInfo {
    //奖品ID
    private String awardId;

    //奖品类型
    private Integer awardType;

    //奖品名称
    private String awardName;

    //奖品内容
    private String awardContent;

    //策略方式（1:单项概率、2:总体概率）
    private Integer strategyMode;

    //发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
    private Integer grantType;

    //发奖时间
    private Date grantDate;

    public DrawAwardInfo(String awardId, Integer awardType, String awardName,String awardContent) {
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }


}


