package com.stylefeng.guns.modular.jifang.service.impl;

import com.stylefeng.guns.modular.jifang.model.Actions;
import com.stylefeng.guns.modular.jifang.dao.ActionsMapper;
import com.stylefeng.guns.modular.jifang.service.IActionsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuqingfeng123
 * @since 2018-06-19
 */
@Service
public class ActionsServiceImpl extends ServiceImpl<ActionsMapper, Actions> implements IActionsService {
    @Override
    public List<Map<String, Object>> selectlistActions(@Param("companyName") String companyName, @Param("beginTime") String beginTime, @Param("endTime") String endTime){
        return this.baseMapper.selectlistActions(companyName,beginTime,endTime);
    }
}
