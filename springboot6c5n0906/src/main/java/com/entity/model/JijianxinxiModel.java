package com.entity.model;

import com.entity.JijianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 寄件信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public class JijianxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 寄件账号
	 */
	
	private String jijianzhanghao;
		
	/**
	 * 寄件姓名
	 */
	
	private String jijianxingming;
		
	/**
	 * 寄件手机
	 */
	
	private String jijianshouji;
		
	/**
	 * 发货地址
	 */
	
	private String fahuodizhi;
		
	/**
	 * 快递类别
	 */
	
	private String kuaidileibie;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 收件人账号
	 */
	
	private String zhanghao;
		
	/**
	 * 收件人姓名
	 */
	
	private String xingming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 收货地址
	 */
	
	private String dizhi;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 寄件时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jijianshijian;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：寄件账号
	 */
	 
	public void setJijianzhanghao(String jijianzhanghao) {
		this.jijianzhanghao = jijianzhanghao;
	}
	
	/**
	 * 获取：寄件账号
	 */
	public String getJijianzhanghao() {
		return jijianzhanghao;
	}
				
	
	/**
	 * 设置：寄件姓名
	 */
	 
	public void setJijianxingming(String jijianxingming) {
		this.jijianxingming = jijianxingming;
	}
	
	/**
	 * 获取：寄件姓名
	 */
	public String getJijianxingming() {
		return jijianxingming;
	}
				
	
	/**
	 * 设置：寄件手机
	 */
	 
	public void setJijianshouji(String jijianshouji) {
		this.jijianshouji = jijianshouji;
	}
	
	/**
	 * 获取：寄件手机
	 */
	public String getJijianshouji() {
		return jijianshouji;
	}
				
	
	/**
	 * 设置：发货地址
	 */
	 
	public void setFahuodizhi(String fahuodizhi) {
		this.fahuodizhi = fahuodizhi;
	}
	
	/**
	 * 获取：发货地址
	 */
	public String getFahuodizhi() {
		return fahuodizhi;
	}
				
	
	/**
	 * 设置：快递类别
	 */
	 
	public void setKuaidileibie(String kuaidileibie) {
		this.kuaidileibie = kuaidileibie;
	}
	
	/**
	 * 获取：快递类别
	 */
	public String getKuaidileibie() {
		return kuaidileibie;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：收件人账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：收件人账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：收件人姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：收件人姓名
	 */
	public String getXingming() {
		return xingming;
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
	 * 设置：收货地址
	 */
	 
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	/**
	 * 获取：收货地址
	 */
	public String getDizhi() {
		return dizhi;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：寄件时间
	 */
	 
	public void setJijianshijian(Date jijianshijian) {
		this.jijianshijian = jijianshijian;
	}
	
	/**
	 * 获取：寄件时间
	 */
	public Date getJijianshijian() {
		return jijianshijian;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
