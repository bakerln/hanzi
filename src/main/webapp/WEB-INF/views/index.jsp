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
            function enter() {
                var code = event.keyCode;
                if (code == 13) {
                    document.form.submit();
                }
            }
        </script>
    </head>
    <body class="index">
        <div class="title tct">
            3500字笔顺动画
        </div>
        <div class="searchwrap tct">
            <form method="post" action="/bishun/detail.htm" name="form">
                <input name="hanzi" type="text" class="form-control lt" placeholder="请输入汉字" onkeyup="enter()">
                <button type="button" class="btn" onclick="next()">
                    <img src="${resourceServer}/assets/img/book.png">
                </button>
            </form>

        </div>
        <!--         <div class="book">
                    <img src="img/3.png">
                </div> -->
        <div class="footer tct">
            copyrights @FLTRP
        </div>
    </body>


</html>
