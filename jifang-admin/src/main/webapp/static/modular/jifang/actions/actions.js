/**
 * 执法记录表管理初始化
 */
var Actions = {
    id: "ActionsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Actions.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '企业名称', field: 'companyName', visible: true, align: 'center', valign: 'middle'},
            {title: '行政违法行为', field: 'actionDescribe', visible: true, align: 'center', valign: 'middle'},
            {title: '处罚种类', field: 'punishType', visible: true, align: 'center', valign: 'middle'},
            {title: '执法依据', field: 'lawClause', visible: true, align: 'center', valign: 'middle'},
            {title: '行政执法主体', field: 'actionDept', visible: true, align: 'center', valign: 'middle'},
            {title: '执法日期', field: 'actionDate', visible: true, align: 'center', valign: 'middle'},
            {title: '建立者', field: 'createId', visible: false, align: 'center', valign: 'middle'},
            {title: '建立日期', field: 'createDate', visible: false, align: 'center', valign: 'middle'},
            {title: '更改者', field: 'updateId', visible: false, align: 'center', valign: 'middle'},
            {title: '更改日期', field: 'updateDate', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Actions.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Actions.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加执法记录表
 */
Actions.openAddActions = function () {
    var index = layer.open({
        type: 2,
        title: '添加执法记录表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/actions/actions_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看执法记录表详情
 */
Actions.openActionsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '执法记录表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/actions/actions_update/' + Actions.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除执法记录表
 */
Actions.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/actions/delete", function (data) {
            Feng.success("删除成功!");
            Actions.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("actionsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询执法记录表列表
 */
Actions.search = function () {
    var queryData = {};
    queryData['companyName'] = $("#companyName").val();
    queryData['beginTime']=$("#beginTime").val();
    queryData['endTime'] =$("#endTime").val();
    Actions.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Actions.initColumn();
    var table = new BSTable(Actions.id, "/actions/list", defaultColunms);
    table.setPaginationType("client");
    Actions.table = table.init();
});
