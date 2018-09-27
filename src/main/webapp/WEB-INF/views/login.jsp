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
        function placeholderSupport() {
            return 'placeholder' in document.createElement('input');
        }
        function next() {
            document.form.submit();
        }
        function enter(){
            var code = event.keyCode;
            if(code == 13){
                next()
            }
        }
        window.onload = function () {
            if(!placeholderSupport()){
                document.getElementById("password").value = "输入6位验证码";
            }
        };
    </script>
</head>
<body class="index">
<div id="content" class="content">
    <div class="title tct">
        <img src="${resourceServer}/assets/img/title.png">
    </div>
    <div class="loginwrap tct">
        <form method="post" action="/bishun/search.htm" name="form">
            <input id="password" name="password" type="text" class="form-control lt" maxlength="6" placeholder="输入6位验证码" onkeyup="enter()"
                   autocomplete="off">
            <button type="button" class="loginbtn" onclick="next()"/><img id="login" src="${resourceServer}/assets/img/loginbtn.png"></button>
        </form>
    </div>
    <div class="tct wechat">
        <p>微信用户若不能正常使用，请点击右上角按钮，选择“在浏览器中打开”即可。</p>
    </div>
</div>

<div class="footer tct fixed-bottom">
    copyrights @FLTRP
</div>
</body>


</html>
