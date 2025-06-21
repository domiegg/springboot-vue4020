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
 * 路线信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@TableName("luxianxinxi")
public class LuxianxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LuxianxinxiEntity() {
		
	}
	
	public LuxianxinxiEntity(T t) {
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
	 * 路线编号
	 */
					
	private String luxianbianhao;
	
	/**
	 * 路线名称
	 */
					
	private String luxianmingcheng;
	
	/**
	 * 起点
	 */
					
	private String qidian;
	
	/**
	 * 途径站点
	 */
					
	private String tujingzhandian;
	
	/**
	 * 终点
	 */
					
	private String zhongdian;
	
	/**
	 * 路线距离
	 */
					
	private String luxianjuli;
	
	/**
	 * 路线详情
	 */
					
	private String luxianxiangqing;
	
	
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
	 * 设置：路线编号
	 */
	public void setLuxianbianhao(String luxianbianhao) {
		this.luxianbianhao = luxianbianhao;
	}
	/**
	 * 获取：路线编号
	 */
	public String getLuxianbianhao() {
		return luxianbianhao;
	}
	/**
	 * 设置：路线名称
	 */
	public void setLuxianmingcheng(String luxianmingcheng) {
		this.luxianmingcheng = luxianmingcheng;
	}
	/**
	 * 获取：路线名称
	 */
	public String getLuxianmingcheng() {
		return luxianmingcheng;
	}
	/**
	 * 设置：起点
	 */
	public void setQidian(String qidian) {
		this.qidian = qidian;
	}
	/**
	 * 获取：起点
	 */
	public String getQidian() {
		return qidian;
	}
	/**
	 * 设置：途径站点
	 */
	public void setTujingzhandian(String tujingzhandian) {
		this.tujingzhandian = tujingzhandian;
	}
	/**
	 * 获取：途径站点
	 */
	public String getTujingzhandian() {
		return tujingzhandian;
	}
	/**
	 * 设置：终点
	 */
	public void setZhongdian(String zhongdian) {
		this.zhongdian = zhongdian;
	}
	/**
	 * 获取：终点
	 */
	public String getZhongdian() {
		return zhongdian;
	}
	/**
	 * 设置：路线距离
	 */
	public void setLuxianjuli(String luxianjuli) {
		this.luxianjuli = luxianjuli;
	}
	/**
	 * 获取：路线距离
	 */
	public String getLuxianjuli() {
		return luxianjuli;
	}
	/**
	 * 设置：路线详情
	 */
	public void setLuxianxiangqing(String luxianxiangqing) {
		this.luxianxiangqing = luxianxiangqing;
	}
	/**
	 * 获取：路线详情
	 */
	public String getLuxianxiangqing() {
		return luxianxiangqing;
	}

}
