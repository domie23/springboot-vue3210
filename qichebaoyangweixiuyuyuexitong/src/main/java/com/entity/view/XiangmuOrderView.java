package com.entity.view;

import com.entity.XiangmuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目预约订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiangmu_order")
public class XiangmuOrderView extends XiangmuOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 车辆类型的值
		*/
		private String cheliangValue;
		/**
		* 订单类型的值
		*/
		private String xiangmuOrderValue;
		/**
		* 支付类型的值
		*/
		private String xiangmuOrderPaymentValue;



		//级联表 xiangmu
			/**
			* 项目编号
			*/
			private String xiangmuUuidNumber;
			/**
			* 项目名称
			*/
			private String xiangmuName;
			/**
			* 项目照片
			*/
			private String xiangmuPhoto;
			/**
			* 项目类型
			*/
			private Integer xiangmuTypes;
				/**
				* 项目类型的值
				*/
				private String xiangmuValue;
			/**
			* 项目原价
			*/
			private Double xiangmuOldMoney;
			/**
			* 现价
			*/
			private Double xiangmuNewMoney;
			/**
			* 热度
			*/
			private Integer xiangmuClicknum;
			/**
			* 项目介绍
			*/
			private String xiangmuContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer xiangmuDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;

	public XiangmuOrderView() {

	}

	public XiangmuOrderView(XiangmuOrderEntity xiangmuOrderEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmuOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 车辆类型的值
			*/
			public String getCheliangValue() {
				return cheliangValue;
			}
			/**
			* 设置： 车辆类型的值
			*/
			public void setCheliangValue(String cheliangValue) {
				this.cheliangValue = cheliangValue;
			}
			/**
			* 获取： 订单类型的值
			*/
			public String getXiangmuOrderValue() {
				return xiangmuOrderValue;
			}
			/**
			* 设置： 订单类型的值
			*/
			public void setXiangmuOrderValue(String xiangmuOrderValue) {
				this.xiangmuOrderValue = xiangmuOrderValue;
			}
			/**
			* 获取： 支付类型的值
			*/
			public String getXiangmuOrderPaymentValue() {
				return xiangmuOrderPaymentValue;
			}
			/**
			* 设置： 支付类型的值
			*/
			public void setXiangmuOrderPaymentValue(String xiangmuOrderPaymentValue) {
				this.xiangmuOrderPaymentValue = xiangmuOrderPaymentValue;
			}










				//级联表的get和set xiangmu

					/**
					* 获取： 项目编号
					*/
					public String getXiangmuUuidNumber() {
						return xiangmuUuidNumber;
					}
					/**
					* 设置： 项目编号
					*/
					public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
						this.xiangmuUuidNumber = xiangmuUuidNumber;
					}

					/**
					* 获取： 项目名称
					*/
					public String getXiangmuName() {
						return xiangmuName;
					}
					/**
					* 设置： 项目名称
					*/
					public void setXiangmuName(String xiangmuName) {
						this.xiangmuName = xiangmuName;
					}

					/**
					* 获取： 项目照片
					*/
					public String getXiangmuPhoto() {
						return xiangmuPhoto;
					}
					/**
					* 设置： 项目照片
					*/
					public void setXiangmuPhoto(String xiangmuPhoto) {
						this.xiangmuPhoto = xiangmuPhoto;
					}

					/**
					* 获取： 项目类型
					*/
					public Integer getXiangmuTypes() {
						return xiangmuTypes;
					}
					/**
					* 设置： 项目类型
					*/
					public void setXiangmuTypes(Integer xiangmuTypes) {
						this.xiangmuTypes = xiangmuTypes;
					}


						/**
						* 获取： 项目类型的值
						*/
						public String getXiangmuValue() {
							return xiangmuValue;
						}
						/**
						* 设置： 项目类型的值
						*/
						public void setXiangmuValue(String xiangmuValue) {
							this.xiangmuValue = xiangmuValue;
						}

					/**
					* 获取： 项目原价
					*/
					public Double getXiangmuOldMoney() {
						return xiangmuOldMoney;
					}
					/**
					* 设置： 项目原价
					*/
					public void setXiangmuOldMoney(Double xiangmuOldMoney) {
						this.xiangmuOldMoney = xiangmuOldMoney;
					}

					/**
					* 获取： 现价
					*/
					public Double getXiangmuNewMoney() {
						return xiangmuNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setXiangmuNewMoney(Double xiangmuNewMoney) {
						this.xiangmuNewMoney = xiangmuNewMoney;
					}

					/**
					* 获取： 热度
					*/
					public Integer getXiangmuClicknum() {
						return xiangmuClicknum;
					}
					/**
					* 设置： 热度
					*/
					public void setXiangmuClicknum(Integer xiangmuClicknum) {
						this.xiangmuClicknum = xiangmuClicknum;
					}

					/**
					* 获取： 项目介绍
					*/
					public String getXiangmuContent() {
						return xiangmuContent;
					}
					/**
					* 设置： 项目介绍
					*/
					public void setXiangmuContent(String xiangmuContent) {
						this.xiangmuContent = xiangmuContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getXiangmuDelete() {
						return xiangmuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setXiangmuDelete(Integer xiangmuDelete) {
						this.xiangmuDelete = xiangmuDelete;
					}













				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}






}
