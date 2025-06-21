package com.dao;

import com.entity.KuaidifenjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KuaidifenjianVO;
import com.entity.view.KuaidifenjianView;


/**
 * 快递分拣
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidifenjianDao extends BaseMapper<KuaidifenjianEntity> {
	
	List<KuaidifenjianVO> selectListVO(@Param("ew") Wrapper<KuaidifenjianEntity> wrapper);
	
	KuaidifenjianVO selectVO(@Param("ew") Wrapper<KuaidifenjianEntity> wrapper);
	
	List<KuaidifenjianView> selectListView(@Param("ew") Wrapper<KuaidifenjianEntity> wrapper);

	List<KuaidifenjianView> selectListView(Pagination page,@Param("ew") Wrapper<KuaidifenjianEntity> wrapper);

	
	KuaidifenjianView selectView(@Param("ew") Wrapper<KuaidifenjianEntity> wrapper);
	

}
