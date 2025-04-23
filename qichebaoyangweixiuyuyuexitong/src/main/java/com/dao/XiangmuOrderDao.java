package com.dao;

import com.entity.XiangmuOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuOrderView;

/**
 * 项目预约订单 Dao 接口
 *
 * @author 
 */
public interface XiangmuOrderDao extends BaseMapper<XiangmuOrderEntity> {

   List<XiangmuOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
