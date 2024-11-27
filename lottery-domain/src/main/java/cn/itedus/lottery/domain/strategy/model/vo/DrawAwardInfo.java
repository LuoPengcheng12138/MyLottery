package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/19
 */
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


}


