package com.data.service;

import com.manager.common.core.domain.model.param.DataAnalysisParam;
import com.manager.common.core.domain.model.vo.DataAnalysisVO;
import com.manager.common.core.domain.model.vo.DataWaterTopVO;
import com.manager.common.core.domain.model.vo.RechargeTopVO;

import java.util.List;

/**
 * @author jason
 * @date 2021-10-08
 */
public interface DataAnalysisService {


    List<DataAnalysisVO> withdrawTopList(DataAnalysisParam param);

    List<DataWaterTopVO> getDataWaterTopList(DataAnalysisParam param);

    /**
     * 获取充值top100
     * @param param
     * @return
     */
    List<RechargeTopVO> getRechargeTopList(DataAnalysisParam param);


}