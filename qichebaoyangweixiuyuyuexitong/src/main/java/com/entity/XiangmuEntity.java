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
 * 项目
 *
 * @author 
 * @email
 */
@TableName("xiangmu")
public class XiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuEntity() {

	}

	public XiangmuEntity(T t) {
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
     * 项目编号
     */
    @TableField(value = "xiangmu_uuid_number")

    private String xiangmuUuidNumber;


    /**
     * 项目名称
     */
    @TableField(value = "xiangmu_name")

    private String xiangmuName;


    /**
     * 项目照片
     */
    @TableField(value = "xiangmu_photo")

    private String xiangmuPhoto;


    /**
     * 项目类型
     */
    @TableField(value = "xiangmu_types")

    private Integer xiangmuTypes;


    /**
     * 项目原价
     */
    @TableField(value = "xiangmu_old_money")

    private Double xiangmuOldMoney;


    /**
     * 现价
     */
    @TableField(value = "xiangmu_new_money")

    private Double xiangmuNewMoney;


    /**
     * 热度
     */
    @TableField(value = "xiangmu_clicknum")

    private Integer xiangmuClicknum;


    /**
     * 项目介绍
     */
    @TableField(value = "xiangmu_content")

    private String xiangmuContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "xiangmu_delete")

    private Integer xiangmuDelete;


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
	 * 设置：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }
    /**
	 * 获取：项目编号
	 */

    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 设置：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }
    /**
	 * 获取：项目名称
	 */

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 设置：项目照片
	 */
    public String getXiangmuPhoto() {
        return xiangmuPhoto;
    }
    /**
	 * 获取：项目照片
	 */

    public void setXiangmuPhoto(String xiangmuPhoto) {
        this.xiangmuPhoto = xiangmuPhoto;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }
    /**
	 * 获取：项目类型
	 */

    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 设置：项目原价
	 */
    public Double getXiangmuOldMoney() {
        return xiangmuOldMoney;
    }
    /**
	 * 获取：项目原价
	 */

    public void setXiangmuOldMoney(Double xiangmuOldMoney) {
        this.xiangmuOldMoney = xiangmuOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getXiangmuNewMoney() {
        return xiangmuNewMoney;
    }
    /**
	 * 获取：现价
	 */

    public void setXiangmuNewMoney(Double xiangmuNewMoney) {
        this.xiangmuNewMoney = xiangmuNewMoney;
    }
    /**
	 * 设置：热度
	 */
    public Integer getXiangmuClicknum() {
        return xiangmuClicknum;
    }
    /**
	 * 获取：热度
	 */

    public void setXiangmuClicknum(Integer xiangmuClicknum) {
        this.xiangmuClicknum = xiangmuClicknum;
    }
    /**
	 * 设置：项目介绍
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }
    /**
	 * 获取：项目介绍
	 */

    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXiangmuDelete() {
        return xiangmuDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setXiangmuDelete(Integer xiangmuDelete) {
        this.xiangmuDelete = xiangmuDelete;
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
        return "Xiangmu{" +
            "id=" + id +
            ", xiangmuUuidNumber=" + xiangmuUuidNumber +
            ", xiangmuName=" + xiangmuName +
            ", xiangmuPhoto=" + xiangmuPhoto +
            ", xiangmuTypes=" + xiangmuTypes +
            ", xiangmuOldMoney=" + xiangmuOldMoney +
            ", xiangmuNewMoney=" + xiangmuNewMoney +
            ", xiangmuClicknum=" + xiangmuClicknum +
            ", xiangmuContent=" + xiangmuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", xiangmuDelete=" + xiangmuDelete +
            ", createTime=" + createTime +
        "}";
    }
}
