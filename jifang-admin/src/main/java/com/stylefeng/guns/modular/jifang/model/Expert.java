package com.stylefeng.guns.modular.jifang.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-25
 */
@TableName("jf_expert")
public class Expert extends Model<Expert> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 专家编号
     */
    @TableField("expert_code")
    private String expertCode;
    /**
     * 专家姓名
     */
    @TableField("expert_name")
    private String expertName;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 政治面貌
     */
    private String politics;
    /**
     * 身份证号
     */
    @TableField("id_number")
    private String idNumber;
    /**
     * 照片
     */
    private String photo;
    /**
     * 职务
     */
    private String position;
    /**
     * 职称
     */
    @TableField("professor_grade")
    private String professorGrade;
    /**
     * 专业类别
     */
    @TableField("professor_type")
    private String professorType;
    /**
     * 从事专业年限
     */
    @TableField("professor_age")
    private Integer professorAge;
    /**
     * 最高学历
     */
    private String eduction;
    /**
     * 最高学位
     */
    private String degree;
    /**
     * 所在地区
     */
    private String address;
    /**
     * 所属行业
     */
    private String trade;
    /**
     * 创建ID
     */
    @TableField("create_id")
    private Integer createId;
    /**
     * 创建日期
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
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 电子邮箱
     */
    @TableField("e_mail")
    private String eMail;
    /**
     * 单位电话
     */
    @TableField("company_phone")
    private String companyPhone;
    /**
     * 工作单位
     */
    @TableField("company_name")
    private String companyName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpertCode() {
        return expertCode;
    }

    public void setExpertCode(String expertCode) {
        this.expertCode = expertCode;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfessorGrade() {
        return professorGrade;
    }

    public void setProfessorGrade(String professorGrade) {
        this.professorGrade = professorGrade;
    }

    public String getProfessorType() {
        return professorType;
    }

    public void setProfessorType(String professorType) {
        this.professorType = professorType;
    }

    public Integer getProfessorAge() {
        return professorAge;
    }

    public void setProfessorAge(Integer professorAge) {
        this.professorAge = professorAge;
    }

    public String getEduction() {
        return eduction;
    }

    public void setEduction(String eduction) {
        this.eduction = eduction;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Expert{" +
        "id=" + id +
        ", expertCode=" + expertCode +
        ", expertName=" + expertName +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", politics=" + politics +
        ", idNumber=" + idNumber +
        ", photo=" + photo +
        ", position=" + position +
        ", professorGrade=" + professorGrade +
        ", professorType=" + professorType +
        ", professorAge=" + professorAge +
        ", eduction=" + eduction +
        ", degree=" + degree +
        ", address=" + address +
        ", trade=" + trade +
        ", createId=" + createId +
        ", createDate=" + createDate +
        ", updateId=" + updateId +
        ", updateDate=" + updateDate +
        ", phone=" + phone +
        ", eMail=" + eMail +
        ", companyPhone=" + companyPhone +
        ", companyName=" + companyName +
        "}";
    }
}
