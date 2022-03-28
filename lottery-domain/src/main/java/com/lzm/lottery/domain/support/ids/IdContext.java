package com.lzm.lottery.domain.support.ids;

import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.support.ids.policy.RandomNumeric;
import com.lzm.lottery.domain.support.ids.policy.ShortCode;
import com.lzm.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class IdContext {

    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric) {
        Map<Constants.Ids, IIdGenerator> idGeneratorMap = new HashMap<>(8);
        idGeneratorMap.put(Constants.Ids.SnowFlake, snowFlake);
        idGeneratorMap.put(Constants.Ids.ShortCode, shortCode);
        idGeneratorMap.put(Constants.Ids.RandomNumeric, randomNumeric);
        return idGeneratorMap;
    }
}
