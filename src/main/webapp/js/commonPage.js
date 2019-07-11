 	 //加载页面默认首页
	   	$(function(){
	   		to_page(1);
	   	});
	function to_page(pn){
			$.ajax({
				url:"emps",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					//console.log(result);
					 //1、解析并显示员工数据
					build_emps_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result); 
				}
			});
		}
		
	
		//1、解析并显示员工数据
		function build_emps_table(result){
			//清空tbody
			var tbody=$("#emps_table tbody");
			tbody.empty();
			var emps=result.map.pageInfo.list;
			var theadInfo=result.map.headInfo;
			//拿到表头单元行
			var thead=$("thead tr");
			thead.empty();
			thead.append("<th><input type='checkbox' id='check_all' /></th>")
				$.each(emps,function(index,item){
				//alert(index);
				//创建一个tr标签
				var tr=$("<tr></tr>");
				//创建一个全选按钮
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				//增加到tr里去
				tr.append(checkBoxTd);
				//找到th标签里带name属性的
				//创建编辑删除按钮
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				
				var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				//解析表头信息
				var count=0;
				for(var name in theadInfo){
					//当count为1  则证明此时name是id
					count++;
					if(index==0){
							thead.append("<th>"+theadInfo[name]+"</th>");
					}
					var value;
					//如果字符串包含"-",是级联属性,否则不是
					if(name.indexOf("-")!=-1){
						var arrName=name.split("-");
						value=item;
						//级联属性遍历
						for(var i in arrName){
						value=value[arrName[i]];
						}
					}else{
						value=item[name];
					}
					var result=$("<td></td>").append(value);
					//当count为1时，当前值为id
					if(count==1){
						//为编辑按钮添加一个自定义的属性，来表示当前员工id
						editBtn.attr("edit-id",value);
						//为删除按钮添加一个自定义的属性来表示当前删除的员工id
						delBtn.attr("del-id",value);
					}
					tr.append(result);
				};
				//append方法执行完成以后还是返回原来的元素
					tr.append(btnTd)
					.appendTo(tbody);
		});
			thead.append("<th>操作</th>");
		};
		//2、解析并显示分页信息
		var  currentPage,lastPage;
		function build_page_info(result){
			$("#page_info_area").empty();
			var pageInfo=result.map.pageInfo;
			$("#page_info_area").append("当前是第"+pageInfo.pageNum+"页,总共"+
					pageInfo.pages+"页,总共"+
					pageInfo.total+"条记录");
			//总记录
			//当前页面
			currentPage =pageInfo.pageNum;
			lastPage=pageInfo.pages;
		}
		//3、解析显示分页条数据
		function build_page_nav(result){
			//page_nav_area
			$("#page_nav_area").empty();
			var pageInfo=result.map.pageInfo;
			var ul = $("<ul></ul>").addClass("pagination");
			
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			//如果没有前一页,前一页和首页的元素不可用
			if(pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页的事件
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(pageInfo.pageNum -1);
				});
			}
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			//如果没有下一页,则下一页和末页的元素不可用
			if(pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(pageInfo.pageNum +1);
				});
				lastPageLi.click(function(){
					to_page(pageInfo.pages);
				});
			}
			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(pageInfo.navigatepageNums,function(index,item){
				
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				//当前页面高亮  当前页的页码变突出
				if(pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
			
			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}