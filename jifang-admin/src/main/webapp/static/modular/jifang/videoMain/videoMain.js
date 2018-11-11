/**
 * 监控管理管理初始化
 */
var VideoMain = {
    id: "VideoMainTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
VideoMain.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '所属区域', field: 'areaName', visible: true, align: 'center', valign: 'middle'},
            {title: '监控申报数量', field: 'scheduleQty', visible: true, align: 'center', valign: 'middle'},
            {title: '已建数量', field: 'actualQty', visible: true, align: 'center', valign: 'middle'},
            {title: '区域负责人', field: 'masterName', visible: true, align: 'center', valign: 'middle'},
            {title: '设备更新日期', field: 'equipmentDate', visible: true, align: 'center', valign: 'middle'},
            {title: '录入ID', field: 'createId', visible: true, align: 'center', valign: 'middle'},
            {title: '录入日期', field: 'createDate', visible: true, align: 'center', valign: 'middle'},
            {title: '更新ID', field: 'updateId', visible: true, align: 'center', valign: 'middle'},
            {title: '更新日期', field: 'updateDate', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
VideoMain.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        VideoMain.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加监控管理
 */
VideoMain.openAddVideoMain = function () {
    var index = layer.open({
        type: 2,
        title: '添加监控管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/videoMain/videoMain_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看监控管理详情
 */
VideoMain.openVideoMainDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '监控管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/videoMain/videoMain_update/' + VideoMain.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除监控管理
 */
VideoMain.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/videoMain/delete", function (data) {
            Feng.success("删除成功!");
            VideoMain.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("videoMainId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询监控管理列表
 */
VideoMain.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    VideoMain.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = VideoMain.initColumn();
    var table = new BSTable(VideoMain.id, "/videoMain/list", defaultColunms);
    table.setPaginationType("client");
    VideoMain.table = table.init();
});
