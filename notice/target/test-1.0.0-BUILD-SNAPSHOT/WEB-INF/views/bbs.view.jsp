<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>스프링프레임워크 게시판</title>
    <script>
function del(){
if (confirm("삭제하시겠습니까?")) document.form.submit();
}
</script>
</head>
<body>
    <form id="form" name="form" method="post" action="./delete">
        <input type="hidden" id="idx" name="idx" value="${object.idx}" />
    </form>
    <p>${object.subject}</p>
    <div>${object.content}</div>
    <div>
        <p>작성자 : ${object.user_name}</p>
        <p>등록일 : ${object.reg_datetime}</p>
    </div>
    <div>
        <input type="button" value="삭제" onclick="del()">    
        <input type="button" value="수정" onclick="location.href='./write?idx=${object.idx}' ">    
        <input type="button" value="목록" onclick="location.href='./' ">    
    </div>
</body>
</html>
