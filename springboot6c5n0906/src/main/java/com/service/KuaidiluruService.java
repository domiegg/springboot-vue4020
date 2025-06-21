package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuaidiluruEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KuaidiluruVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidiluruView;


/**
 * 快递录入
 *
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public interface KuaidiluruService extends IService<KuaidiluruEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KuaidiluruVO> selectListVO(Wrapper<KuaidiluruEntity> wrapper);
   	
   	KuaidiluruVO selectVO(@Param("ew") Wrapper<KuaidiluruEntity> wrapper);
   	
   	List<KuaidiluruView> selectListView(Wrapper<KuaidiluruEntity> wrapper);
   	
   	KuaidiluruView selectView(@Param("ew") Wrapper<KuaidiluruEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KuaidiluruEntity> wrapper);

   	

}

