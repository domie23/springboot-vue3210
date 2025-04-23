package com.entity.model;

import com.entity.XiangmuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目预约订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String xiangmuOrderUuidNumber;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 车辆名称
     */
    private String cheliangName;


    /**
     * 车辆类型
     */
    private Integer cheliangTypes;


    /**
     * 车牌号
     */
    private String chepaihao;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 实付价格
     */
    private Double xiangmuOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer xiangmuOrderTypes;


    /**
     * 支付类型
     */
    private Integer xiangmuOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getXiangmuOrderUuidNumber() {
        return xiangmuOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setXiangmuOrderUuidNumber(String xiangmuOrderUuidNumber) {
        this.xiangmuOrderUuidNumber = xiangmuOrderUuidNumber;
    }
    /**
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 设置：项目
	 */
    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：车辆名称
	 */
    public String getCheliangName() {
        return cheliangName;
    }


    /**
	 * 设置：车辆名称
	 */
    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
    }
    /**
	 * 获取：车辆类型
	 */
    public Integer getCheliangTypes() {
        return cheliangTypes;
    }


    /**
	 * 设置：车辆类型
	 */
    public void setCheliangTypes(Integer cheliangTypes) {
        this.cheliangTypes = cheliangTypes;
    }
    /**
	 * 获取：车牌号
	 */
    public String getChepaihao() {
        return chepaihao;
    }


    /**
	 * 设置：车牌号
	 */
    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getXiangmuOrderTruePrice() {
        return xiangmuOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setXiangmuOrderTruePrice(Double xiangmuOrderTruePrice) {
        this.xiangmuOrderTruePrice = xiangmuOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getXiangmuOrderTypes() {
        return xiangmuOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setXiangmuOrderTypes(Integer xiangmuOrderTypes) {
        this.xiangmuOrderTypes = xiangmuOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getXiangmuOrderPaymentTypes() {
        return xiangmuOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setXiangmuOrderPaymentTypes(Integer xiangmuOrderPaymentTypes) {
        this.xiangmuOrderPaymentTypes = xiangmuOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
