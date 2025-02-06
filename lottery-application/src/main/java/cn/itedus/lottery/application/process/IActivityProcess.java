package cn.itedus.lottery.application.process;

import cn.itedus.lottery.application.process.req.DrawProcessReq;
import cn.itedus.lottery.application.process.res.DrawProcessResult;

/**
 * @description:活动抽奖流程编排接口
 * @author：Luopc
 * @date: 2025/2/6
 */
public interface IActivityProcess {

    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
