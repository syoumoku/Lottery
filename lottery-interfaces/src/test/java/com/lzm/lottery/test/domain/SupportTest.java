package com.lzm.lottery.test.domain;


import com.lzm.lottery.common.Constants;
import com.lzm.lottery.domain.support.ids.IIdGenerator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest

public class SupportTest {

    private Logger logger = LoggerFactory.getLogger(SupportTest.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> IIdGeneratorMap;

    @Test
    public void test_ids() {
        logger.info("snowflake ID strategy, generating ID : {}", IIdGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        logger.info("Random ID strategy, generating ID : {}", IIdGeneratorMap.get(Constants.Ids.RandomNumeric).nextId());
        logger.info("Date ID strategy, generating ID : {}", IIdGeneratorMap.get(Constants.Ids.ShortCode).nextId());

    }
}
