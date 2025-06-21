package com.dao;

import com.entity.KuaidipeisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KuaidipeisongVO;
import com.entity.view.KuaidipeisongView;


/**
 * 快递配送
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidipeisongDao extends BaseMapper<KuaidipeisongEntity> {
	
	List<KuaidipeisongVO> selectListVO(@Param("ew") Wrapper<KuaidipeisongEntity> wrapper);
	
	KuaidipeisongVO selectVO(@Param("ew") Wrapper<KuaidipeisongEntity> wrapper);
	
	List<KuaidipeisongView> selectListView(@Param("ew") Wrapper<KuaidipeisongEntity> wrapper);

	List<KuaidipeisongView> selectListView(Pagination page,@Param("ew") Wrapper<KuaidipeisongEntity> wrapper);

	
	KuaidipeisongView selectView(@Param("ew") Wrapper<KuaidipeisongEntity> wrapper);
	

}
