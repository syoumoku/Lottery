package com.lzm.lottery.domain.support.ids;

public interface IIdGenerator {

    /**
     * methods for generating ID, now there are three:
     * 1. snowflake for order ID
     * 2. shortcode for activity id
     * 3. random numeric for strategy ID
     *
     * @return ID
     */
    long nextId();
}
