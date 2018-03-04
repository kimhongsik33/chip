<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@include file="../include/header.jsp" %>
<!-- Main -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
    	<h3><i class="fa fa-angle-right"></i> Write Page</h3>
    	
    	<!-- BASIC FORM ELELEMNTS -->
    	<div class="row mt">
    		<div class="col-lg-12">
            <div class="form-panel">
            	  <h4 class="mb"><i class="fa fa-angle-right"></i> Input Information</h4>
                <form class="form-horizontal style-form" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Title</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="subject">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Content</label>
                        <div class="col-sm-10">
                        	<textarea class="form-control" name="content" cols="4">
                        	</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Writer</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="writer">
                        </div>
                    </div>
                    <div class="form-group">
                    	<div class="col-sm-12" align="center">
                    		<button type="submit" class="btn btn-theme">Sign in</button>
                    	</div>
                    </div>
                </form>
            </div>
    		</div><!-- col-lg-12-->      	
    	</div><!-- /row -->
</section><!--/wrapper -->
</section><!-- /MAIN CONTENT -->
<%@include file="../include/footer.jsp" %>