package com.dao;

import com.entity.KuaidiyunshuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KuaidiyunshuVO;
import com.entity.view.KuaidiyunshuView;


/**
 * 快递运输
 * 
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidiyunshuDao extends BaseMapper<KuaidiyunshuEntity> {
	
	List<KuaidiyunshuVO> selectListVO(@Param("ew") Wrapper<KuaidiyunshuEntity> wrapper);
	
	KuaidiyunshuVO selectVO(@Param("ew") Wrapper<KuaidiyunshuEntity> wrapper);
	
	List<KuaidiyunshuView> selectListView(@Param("ew") Wrapper<KuaidiyunshuEntity> wrapper);

	List<KuaidiyunshuView> selectListView(Pagination page,@Param("ew") Wrapper<KuaidiyunshuEntity> wrapper);

	
	KuaidiyunshuView selectView(@Param("ew") Wrapper<KuaidiyunshuEntity> wrapper);
	

}
