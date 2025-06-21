package com.dao;

import com.entity.JijianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JijianxinxiVO;
import com.entity.view.JijianxinxiView;


/**
 * 寄件信息
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface JijianxinxiDao extends BaseMapper<JijianxinxiEntity> {
	
	List<JijianxinxiVO> selectListVO(@Param("ew") Wrapper<JijianxinxiEntity> wrapper);
	
	JijianxinxiVO selectVO(@Param("ew") Wrapper<JijianxinxiEntity> wrapper);
	
	List<JijianxinxiView> selectListView(@Param("ew") Wrapper<JijianxinxiEntity> wrapper);

	List<JijianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JijianxinxiEntity> wrapper);

	
	JijianxinxiView selectView(@Param("ew") Wrapper<JijianxinxiEntity> wrapper);
	

}
