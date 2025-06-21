package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuaidifenjianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KuaidifenjianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidifenjianView;


/**
 * 快递分拣
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidifenjianService extends IService<KuaidifenjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KuaidifenjianVO> selectListVO(Wrapper<KuaidifenjianEntity> wrapper);
   	
   	KuaidifenjianVO selectVO(@Param("ew") Wrapper<KuaidifenjianEntity> wrapper);
   	
   	List<KuaidifenjianView> selectListView(Wrapper<KuaidifenjianEntity> wrapper);
   	
   	KuaidifenjianView selectView(@Param("ew") Wrapper<KuaidifenjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KuaidifenjianEntity> wrapper);

   	

}

