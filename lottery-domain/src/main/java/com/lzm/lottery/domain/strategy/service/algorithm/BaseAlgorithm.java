package com.lzm.lottery.domain.strategy.service.algorithm;

import com.lzm.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseAlgorithm implements IDrawAlgorithm{

    /** Fibonacci Hash Increment to avoid the hash collision
     * (√5 - 1) / 2 = 0.6180339887, Math.pow(2, 32) * 0.6180339887 = 0x61c88647
      */

    private final int HASH_INCREMENT = 0x61c88647;

    /**
     * the initial size of the array
     */
    private final int RATE_TUPLE_LENGTH = 128;

    /**
     *  store rateTuple strategyId -> rateTuple
     */
    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    /** reward interval, strategyId -> [awardId -> begin, awardId -> end]
     */
    protected  Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();


    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateInfoMap.put(strategyId, awardRateInfoList);
        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();

            // adding the interval recursively
            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }

            cursorVal += rateVal;
        }
    }

        /**
         * Fibonacci Hash，to compute the index
         *
         * @param val value
         * @return index
         */
        protected  int hashIdx(int val) {
            int hashcode = val * HASH_INCREMENT + HASH_INCREMENT;
            return hashcode & (RATE_TUPLE_LENGTH - 1);
        }

    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return rateTupleMap.containsKey(strategyId);
    }

    /**
     * generate 100 lottery code randomly
     */
    protected int generateSecureRandomIntCode(int bound) {
        return new SecureRandom().nextInt(bound) + 1;
    }

  


}
