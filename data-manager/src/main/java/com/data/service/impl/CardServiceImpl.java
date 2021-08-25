package com.data.service.impl;

import com.data.mapper.CardMapper;
import com.data.service.CardService;
import com.manager.common.core.domain.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author marvin 2021/8/25
 */
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;
    @Override
    public List selectCard(Card card) {
        return cardMapper.selectCard(card);
    }
}