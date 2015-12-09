<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->

		<!-- general form elements -->


		<!-- /.box-header -->

		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<table class="table table-bordered">
					<tr>
						<th style="width: 10px">BNO</th>
						<th>TITLE</th>
						<th>WRITER</th>
						<th>REGDATE</th>
						<th style="width: 40px">VIEW</th>
					</tr>
				<c:forEach items="${list }" var="boardVO">
					<tr>
						<td>${boardVO.bno }</td>
						<td><a href='/board/read?bno=${boardVO.bno }'>${boardVO.title }
						<strong>[${boardVO.replyCount }]</strong></a></td>
						<td>${boardVO.writer }</td>
						<td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${boardVO.regDate }"/></td>
						<td><span class="badge bg-red">${boardVO.viewCount }</span></td>
					</tr>
				</c:forEach>
					
				</table>
				
				<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev }">
					<li><a href="listpage?pageNo=${pageMaker.startPage - 1}">&laquo;</a></li>
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage}"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.pageNo == idx?'class=active':''}"/>>
						<a href="listpage?pageNo=${idx }">${idx}</a>
					</li>
					</c:forEach>
					
					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a href="listpage?pageNo=${pageMaker.endPage + 1}">&raquo;</a></li>
					</c:if>
				
				</ul>
				</div>
				
				<!-- /.box-body -->
				
				<div class="box-footer">Footer</div>
				<!-- /.box-footer -->
			</div>
		</div>


		<!-- /.box -->
	</div>
	<!--/.col (left) -->


	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>