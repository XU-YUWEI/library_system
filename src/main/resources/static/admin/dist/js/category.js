$(function(){
	$("#jqGrid").jqGrid({
		url:'/admin/kind/list',
		datatype:"json",
		colModel: [
            {label: 'id', name: 'kindId', index: 'categoryId', width: 50, key: true, hidden: true},
            {label: '分类名称', name: 'kindTitle', index: 'categoryName', width: 240},
            {label: '添加时间', name: 'kindDate', index: 'createTime', width: 120}
        ],
        height: 560,
        rowNum: 10,
        rowList: [10, 20, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order",
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
	});
	$(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });
});

function reload() {
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger("reloadGrid");
}

function categoryAdd(){
	reset();
	$('.modal-title').html('添加分类');
	$('#categoryModal').modal('show');
}
function categoryEdit(){
	reset();
	var id = getSelectedRow();
	if(id==null){
		return;
	}
	$.get("/admin/kind/info/"+id,function(r){
		if(r.resultCode==200||r.data!=null){
			$('#categoryName').val(r.data.kindTitle);
		}
	});
	
	
	$('.modal-title').html('分类编辑');
    $('#categoryModal').modal('show');
    $("#categoryId").val(id);
}





$('#saveButton').click(function(){
	var kindName = $("#categoryName").val();
	if (!validCN_ENString2_18(kindName)) {
        $('#edit-error-msg').css("display", "block");
        $('#edit-error-msg').html("请输入符合规范的分类名称！");
    }else{
    	var params=$("#categoryForm").serialize();
    	var url='/admin/kind/addkind';
    	var id=getSelectedRowWithoutAlert();
    	if(id!=null){
    		url='/admin/kind/update';
    	}
    	
    	$.ajax({
    		type:'POST',
    		url:url,
    		data:params,
    		success:function(result){
    			if(result.resultCode==200){ 
    				$('#categoryModal').modal('hide');
    				swal("保存成功",{
    					icon:"success",
    				});
    				reload();
    			}
    			else{
    				$('#categoryModal').modal('hide');
    				swal(result.message,{
    					icon:"error",
    				});
    			}
    		},
    		error:function(){
    			swal("操作失败",{
    				icon:"error"
    			});
    		}
    	});
    }
});

function deleteCagegory(){
	var ids = getSelectedRows();
	if(ids == null){
		return;
	}
	swal({
		title:"确认弹框",
		text:"确认要删除数据吗?",
		icon:"warning",
		buttons:true,
		dangerMode:true,
	}).then((flag) =>{
		if(flag){
			$.ajax({
				type:"POST",
				url:"/admin/kind/delete",
				contentType:"application/json",
				data:JSON.stringify(ids),
				success:function(r){
					if(r.resultCode == 200){
						swal("删除成功",{
							icon:"success",
						});
						$("#jqGrid").trigger("reloadGrid");
					}else{
						swal(r.message, {
                            icon: "error",
                        });
					}
				}
			});
		}
	});
}


function reset() {
    $("#categoryName").val('');
    $('.alert-danger').css("display", "none");
}

