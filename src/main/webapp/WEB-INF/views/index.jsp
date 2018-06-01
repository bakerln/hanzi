<%--
  Created by IntelliJ IDEA.
  User: LINAN
  Date: 2018-05-29
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <title>汉语辞书笔画</title>
        <script src="${resourceServer}/assets/js/jquery-1.8.3.min.js?v=${versionNo}"></script>
        <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/bootstrap.css?v=${versionNo}"/>
        <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/style.css?v=${versionNo}"/>
        <script type="text/javascript">
            function next() {
                window.location.href = "detail.htm";
            }
        </script>
    </head>
    <body class="index">
        <div class="title tct">
            汉语辞书笔画
        </div>
        <div class="searchwrap tct">
            <input type="text" class="form-control" placeholder="请输入要查询的汉字">
            <button type="button" class="btn btn-primary btn-lg" onclick="next()"><span
                    class="glyphicon glyphicon-search"></span></button>
        </div>
        <div class="book">
            <img src="${resourceServer}/assets/img/book.png">
        </div>
        <div class="footer tct">
            copyrights @FLTRP
        </div>
    </body>
</html>
