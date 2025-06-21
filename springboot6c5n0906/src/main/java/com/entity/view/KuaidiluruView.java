package com.entity.view;

import com.entity.KuaidiluruEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 快递录入
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@TableName("kuaidiluru")
public class KuaidiluruView  extends KuaidiluruEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KuaidiluruView(){
	}
 
 	public KuaidiluruView(KuaidiluruEntity kuaidiluruEntity){
 	try {
			BeanUtils.copyProperties(this, kuaidiluruEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
