<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
<!--
 //javascript代码函数，处理上一页，下一页的问题
function go(no){
	
     $("#pageNo").val(no);
    $("#domainForm").submit();

}
function updateDomain(url,id){
 
 //domainFrom表单的id,attr：属性，即action 属性：employee
	$("#domainForm").attr("action",url+"_showForum.action?id="+id);
    $("#domainForm").submit();
    $("#domainForm").attr("action",url+".action");
}
function updateDomain(url,id){
	$("#domainForm").attr("action",url+"_input.action?id="+id);
    $("#domainForm").submit();
    $("#domainForm").attr("action",url+".action");
}

//发出一个ajax删除的请求
//每次删除并不刷新，而是在当前页中把当前table中的tr给删除了
function deleteDomain(src,url,idValue){
	$.get(url, { id: idValue },function(data){
	//因为返回的是json,如果返回的不是json就无法解析，当针对权限删除处理的时候，要另外的处理
	if(data instanceof Object){
	  if(data.success){
		//查询出id= itemTable 中的table中tr还有几个（好像利用之前学的技术xPath技术），如果是两个，则就会刷新页面
		  	if($("#itemTable tr").size()==2){//删除后只剩下一行数据+表头
		   		$("#domainForm").submit();
			}else{//直接js操作
				//src=a  a->td->tr，a标签向上找，找到tr,然后就会把当前的那一行数据给删除了
		   	    $(src).closest("tr").remove(); 	
				//修改总的记录数
				//var totalCount=$("#totalCount").html()-1;
		   	    //alert(totalCount);		
		   	    $("#totalCount").html($("#totalCount").html()-1);
			}
		}else{
		   	alert(data.msg);
		}
	}else{
	//返回的是一个字符串
		alert(data);
	}
		
	}); 
}
//-->
</script>
<div class="content-bbg">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								&nbsp;
							</td>
							 <td>共<span id="totalCount">${pageResult.totalCount}</span>条记录</td>
							<td>
								当前第
								<span style="color: red;">${pageResult.currentPage}</span>/${pageResult.totalPage}
							</td>
							<td>
								每页${pageResult.pageSize}条记录
							</td>
					<!-- 		<td>
								分页:

							</td> -->
							<td>
								<s:if test="pageResult.currentPage==1">
									<td>
										首页
									</td>
									<td>
										上一页
									</td>
								</s:if>
								<s:else>
									<td>
										<a href="#" onclick="go(1)">首页</a>
									</td>
									<td>
										<a href="#" onclick="go(${pageResult.currentPage-1})">上一页</a>
									</td>
								</s:else>
								<s:if test="pageResult.currentPage==pageResult.totalPage">
									<td>
										下一页
									</td>
									<td>
										末页
									</td>
								</s:if>
								<s:else>
									<td>
										<a href="#" onclick="go(${pageResult.currentPage+1})">下一页</a>
									</td>
									<td>
										<a href="#" onclick="go(${pageResult.totalPage})">末页</a>
									</td>
								</s:else>
							</td>
							<!-- name:属性是用来将数据设置到类中，而value属性是:用来将值回显的 -->
							<td>
								<s:textfield id="pageNo" name="baseQuery.currentPage"
									value="%{pageResult.currentPage}" size="2" />
								<s:submit value="go" />
								<s:select list="{5,10,15,20}" name="baseQuery.pageSize"
									onchange="document.forms[0].submit();" />
								<!-- document.forms[0].submit()：document对象拿到所有的表单，但是当前就一个表单，所以{}为第0个然后提交 -->
							</td>
						</tr>
					</table>
				</div>
			</div>