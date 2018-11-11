package com.stylefeng.guns.modular.activiti.controller;

import com.stylefeng.guns.modular.activiti.service.IActivitiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
public class ActivitiUserController {

    @Autowired
    private IActivitiUserService service;

    @PostMapping("/user/assigneeList")
    public Map<String, String> assigneeList(@RequestBody Set<String> assigneeList) {
        return service.getRealNameByAssigneeList(assigneeList);
    }

/*    @PostMapping("/user/candidateGroupsList")
    public Map<String, String> candidateGroupsList(@RequestBody Set<String> candidateGroupsList) {
        return userService.getRealNameByCandidateGroupsList(candidateGroupsList);
    }*/

    @PostMapping("/user/candidateUsersList")
    public Map<String, String> candidateUsersList(@RequestBody Set<String> candidateUsersList) {
        return service.getRealNameByCandidateUsersList(candidateUsersList);
    }
}
