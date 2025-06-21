package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 派送员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@TableName("paisongyuan")
public class PaisongyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PaisongyuanEntity() {
		
	}
	
	public PaisongyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 派送员账号
	 */
					
	private String paisongyuanzhanghao;
	
	/**
	 * 派送员姓名
	 */
					
	private String paisongyuanxingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：派送员账号
	 */
	public void setPaisongyuanzhanghao(String paisongyuanzhanghao) {
		this.paisongyuanzhanghao = paisongyuanzhanghao;
	}
	/**
	 * 获取：派送员账号
	 */
	public String getPaisongyuanzhanghao() {
		return paisongyuanzhanghao;
	}
	/**
	 * 设置：派送员姓名
	 */
	public void setPaisongyuanxingming(String paisongyuanxingming) {
		this.paisongyuanxingming = paisongyuanxingming;
	}
	/**
	 * 获取：派送员姓名
	 */
	public String getPaisongyuanxingming() {
		return paisongyuanxingming;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}

}
