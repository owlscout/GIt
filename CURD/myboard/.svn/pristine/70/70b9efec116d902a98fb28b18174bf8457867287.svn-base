<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	
	<h4>댓 글</h4>
	<div>
		<c:choose>
			<c:when test="${empty list }">
					<p>--------작성된 댓글이 없습니다-----------</p>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list" varStatus="status">
					<div>
					<c:forEach begin="1" end="${list.titletab }">
						&emsp;&emsp;
					</c:forEach>
					<div class="row">
						<div class="comment-util">
							<span class="username"> ${list.username }&emsp;&emsp;</span>
                        	<span class="cdate"> ${list.cdate }&emsp;&emsp;</span>
						</div>
						<p>
							<textarea rows="3" cols="60" readonly="readonly">${list.ccontent }</textarea>
						</p>
						<div class="comment-button">
							&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
							<c:if test="${login.username eq list.username }">
							<button class="btn-update" onclick="onclickUpdateComment(${status.index})">수정</button>
							<input type="button" value="삭제" onclick="location.href='cdelete.do?commentno=${list.commentno}&myno=${dto.myno}&nowPage=${nowPage} '">
							</c:if>
							<c:if test="${login != null && list.titletab < 3}">
							 <button class="btn-answer" onclick="onClickAnswerComment(${status.index})">답글달기</button>
							</c:if>
						</div>
						<br/>
					</div>
					</div>
					<!-- 댓글 수정 -->
					<div class="updatetext">
						<form action="cupdate.do" method="post">
							<div>
								<input type="hidden" name="nowPage" value="${nowPage }">
								<input type="hidden" name="commentno" value="${list.commentno }">
								<textarea rows="3" cols="60" class="updatecontent" name="ccontent">${list.ccontent }</textarea>
							</div>
							<input type="submit" value="댓글 수정">
						</form>
						<br/>
					</div>
					<!-- 답글 -->
					<div class="answertext">
						<form action="answer.do" method="post">
							<div>
								<input type="hidden" name="nowPage" value="${nowPage }">
								<input type="hidden" name="myno" value="${dto.myno }">
								<input type="hidden" name="commentno" value="${list.commentno }">
								<input type="hidden" name="username" value="${login.username }">
								<textarea rows="3" cols="60" name="ccontent"></textarea>
							</div>
							<input type="submit" value="답글 등록">
						</form>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<h4>댓글 달기</h4>
		<c:choose>
			<c:when test="${empty login }">
				<p>------ 로그인을 하시면 댓글을 쓰실 수 있습니다----</p>
			</c:when>
			<c:otherwise>
			<div class="comment">
				<form action="cinsert.do" method="post">
					<div>
						<input type="hidden" name="nowPage" value="${nowPage }">
						<input type="hidden" name="myno" value="${dto.myno }">
						<input type="hidden" name="username" value="${login.username }">
						<textarea rows="3" cols="60" name="ccontent"></textarea>
					</div>
					<p><input type="submit" value="댓글 등록"></p>
				</form>
			</div>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>