/**
 * 初始化执法记录表详情对话框
 */
var ActionsInfoDlg = {
    actionsInfoData : {},
    validateFields: {
        actionDate: {
            validators: {
                notEmpty: {
                    message: '执法日期不能为空'
                }
            }
        },
        companyName: {
            validators: {
                notEmpty: {
                    message: '企业名称不能为空'
                }
            }
        },
        actionDept: {
            validators: {
                notEmpty: {
                    message: '执法主体不能为空'
                }
            }
        },
        actionDescribe: {
            validators: {
                notEmpty: {
                    message: '行政违法行为不能为空'
                }
            }
        },
        punishType: {
            validators: {
                notEmpty: {
                    message: '处罚种类不能为空'
                }
            }
        },
        lawClause: {
            validators: {
                notEmpty: {
                    message: '执法依据不能为空'
                }
            }
        }
    }
};




/**
 * 清除数据
 */
ActionsInfoDlg.clearData = function() {
    this.actionsInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ActionsInfoDlg.set = function(key, val) {
    this.actionsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ActionsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ActionsInfoDlg.close = function() {
    parent.layer.close(window.parent.Actions.layerIndex);
}

/**
 * 收集数据
 */
ActionsInfoDlg.collectData = function() {
    this
    .set('id')
    .set('companyName')
    .set('actionDescribe')
    .set('punishType')
    .set('lawClause')
    .set('actionDept')
    .set('actionDate')
    .set('createId')
    .set('createDate')
    .set('updateId')
    .set('updateDate');
}

/**
 * 提交添加
 */
ActionsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

   /* if (!this.validate()) {
        return;
    }
    */
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/actions/add", function(data){
        Feng.success("添加成功!");
        window.parent.Actions.table.refresh();
        ActionsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.actionsInfoData);
    ajax.start();
}

ActionsInfoDlg.validate = function () {
    $('#actionsInfoForm').data("bootstrapValidator").resetForm();
    $('#actionsInfoForm').bootstrapValidator('validate');
    return $("#actionsInfoForm").data('bootstrapValidator').isValid();
}

/**
 * 提交修改
 */
ActionsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

   /* if (!this.validate()) {
        return;
    }*/

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/actions/update", function(data){
        Feng.success("修改成功!");
        window.parent.Actions.table.refresh();
        ActionsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.actionsInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("actionsInfoForm", ActionsInfoDlg.validateFields);
});
