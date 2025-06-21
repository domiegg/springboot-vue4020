package com.entity.vo;

import com.entity.KuaidiyunshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 快递运输
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public class KuaidiyunshuVO  implements Serializable {
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
	 * 报价
	 */
	
	private String baojia;
		
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
	 * 运输信息
	 */
	
	private String yunshuxinxi;
		
	/**
	 * 运输状态
	 */
	
	private String yunshuzhuangtai;
		
	/**
	 * 运输时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yunshushijian;
		
	/**
	 * 司机账号
	 */
	
	private String sijizhanghao;
		
	/**
	 * 司机姓名
	 */
	
	private String sijixingming;
		
	/**
	 * 车牌号
	 */
	
	private String chepaihao;
		
	/**
	 * 路线名称
	 */
	
	private String luxianmingcheng;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
		
	/**
	 * 经度
	 */
	
	private Double longitude;
		
	/**
	 * 纬度
	 */
	
	private Double latitude;
		
	/**
	 * 地址
	 */
	
	private String fulladdress;
				
	
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
	 * 设置：报价
	 */
	 
	public void setBaojia(String baojia) {
		this.baojia = baojia;
	}
	
	/**
	 * 获取：报价
	 */
	public String getBaojia() {
		return baojia;
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
	 * 设置：运输信息
	 */
	 
	public void setYunshuxinxi(String yunshuxinxi) {
		this.yunshuxinxi = yunshuxinxi;
	}
	
	/**
	 * 获取：运输信息
	 */
	public String getYunshuxinxi() {
		return yunshuxinxi;
	}
				
	
	/**
	 * 设置：运输状态
	 */
	 
	public void setYunshuzhuangtai(String yunshuzhuangtai) {
		this.yunshuzhuangtai = yunshuzhuangtai;
	}
	
	/**
	 * 获取：运输状态
	 */
	public String getYunshuzhuangtai() {
		return yunshuzhuangtai;
	}
				
	
	/**
	 * 设置：运输时间
	 */
	 
	public void setYunshushijian(Date yunshushijian) {
		this.yunshushijian = yunshushijian;
	}
	
	/**
	 * 获取：运输时间
	 */
	public Date getYunshushijian() {
		return yunshushijian;
	}
				
	
	/**
	 * 设置：司机账号
	 */
	 
	public void setSijizhanghao(String sijizhanghao) {
		this.sijizhanghao = sijizhanghao;
	}
	
	/**
	 * 获取：司机账号
	 */
	public String getSijizhanghao() {
		return sijizhanghao;
	}
				
	
	/**
	 * 设置：司机姓名
	 */
	 
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
				
	
	/**
	 * 设置：车牌号
	 */
	 
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	
	/**
	 * 获取：车牌号
	 */
	public String getChepaihao() {
		return chepaihao;
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
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
				
	
	/**
	 * 设置：经度
	 */
	 
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * 获取：经度
	 */
	public Double getLongitude() {
		return longitude;
	}
				
	
	/**
	 * 设置：纬度
	 */
	 
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * 获取：纬度
	 */
	public Double getLatitude() {
		return latitude;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	
	/**
	 * 获取：地址
	 */
	public String getFulladdress() {
		return fulladdress;
	}
			
}
