<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LINAN
  Date: 2018-05-29
  Time: 15:51
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
        function prev() {
            window.location.href = "index.htm";
        }
        var fullscreen = false;

        $(function () {
            $(document).keydown(function (event) {
                if (event.keyCode != 27) {
                } else {
                    prev();
                }
            });
            //禁用右键
            $('#video').live('contextmenu', function () {
                return false;
            });
            //双击全屏
            $("#video").dblclick(function () {
                if (!fullscreen) {
                    launchFullscreen(document.getElementById('video'));
                    fullscreen = true;
                }
                else {
                    exitFullscreen();
                    fullscreen = false;
                }
            });
        });
        //进入全屏
        function launchFullscreen(element) {
            if (element.requestFullscreen) {
                element.requestFullscreen();
            }
            //FireFox
            else if (element.mozRequestFullScreen) {
                element.mozRequestFullScreen();
            }
            //Chrome等
            else if (element.webkitRequestFullScreen) {
                element.webkitRequestFullScreen();
            }
            //IE11
            else if (element.msRequestFullscreen) {
                element.msRequestFullscreen();
            }
        }
        //退出全屏
        function exitFullscreen() {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            }
            else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            }
            else if (document.webkitCancelFullScreen) {
                document.webkitCancelFullScreen();
            }
            else if (document.msExitFullscreen) {
                document.msExitFullscreen();
            }
        }
    </script>
</head>
<body class="detail">
<div class="title tct">
    <img src="${resourceServer}/assets/img/title.png">
</div>
<div class="home"><img src="${resourceServer}/assets/img/home.png" onclick="prev()"></div>
<div class="searchwrap tct">
    <form method="post" action="/bishun/detail.htm" name="form">
        <input name="hanzi" type="text" class="form-control lt" placeholder="请输入汉字" onkeyup="enter()"
               autocomplete="off">
        <button type="button" class="btn" onclick="next()">
            <img src="${resourceServer}/assets/img/search.png">
        </button>
    </form>
</div>
<div class="detailwrap tct">
    <table class="mytable infoRow">
        <tr>
            <td class="tlt">注音：${hanzi.get("pinyin")}</td>
            <td style="width: 60px;"></td>
            <td class="tlt">笔画数：${hanzi.get("bihua_num")}</td>
        </tr>
        <tr>
            <td class="tlt">部首：<img src="${nginxServer}/bushou/${hanzi.get("img")}"/></td>
            <td style="width: 60px;"></td>
            <td class="tlt">结构：${hanzi.get("jiegou")}</td>
        </tr>
    </table>
    <video src="${nginxServer}/video/${hanzi.get("video_url")}" width="400" controls="controls" id="video" loop="loop"
           style="margin-top: 15px;">
        <%--<video width="400" controls="controls" id="video" autoplay="autoplay" loop	="loop">--%>
        <%--<source src="${resourceServer}//test.htm" type="video/mp4" />--%>
        您的浏览器版本过低啦，请升级一下哦
    </video>
</div>
<%--<c:if test="${hanzi.get('tips') != null }">--%>
    <%--<div class="tips">提示信息：${hanzi.get("tips")}</div>--%>
<%--</c:if>--%>
<div id="capture" class="capture tct">
    <table class="dtltable infoRow">
        <tr>
            <c:forEach var="item" items="${bihua}">
                <td>
                    <div class="no">${item.getNo()}</div>
                    <img src="${nginxServer}/image/${item.getUrl()}">
                </td>
            </c:forEach>
        </tr>
        <tr class="tct name">
            <c:forEach var="item" items="${bihua}">
                <td>${item.getBihua()}</td>
            </c:forEach>
        </tr>
    </table>
</div>
<div class="footer tct" style="margin-bottom:15px;">
    copyrights @FLTRP
</div>
</body>
</html>
