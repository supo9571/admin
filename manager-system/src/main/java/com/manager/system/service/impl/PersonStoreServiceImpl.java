package com.manager.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.manager.common.core.domain.entity.PersonStore;
import com.manager.common.utils.StringUtils;
import com.manager.system.mapper.PersonStoreMapper;
import com.manager.system.service.PersonStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author marvin 2021/10/13
 */
@Service
public class PersonStoreServiceImpl implements PersonStoreService {

    @Autowired
    private PersonStoreMapper personStoreMapper;
    @Override
    public int addPersonStore(PersonStore personStore) {
        return personStoreMapper.addPersonStore(personStore);
    }

    @Override
    public List getPersonStrategys(Integer strategyTagId) {
        return personStoreMapper.getPersonStrategys(strategyTagId);
    }

    @Override
    public int editPersonStrategy(PersonStore personStore) {
        return personStoreMapper.editPersonStrategy(personStore);
    }

    @Override
    public int delPersonStrategy(Integer strategyId) {
        return personStoreMapper.delPersonStrategy(strategyId);
    }

    @Override
    public String sendPersonStrategy() {
        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        List<Map> personList = personStoreMapper.getPersonStrategyList();
        Map personMap = new HashMap();
        personList.forEach(map -> {
            personMap.put(map.get("strategy_id")+"",new JSONObject(map));
        });
        param.put("strategy_list",new JSONObject(personMap));
        String resultStr = StringUtils.jsonToLua(param);
        result.put("strategy_person_store.lua", "return {" + resultStr + "}");
        return result.toJSONString();
    }
}
