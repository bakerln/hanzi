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
            function check(c){
                var c1 = document.getElementById('c1');
                var c2 = document.getElementById('c2');
                var c3 = document.getElementById('c3');
                if(c == 'c3'){
                    c3.setAttribute("src", "${resourceServer}/assets/img/c3-check.png");
                    c1.setAttribute("src", "${resourceServer}/assets/img/c1.png");
                    c2.setAttribute("src", "${resourceServer}/assets/img/c2.png");
                    document.getElementById("check").value = "c3";
                }
                else if(c == 'c2'){
                    c2.setAttribute("src", "${resourceServer}/assets/img/c2-check.png");
                    c1.setAttribute("src", "${resourceServer}/assets/img/c1.png");
                    c3.setAttribute("src", "${resourceServer}/assets/img/c3.png");
                    document.getElementById("check").value = "c2";
                }
                else{
                    c1.setAttribute("src", "${resourceServer}/assets/img/c1-check.png");
                    c2.setAttribute("src", "${resourceServer}/assets/img/c2.png");
                    c3.setAttribute("src", "${resourceServer}/assets/img/c3.png");
                    document.getElementById("check").value = "c1";
                }
            }
            function next() {
                if(document.getElementById("hanzi").value == ""){

                }else {
                    //根据不同的查询跳转到不同的后台处理
                    if("c1" == document.getElementById("check").value){
                        document.form.action = "/bishun/detail.htm"
                        document.form.submit();
                    }else if ("c2" == document.getElementById("check").value){
                        document.form.action = "/bishun/pinying.htm"
                        document.form.submit();
                    }else if ("c3" == document.getElementById("check").value){
                        document.form.action = "/bishun/bushou.htm"
                        document.form.submit();
                    }

                }
            }
            function enter() {
                var code = event.keyCode;
                if (code == 13) {
                    if(document.getElementById("hanzi").value == ""){

                    }else {
                        //根据不同的查询跳转到不同的后台处理
                        if("c1" == document.getElementById("check").value){
                            document.form.action = "/bishun/detail.htm"
                            document.form.submit();
                        }else if ("c2" == document.getElementById("check").value){
                            document.form.action = "/bishun/pinying.htm"
                            document.form.submit();
                        }else if ("c3" == document.getElementById("check").value){
                            document.form.action = "/bishun/bushou.htm"
                            document.form.submit();
                        }
                    }
                }
            }
        </script>
    </head>
    <body class="index">
        <div class="title tct">
            <img src="${resourceServer}/assets/img/title.png">
        </div>
        <div class="searchwrap tct">
            <form method="post" action="" name="form">
                <input id="hanzi" name="hanzi" type="text" class="form-control lt" placeholder="请输入汉字" onkeyup="enter()" autocomplete="off">
                <input id="check" name="check" style="display: none" value="c1"/>
                <button type="button" class="btn" onclick="next()">
                    <img src="${resourceServer}/assets/img/search.png">
                </button>
            </form>
        </div>
        <div class="myradios tlt">
            <button type="button" class="radiobtn" onclick="check('c1');"><img id="c1" src="${resourceServer}/assets/img/c1-check.png"></button>
            <button type="button" class="radiobtn" onclick="check('c2');"><img id="c2" src="${resourceServer}/assets/img/c2.png"></button>
            <button type="button" class="radiobtn" onclick="check('c3');"><img id="c3" src="${resourceServer}/assets/img/c3.png"></button>
        </div>
        <div class="footer tct">
            copyrights @FLTRP
        </div>
    </body>


</html>
