<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@include file="../include/header.jsp" %>
<!-- Main -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
    	<h3><i class="fa fa-angle-right"></i> Inquiry Page</h3>
		
		<!-- role 속성
			・HTML5에서 새롭게 추가된 속성
			・ARIA(Accessible Rich Internet Application) 라는 HTML5의 상세 규격 중 하나
			・시각장애인이 컴퓨터의 리더기를 사용해서 웹페이지를 읽을 때 [해당부분이form이다]라고 정의해 주는 것.
			・role은 필수 요소는 아니지만 화면용 리더기를 이용해야 하는 사람들에게도 불편함이 없는 사이트를 제공하고자 이 속성을 이용한다. 
		 -->
		<form role="form" method="post">
			<input type="hidden" name="boardId" value="${boardVO.boardId}" />
			<input type="hidden" name="page" value="${pageCriteria.page}" />
			<input type="hidden" name="numPerPage" value="${pageCriteria.numPerPage}" />
    	</form>
    	<!-- BASIC FORM ELELEMNTS -->
    	<div class="row mt">
    		<div class="col-lg-12">
            <div class="form-panel">
	            <form class="form-horizontal style-form" method="post">
					<h4 class="mb"><i class="fa fa-angle-right"></i> Inquiry Information</h4>
	                  <div class="form-group">
	                      <label class="col-sm-2 col-sm-2 control-label">Title</label>
	                      <div class="col-sm-10">
	                          <input type="text" class="form-control" name="subject" value="${boardVO.subject}" readonly="readonly">
	                      </div>
	                  </div>
	                  <div class="form-group">
	                      <label class="col-sm-2 col-sm-2 control-label">Content</label>
	                      <div class="col-sm-10">
	                      	<textarea class="form-control" name="content" cols="4" readonly="readonly">${boardVO.content}
	                      	</textarea>
	                      </div>
	                  </div>
	                  <div class="form-group">
	                      <label class="col-sm-2 col-sm-2 control-label">Writer</label>
	                      <div class="col-sm-10">
	                          <input type="text" class="form-control" name="writer" value="${boardVO.writer}" readonly="readonly">
	                      </div>
	                  </div>
				</form>
            </div> <!-- form-panel-->
            <div>
	    	  	<div class="col-sm-12" align="center">
			    	<button type="submit" id="btn_modify" class="btn btn-primary">modify</button>&nbsp;
			    	<button type="submit" id="btn_delete" class="btn btn-danger">delete</button>&nbsp;
			    	<button type="submit" id="btn_back" class="btn btn-info">back</button>
	    		</div>
	    	</div>
	    	
	    	<script>
	    		//$ 는 JQuery를 의미
	    		$(document).ready(function(){
	    			var frmObj = $("form[role='form']");
	    			console.log("you select the form tag");
	    			
	    			//modify
	    			$("#btn_modify").on("click", function(){
	    				frmObj.attr("action", "/board/modifyPage");
	    				frmObj.attr("method", "get");
	    				frmObj.submit();
	    			});
	    			
	    			//delete
	    			$(".btn-danger").on("click", function(){
	    				frmObj.attr("method", "get");
	    				frmObj.attr("action", "/board/deletePage");
	    				frmObj.submit();
	    			});
	    			
	    			//back
	    			$(".btn-info").on("click", function(){
	    				//self.location = "/board/list";
	    				frmObj.attr("method", "get");
	    				frmObj.attr("action", "/board/pageList");
	    				frmObj.submit();
	    			});
	    		});
	    	</script>
	    	
    		</div><!-- col-lg-12-->
    	</div><!-- /row -->
    	
</section><!--/wrapper -->
</section><!-- /MAIN CONTENT -->
<%@include file="../include/footer.jsp" %>