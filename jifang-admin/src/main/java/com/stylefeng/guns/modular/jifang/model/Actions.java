package com.stylefeng.guns.modular.jifang.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuqingfeng123
 * @since 2018-06-19
 */
@TableName("jf_actions")
public class Actions extends Model<Actions> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 企业名称
     */
    @TableField("company_name")
    private String companyName;
    /**
     * 行政违法行为
     */
    @TableField("action_describe")
    private String actionDescribe;
    /**
     * 处罚种类
     */
    @TableField("punish_type")
    private String punishType;
    /**
     * 执法依据
     */
    @TableField("law_clause")
    private String lawClause;
    /**
     * 行政执法主体
     */
    @TableField("action_dept")
    private String actionDept;
    /**
     * 执法日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("action_date")
    private Date actionDate;
    /**
     * 建立者
     */
    @TableField("create_id")
    private Integer createId;
    /**
     * 建立日期
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 更改者
     */
    @TableField("update_id")
    private Integer updateId;
    /**
     * 更改日期
     */
    @TableField("update_date")
    private Date updateDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getActionDescribe() {
        return actionDescribe;
    }

    public void setActionDescribe(String actionDescribe) {
        this.actionDescribe = actionDescribe;
    }

    public String getPunishType() {
        return punishType;
    }

    public void setPunishType(String punishType) {
        this.punishType = punishType;
    }

    public String getLawClause() {
        return lawClause;
    }

    public void setLawClause(String lawClause) {
        this.lawClause = lawClause;
    }

    public String getActionDept() {
        return actionDept;
    }

    public void setActionDept(String actionDept) {
        this.actionDept = actionDept;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
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
        return "Actions{" +
        "id=" + id +
        ", companyName=" + companyName +
        ", actionDescribe=" + actionDescribe +
        ", punishType=" + punishType +
        ", lawClause=" + lawClause +
        ", actionDept=" + actionDept +
        ", actionDate=" + actionDate +
        ", createId=" + createId +
        ", createDate=" + createDate +
        ", updateId=" + updateId +
        ", updateDate=" + updateDate +
        "}";
    }
}
