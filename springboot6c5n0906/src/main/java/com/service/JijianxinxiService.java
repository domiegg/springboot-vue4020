package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JijianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JijianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JijianxinxiView;


/**
 * 寄件信息
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface JijianxinxiService extends IService<JijianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JijianxinxiVO> selectListVO(Wrapper<JijianxinxiEntity> wrapper);
   	
   	JijianxinxiVO selectVO(@Param("ew") Wrapper<JijianxinxiEntity> wrapper);
   	
   	List<JijianxinxiView> selectListView(Wrapper<JijianxinxiEntity> wrapper);
   	
   	JijianxinxiView selectView(@Param("ew") Wrapper<JijianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JijianxinxiEntity> wrapper);

   	

}

