package cn.itedus.lottery.infrastructure.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 活动基础信息表
 * <p>
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@Getter
@Setter
public class Activity {

    // 自增ID
    private Long id;

    // 活动ID
    private Long activityId;

    // 活动名称
    private String activityName;

    // 活动描述
    private String activityDesc;

    // 开始时间
    private Date beginDateTime;

    // 结束时间
    private Date endDateTime;

    // 库存
    private Integer stockCount;

    // 每人可参与次数
    private Integer takeCount;

    // 活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启
    private Integer state;

    // 创建人
    private String creator;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date updateTime;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setActivityId(Long activityId) {
//        this.activityId = activityId;
//    }
//
//    public void setActivityName(String activityName) {
//        this.activityName = activityName;
//    }
//
//    public void setActivityDesc(String activityDesc) {
//        this.activityDesc = activityDesc;
//    }
//
//    public void setBeginDateTime(Date beginDateTime) {
//        this.beginDateTime = beginDateTime;
//    }
//
//    public void setEndDateTime(Date endDateTime) {
//        this.endDateTime = endDateTime;
//    }
//
//    public void setStockCount(Integer stockCount) {
//        this.stockCount = stockCount;
//    }
//
//    public void setTakeCount(Integer takeCount) {
//        this.takeCount = takeCount;
//    }
//
//    public void setState(Integer state) {
//        this.state = state;
//    }
//
//    public void setCreator(String creator) {
//        this.creator = creator;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
}
