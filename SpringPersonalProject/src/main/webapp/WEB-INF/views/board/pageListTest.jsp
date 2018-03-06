<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>

<%@include file="../include/header.jsp" %>

<!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> List Page</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right"></i> List Information</h4>
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                              <tr>
                                  <th>Number</th>
                                  <th>Title</th>
                                  <th>Writer</th>
                                  <th>Register Date</th>
                                  <th class="numeric">Hit Count</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${list}" var="boardVO">
	                              <tr>
	                                  <td>${boardVO.boardId}</td>
	                                  <td><a href="/board/read?boardId=${boardVO.boardId}">${boardVO.subject}</a></td>
	                                  <td>${boardVO.writer}</td>
	                                  <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${boardVO.registerDate}"/></td>
	                                  <td class="numeric">${boardVO.hit}</td>
	                              </tr>
	                           </c:forEach>
                              </tbody>
                          </table>
                          </section>
                  </div><!-- /content-panel -->
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		</section><!--/wrapper -->
      </section><!-- /MAIN CONTENT -->
      <!--main content end-->
      
      <script>
      	var result = '${result}';
      	if(result == 'success'){
      		alert('Successfully completed.');
      	} 
      </script>
      
<%@include file="../include/footer.jsp" %>