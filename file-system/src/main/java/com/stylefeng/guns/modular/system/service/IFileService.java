package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.core.page.Page;
import com.stylefeng.guns.modular.system.criteria.FileCriteria;
import com.stylefeng.guns.modular.system.model.File;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 文件系统 服务类
 * </p>
 *
 * @author Spark123
 * @since 2018-06-07
 */
public interface IFileService extends IService<File> {

    Object selectList(Page<File,FileCriteria> page);
}
