package com.stylefeng.guns.modular.jifang.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.jifang.model.Actions;
import com.stylefeng.guns.modular.jifang.service.IActionsService;
import com.stylefeng.guns.modular.jifang.warpper.ActionsWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 执法管理控制器
 *
 * @author Spark
 * @Date 2018-06-22 09:10:32
 */
@Controller
@RequestMapping("/actions")
public class ActionsController extends BaseController {

    private String PREFIX = "/jifang/actions/";

    @Autowired
    private IActionsService actionsService;

    /**
     * 跳转到执法管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "actions.html";
    }

    /**
     * 跳转到添加执法管理
     */
    @RequestMapping("/actions_add")
    public String actionsAdd() {
        return PREFIX + "actions_add.html";
    }

    /**
     * 跳转到修改执法管理
     */
    @RequestMapping("/actions_update/{actionsId}")
    public String actionsUpdate(@PathVariable Integer actionsId, Model model) {
        Actions actions = actionsService.selectById(actionsId);
        model.addAttribute("item",actions);
        LogObjectHolder.me().set(actions);
        return PREFIX + "actions_edit.html";
    }

    /**
     * 获取执法管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String companyName,  @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime) {
        List<Map<String, Object>> listActions = actionsService.selectlistActions(companyName, beginTime, endTime);
        return new ActionsWarpper(listActions).warp();
    }
    /**
     * 新增执法管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Actions actions) {
        actions.setCreateId(ShiroKit.getUser().getId());
        actions.setCreateDate(new Date());
        actionsService.insert(actions);
        return SUCCESS_TIP;
    }

    /**
     * 删除执法管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer actionsId) {
        actionsService.deleteById(actionsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改执法管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Actions actions) {
        actions.setUpdateId(ShiroKit.getUser().getId());
        actions.setUpdateDate(new Date());
        actionsService.updateById(actions);
        return SUCCESS_TIP;
    }

    /**
     * 执法管理详情
     */
    @RequestMapping(value = "/detail/{actionsId}")
    @ResponseBody
    public Object detail(@PathVariable("actionsId") Integer actionsId) {
        return actionsService.selectById(actionsId);
    }
}
