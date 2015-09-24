<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>스프링프레임워크 게시판</title>
</head>
<body>
    <h1>${message}</h1>
    <form id="form" method="post" action="./write_ok">
        <input type="hidden" name="idx" id="idx" value="${object.idx}" />
        <div>
            <span>제목</span>
            <input type="text" id="subject" name="subject" value="${object.subject}" />
        </div>
        <div>
            <span>작성자</span>
            <input type="text" id="user_name" name="user_name" value="${object.user_name}" />
        </div>
        <div>
            <span>내용</span>
            <textarea id="content" name="content" rows="10" cols="20">
                ${object.content}
            </textarea>
        </div>
        <div>
            <input type="submit" value="저장" />
            <input type="button" value="목록" onclick="location.href='./' ">
        </div>                
    </form>
</body>
</html>
