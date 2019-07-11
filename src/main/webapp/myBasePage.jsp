<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>分区列表</title>
		<%
			pageContext.setAttribute("APP_PATH", request.getContextPath());
		%>
		<script type="text/javascript" src="${APP_PATH }/js/jquery-1.12.4.min.js"></script>
		<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${APP_PATH }/js/commonPage.js"></script>

		<!-- <script type="text/javascript" src="/ssm/js/jquery-1.12.4.min.js"></script>
		<link href="/ssm/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="/ssm/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/ssm/js/commonPage.js"></script> -->

		 <!-- <script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
		<link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
		<script type="javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="javascript" src="/js/commonPage.js"></script> --> 

	</head>

	<body>
		<!-- 员工修改的模态框 -->
		<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<!-- 员工修改模态框的头部 -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
						<h4 class="modal-title">员工修改</h4>
					</div>
					<!--员工修改模态框的主体  -->
					<div class="modal-body">
						<!-- 表单开始 -->
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">subareaId</label>
								<div class="col-sm-10">
									<input type="text" name="subareaId" class="form-control" id="subareaId_add_input" placeholder="subareaId"> <span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">sortCode</label>
								<div class="col-sm-10">
									<input type="text" name="sortCode" class="form-control" id="empName_add_input" placeholder="sortCode"> <span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">subarea</label>
								<div class="col-sm-10">
									<input type="text" name="subarea" class="form-control" id="email_add_input" placeholder="subarea"> <span class="help-block"></span>
								</div>
							</div>
						</form>
						<!-- 表单结束 -->
					</div>
					<!--员工修改模态框的尾部，包含关闭更新按钮  -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 员工添加的模态框 -->
		<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<!-- 模态框内容 -->
				<div class="modal-content">
					<!-- 内容头部 -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
						<h4 class="modal-title" id="myModalLabel">员工添加</h4>
					</div>
					<!-- 内容主体 -->
					<div class="modal-body">
						<!-- 表单开始-->
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">subareaId</label>
								<div class="col-sm-10">
									<input type="text" name="subareaId" class="form-control" id="empName_add_input" placeholder="subareaId"> <span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">sortCode</label>
								<div class="col-sm-10">
									<input type="text" name="sortCode" class="form-control" id="empName_add_input" placeholder="sortCode"> <span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">position</label>
								<div class="col-sm-10">
									<input type="text" name="position" class="form-control" id="email_add_input" placeholder="position"> <span class="help-block"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">areaId</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" name="areaId" class="form-control" id="email_add_input" placeholder="areaId"> <span class="help-block"></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">province</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" name="province" class="form-control" id="email_add_input" placeholder="province"> <span class="help-block"></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">city</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" name="city" class="form-control" id="email_add_input" placeholder="city"> <span class="help-block"></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">county</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" name="county" class="form-control" id="email_add_input" placeholder="county"> <span class="help-block"></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">setAreaId</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" name="setAreaId" class="form-control" id="email_add_input" placeholder="setAreaId"> <span class="help-block"></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">setArea</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" name="setArea" class="form-control" id="email_add_input" placeholder="setArea"> <span class="help-block"></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">useable</label>
								<div class="col-sm-10">
									<div class="col-sm-10">
										<input type="text" name="useable" class="form-control" id="email_add_input" placeholder="areaId"> <span class="help-block"></span>
									</div>
								</div>
							</div>
						</form>
						<!-- 表单结束 -->
					</div>
					<!-- 内容主题关闭和保存按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
					</div>

				</div>
			</div>
		</div>

		<div class="container">

			<!-- 标题-->
			<div class="row">
				<div class="col-md-12">
					<h1>SSM-CURD</h1>
				</div>
			</div>
			<hr />
			<!--搜索框  -->
			<div class="row">
				<div class="col-lg-4">
					<div class="input-group">
						<span class="input-group-addon"> <input type="checkbox" class="isSelect1" aria-label="..." isSelectCode="0"> </span> 
						<input type="text" class="form-control queryProvince" aria-label="..." placeholder="请输入您要查询分区所在的省份">
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
				<div class="col-lg-4">
					<div class="input-group">
						<span class="input-group-addon"> <input type="checkbox" class="isSelect2" aria-label="..." isSelectCode="0" /></span> 
						<input type="text" class="form-control queryCity" aria-label="..." placeholder="请输入您要查询分区所在的市">
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
				<div class="col-lg-4">
					<div class="input-group">
						<input type="text" class="form-control querySubarea" id="" placeholder="请输入您要查询分区名" />
						<span class="input-group-btn">
							<button class="btn btn-default" id="search" type="button">Go!</button>
						</span>
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
			</div>
			<!-- /.row -->
			<br />
			<!-- 按钮 -->
			<div class="row">
				<div class="col-md-4">
					<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
					<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
				</div>
			</div>
			<br />
			<!-- 显示表格数据 -->
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover" id="emps_table">
						<thead>
							<tr>
								<!-- 要显示的字段开始  从后端拿过来-->

								<!-- 要显示的字段结束 -->
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-5 col-md-offset-1" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area"></div>
		</div>

		</div>
		
		
		
		
		
		<script type="text/javascript">
			//复合模糊查询
			
			isSelect($(".isSelect1"));
			isSelect($(".isSelect2"));
			//var queryStrs=new Array();
			var queryStrsMap=new Map();
			/*var querySubarea;
			var queryProvince;
			var queryCity;*/
			$("#search").click(function() {
				
				//清空
				//queryStrs.splice(0,(queryStrs.length));
				queryStrsMap.clear();
				/*var querySubarea=null;
				var queryProvince=null;
				var queryCity=null;*/
				
				if($(".isSelect1").attr("isSelectCode")=="1"){
					//queryStrs.push($(".queryProvince").val());
					queryStrsMap.set("bluQueryProvince",$(".queryProvince").val());
					//queryProvince=$(".queryProvince").val();
				}
				if($(".isSelect2").attr("isSelectCode")=="1"){
					//queryStrs.push($(".queryCity").val());
					queryStrsMap.set("bluQueryCity",$(".queryCity").val());
					//queryCity=$(".queryCity").val();
				}
				//queryStrs.push($(".querySubarea").val());
				//alert($(".querySubarea").val())
				queryStrsMap.set("bluQuerySubarea",$(".querySubarea").val());
				
				alert(queryStrsMap.get("bluQuerySubarea"));
				//querySubarea=$(".querySubarea").val();
				//alert("querySubarea的值为:"+querySubarea);
				
				
				//$(this).css("backgroundColor","#d9534f");
				
				//alert(queryStrsMap.toString())
				//循环遍历map
				/*queryStrsMap.forEach(function (item, key, mapObj) {
					alert(item.toString())
				});*/
				
				//先将map对象转为obj对象
			    let obj= Object.create(null);
			    for (let[k,v] of queryStrsMap) {
			      obj[k] = v;
			    }
			    //再将obj对象转为json格式的字符串
				var str = JSON.stringify(obj); 
				alert(str)
				$.ajax({
					type:"get",
					url:"bluQuery/"+str,
					async:true,
					success:function(){
						//alert("success");
					}
				});
				//alert(queryStrs.toString());
			})
			
			
			
			
			
			
			
			/*判断多选框是否勾选 页面的isSelectCode属性值设为0*/
			function isSelect(checkbox){
				checkbox.click(function(){
					var isSelect=$(this).attr("isSelectCode");
					if(isSelect == "0"){
						$(this).attr("isSelectCode","1")
						//alert($(this).attr("isSelectCode"))
					}else{
						$(this).attr("isSelectCode","0")
						//alert($(this).attr("isSelectCode"))
					}
				})
			}
			
			
			
			/* 	function onKeyDown(event){
				                 var e = event || window.event || arguments.callee.caller.arguments[0];
				                if(e && e.keyCode==27){ // 按 Esc 
				                    //要做的事情
				                }
				                if(e && e.keyCode==113){ // 按 F2 
				                      //要做的事情
				                 }            
				                 if(e && e.keyCode==13){ // enter 键
				                      alert("此处回车触发搜索事件");
				               }
				                 
				             } */
			//清空表单样式及内容
			function reset_form(ele) {
				$(ele)[0].reset();
				//清空表单样式
				$(ele).find("*").removeClass("has-error has-success");
				$(ele).find(".help-block").text("");
			}
			//点击新增按钮
			$("#emp_add_modal_btn").click(function() {
				//清除表单数据（表单完整重置（表单的数据，表单的样式））
				reset_form("#empAddModal form");
				//s$("")[0].reset();
				//发送ajax请求，查出部门信息，显示在下拉列表中
				getDepts("#empAddModal select");
				//弹出模态框
				$("#empAddModal").modal({
					backdrop: "static"
				});

			})

			//查出所有的部门信息并显示在下拉列表中
			function getDepts(ele) {
				//清空之前下拉列表的值
				$(ele).empty();
				$.ajax({
					url: "${APP_PATH}/depts",
					type: "GET",
					success: function(result) {
						//{"code":100,"msg":"处理成功！",
						//"extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
						//console.log(result);
						//显示部门信息在下拉列表中
						//$("#empAddModal select").append("")
						$.each(result.map.depts, function() {
							var optionEle = $("<option></option>").append(
								this.deptname).attr("value", this.deptid);
							optionEle.appendTo(ele);
						})
					}
				})
			};
			//新增的保存
			$("#emp_save_btn").click(function() {
				alert($("#empAddModal form").serialize());
				//2、发送ajax请求保存员工
				$.ajax({
					url: "${APP_PATH}/subarea",
					type: "POST",
					data: $("#empAddModal form").serialize(), //把表单的数据提交给后端  
					success: function(result) {
						//alert(result.msg);
						if(result.code == 100) {
							//员工保存成功；
							//1、关闭模态框
							$("#empAddModal").modal('hide');

							//2、来到最后一页，显示刚才保存的数据
							//发送ajax请求显示最后一页数据即可
							to_page(lastPage + 1);
						}
					}
				})
			});
			//点击编辑员工更新
			$(document).on("click", ".edit_btn", function() {
				var empId = $(this).attr("edit-id");
				//2、查出员工信息，显示员工信息
				getEmpById(empId);
				//1、查出部门信息，并显示部门列表
				getDepts("#empUpdateModal select");
				//3、把员工的id传递给模态框的更新按钮
				$("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));
				//弹出模态框
				$("#empUpdateModal").modal({
					backdrop: "static"
				});

			});
			//编辑完成后点击完成
			$("#emp_update_btn").click(function() {
				var subareaId = $(this).attr("edit-id");
				//2、发送ajax请求保存员工
				$.ajax({
					url: "${APP_PATH}/subarea/" + subareaId,
					type: "PUT",
					data: $("#empUpdateModal form").serialize(), //把表单的数据提交给后端  
					success: function(result) {
						alert(result.msg);
						if(result.code == 100) {
							//员工保存成功；
							//1、关闭模态框
							$("#empUpdateModal").modal('hide');
							//2、来到当前页面，显示刚才更新完的数据
							to_page(currentPage);
						}
					}
				})
			});
			//编辑完成后点击完成  用post转put
			/* $("#emp_update_btn").click(function(){
				var empId=$(this).attr("edit-id");
				alert($("#empUpdateModal form").serialize());
				//2、发送ajax请求保存员工
				$.ajax({
					url:"${APP_PATH}/emp/"+empId,
					type:"POST",
					data:$("#empUpdateModal form").serialize()+"&_method=PUT",   //把表单的数据提交给后端  
					success:function(result){
						alert(result.msg);
						if(result.code == 100){
							//员工保存成功；
							//1、关闭模态框
							$("#empUpdateModal").modal('hide');
							//2、来到当前页面，显示刚才更新完的数据
							to_page(currentPage);
							}
				}
				})
			}); */
			//在更新前通过Id先查询出emp
			function getEmpById(id) {
				$.ajax({
					url: "${APP_PATH}/subarea/" + id,
					type: "GET",
					success: function(result) {
						console.log(result);
						var empData = result.map.subarea;
						$("#subareaId_add_input").val(empData.subareaId);
						$("#empUpdateModal input[name=sortCode]").val(empData.sortCode);
						$("#empUpdateModal input[name=subarea]").val(empData.subarea);
					}
				});
			}

			//单个删除按钮
			$(document).on("click", ".delete_btn", function() {
				//1、弹出是否确认删除对话框
				var subarea = $(this).parents("tr").find("td:eq(2)").text();
				var subareaId = $(this).attr("del-id");
				if(confirm("确认删除【" + subarea + "】吗？")) {
					$.ajax({
						url: "${APP_PATH}/subarea/" + subareaId,
						type: "DELETE",
						success: function(result) {
							if(result.code == 100) {
								alert("删除成功");
							} else {
								alert("删除失败");
							}
							//回到本页
							to_page(currentPage);
						}
					})
				}

			});

			//完成全选/全不选功能
			$("#check_all").click(function() {
				//attr获取checked是undefined;
				//我们这些dom原生的属性；attr获取自定义属性的值；
				//prop修改和读取dom原生属性的值
				$(".check_item").prop("checked", $(this).prop("checked"));
			});
			//check_item 
			$(document)
				.on(
					"click",
					".check_item",
					function() {
						//判断当前选择中的元素是否5个
						var flag = $(".check_item:checked").length == $(".check_item").length;
						$("#check_all").prop("checked", flag);
					});
			//点击全部删除，就批量删除
			$("#emp_delete_all_btn").click(
				function() {
					//
					var empNames = "";
					var del_idstr = "";
					if($(".check_item:checked").length > 0) {
						$.each($(".check_item:checked"), function() {
							//this
							empNames += $(this).parents("tr").find("td:eq(2)")
								.text() +
								",";
							//组装员工id字符串
							del_idstr += $(this).parents("tr").find("td:eq(1)")
								.text() +
								"-";
						});
						//去除empNames多余的,
						empNames = empNames.substring(0, empNames.length - 1);
						//去除删除的id多余的-
						del_idstr = del_idstr
							.substring(0, del_idstr.length - 1);
						if(confirm("确认删除【" + empNames + "】吗？")) {
							//发送ajax请求删除
							$.ajax({
								url: "${APP_PATH}/subarea/" + del_idstr,
								type: "DELETE",
								success: function(result) {
									alert(result.msg);
									//回到当前页面
									to_page(currentPage);
								}
							});
						}
					} else {
						alert("请至少选择一个要删除的对象");
					}

				});
		</script>
	</body>

</html>