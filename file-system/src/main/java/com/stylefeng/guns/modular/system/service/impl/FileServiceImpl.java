package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.page.Page;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.criteria.FileCriteria;
import com.stylefeng.guns.modular.system.model.File;
import com.stylefeng.guns.modular.system.dao.FileMapper;
import com.stylefeng.guns.modular.system.service.IFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文件系统 服务实现类
 * </p>
 *
 * @author Spark
 * @since 2018-06-07
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public boolean updateById(File entity) {
        entity.setModifyTime(DateUtil.getNow());
        entity.setModifyUserId(String.valueOf(ShiroKit.getUser().getId()));
        return super.updateById(entity);
    }

    @Override
    public Object selectList(Page<File, FileCriteria> page) {
        EntityWrapper ew = new EntityWrapper();
        FileCriteria criteria = page.getCondition();
        if (criteria != null) {
            ew.like("file_name", criteria.getName());
        }
        List<File> list = fileMapper.selectPage(page, ew);
        page.setRows(list);
        return page;
    }
}
