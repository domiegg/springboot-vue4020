package com.entity.vo;

import com.entity.CheliangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车辆信息
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public class CheliangxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车辆型号
	 */
	
	private String cheliangxinghao;
		
	/**
	 * 车辆品牌
	 */
	
	private String cheliangpinpai;
		
	/**
	 * 车辆类型
	 */
	
	private String cheliangleixing;
		
	/**
	 * 颜色
	 */
	
	private String yanse;
		
	/**
	 * 换挡方式
	 */
	
	private String huandangfangshi;
		
	/**
	 * 座位数量
	 */
	
	private Integer zuoweishuliang;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 车辆详情
	 */
	
	private String cheliangxiangqing;
				
	
	/**
	 * 设置：车辆型号
	 */
	 
	public void setCheliangxinghao(String cheliangxinghao) {
		this.cheliangxinghao = cheliangxinghao;
	}
	
	/**
	 * 获取：车辆型号
	 */
	public String getCheliangxinghao() {
		return cheliangxinghao;
	}
				
	
	/**
	 * 设置：车辆品牌
	 */
	 
	public void setCheliangpinpai(String cheliangpinpai) {
		this.cheliangpinpai = cheliangpinpai;
	}
	
	/**
	 * 获取：车辆品牌
	 */
	public String getCheliangpinpai() {
		return cheliangpinpai;
	}
				
	
	/**
	 * 设置：车辆类型
	 */
	 
	public void setCheliangleixing(String cheliangleixing) {
		this.cheliangleixing = cheliangleixing;
	}
	
	/**
	 * 获取：车辆类型
	 */
	public String getCheliangleixing() {
		return cheliangleixing;
	}
				
	
	/**
	 * 设置：颜色
	 */
	 
	public void setYanse(String yanse) {
		this.yanse = yanse;
	}
	
	/**
	 * 获取：颜色
	 */
	public String getYanse() {
		return yanse;
	}
				
	
	/**
	 * 设置：换挡方式
	 */
	 
	public void setHuandangfangshi(String huandangfangshi) {
		this.huandangfangshi = huandangfangshi;
	}
	
	/**
	 * 获取：换挡方式
	 */
	public String getHuandangfangshi() {
		return huandangfangshi;
	}
				
	
	/**
	 * 设置：座位数量
	 */
	 
	public void setZuoweishuliang(Integer zuoweishuliang) {
		this.zuoweishuliang = zuoweishuliang;
	}
	
	/**
	 * 获取：座位数量
	 */
	public Integer getZuoweishuliang() {
		return zuoweishuliang;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
				
	
	/**
	 * 设置：车辆详情
	 */
	 
	public void setCheliangxiangqing(String cheliangxiangqing) {
		this.cheliangxiangqing = cheliangxiangqing;
	}
	
	/**
	 * 获取：车辆详情
	 */
	public String getCheliangxiangqing() {
		return cheliangxiangqing;
	}
			
}
