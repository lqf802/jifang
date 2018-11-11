package com.stylefeng.guns.modular.activiti.service.impl;

import com.stylefeng.guns.modular.activiti.service.IActivitiUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class ActivitiUserServiceImpl implements IActivitiUserService {
    public Map<String, String> getRealNameByAssigneeList(Set<String> assigneeList) {
        Map<String, String> map = new HashMap<String, String>();
        for (String item : assigneeList) {
            String value = "";
            if ("project".equals(item)) {
                value = "lqf";
            } else if ("manage".equals(item)) {
                value = "lwx";
            }
            map.put(item, value);
        }
        return map;
    }

 /*   public Map<String, String> getRealNameByCandidateGroupsList(Set<String> candidateGroupsList) {
        Map<String, String> map = new HashMap<String, String>();
        return map;
    }*/

    public Map<String, String> getRealNameByCandidateUsersList(Set<String> candidateUsersList) {
        Map<String, String> map = new HashMap<String, String>();
        for (String item : candidateUsersList) {
            String value = "";
            if (item.indexOf("group:") >= 0) {
                //组ID，
                String id = item.split(":")[1];
                //多个值用","分隔
                //这里根据id去查询数据，
            } else {
                if ("project".equals(item)) {
                    value = "lqf";
                } else if ("manage".equals(item)) {
                    value = "lwx";
                }
            }
            map.put(item, value);
        }
        return map;
    }
}
