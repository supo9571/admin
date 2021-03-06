package com.data.mapper;

import com.manager.common.core.domain.model.Coins;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author marvin 2021/8/19
 */
@Mapper
public interface CoinsMapper {

    List<Coins> selectCoins(Coins coins);

    BigDecimal selectCoinsCount(Coins coins);
}
