package com.lyl.study.portal.common.sequence;

/**
 * Snowflake算法
 *
 * @author liyilin
 */
public interface Sequence {
    long nextId();
    long nextId(String key);
}
