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
                            <div align="center">
                                <span class="col-md-12">
		                          	<select name="findType">
									  <option value="N"
									      <c:out value="${findCriteria.findType==null?'selected':''}" />>-------------</option>
									  <option value="S"
									      <c:out value="${findCriteria.findType=='S'?'selected':''}" />>Subject</option>
									  <option value="C"
									      <c:out value="${findCriteria.findType=='C'?'selected':''}" />>Content</option>
									  <option value="W"
									      <c:out value="${findCriteria.findType=='W'?'selected':''}" />>Writer</option>
									  <option value="SC"
									      <c:out value="${findCriteria.findType=='SC'?'selected':''}" />>Subject+Content</option>
									  <option value="CW"
									      <c:out value="${findCriteria.findType=='CW'?'selected':''}" />>Content+Writer</option>
									  <option value="SCW"
									      <c:out value="${findCriteria.findType=='SCW'?'selected':''}" />>Subject+Content+Writer</option>
									</select>
									<input type="text" name="keyWord" id="keyWord" value="${findCriteria.keyWord}" />
									<button id="findButton">Search</button>
								</span> 
							</div>
							
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
	                                  <td><a href="/findBoard/readPage${pagingMaker.makeFindURI(pagingMaker.pageCriteria.page)}&boardId=${boardVO.boardId}">${boardVO.subject}</a></td>
	                                  <td>${boardVO.writer}</td>
	                                  <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${boardVO.registerDate}"/></td>
	                                  <td class="numeric">${boardVO.hit}</td>
	                              </tr>
	                           </c:forEach>
                              </tbody>
                          </table>
                          </section>
                  </div><!-- /content-panel -->
                  
    			  <div class="showback" align="center">
					  <div class="btn-group">
					  <c:if test="${pagingMaker.prev}">
					      <a href="list${pagingMaker.makeFindURI(pagingMaker.startPage - 1)}">
					          <button type="button" class="btn btn-theme03">◀</button>
					      </a>
					  </c:if>
					  <c:forEach begin="${pagingMaker.startPage}" end="${pagingMaker.endPage}" var="pageNumber">
					      <a href="list${pagingMaker.makeFindURI(pageNumber)}">
					          <button type="button"
					              class="<c:out value="${pagingMaker.pageCriteria.page == pageNumber ? 'btn btn-theme':'btn btn-default'}"/>">${pageNumber}</button>
					      </a>
					  </c:forEach>
					  <c:if test="${pagingMaker.next && pagingMaker.endPage > 0}">
					      <a href="list${pagingMaker.makeFindURI(pagingMaker.endPage + 1)}">
					          <button type="button" class="btn btn-theme03">▶</button>
					      </a>
					  </c:if>
					  </div>      				
      			  </div><!-- /showback -->
      				
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
      <script type="text/javascript">
          $(document).ready(function(){
              $('#findButton').on("click", function(e){
            	 self.location = 
            		 "list${pagingMaker.makeURI(1)}"
            		 + "&findType=" + $("select option:selected").val()
            		 + "&keyWord=" + $("#keyWord").val();
              });
          });
      </script>
      
<%@include file="../include/footer.jsp" %>