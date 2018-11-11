package com.stylefeng.guns.modular.jifang.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.jifang.model.Expert;
import com.stylefeng.guns.modular.jifang.service.IExpertService;
import com.stylefeng.guns.modular.jifang.warpper.ExpertWarppaer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 专家库管理控制器
 *
 * @author Spark
 * @Date 2018-06-25 17:22:00
 */
@Controller
@RequestMapping("/expert")
public class ExpertController extends BaseController {

    private String PREFIX = "/jifang/expert/";

    @Autowired
    private IExpertService expertService;

    /**
     * 跳转到专家库管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "expert.html";
    }

    /**
     * 跳转到添加专家库管理
     */
    @RequestMapping("/expert_add")
    public String expertAdd() {
        return PREFIX + "expert_add.html";
    }

    /**
     * 跳转到修改专家库管理
     */
    @RequestMapping("/expert_update/{expertId}")
    public String expertUpdate(@PathVariable Integer expertId, Model model) {
        Expert expert = expertService.selectById(expertId);
        model.addAttribute("item",expert);
        LogObjectHolder.me().set(expert);
        return PREFIX + "expert_edit.html";
    }

    /**
     * 获取专家库管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> experts = expertService.selectMaps(null);
        return new ExpertWarppaer(experts).warp();
    }

    /**
     * 新增专家库管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Expert expert) {
        expertService.insert(expert);
        return SUCCESS_TIP;
    }

    /**
     * 删除专家库管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer expertId) {
        expertService.deleteById(expertId);
        return SUCCESS_TIP;
    }

    /**
     * 修改专家库管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Expert expert) {
        expertService.updateById(expert);
        return SUCCESS_TIP;
    }

    /**
     * 专家库管理详情
     */
    @RequestMapping(value = "/detail/{expertId}")
    @ResponseBody
    public Object detail(@PathVariable("expertId") Integer expertId) {
        return expertService.selectById(expertId);
    }
}
