package cn.itedus.lottery.application.process.impl;

import cn.itedus.lottery.application.process.IActivityProcess;
import cn.itedus.lottery.application.process.req.DrawProcessReq;
import cn.itedus.lottery.application.process.res.DrawProcessResult;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.itedus.lottery.domain.activity.service.partake.IActivityPartake;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.itedus.lottery.domain.strategy.service.draw.IDrawExec;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:活动抽奖流程编排
 * @author：Luopc
 * @date: 2025/2/6
 */
@Service
public class ActivityProcessImpl implements IActivityProcess {
    @Resource
    private IActivityPartake activityPartake;
    @Resource
    private IDrawExec drawExec;
    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req){
        //1、领取活动
        PartakeResult partakeResult = activityPartake.doPartake(new PartakeReq(req.getUId(), req.getActivityId()));
        //  失败返回错误信息
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(partakeResult.getCode())) {
            return new DrawProcessResult(partakeResult.getCode(), partakeResult.getInfo());
        }
        Long strategyId = partakeResult.getStrategyId();
        Long takeId = partakeResult.getTakeId();

        // 2. 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq(req.getUId(), strategyId, String.valueOf(takeId)));
        if (Constants.DrawState.FAIL.getCode().equals(drawResult.getDrawState())) {
            return new DrawProcessResult(Constants.ResponseCode.LOSING_DRAW.getCode(), Constants.ResponseCode.LOSING_DRAW.getInfo());
        }
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();

        // 3. 结果落库
        activityPartake.recordDrawOrder(buildDrawOrderVO(req, strategyId, takeId, drawAwardInfo));

        // 4. 发送MQ，触发发奖流程

        // 5. 返回结果
        return new DrawProcessResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), drawAwardInfo);

    }

    private DrawOrderVO buildDrawOrderVO(DrawProcessReq req, Long strategyId, Long takeId, DrawAwardInfo drawAwardInfo) {
        long orderId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        DrawOrderVO drawOrderVO = new DrawOrderVO();
        drawOrderVO.setUId(req.getUId());
        drawOrderVO.setTakeId(takeId);
        drawOrderVO.setActivityId(req.getActivityId());
        drawOrderVO.setOrderId(orderId);
        drawOrderVO.setStrategyId(strategyId);
        drawOrderVO.setStrategyMode(drawAwardInfo.getStrategyMode());
        drawOrderVO.setGrantType(drawAwardInfo.getGrantType());
        drawOrderVO.setGrantDate(drawAwardInfo.getGrantDate());
        drawOrderVO.setGrantState(Constants.GrantState.INIT.getCode());
        drawOrderVO.setAwardId(drawAwardInfo.getAwardId());
        drawOrderVO.setAwardType(drawAwardInfo.getAwardType());
        drawOrderVO.setAwardName(drawAwardInfo.getAwardName());
        drawOrderVO.setAwardContent(drawAwardInfo.getAwardContent());
        return drawOrderVO;
    }

}


