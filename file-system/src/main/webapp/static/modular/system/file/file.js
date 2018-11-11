/**
 * 文件管理管理初始化
 */
var File = {
    id: "FileTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

var purview=window.location.href.substring(window.location.href.lastIndexOf("\/") + 1, window.location.href.length);

/**
 * 初始化表格的列
 */
File.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '名称', field: 'fileName', visible: true, align: 'left', valign: 'middle'},
            /*{title: '分区', field: 'filePart', visible: true, align: 'left', valign: 'middle'},*/
            {title: '大小', field: 'fileSize', visible: true, align: 'right', valign: 'middle'},
            {title: '类型', field: 'fileType', visible: true, align: 'left', valign: 'middle'},
            {title: '下载', field: 'fileUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '上传时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifyTime', visible: true, align: 'center', valign: 'middle'},
            {title: '上传人', field: 'createUserId', visible: true, align: 'center', valign: 'middle'},
            {title: '修改人', field: 'modifyUserId', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
File.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        File.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加文件管理
 */
File.openAddFile = function () {
    var index = layer.open({
        type: 2,
        title: '添加文件管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/file/'+purview+'/file_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看文件管理详情
 */
File.openFileDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '文件管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/file/'+purview+'/file_update/' + File.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除文件管理
 */
File.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/file/"+purview+"/delete", function (data) {
            Feng.success("删除成功!");
            File.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("fileId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询文件管理列表
 */
File.search = function () {
    var queryData = {};
    queryData['condition'] = {name:$("#condition").val()};
    File.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = File.initColumn();
    var table = new BSTable(File.id, "/file/"+purview+"/list", defaultColunms);
    table.setPaginationType("server");
    table.setContentType("json");
    var queryData = {};
    queryData['condition'] = {name:$("#condition").val()};
    table.setQueryParams(queryData);
    File.table = table.init();
});
