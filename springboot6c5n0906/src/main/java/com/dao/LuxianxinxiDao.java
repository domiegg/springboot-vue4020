package com.dao;

import com.entity.LuxianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LuxianxinxiVO;
import com.entity.view.LuxianxinxiView;


/**
 * 路线信息
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface LuxianxinxiDao extends BaseMapper<LuxianxinxiEntity> {
	
	List<LuxianxinxiVO> selectListVO(@Param("ew") Wrapper<LuxianxinxiEntity> wrapper);
	
	LuxianxinxiVO selectVO(@Param("ew") Wrapper<LuxianxinxiEntity> wrapper);
	
	List<LuxianxinxiView> selectListView(@Param("ew") Wrapper<LuxianxinxiEntity> wrapper);

	List<LuxianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LuxianxinxiEntity> wrapper);

	
	LuxianxinxiView selectView(@Param("ew") Wrapper<LuxianxinxiEntity> wrapper);
	

}
