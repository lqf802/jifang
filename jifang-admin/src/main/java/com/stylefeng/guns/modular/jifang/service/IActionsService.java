package com.stylefeng.guns.modular.jifang.service;

import com.stylefeng.guns.core.datascope.DataScope;
import com.stylefeng.guns.modular.jifang.model.Actions;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuqingfeng123
 * @since 2018-06-19
 */
public interface IActionsService extends IService<Actions> {

    List<Map<String, Object>> selectlistActions( @Param("companyName") String companyName, @Param("beginTime") String beginTime, @Param("endTime") String endTime);

}
