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
 * 快递录入
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@TableName("kuaidiluru")
public class KuaidiluruEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KuaidiluruEntity() {
		
	}
	
	public KuaidiluruEntity(T t) {
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
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
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
					
	private Double baojia;
	
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
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
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
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
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
	public void setBaojia(Double baojia) {
		this.baojia = baojia;
	}
	/**
	 * 获取：报价
	 */
	public Double getBaojia() {
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
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
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
