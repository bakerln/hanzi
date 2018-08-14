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
    <form method="post" action="/bishun/backdoor/upload/json.htm" enctype="multipart/form-data">
        选择一个json文件:
        <input type="file" name="file" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
    <form method="post" action="/bishun/backdoor/upload/excel.htm" enctype="multipart/form-data">
        选择一个excel文件:
        <input type="file" name="file" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
    <form method="post" action="/bishun/backdoor/upload/word.htm" enctype="multipart/form-data">
        选择一个word文件:
        <input type="file" name="file" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
    <form method="post" action="/bishun/backdoor/upload/input.htm" enctype="multipart/form-data">
        导入pinytin:
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
    <form method="post" action="/bishun/backdoor/upload/test.htm" enctype="multipart/form-data">
        选择一个word文件:
        <input type="text" name="name" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
    <form method="post" action="/bishun/backdoor/upload/geshi.htm" enctype="multipart/form-data">
        多音字格式
        <br/><br/>
        <input type="submit" value="修改" />
    </form>
</body>
</html>
