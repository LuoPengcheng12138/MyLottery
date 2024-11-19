package cn.itedus.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Award {
    //自增id
    private Long id;

    //奖品id
    private String awardId;

    //奖品类型（文字描述/兑换码/优惠券/实物）
    private Integer awardType;

    //奖品数量
    private Integer awardCount;

    //奖品名称
    private String awardName;

    //奖品内容（文字描述/key/码）
    private String awardContent;
    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;





}
