package com.stylefeng.guns.modular.jifang.dao;

import com.stylefeng.guns.modular.jifang.model.Actions;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuqingfeng123
 * @since 2018-06-19
 */
public interface ActionsMapper extends BaseMapper<Actions> {
     List<Map<String, Object>> selectlistActions( @Param("companyName") String companyName, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
}
