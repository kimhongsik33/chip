<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@include file="../include/header.jsp" %>
<!-- Main -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
    	<h3><i class="fa fa-angle-right"></i> Modify Page</h3>
		
		<!-- role 속성
			・HTML5에서 새롭게 추가된 속성
			・ARIA(Accessible Rich Internet Application) 라는 HTML5의 상세 규격 중 하나
			・시각장애인이 컴퓨터의 리더기를 사용해서 웹페이지를 읽을 때 [해당부분이form이다]라고 정의해 주는 것.
			・role은 필수 요소는 아니지만 화면용 리더기를 이용해야 하는 사람들에게도 불편함이 없는 사이트를 제공하고자 이 속성을 이용한다. 
		 -->
    	
    	<!-- BASIC FORM ELELEMNTS -->
    	<div class="row mt">
    		<div class="col-lg-12">
            <div class="form-panel">
	            <form class="form-horizontal style-form" role="form" method="post">
	            	<input type="hidden" name="page" value="${findCriteria.page}" />
	            	<input type="hidden" name="numPerPage" value="${findCriteria.numPerPage}" />
					<input type="hidden" name="findType" value="${findCriteria.findType}" />
					<input type="hidden" name="keyWord" value="${findCriteria.keyWord}" />
					
					<h4 class="mb"><i class="fa fa-angle-right"></i> Modify Information</h4>
	                  <div class="form-group">
	                      <label class="col-sm-2 col-sm-2 control-label">Content Id</label>
	                      <div class="col-sm-10">
	                          <input type="text" class="form-control" name="boardId" value="${boardVO.boardId}" readonly="readonly">
	                      </div>
	                  </div>
	                  <div class="form-group">
	                      <label class="col-sm-2 col-sm-2 control-label">Title</label>
	                      <div class="col-sm-10">
	                          <input type="text" class="form-control" name="subject" value="${boardVO.subject}">
	                      </div>
	                  </div>
	                  <div class="form-group">
	                      <label class="col-sm-2 col-sm-2 control-label">Content</label>
	                      <div class="col-sm-10">
	                      	<textarea class="form-control" name="content" cols="4">${boardVO.content}
	                      	</textarea>
	                      </div>
	                  </div>
	                  <div class="form-group">
	                      <label class="col-sm-2 col-sm-2 control-label">Writer</label>
	                      <div class="col-sm-10">
	                          <input type="text" class="form-control" name="writer" value="${boardVO.writer}">
	                      </div>
	                  </div>
				</form>
            </div> <!-- form-panel-->
            <div>
	    	  	<div class="col-sm-12" align="center">
			    	<button type="submit" id="btn_save" class="btn btn-primary">save</button>&nbsp;
			    	<button type="submit" id="btn_cancel" class="btn btn-warning">cancel</button>&nbsp;
	    		</div>
	    	</div>
	    	
	    	<script>
	    		$(document).ready(function(){
	    			var frmObj = $("form[role='form']");
	    			console.log("you select the form tag");
	    			
	    			//수정처리 페이지로 이동
	    			$("#btn_save").on("click", function(){
	    				//frmObj.attr("action", "/findBoard/modifyPage");
	    				frmObj.submit();
	    			});
	    			
	    			$("#btn_cancel").on("click", function(){
	    				//self.location="/board/list";
	    				self.location="/findBoard/pageList?page=${pageCriteria.page}&numPerPage=${pageCriteria.numPerPage}"
	    				+"&findType=${findCriteria.findType}&keyWord=${findCriteria.keyWord}";
	    			});
	    		});
	    	</script>
	    	
    		</div><!-- col-lg-12-->
    	</div><!-- /row -->
    	
</section><!--/wrapper -->
</section><!-- /MAIN CONTENT -->
<%@include file="../include/footer.jsp" %>