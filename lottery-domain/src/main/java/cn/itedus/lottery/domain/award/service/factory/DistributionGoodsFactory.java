package cn.itedus.lottery.domain.award.service.factory;


import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/28
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig {
    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}


