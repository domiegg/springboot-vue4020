package com.dao;

import com.entity.PaisongyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaisongyuanVO;
import com.entity.view.PaisongyuanView;


/**
 * 派送员
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface PaisongyuanDao extends BaseMapper<PaisongyuanEntity> {
	
	List<PaisongyuanVO> selectListVO(@Param("ew") Wrapper<PaisongyuanEntity> wrapper);
	
	PaisongyuanVO selectVO(@Param("ew") Wrapper<PaisongyuanEntity> wrapper);
	
	List<PaisongyuanView> selectListView(@Param("ew") Wrapper<PaisongyuanEntity> wrapper);

	List<PaisongyuanView> selectListView(Pagination page,@Param("ew") Wrapper<PaisongyuanEntity> wrapper);

	
	PaisongyuanView selectView(@Param("ew") Wrapper<PaisongyuanEntity> wrapper);
	

}
