<%--
  Created by IntelliJ IDEA.
  User: LINAN
  Date: 2018-06-05
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>3500字笔顺动画</title>
    <script src="${resourceServer}/assets/js/jquery-1.8.3.min.js?v=${versionNo}"></script>
    <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/bootstrap.css?v=${versionNo}"/>
    <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/style.css?v=${versionNo}"/>
    <script type="text/javascript">
        function prev() {
            window.location.href="search.htm";
        }
        function next() {
            document.form.submit();
        }
    </script>
</head>
<body class="detail">
<div class="title tct">
    <img src="${resourceServer}/assets/img/404.png" style="height:50px; width:200px;">
</div>
<div class="home" ><img src="${resourceServer}/assets/img/home.png" onclick="prev()"></div>
<div class="searchwrap tct">
    <form method="post" action="/bishun/detail.htm" name="form">
        <input name="hanzi" type="text" class="form-control lt" placeholder="请输入汉字" onkeyup="enter()"
               autocomplete="off">
        <button type="button" class="btn" onclick="next()">
            <img src="${resourceServer}/assets/img/search.png">
        </button>
    </form>
</div>
<div class="footer tct" style="margin-bottom:15px;">
    copyrights @FLTRP
</div>
</body>
</html>
