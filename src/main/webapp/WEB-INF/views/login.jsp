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
    <title>3500字笔顺动画</title>
    <script src="${resourceServer}/assets/js/jquery-1.8.3.min.js?v=${versionNo}"></script>
    <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/bootstrap.css?v=${versionNo}"/>
    <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/style.css?v=${versionNo}"/>
    <script type="text/javascript">
        function next() {
            document.form.submit();
        }
    </script>
</head>
<body class="index">
<div id="content" class="content">
    <div class="title tct">
        <img src="${resourceServer}/assets/img/title.png">
    </div>
    <div class="searchwrap tct">
        <form method="post" action="/bishun/search.htm" name="form">
            <input id="password" name="password" type="text" class="form-control lt" placeholder="请输入密码" autocomplete="off">
            <button type="button" class="btn" onclick="next()"/>
        </form>
    </div>
</div>

<div class="footer tct fixed-bottom">
    copyrights @FLTRP
</div>
</body>


</html>
