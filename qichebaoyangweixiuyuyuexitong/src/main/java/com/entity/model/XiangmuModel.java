package com.entity.model;

import com.entity.XiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 逻辑删除
     */
    private Integer xiangmuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }


    /**
	 * 设置：项目编号
	 */
    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 获取：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }


    /**
	 * 设置：项目名称
	 */
    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 获取：项目照片
	 */
    public String getXiangmuPhoto() {
        return xiangmuPhoto;
    }


    /**
	 * 设置：项目照片
	 */
    public void setXiangmuPhoto(String xiangmuPhoto) {
        this.xiangmuPhoto = xiangmuPhoto;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }


    /**
	 * 设置：项目类型
	 */
    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 获取：项目原价
	 */
    public Double getXiangmuOldMoney() {
        return xiangmuOldMoney;
    }


    /**
	 * 设置：项目原价
	 */
    public void setXiangmuOldMoney(Double xiangmuOldMoney) {
        this.xiangmuOldMoney = xiangmuOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getXiangmuNewMoney() {
        return xiangmuNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setXiangmuNewMoney(Double xiangmuNewMoney) {
        this.xiangmuNewMoney = xiangmuNewMoney;
    }
    /**
	 * 获取：热度
	 */
    public Integer getXiangmuClicknum() {
        return xiangmuClicknum;
    }


    /**
	 * 设置：热度
	 */
    public void setXiangmuClicknum(Integer xiangmuClicknum) {
        this.xiangmuClicknum = xiangmuClicknum;
    }
    /**
	 * 获取：项目介绍
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }


    /**
	 * 设置：项目介绍
	 */
    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXiangmuDelete() {
        return xiangmuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXiangmuDelete(Integer xiangmuDelete) {
        this.xiangmuDelete = xiangmuDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
