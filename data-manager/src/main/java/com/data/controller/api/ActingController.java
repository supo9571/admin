package com.data.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.data.controller.BaseController;
import com.data.service.ConfigAgenService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author sieGuang 2021/9/9
 * 推广链接 接口
 */
@RestController
@RequestMapping("/api/v1")
public class ActingController extends BaseController {

    @Autowired
    private ConfigAgenService configAgenService;

    /**
     * 返佣金额表
     */
    @PostMapping("/agentv2/rebate_form")
    public JSONObject rebate_form(){
        String channelId = getHeader("Client-ChannelId");//渠道id
        JSONObject result = new JSONObject();
        String uid = getHeader("uid"); // uid
        String promotionDomain = "";

        List<Map> list = configAgenService.getConfigAgentList(channelId);
        if(CollectionUtils.isNotEmpty(list)){
            promotionDomain = (String)list.get(0).get("promotionDomain");
        }
        result.put("reCommissionRuleList",list);
        result.put("spread_url",promotionDomain);
        result.put("uid",uid);
        return result;
    }

    /**
     * 推广数据
     */
    @PostMapping("/agentv2/info")
    public JSONObject info(@RequestBody JSONObject param){
        String uid = param.getString("uid");//渠道id
        JSONObject result = new JSONObject();
        return result;
    }

    /**
     * 下级列表信息
     * "{"page":1,"playerid":0,"limit":7,"index":1}"
     */
    @PostMapping("/agentv2/subinfo")
    public JSONObject subinfo(@RequestBody JSONObject param){
        String uid = param.getString("uid");//渠道id
        JSONObject result = new JSONObject();
        return result;
    }

    /**
     * 绑定代理
     */
    @PostMapping("/agentv2/bind")
    public JSONObject bind(@RequestBody JSONObject param){
        String channelId = getHeader("Client-ChannelId");//渠道id
        String uid = param.getString("uid");//玩家id
        String agentId = param.getString("agent_id");//代理id
        return configAgenService.bindAgent(channelId,uid,agentId);
    }
}
