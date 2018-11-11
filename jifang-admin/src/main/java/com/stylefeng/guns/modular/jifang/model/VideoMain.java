package com.stylefeng.guns.modular.jifang.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-22
 */
@TableName("jf_video_main")
public class VideoMain extends Model<VideoMain> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 所属区域
     */
    @TableField("area_name")
    private String areaName;
    /**
     * 监控申报数量
     */
    @TableField("schedule_qty")
    private Integer scheduleQty;
    /**
     * 已建数量
     */
    @TableField("actual_qty")
    private Integer actualQty;
    /**
     * 区域负责人
     */
    @TableField("master_name")
    private String masterName;
    /**
     * 设备更新日期
     */
    @TableField("equipment_date")
    private Date equipmentDate;
    /**
     * 录入ID
     */
    @TableField("create_id")
    private Integer createId;
    /**
     * 录入日期
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 更新ID
     */
    @TableField("update_id")
    private Integer updateId;
    /**
     * 更新日期
     */
    @TableField("update_date")
    private Date updateDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getScheduleQty() {
        return scheduleQty;
    }

    public void setScheduleQty(Integer scheduleQty) {
        this.scheduleQty = scheduleQty;
    }

    public Integer getActualQty() {
        return actualQty;
    }

    public void setActualQty(Integer actualQty) {
        this.actualQty = actualQty;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public Date getEquipmentDate() {
        return equipmentDate;
    }

    public void setEquipmentDate(Date equipmentDate) {
        this.equipmentDate = equipmentDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "VideoMain{" +
        "id=" + id +
        ", areaName=" + areaName +
        ", scheduleQty=" + scheduleQty +
        ", actualQty=" + actualQty +
        ", masterName=" + masterName +
        ", equipmentDate=" + equipmentDate +
        ", createId=" + createId +
        ", createDate=" + createDate +
        ", updateId=" + updateId +
        ", updateDate=" + updateDate +
        "}";
    }
}
