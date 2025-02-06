package cn.itedus.lottery.domain.award.service.goods;

import cn.itedus.lottery.domain.award.repository.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;


/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/28
 */
public class DistributionBase {
    protected Logger logger= LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IOrderRepository awardRepository;

    protected void updateUserAwardState(String uId,String orderId,String awardId,Integer awardState,String awardStateInfo){
        //TODO 后期添加：更新分库分表的用户个人的抽奖记录表中的奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uId：{}", uId);
    }

}


