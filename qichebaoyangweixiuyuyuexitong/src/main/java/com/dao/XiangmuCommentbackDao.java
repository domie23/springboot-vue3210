package com.dao;

import com.entity.XiangmuCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuCommentbackView;

/**
 * 项目评价 Dao 接口
 *
 * @author 
 */
public interface XiangmuCommentbackDao extends BaseMapper<XiangmuCommentbackEntity> {

   List<XiangmuCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
