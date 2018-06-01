<%--
  Created by IntelliJ IDEA.
  User: LINAN
  Date: 2018-06-01
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>readJson</title>
</head>
<body>
    <form method="post" action="/bishun/upload/json.htm" enctype="multipart/form-data">
        选择一个文件:
        <input type="file" name="file" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
</body>
</html>
