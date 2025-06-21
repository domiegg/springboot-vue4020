package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PaisongyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PaisongyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PaisongyuanView;


/**
 * 派送员
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface PaisongyuanService extends IService<PaisongyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaisongyuanVO> selectListVO(Wrapper<PaisongyuanEntity> wrapper);
   	
   	PaisongyuanVO selectVO(@Param("ew") Wrapper<PaisongyuanEntity> wrapper);
   	
   	List<PaisongyuanView> selectListView(Wrapper<PaisongyuanEntity> wrapper);
   	
   	PaisongyuanView selectView(@Param("ew") Wrapper<PaisongyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaisongyuanEntity> wrapper);

   	

}

