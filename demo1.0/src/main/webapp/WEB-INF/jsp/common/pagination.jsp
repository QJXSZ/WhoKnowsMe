<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ page import="com.qjkobe.db.model.PagerImpl" %>
    <%
	PagerImpl pageInfo = (PagerImpl)request.getAttribute("page");
    if( pageInfo != null){
	//System.out.print(pageInfo.getPages());
	//System.out.print(pageInfo.getList().size() + "1111111111111111111111111");

	int currenPage = pageInfo.getPage();
	int allPages = pageInfo.getPageCount();
	int recordCount = pageInfo.getRecordCount();
	//System.out.print(allPages);
	
	int begin = currenPage + 1;
	int end = 9;
	
	if( allPages <= end){
		begin = 1;
		end = allPages;
	}
	else{	
		if( currenPage <= 5 ){
			begin = 1;
			end = 9;
		}
		else if( currenPage > 5 ){
			begin = currenPage - 4;
			end = 9;
						
			if( begin + end - 1 >  allPages ){
				begin = allPages - end + 1;
			}
			
		}
	}
%>
	<div class="row">
		<div class="col-md-12 col-sm-12">
		<div class="pull-left col-md-4" style="float:left" >每页显示条目&nbsp;<select id="chosepage">
			<option>20</option>
			<option>50</option>
			<option>100</option></select>
		</div>
			
			
			<div class="text-center col-md-2">
				共<%=recordCount%>条
			</div>
			
		
			<div class="dataTables_paginate paging_simple_numbers pull-right ">
				<ul class="pagination pagination-sm">
				
				<%
				   if( currenPage < 1){
				 %>				 
					  <li class="disabled"><a href="#">首页</a></li>					  
			     <%
				  }
				  else{
				%>
					 <li><a href="javascript:$('#page').val(<%=0%>); $('#pageCount').val(<%=allPages%>); document.queryForm.submit();">首页</a></li>			  
				<%
				  }
				 %>
					  
				<%
				   if( currenPage < 1){
				 %>				 
					  <li class="disabled"><a href="#">上一页</a></li>					  
			     <%
				  }
				  else{
				%>
					  <li><a href="javascript:$('#page').val(<%=currenPage-1%>);$('#pageCount').val(<%=allPages%>);  document.queryForm.submit();">上一页</a></li>					  
				<%
				  }
				 %>
				  <%
				  	for(int i = 0  ; i < end; i ++){
				  %>
				  		<li class='paginate_button <%=( (i) == currenPage)?"active":"" %>'><a href="javascript:$('#page').val(<%=begin + i - 1%>);  $('#pageCount').val(<%=allPages%>); document.queryForm.submit();"><%= begin + i %></a></li>
				  		
				  <%
				  	}				 
				  if( currenPage + 1 == allPages || allPages == 0){
				 %>				 
					  <li class="disabled"><a href="#">下一页</a></li>
					  
			     <%
				  }
				  else{
				%>
					  <li><a href="javascript:$('#page').val(<%=currenPage+1%>); $('#pageCount').val(<%=allPages%>); document.queryForm.submit();">下一页</a></li>
					  
				<%
				  }
				 %>
				 <%
				  					 
				  if( currenPage + 1 == allPages || allPages == 0){
				 %>				 
					  <li class="disabled"><a href="#">尾页</a></li>
					  
			     <%
				  }
				  else{
				%>
					  <li><a href="javascript:$('#page').val(<%=allPages-1%>); $('#pageCount').val(<%=allPages%>); document.queryForm.submit();">尾页</a></li>
					  
				<%
				  }
				 %>
				</ul>
			</div>
		</div>
	</div>
<% }%>

<script>
	$(function() {
		$("#chosepage").val($('#pagesize').val());
		$("#chosepage").change(function(){
			/* 
			var starttime = $("#starttime").val();
			var endtime = $("#endtime").val();
			if (starttime == "" || endtime == "") {
				alert("开始时间与结束时间不能为空");
				return false;
			}
			if (!checkEndTime()) {
				alert("开始时间不能小于结束时间");
				return false;
			}
			*/
			
			var pagenum = $(this).val();
			$('#pagesize').val($.trim(pagenum));
			$("#page").val(0);
			document.queryForm.submit();
		});
		
		function checkEndTime() {
			var starttime = $("#starttime").val();
			var endtime = $("#endtime").val();
			var start=new Date(starttime.replace("-", "/").replace("-", "/"));  
   			var end=new Date(endtime.replace("-", "/").replace("-", "/"));
   			if (end < start) {
				return false;
			}else{
				return true;
			}
		}
	});
</script>

