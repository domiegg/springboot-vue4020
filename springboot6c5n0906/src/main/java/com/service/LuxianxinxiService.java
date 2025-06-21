package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LuxianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LuxianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LuxianxinxiView;


/**
 * 路线信息
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface LuxianxinxiService extends IService<LuxianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LuxianxinxiVO> selectListVO(Wrapper<LuxianxinxiEntity> wrapper);
   	
   	LuxianxinxiVO selectVO(@Param("ew") Wrapper<LuxianxinxiEntity> wrapper);
   	
   	List<LuxianxinxiView> selectListView(Wrapper<LuxianxinxiEntity> wrapper);
   	
   	LuxianxinxiView selectView(@Param("ew") Wrapper<LuxianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LuxianxinxiEntity> wrapper);

   	

}

