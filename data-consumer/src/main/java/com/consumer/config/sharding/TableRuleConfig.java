package com.consumer.config.sharding;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * @author marvin 2021/8/18
 * 数据表分表策略
 */
@Slf4j
public class TableRuleConfig implements PreciseShardingAlgorithm<Long>, RangeShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String tableName = preciseShardingValue.getLogicTableName() + "_";
        try {
            Long time = preciseShardingValue.getValue();
            Date date  = new Date(time);
            String year = String.format("%ty", date);
            String mon = String.format("%tm", date);
            tableName = tableName + year + mon;
            log.info(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String each : collection) {
            if (each.equals(tableName)) {
                return each;
            }
        }

        throw new IllegalArgumentException();

    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        Range<Long> range = rangeShardingValue.getValueRange();
        Long lower = range.lowerEndpoint();
        Long upper = range.upperEndpoint();

        Date lowDate  = new Date(lower);
        String lowMon = String.format("%tm", lowDate);

        Date upDate  = new Date(upper);
        String upMon = String.format("%tm", upDate);

        for (int i = Integer.valueOf(lowMon); i <= Integer.valueOf(upMon); i++) {
            for (String each : collection) {
                if (each.endsWith(i + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}