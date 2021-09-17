package com.data.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author marvin 2021/9/11
 */
public interface ConfigAgenService {
    List<Map> getConfigAgentList(String cid);

    JSONObject bindAgent(String channelId, String uid, String agentId);
}
