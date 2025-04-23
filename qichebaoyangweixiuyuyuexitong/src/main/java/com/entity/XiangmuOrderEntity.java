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
 * 项目预约订单
 *
 * @author 
 * @email
 */
@TableName("xiangmu_order")
public class XiangmuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuOrderEntity() {

	}

	public XiangmuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "xiangmu_order_uuid_number")

    private String xiangmuOrderUuidNumber;


    /**
     * 项目
     */
    @TableField(value = "xiangmu_id")

    private Integer xiangmuId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 车辆名称
     */
    @TableField(value = "cheliang_name")

    private String cheliangName;


    /**
     * 车辆类型
     */
    @TableField(value = "cheliang_types")

    private Integer cheliangTypes;


    /**
     * 车牌号
     */
    @TableField(value = "chepaihao")

    private String chepaihao;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "yuyue_time")

    private Date yuyueTime;


    /**
     * 实付价格
     */
    @TableField(value = "xiangmu_order_true_price")

    private Double xiangmuOrderTruePrice;


    /**
     * 订单类型
     */
    @TableField(value = "xiangmu_order_types")

    private Integer xiangmuOrderTypes;


    /**
     * 支付类型
     */
    @TableField(value = "xiangmu_order_payment_types")

    private Integer xiangmuOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getXiangmuOrderUuidNumber() {
        return xiangmuOrderUuidNumber;
    }
    /**
	 * 获取：订单号
	 */

    public void setXiangmuOrderUuidNumber(String xiangmuOrderUuidNumber) {
        this.xiangmuOrderUuidNumber = xiangmuOrderUuidNumber;
    }
    /**
	 * 设置：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }
    /**
	 * 获取：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：车辆名称
	 */
    public String getCheliangName() {
        return cheliangName;
    }
    /**
	 * 获取：车辆名称
	 */

    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
    }
    /**
	 * 设置：车辆类型
	 */
    public Integer getCheliangTypes() {
        return cheliangTypes;
    }
    /**
	 * 获取：车辆类型
	 */

    public void setCheliangTypes(Integer cheliangTypes) {
        this.cheliangTypes = cheliangTypes;
    }
    /**
	 * 设置：车牌号
	 */
    public String getChepaihao() {
        return chepaihao;
    }
    /**
	 * 获取：车牌号
	 */

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }
    /**
	 * 获取：预约时间
	 */

    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getXiangmuOrderTruePrice() {
        return xiangmuOrderTruePrice;
    }
    /**
	 * 获取：实付价格
	 */

    public void setXiangmuOrderTruePrice(Double xiangmuOrderTruePrice) {
        this.xiangmuOrderTruePrice = xiangmuOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getXiangmuOrderTypes() {
        return xiangmuOrderTypes;
    }
    /**
	 * 获取：订单类型
	 */

    public void setXiangmuOrderTypes(Integer xiangmuOrderTypes) {
        this.xiangmuOrderTypes = xiangmuOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getXiangmuOrderPaymentTypes() {
        return xiangmuOrderPaymentTypes;
    }
    /**
	 * 获取：支付类型
	 */

    public void setXiangmuOrderPaymentTypes(Integer xiangmuOrderPaymentTypes) {
        this.xiangmuOrderPaymentTypes = xiangmuOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "XiangmuOrder{" +
            "id=" + id +
            ", xiangmuOrderUuidNumber=" + xiangmuOrderUuidNumber +
            ", xiangmuId=" + xiangmuId +
            ", yonghuId=" + yonghuId +
            ", cheliangName=" + cheliangName +
            ", cheliangTypes=" + cheliangTypes +
            ", chepaihao=" + chepaihao +
            ", yuyueTime=" + yuyueTime +
            ", xiangmuOrderTruePrice=" + xiangmuOrderTruePrice +
            ", xiangmuOrderTypes=" + xiangmuOrderTypes +
            ", xiangmuOrderPaymentTypes=" + xiangmuOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
