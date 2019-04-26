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
        function check(c) {
            var ipt = document.getElementById('hanzi');
            if (c == 'c3') {
                document.form.action = "/bishun/web/bushouIndex.htm"
                document.form.submit();
            }
            else if (c == 'c2') {
                ipt.setAttribute("placeholder","请输入拼音，例：输入hua1，查询“花”");
                document.getElementById("check").value = "c2";
                if(!placeholderSupport()){
                    document.getElementById("hanzi").value = "请输入拼音，例：输入hua1，查询“花”";
                }
//                document.getElementById("pinyintips").style.web='block';
            }
            else {
                ipt.setAttribute("placeholder","请输入汉字");
                document.getElementById("check").value = "c1";
                if(!placeholderSupport()){
                    document.getElementById("hanzi").value = "请输入汉字";
                }
                document.getElementById("pinyintips").style.display='none';
            }
        }
        function next() {
            if (document.getElementById("hanzi").value == "") {

            } else if(!placeholderSupport() && document.getElementById("hanzi").value == "请输入汉字" ){

            }
            else if(!placeholderSupport() && document.getElementById("hanzi").value == "请输入拼音，例：输入hua1，查询“花”" ){

            }
            else {
                //根据不同的查询跳转到不同的后台处理
                if ("c1" == document.getElementById("check").value) {
                    document.form.action = "/bishun/web/detail.htm"
                    document.form.submit();
                } else if ("c2" == document.getElementById("check").value) {
                    document.form.action = "/bishun/web/pinyin.htm"
                    document.form.submit();
                }
            }
        }
        function enter() {
            if (13 == event.keyCode) {
                next();
            }
        }
        window.onload = function () {
            if(!placeholderSupport()){
                document.getElementById("hanzi").value = "请输入汉字";
            }
        };
        function showtutorial() {
            var tuto = document.getElementById('tutorialwrap');
            var show = tuto.style.display;
            if(show != "block") {
                tuto.style.display = "block";
            }
            else {
                tuto.style.display = "none";
            }
        }
        function downloadgift() {
            var ua = window.navigator.userAgent.toLowerCase();
            if(ua.match(/MicroMessenger/i) == 'micromessenger'){
                alert("请选择在手机浏览器中打开")
            }else{
                window.location.href="${resourceServer}/assets/file/趣味益智识字卡片-创意剪纸.zip";
            }
        }
    </script>
</head>
<body class="index">
<div id="content" class="content">
    <div class="title tct">
        <img src="${resourceServer}/assets/img/title.png">
    </div>
    <div class="searchwrap tct">
        <form method="post" action="" name="form">
            <input id="hanzi" name="hanzi" type="text" class="form-control lt" placeholder="请输入汉字" onkeyup="enter()"
                   autocomplete="off">
            <input id="check" name="check" style="display: none" value="c1"/>
            <button type="button" class="btn" onclick="next()">
                <img src="${resourceServer}/assets/img/search.png">
            </button>
        </form>
    </div>
    <div class="myradios tct">
        <button type="button" class="radiobtn" onclick="check('c1');"><img id="c1"
                                                                           src="${resourceServer}/assets/img/c1.png">
        </button>
        <button type="button" class="radiobtn" onclick="check('c2');"><img id="c2"
                                                                           src="${resourceServer}/assets/img/c2.png">
        </button>
        <button type="button" class="radiobtn" onclick="check('c3');"><img id="c3"
                                                                           src="${resourceServer}/assets/img/c3.png">
        </button>
    </div>
    <div style="width: 800px;text-align: center;">
        <div id="tutorial" class="tutorial" onclick="showtutorial()">
            <img src="${resourceServer}/assets/img/tutor.png">
        </div>
        <div class="tutorial" style="margin-top: 58px;" onclick="downloadgift()">
            <%--<a href="${resourceServer}/assets/file/趣味益智识字卡片-创意剪纸.zip" download="趣味益智识字卡片-创意剪纸.zip">--%>
                <img src="${resourceServer}/assets/img/gift.png">
            <%--</a>--%>
        </div>
    </div>
    <div id="tutorialwrap" class="tct tutorialwrap">
        <video src="${nginxServer}/resource/笔顺演示小视频.mp4" width="800" controls="controls" id="video" loop="loop"
               style="margin-top: 15px;">
            您的浏览器版本过低啦，请升级一下哦
        </video>
    </div>
    <div class="footer tct" style="margin-top: 40px;">
        <p class="sum"><img src="${resourceServer}/assets/img/currentSum.png">${onlinePeopleNum}</p>
        <p>欢迎使用外研社产品，请配合外研社<a href="http://product.dangdang.com/25329067.html" target="_blank">《小学生笔画部首结构全笔顺字典》</a>使用，效果更佳 (^▽^)b</p>
        copyrights @FLTRP
    </div>
</div>
</body>
</html>
