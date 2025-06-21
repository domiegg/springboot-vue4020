package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuaidileibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KuaidileibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidileibieView;


/**
 * 快递类别
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidileibieService extends IService<KuaidileibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KuaidileibieVO> selectListVO(Wrapper<KuaidileibieEntity> wrapper);
   	
   	KuaidileibieVO selectVO(@Param("ew") Wrapper<KuaidileibieEntity> wrapper);
   	
   	List<KuaidileibieView> selectListView(Wrapper<KuaidileibieEntity> wrapper);
   	
   	KuaidileibieView selectView(@Param("ew") Wrapper<KuaidileibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KuaidileibieEntity> wrapper);

   	

}

