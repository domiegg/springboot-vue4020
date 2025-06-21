package com.entity.vo;

import com.entity.KuaidipeisongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 快递配送
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
public class KuaidipeisongVO  implements Serializable {
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
	 * 派送状态
	 */
	
	private String paisongzhuangtai;
		
	/**
	 * 派送信息
	 */
	
	private String paisongxinxi;
		
	/**
	 * 派送时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date paisongshijian;
		
	/**
	 * 派送员账号
	 */
	
	private String paisongyuanzhanghao;
		
	/**
	 * 派送员姓名
	 */
	
	private String paisongyuanxingming;
		
	/**
	 * 派送路线
	 */
	
	private String paisongluxian;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
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
	 * 设置：派送状态
	 */
	 
	public void setPaisongzhuangtai(String paisongzhuangtai) {
		this.paisongzhuangtai = paisongzhuangtai;
	}
	
	/**
	 * 获取：派送状态
	 */
	public String getPaisongzhuangtai() {
		return paisongzhuangtai;
	}
				
	
	/**
	 * 设置：派送信息
	 */
	 
	public void setPaisongxinxi(String paisongxinxi) {
		this.paisongxinxi = paisongxinxi;
	}
	
	/**
	 * 获取：派送信息
	 */
	public String getPaisongxinxi() {
		return paisongxinxi;
	}
				
	
	/**
	 * 设置：派送时间
	 */
	 
	public void setPaisongshijian(Date paisongshijian) {
		this.paisongshijian = paisongshijian;
	}
	
	/**
	 * 获取：派送时间
	 */
	public Date getPaisongshijian() {
		return paisongshijian;
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
	 * 设置：派送路线
	 */
	 
	public void setPaisongluxian(String paisongluxian) {
		this.paisongluxian = paisongluxian;
	}
	
	/**
	 * 获取：派送路线
	 */
	public String getPaisongluxian() {
		return paisongluxian;
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
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
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
