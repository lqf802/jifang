package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文件系统
 * </p>
 *
 * @author Spark123
 * @since 2018-06-07
 */
@TableName("sys_file")
public class File extends Model<File> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("file_name")
    private String fileName;
    /**
     * 分区，备用，将来可以扩展存储到不用的服务器
     */
    @TableField("file_part")
    private String filePart;
    @TableField("file_path")
    private String filePath;
    @TableField("file_size")
    private Long fileSize;
    @TableField("file_type")
    private String fileType;
    @TableField("file_url")
    private String fileUrl;
    @TableField("modul_name")
    private String modulName;
    @TableField("parent_id")
    private String parentId;
    private Integer sort;
    @TableField("create_time")
    private Date createTime;
    @TableField("modify_time")
    private Date modifyTime;
    @TableField("delete_time")
    private Date deleteTime;
    /**
     * 用户ID，上传人
     */
    @TableField("create_user_id")
    private String createUserId;
    /**
     * 修改人ID，公共盘可能会有其它人修改
     */
    @TableField("modify_user_id")
    private String modifyUserId;
    /**
     * 删除人ID，删除时记录，
     */
    @TableField("delete_user_id")
    private String deleteUserId;
    /**
     * 权限,0:私有,1:公有
     */
    private Integer purview;
    /**
     * 是否有效,0:无效,1:有效
     */
    @TableField("is_valid")
    private Integer isValid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePart() {
        return filePart;
    }

    public void setFilePart(String filePart) {
        this.filePart = filePart;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getDeleteUserId() {
        return deleteUserId;
    }

    public void setDeleteUserId(String deleteUserId) {
        this.deleteUserId = deleteUserId;
    }

    public Integer getPurview() {
        return purview;
    }

    public void setPurview(Integer purview) {
        this.purview = purview;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "File{" +
        "id=" + id +
        ", fileName=" + fileName +
        ", filePart=" + filePart +
        ", filePath=" + filePath +
        ", fileSize=" + fileSize +
        ", fileType=" + fileType +
        ", fileUrl=" + fileUrl +
        ", modulName=" + modulName +
        ", parentId=" + parentId +
        ", sort=" + sort +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", deleteTime=" + deleteTime +
        ", createUserId=" + createUserId +
        ", modifyUserId=" + modifyUserId +
        ", deleteUserId=" + deleteUserId +
        ", purview=" + purview +
        ", isValid=" + isValid +
        "}";
    }
}
