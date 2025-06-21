package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuaidipeisongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KuaidipeisongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidipeisongView;


/**
 * 快递配送
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidipeisongService extends IService<KuaidipeisongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KuaidipeisongVO> selectListVO(Wrapper<KuaidipeisongEntity> wrapper);
   	
   	KuaidipeisongVO selectVO(@Param("ew") Wrapper<KuaidipeisongEntity> wrapper);
   	
   	List<KuaidipeisongView> selectListView(Wrapper<KuaidipeisongEntity> wrapper);
   	
   	KuaidipeisongView selectView(@Param("ew") Wrapper<KuaidipeisongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KuaidipeisongEntity> wrapper);

   	

}

