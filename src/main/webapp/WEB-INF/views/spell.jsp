<%--
  Created by IntelliJ IDEA.
  User: LINAN
  Date: 2018-06-25
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>3500字笔顺动画</title>
    <script src="${resourceServer}/assets/js/jquery-1.8.3.min.js?v=${versionNo}"></script>
    <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/bootstrap.css?v=${versionNo}"/>
    <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/style.css?v=${versionNo}"/>
    <script type="text/javascript">
        function prev() {
            window.location.href = "index.htm";
        }
        $(function () {
            $("a").click(function () {
                $("#hanzi").val(this.innerHTML);
                document.form.submit();
            })
        })
    </script>
</head>
<body class="radical">
<div class="title tct">
    <img src="${resourceServer}/assets/img/spell.png">
</div>
<div class="home"><img src="${resourceServer}/assets/img/home.png" onclick="prev()"></div>
<div class="rdlist">
    <form method="post" action="/bishun/detail.htm" name="form">
        <input id="hanzi" name="hanzi" style="display: none" value=""/>
    </form>
    <table>
        <div class="info">拼音为“${hanzi}”的汉字</div>
        <c:if test="${result.get('0') != null && result.get('0').size() != 0}">
            <tr>
                <td>
                    <div class="count">轻声</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('0')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('1') != null && result.get('1').size() != 0}">
            <tr>
                <td>
                    <div class="count">一声</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('1')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('2') != null && result.get('2').size() != 0}">
            <tr>
                <td>
                    <div class="count">二声</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('2')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('3') != null && result.get('3').size() != 0}">
            <tr>
                <td>
                    <div class="count">三声</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('3')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('4') != null && result.get('4').size() != 0}">
            <tr>
                <td>
                    <div class="count">四声</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('4')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
    </table>
</div>
<div class="footer tct">
    copyrights @FLTRP
</div>
</body>
</html>
