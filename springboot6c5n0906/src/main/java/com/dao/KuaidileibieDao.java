package com.dao;

import com.entity.KuaidileibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KuaidileibieVO;
import com.entity.view.KuaidileibieView;


/**
 * 快递类别
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidileibieDao extends BaseMapper<KuaidileibieEntity> {
	
	List<KuaidileibieVO> selectListVO(@Param("ew") Wrapper<KuaidileibieEntity> wrapper);
	
	KuaidileibieVO selectVO(@Param("ew") Wrapper<KuaidileibieEntity> wrapper);
	
	List<KuaidileibieView> selectListView(@Param("ew") Wrapper<KuaidileibieEntity> wrapper);

	List<KuaidileibieView> selectListView(Pagination page,@Param("ew") Wrapper<KuaidileibieEntity> wrapper);

	
	KuaidileibieView selectView(@Param("ew") Wrapper<KuaidileibieEntity> wrapper);
	

}
