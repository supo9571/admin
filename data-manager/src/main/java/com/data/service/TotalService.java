package com.data.service;

import com.manager.common.core.domain.model.Summarize;

import java.util.List;
import java.util.Map;

/**
 * @author marvin 2021/10/6
 */
public interface TotalService {
    List getTotals(Summarize summarize);

    Map getLeft(int tid);

    Map getRight(int tid, String beginTime, String endTime);
}
