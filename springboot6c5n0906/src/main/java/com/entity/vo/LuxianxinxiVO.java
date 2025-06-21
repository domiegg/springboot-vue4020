package com.entity.vo;

import com.entity.LuxianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 路线信息
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public class LuxianxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
