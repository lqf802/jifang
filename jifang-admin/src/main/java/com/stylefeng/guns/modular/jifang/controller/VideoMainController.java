package com.stylefeng.guns.modular.jifang.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.jifang.service.IVideoMainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.jifang.model.VideoMain;


/**
 * 监控管理控制器
 *
 * @author Spark
 * @Date 2018-06-22 17:00:20
 */
@Controller
@RequestMapping("/videoMain")
public class VideoMainController extends BaseController {

    private String PREFIX = "/jifang/videoMain/";

    @Autowired
    private IVideoMainService videoMainService;

    /**
     * 跳转到监控管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "videoMain.html";
    }

    /**
     * 跳转到添加监控管理
     */
    @RequestMapping("/videoMain_add")
    public String videoMainAdd() {
        return PREFIX + "videoMain_add.html";
    }

    /**
     * 跳转到修改监控管理
     */
    @RequestMapping("/videoMain_update/{videoMainId}")
    public String videoMainUpdate(@PathVariable Integer videoMainId, Model model) {
        VideoMain videoMain = videoMainService.selectById(videoMainId);
        model.addAttribute("item",videoMain);
        LogObjectHolder.me().set(videoMain);
        return PREFIX + "videoMain_edit.html";
    }

    /**
     * 获取监控管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
           return videoMainService.selectList(null);
    }

    /**
     * 新增监控管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(VideoMain videoMain) {
        videoMainService.insert(videoMain);
        return SUCCESS_TIP;
    }

    /**
     * 删除监控管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer videoMainId) {
        videoMainService.deleteById(videoMainId);
        return SUCCESS_TIP;
    }

    /**
     * 修改监控管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(VideoMain videoMain) {
        videoMainService.updateById(videoMain);
        return SUCCESS_TIP;
    }

    /**
     * 监控管理详情
     */
    @RequestMapping(value = "/detail/{videoMainId}")
    @ResponseBody
    public Object detail(@PathVariable("videoMainId") Integer videoMainId) {
        return videoMainService.selectById(videoMainId);
    }
}
