package com.entity.vo;

import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmu")
public class XiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
