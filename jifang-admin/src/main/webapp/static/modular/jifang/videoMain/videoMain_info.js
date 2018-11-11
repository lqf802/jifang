/**
 * 初始化监控管理详情对话框
 */
var VideoMainInfoDlg = {
    videoMainInfoData : {}
};

/**
 * 清除数据
 */
VideoMainInfoDlg.clearData = function() {
    this.videoMainInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
VideoMainInfoDlg.set = function(key, val) {
    this.videoMainInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
VideoMainInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
VideoMainInfoDlg.close = function() {
    parent.layer.close(window.parent.VideoMain.layerIndex);
}

/**
 * 收集数据
 */
VideoMainInfoDlg.collectData = function() {
    this
    .set('id')
    .set('areaName')
    .set('scheduleQty')
    .set('actualQty')
    .set('masterName')
    .set('equipmentDate')
    .set('createId')
    .set('createDate')
    .set('updateId')
    .set('updateDate');
}

/**
 * 提交添加
 */
VideoMainInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/videoMain/add", function(data){
        Feng.success("添加成功!");
        window.parent.VideoMain.table.refresh();
        VideoMainInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.videoMainInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
VideoMainInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/videoMain/update", function(data){
        Feng.success("修改成功!");
        window.parent.VideoMain.table.refresh();
        VideoMainInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.videoMainInfoData);
    ajax.start();
}

$(function() {

});
