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
                document.form.action = "/bishun/bushouIndex.htm"
                document.form.submit();
            }
            else if (c == 'c2') {
                ipt.setAttribute("placeholder","请输入拼音，例：输入hua1，查询“花”");
                document.getElementById("check").value = "c2";
                if(!placeholderSupport()){
                    document.getElementById("hanzi").value = "请输入拼音，例：输入hua1，查询“花”";
                }
//                document.getElementById("pinyintips").style.display='block';
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
                    document.form.action = "/bishun/detail.htm"
                    document.form.submit();
                } else if ("c2" == document.getElementById("check").value) {
                    document.form.action = "/bishun/pinyin.htm"
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
    <%--<div id="pinyintips" class="pinyintips">--%>
        <%--<p>输入hua或者hua1，查询“花”。</p>--%>
        <%--<p>0代表轻声，1~4依次代表阴平、阳平、上声、去声。</p>--%>
    <%--</div>--%>
</div>

<div class="footer tct fixed-bottom">
    <p>欢迎使用外研社产品，推荐配合外研社《小学生笔画部首结构全笔顺字典》使用 (^▽^)b</p>
    copyrights @FLTRP
</div>
</body>


</html>
