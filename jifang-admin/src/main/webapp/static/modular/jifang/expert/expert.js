/**
 * 专家库管理管理初始化
 */
var Expert = {
    id: "ExpertTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Expert.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '专家编号', field: 'expertCode', visible: true, align: 'center', valign: 'middle'},
            {title: '专家姓名', field: 'expertName', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'sexName', visible: true, align: 'center', valign: 'middle'},
            {title: '出生日期', field: 'birthday', visible: true, align: 'center', valign: 'middle',
                formatter: function (value, row, index){return value.substring(0,10)}
            },
            {title: '政治面貌', field: 'politics', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'idNumber', visible: false, align: 'center', valign: 'middle'},
            {title: '照片', field: 'photo', visible: false, align: 'center', valign: 'middle'},
            {title: '职务', field: 'position', visible: false, align: 'center', valign: 'middle'},
            {title: '职称', field: 'professorGrade', visible: false, align: 'center', valign: 'middle'},
            {title: '专业类别', field: 'professorType', visible: true, align: 'center', valign: 'middle'},
            {title: '从事专业年限', field: 'professorAge', visible: false, align: 'center', valign: 'middle'},
            {title: '最高学历', field: 'eduction', visible: false, align: 'center', valign: 'middle'},
            {title: '最高学位', field: 'degree', visible: true, align: 'center', valign: 'middle'},
            {title: '所在地区', field: 'address', visible: false, align: 'center', valign: 'middle'},
            {title: '所属行业', field: 'trade', visible: false, align: 'center', valign: 'middle'},
            {title: '创建ID', field: 'createId', visible: false, align: 'center', valign: 'middle'},
            {title: '创建日期', field: 'createDate', visible: false, align: 'center', valign: 'middle'},
            {title: '更新ID', field: 'updateId', visible: false, align: 'center', valign: 'middle'},
            {title: '更新日期', field: 'updateDate', visible: false, align: 'center', valign: 'middle'},
            {title: '联系电话', field: 'phone', visible: false, align: 'center', valign: 'middle'},
            {title: '电子邮箱', field: 'eMail', visible: false, align: 'center', valign: 'middle'},
            {title: '单位电话', field: 'companyPhone', visible: false, align: 'center', valign: 'middle'},
            {title: '工作单位', field: 'companyName', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Expert.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Expert.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加专家库管理
 */
Expert.openAddExpert = function () {
    var index = layer.open({
        type: 2,
        title: '添加专家库管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/expert/expert_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看专家库管理详情
 */
Expert.openExpertDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '专家库管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/expert/expert_update/' + Expert.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除专家库管理
 */
Expert.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/expert/delete", function (data) {
            Feng.success("删除成功!");
            Expert.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("expertId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询专家库管理列表
 */
Expert.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Expert.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Expert.initColumn();
    var table = new BSTable(Expert.id, "/expert/list", defaultColunms);
    table.setPaginationType("client");
    Expert.table = table.init();
});
