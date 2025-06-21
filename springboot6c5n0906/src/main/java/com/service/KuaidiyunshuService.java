package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuaidiyunshuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KuaidiyunshuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidiyunshuView;


/**
 * 快递运输
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidiyunshuService extends IService<KuaidiyunshuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KuaidiyunshuVO> selectListVO(Wrapper<KuaidiyunshuEntity> wrapper);
   	
   	KuaidiyunshuVO selectVO(@Param("ew") Wrapper<KuaidiyunshuEntity> wrapper);
   	
   	List<KuaidiyunshuView> selectListView(Wrapper<KuaidiyunshuEntity> wrapper);
   	
   	KuaidiyunshuView selectView(@Param("ew") Wrapper<KuaidiyunshuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KuaidiyunshuEntity> wrapper);

   	

}

