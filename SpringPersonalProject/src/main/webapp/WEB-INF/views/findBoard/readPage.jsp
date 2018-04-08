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
			<input type="hidden" name="page" value="${findCriteria.page}" />
			<input type="hidden" name="numPerPage" value="${findCriteria.numPerPage}" />
			<input type="hidden" name="findType" value="${findCriteria.findType}" />
			<input type="hidden" name="keyWord" value="${findCriteria.keyWord}" />
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
			
			<div class="col-sm-12" align="center">
				<button type="submit" id="btn_modify" class="btn btn-primary">modify</button>&nbsp;
                <button type="submit" id="btn_delete" class="btn btn-danger">delete</button>&nbsp;
                <button type="submit" id="btn_back" class="btn btn-info">back</button>
			</div>
	    	
	    	
	    	<!-- Comment Area -->
       		<div class="form-panel">
       			<h3>Comment Write</h3>
       			<div class="form-group">
                    <label class="col-sm-2 col-sm-2 control-label">Replyer</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="replyer" id="replyWriter" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 col-sm-2 control-label">Reply</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="replyContent" id="addReplyContent" />
                    </div>
                </div>
                <br/>
                <div class="form-group">
                	<div class="col-sm-12" align="right">
                		<button id="submitButton" class="btn btn-primary">Write Comment</button>
                	</div>
                </div>
                
                <br/>
                
                <h3>Comment List</h3>
                <div id="modifyDiv" style="display:none;">
					<span class='title-dialog'></span>
					<div>
						<input type="text" id="replyContent">
					</div>
					<div>
						<button type="button" id="replyModifyButton" class="btn btn-primary">modify</button>
						<button type="button" id="replyDeleteButton" class="btn btn-primary">delete</button>
						<button type="button" id="replyCloseButton" class="btn btn-primary">close</button>
					</div>
				</div>
                <!-- Comment List Area / Paging Number List -->
                <div class="form-group">
                    <ul id="reply">
					</ul>
                    <ul class="pageNumList">
                    </ul>
                </div>
       		</div>
	    
	    	
	    	<script>
	    		//$ 는 JQuery를 의미
	    		$(document).ready(function(){
	    			var frmObj = $("form[role='form']");
	    			console.log("you select the form tag");
	    			
	    			//modify
	    			$("#btn_modify").on("click", function(){
	    				frmObj.attr("action", "/findBoard/modifyPage");
	    				frmObj.attr("method", "get");
	    				frmObj.submit();
	    			});
	    			
	    			//delete
	    			$(".btn-danger").on("click", function(){
	    				//frmObj.attr("method", "get");
	    				frmObj.attr("action", "/findBoard/deletePage");
	    				frmObj.submit();
	    			});
	    			
	    			//back
	    			$(".btn-info").on("click", function(){
	    				//self.location = "/board/list";
	    				frmObj.attr("method", "get");
	    				frmObj.attr("action", "/findBoard/list");
	    				frmObj.submit();
	    			});
	    		});
	    		
	    		
	    		var boardId = '${boardVO.boardId}';
	    		getPageNum(1);
	    		
	    		//댓글 쓰기 처리
	    		$("#submitButton").on("click", function(){
	    			var replyWriter = $("#replyWriter").val();
	    			var replyContent = $("#addReplyContent").val();

	    			//[X-HTTP-Method-Override]
	    			//:REST,AJAX에서 GET,POST만 쓸수 있는 브라우저가 있는데 그 경우 위의 필터를 적용함으로써 그 밖에 다른 형식[PATCH,PUT등등]도 사용하능하게 된다.
	    			//이때 web.xml에 필터 등록을 해주어야 한다.(web.xmld의 hiddenHttpMethodFilter)
	    			$.ajax({
	    				type : 'post',
	    				url : '/replies',
	    				headers : {
	    					"Content-Type" : "application/json",
	    					"X-HTTP-Method-Override" : "POST"
	    				},
	    				dataType : 'text',
	    				data : JSON.stringify({
	    					boardId : boardId,
	    					replyer : replyWriter,
	    					replyContent : replyContent
	    				}),
	    				success : function(result){
	    					if (result == 'success'){
	    						alert("comment writer success!!");
	    						getReplyListAll();
	    					}
	    				}
	    			});
	    		});
	    		
	    		function getReplyListAll(){
	    			//function()은 콜백함수
	    			///replies/selectAll/:댓글 리스트를 가져오는 URL
	    			//JSON데이터를 [data]변수에 담아서 사용한다.
	    			$.getJSON("/replies/selectAll/" + boardId, function(data){
	    				//console.log(data.length);
	    				
	    				var str = "";
	    				$(data).each(function(){
	    					str += "<li data-replyId='" + this.replyId + "' class='replyListPage' data-replyContent='"+this.replyContent+"'>"
	    						+ this.replyId + "|" + this.replyContent
	    						+ "<button class='btn btn-primary'>modify</button>"
	    						+ "</li>";
	    				});
	    				$("#reply").html(str);
	    			});	
	    		}
	    		
	    		//페이징목록 페이지 만들기
	    		function getPageNum(page){
	    			$.getJSON("/replies/"+boardId+"/"+page, function(data){
	    				console.log(data.replyListPage.length);
	    				
	    				var str = "";
	    				$(data.replyListPage).each(function(){
	    					str += "<li data-replyId='" + this.replyId + "'class='replyListPage' data-replyContent='"+this.replyContent+"'>"
	    						+ this.replyId + "|" + this.replyContent
	    						+ "<button class='btn btn-primary'>modify</button>"
	    						+ "</li>";
	    				});
	    				$("#reply").html(str);
	    				
	    				showPageNum(data.pagingMaker);
	    			});
	    		}
	    		
	    		//페이지 목록 보기 함수
	    		function showPageNum(pagingMaker){
	    			var str = "";
	    			if(pagingMaker.prev){
	    				str += "<li><a href='"+(pagingMaker.startPage-1)+"'>◀</a></li>";
	    			}
	    			
	    			for(var i = pagingMaker.startPage, end = pagingMaker.endPage ; i <= end ; i++){
	    				str += "<a href='"+i+"'><button type='button' class='btn btn-primary'>"+i+"</button></a>";
	    			}
	    			
	    			if(pagingMaker.next){
	    				str += "<li><a href='"+(pagingMaker.endPage+1)+"'>▶</a></li>";
	    			}
	    			
	    			$(".pageNumList").html(str);
	    		}
	    		
	    		var replyPage = 1;
	    		//페이지번호를 클릭시 이벤트 발생
	    		$(".pageNumList").on("click", "a button", function(e){
	    			//preventDefault()：<a>태그에 화면전환이 일어나지 않도록 하는 역할을 한다.
	    			e.preventDefault();
	    			replyPage = $(this).parent().attr("href");
	    			getPageNum(replyPage);
	    		});
	    		
	    		
	    		//댓글 목록 가져오기
	    		$("#reply").on("click", ".replyListPage button", function(){
	    			var li = $(this).parent();
	    			var replyId = li.attr("data-replyId");
	    			//var replyContent = li.text();
	    			var replyContent = li.attr("data-replyContent");
	    			
	    			//alert(replyId + ":" + replyContent);
	    			$(".title-dialog").html(replyId);
	    			$("#replyContent").val(replyContent);
	    			$("#modifyDiv").show("slow");
	    		});
	    		
	    		//delete
	    		$("#replyDeleteButton").on("click", function(){
	    			var replyId = $(".title-dialog").html();
	    			var replyContent = $("#replyContent").val();
	    			
	    			$.ajax({
	    				type:'delete',
	    				url:'/replies/' + replyId,
	    				headers : {
	    					"Content-Type" : "application/json",
	    					"X-HTTP-Method-Override" : "DELETE"
	    				},
	    				dataType : 'text',
	    				success: function(result){
	    					console.log("result:" + result);
	    					if(result == 'success'){
	    						alert("delete success!!");
	    						$("#modifyDiv").hide("slow");
	    						getReplyListAll();
	    					}
	    				}
	    			});
	    		});
	    		
	    		//modify
	    		$("#replyModifyButton").on("click", function(){
	    			var replyId = $(".title-dialog").html();
	    			var replyContent = $("#replyContent").val();
	    			$.ajax({
	    				type:'put',
	    				url:'/replies/' + replyId,
	    				headers : {
	    					"Content-Type" : "application/json",
	    					"X-HTTP-Method-Override" : "PUT"
	    				},
	    				data : JSON.stringify({replyContent:replyContent}),
	    				dataType : 'text',
	    				success: function(result){
	    					console.log("result:" + result);
	    					if(result == 'success'){
	    						alert("modify success!!");
	    						$("#modifyDiv").hide("slow");
	    						getReplyListAll();
	    					}
	    				}
	    			});
	    		});
	    	</script>
	    	
    		</div><!-- col-lg-12-->
    	</div><!-- /row -->
    	
</section><!--/wrapper -->
</section><!-- /MAIN CONTENT -->
<%@include file="../include/footer.jsp" %>