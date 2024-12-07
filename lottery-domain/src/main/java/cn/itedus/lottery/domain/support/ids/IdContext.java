package cn.itedus.lottery.domain.support.ids;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.support.ids.policy.RandomNumeric;
import cn.itedus.lottery.domain.support.ids.policy.ShortCode;
import cn.itedus.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: Id 策略模式上下文配置「在正式的完整的系统架构中，ID 的生成会有单独的服务来完成，其他服务来调用 ID 生成接口即可」
 * @author：Luopc
 * @date: 2024/12/6
 */
@Configuration
public class IdContext {
    @Resource
    private RandomNumeric randomNumeric;
    @Resource
    private SnowFlake snowFlake;
    @Resource
    private ShortCode shortCode;

    @Bean
    public Map<Constants.Ids,IIdGenerator> idGenerator() {
        Map<Constants.Ids,IIdGenerator> idGeneratorMap = new HashMap<>(8);
        idGeneratorMap.put(Constants.Ids.SnowFlake,snowFlake);
        idGeneratorMap.put(Constants.Ids.ShortCode,shortCode);
        idGeneratorMap.put(Constants.Ids.RandomNumeric,randomNumeric);
        return idGeneratorMap;
    }
}


