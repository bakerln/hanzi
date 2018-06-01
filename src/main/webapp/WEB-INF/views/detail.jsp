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
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <title>汉语辞书笔画</title>
        <script src="${resourceServer}/assets/js/jquery-1.8.3.min.js?v=${versionNo}"></script>
        <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/bootstrap.css?v=${versionNo}"/>
        <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/style.css?v=${versionNo}"/>
        <script type="text/javascript">
            function prev() {
                window.location.href="index.htm";
            }
        </script>
    </head>

    <body class="detail">
        <button type="button" class="backbtn btn-primary btn-lg" onclick="prev()"><span class="glyphicon glyphicon-home"></span></button>
        <div class="pencil"><img src="${resourceServer}/assets/img/pencil.png"></div>
        <div class="trumpet"><img src="${resourceServer}/assets/img/trumpet.png"></div>
        <div class="title tct redcircle">
            圣
        </div>
        <div class="detailwrap tct">
            <div class="row infoRow">
                <div class="col-md-6">shèng</div>
                <div class="col-md-6">5画</div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <video width="500" height="500" controls>
                        <source src="${nginxServer}/video/sheng.mp4" type="video/mp4">
                    </video>
                </div>
            </div>
            <div class="row infoRow">
                <div class="col-md-6">又部</div>
                <div class="col-md-6">上下</div>
            </div>
            <!-- <div class="row">
                <div class="col-md-12">提示：</div>
            </div> -->
        </div>
        <div class="capture tct">
            <div class="row" style="margin-top:50px;">
                <div class="col-md-2"><div class="no">1</div><img src="${nginxServer}/image/01.png"></div>
                <div class="col-md-2"><div class="no">2</div><img src="${nginxServer}/image/02.png"></div>
                <div class="col-md-2"><div class="no">3</div><img src="${nginxServer}/image/03.png"></div>
                <div class="col-md-2"><div class="no">4</div><img src="${nginxServer}/image/04.png"></div>
                <div class="col-md-2"><div class="no">5</div><img src="${nginxServer}/image/05.png"></div>
                <div class="col-md-2"></div>
            </div>
            <div class="row infoRow">
                <div class="col-md-2">横撇</div>
                <div class="col-md-2">捺</div>
                <div class="col-md-2">横</div>
                <div class="col-md-2">竖</div>
                <div class="col-md-2">横</div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <div class="footer tct" style="margin-bottom:15px;">
            copyrights @FLTRP
        </div>
    </body>
</html>
