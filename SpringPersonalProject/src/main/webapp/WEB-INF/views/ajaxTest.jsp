<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- jQuery 1.8 -->
<script src="/resources/assets/js/jquery-1.8.3.min.js"></script>
<style>
	#modifyDiv {
		width:500px;
		height:100px;
		background-color:gray;
		position:absolute;
		top:20%;
		left:30%;
		padding:20px;
		z-index:100;
	}
</style>

</head>
<body>
<h3>Reply Rest + Ajax Test</h3>
<div id="modifyDiv" style="display:none;">
	<span class='title-dialog'></span> th comment
	<div>
		<input type="text" id="replyContent">
	</div>
	<div>
		<button type="button" id="modifyButton">modify</button>
		<button type="button" id="deleteButton">delete</button>
		<button type="button" id="closeButton">close</button>
	</div>
</div>
<div>
	<div>
		Writer : <input type="text" name="replyer" id="writer" />
	</div>
	<div>
		Comment : <input type="text" name="replyContent" id="addReplyContent" />
	</div>
	<br/>
	<button id="submitButton">Write Comment</button>
</div>

<h4>Comment List</h4>
<ul id="reply">
</ul>
<ul class="pageNumList">
</ul>
<script type="text/javascript">
	
	var boardId = 49135;
	getPageNum(1);
	
	//댓글 쓰기 처리
	$("#submitButton").on("click", function(){
		var replyWriter = $("#writer").val();
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
				if (result ==  'success'){
					alert("comment writer success!!");
					getReplyListAll();
				}
			}
		});
	});
	
	//
	
	function getReplyListAll(){
		//function()은 콜백함수
		///replies/selectAll/:댓글 리스트를 가져오는 URL
		//JSON데이터를 [data]변수에 담아서 사용한다.
		$.getJSON("/replies/selectAll/" +  boardId, function(data){
			//console.log(data.length);
			
			var str = "";
			
			$(data).each(function(){
				str += "<li data-replyId='" + this.replyId + "'class='replyList'>"
					+ this.replyId + "|" + this.replyContent
					+ "<button>modify</button>"
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
				str += "<li data-replyId='" + this.replyId + "'class='replyListPage'>"
					+ this.replyId + "|" + this.replyContent
					+ "<button>modify</button>"
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
			str += "<a href='"+i+"'><button type='button'>"+i+"</button></a>";
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
	$("#reply").on("click", ".replyList button", function(){
		var li = $(this).parent();
		var replyId = li.attr("data-replyId");
		var replyContent = li.text();
		
		//alert(replyId + ":" + replyContent);
		$(".title-dialog").html(replyId);
		$("#replyContent").val(replyContent);
		$("#modifyDiv").show("slow");
	});
	
	//delete
	$("#deleteButton").on("click", function(){
		var replyId = $(".title-dialog").html();
		var replyContent = $("#replyContent").val();
		
		$.ajax({
			type:'delete',
			url:'replies/' + replyId,
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
	$("#modifyButton").on("click", function(){
		var replyId = $(".title-dialog").html();
		var replyContent = $("#replyContent").val();
		
		$.ajax({
			type:'put',
			url:'replies/' + replyId,
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
</body>
</html>