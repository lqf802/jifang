package com.stylefeng.guns.modular.activiti.service;

import java.util.Map;
import java.util.Set;

public interface IActivitiUserService {
    Map<String,String> getRealNameByAssigneeList(Set<String> assigneeList);
//    Map<String,String> getRealNameByCandidateGroupsList(Set<String> candidateGroupsList);
    Map<String,String> getRealNameByCandidateUsersList(Set<String> candidateUsersList);
}
