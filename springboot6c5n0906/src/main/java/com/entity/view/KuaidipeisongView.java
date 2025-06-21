package com.entity.view;

import com.entity.KuaidipeisongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 快递配送
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@TableName("kuaidipeisong")
public class KuaidipeisongView  extends KuaidipeisongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KuaidipeisongView(){
	}
 
 	public KuaidipeisongView(KuaidipeisongEntity kuaidipeisongEntity){
 	try {
			BeanUtils.copyProperties(this, kuaidipeisongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
