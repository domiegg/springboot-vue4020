package com.entity.view;

import com.entity.LuxianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 路线信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@TableName("luxianxinxi")
public class LuxianxinxiView  extends LuxianxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LuxianxinxiView(){
	}
 
 	public LuxianxinxiView(LuxianxinxiEntity luxianxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, luxianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
