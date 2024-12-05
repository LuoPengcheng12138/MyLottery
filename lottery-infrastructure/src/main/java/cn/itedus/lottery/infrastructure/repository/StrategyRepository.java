package cn.itedus.lottery.infrastructure.repository;

import ch.qos.logback.classic.jmx.MBeanUtil;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVO;
import cn.itedus.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.itedus.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import cn.itedus.lottery.domain.strategy.repository.IStrategyRepository;
import cn.itedus.lottery.infrastructure.dao.IAwardDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

@Component
public class StrategyRepository implements IStrategyRepository {
    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId){
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList=strategyDetailDao.queryStrategyDetailList(strategyId);

        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOList.add(strategyDetailBriefVO);
        }

        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOList);

    }
    @Override
    public AwardBriefVO queryAwardinfo(String awardId){
        Award award= awardDao.queryAwardInfo(awardId);
        AwardBriefVO awardBriefVO=new AwardBriefVO();
        BeanUtils.copyProperties(award,awardBriefVO);
        return awardBriefVO;
    }
    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId){
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId){
        StrategyDetail req=new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        int count= strategyDetailDao.deductStock(req);
        return 1==count;

    }


}
