package com.stylefeng.guns.modular.system.controller.file;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.page.Page;
import com.stylefeng.guns.modular.system.criteria.FileCriteria;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.system.model.File;
import com.stylefeng.guns.modular.system.service.IFileService;

import java.util.Map;

/**
 * 文件管理控制器
 *
 * @author Spark
 * @Date 2018-06-07 18:51:57
 */
public abstract class AbsFileController extends BaseController {

    private String PREFIX = "/system/file/";

    @Autowired
    private IFileService fileService;

    /**
     * 跳转到文件管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "file.html";
    }

    /**
     * 跳转到添加文件管理
     */
    @RequestMapping("/file_add")
    public String fileAdd() {
        return PREFIX + "file_add.html";
    }

    /**
     * 跳转到修改文件管理
     */
    @RequestMapping("/file_update/{fileId}")
    public String fileUpdate(@PathVariable Integer fileId, Model model) {
        File file = fileService.selectById(fileId);
        model.addAttribute("item",file);
        LogObjectHolder.me().set(file);
        return PREFIX + "file_edit.html";
    }

    /**
     * 获取文件管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestBody Page<File,FileCriteria> page) {
        return fileService.selectList(page);
    }

    /**
     * 新增文件管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(File file) {
        fileService.insert(file);
        return SUCCESS_TIP;
    }

    /**
     * 删除文件管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer fileId) {
        fileService.deleteById(fileId);
        return SUCCESS_TIP;
    }

    /**
     * 修改文件管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(File file) {
        fileService.updateById(file);
        return SUCCESS_TIP;
    }

    /**
     * 文件管理详情
     */
    @RequestMapping(value = "/detail/{fileId}")
    @ResponseBody
    public Object detail(@PathVariable("fileId") Integer fileId) {
        return fileService.selectById(fileId);
    }
}
