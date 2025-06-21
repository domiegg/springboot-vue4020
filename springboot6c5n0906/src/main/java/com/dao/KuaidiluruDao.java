package com.dao;

import com.entity.KuaidiluruEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KuaidiluruVO;
import com.entity.view.KuaidiluruView;


/**
 * 快递录入
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidiluruDao extends BaseMapper<KuaidiluruEntity> {
	
	List<KuaidiluruVO> selectListVO(@Param("ew") Wrapper<KuaidiluruEntity> wrapper);
	
	KuaidiluruVO selectVO(@Param("ew") Wrapper<KuaidiluruEntity> wrapper);
	
	List<KuaidiluruView> selectListView(@Param("ew") Wrapper<KuaidiluruEntity> wrapper);

	List<KuaidiluruView> selectListView(Pagination page,@Param("ew") Wrapper<KuaidiluruEntity> wrapper);

	
	KuaidiluruView selectView(@Param("ew") Wrapper<KuaidiluruEntity> wrapper);
	

}
