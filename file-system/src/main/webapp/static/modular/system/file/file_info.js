/**
 * 初始化文件管理详情对话框
 */
var FileInfoDlg = {
    fileInfoData : {}
};

/**
 * 清除数据
 */
FileInfoDlg.clearData = function() {
    this.fileInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FileInfoDlg.set = function(key, val) {
    this.fileInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FileInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
FileInfoDlg.close = function() {
    parent.layer.close(window.parent.File.layerIndex);
}

/**
 * 收集数据
 */
FileInfoDlg.collectData = function() {
    this
    .set('id')
    .set('fileName');
}

/**
 * 提交添加
 */
FileInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/file/add", function(data){
        Feng.success("添加成功!");
        window.parent.File.table.refresh();
        FileInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.fileInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
FileInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/file/update", function(data){
        Feng.success("修改成功!");
        window.parent.File.table.refresh();
        FileInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.fileInfoData);
    ajax.start();
}

$(function() {
// 初始化头像上传
    var avatarUp = new $WebUpload("avatar","/qq.com",{});
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();
});
