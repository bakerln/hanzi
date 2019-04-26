<%--
  Created by IntelliJ IDEA.
  User: LINAN
  Date: 2018-06-28
  Time: 13:31
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
            window.location.href = "bushouIndex.htm";
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
    <img src="${resourceServer}/assets/img/radical.png">
</div>
<div class="home"><img src="${resourceServer}/assets/img/home.png" onclick="prev()"></div>
<div class="rdlist">
    <form method="post" action="/bishun/web/detail.htm" name="form">
        <input id="hanzi" name="hanzi" style="display: none" value=""/>
    </form>
    <table style="border-collapse:separate; border-spacing:0px 15px;">
        <div class="info">部首为“<img src="${nginxServer}/bushou/${hanzi}"/>”的汉字</div>
        <c:if test="${result.get('0').size() != 0}">
            <tr>
                <td>
                    <div class="count">0画</div>
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
        <c:if test="${result.get('1').size() != 0}">
            <tr>
                <td>
                    <div class="count">1画</div>
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
        <c:if test="${result.get('2').size() != 0}">
            <tr>
                <td>
                    <div class="count">2画</div>
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
        <c:if test="${result.get('3').size() != 0}">
            <tr>
                <td>
                    <div class="count">3画</div>
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
        <c:if test="${result.get('4').size() != 0}">
            <tr>
                <td>
                    <div class="count">4画</div>
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
        <c:if test="${result.get('5').size() != 0}">
            <tr>
                <td>
                    <div class="count">5画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('5')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('6').size() != 0}">
            <tr>
                <td>
                    <div class="count">6画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('6')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('7').size() != 0}">
            <tr>
                <td>
                    <div class="count">7画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('7')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('8').size() != 0}">
            <tr>
                <td>
                    <div class="count">8画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('8')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('9').size() != 0}">
            <tr>
                <td>
                    <div class="count">9画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('9')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('10').size() != 0}">
            <tr>
                <td>
                    <div class="count">10画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('10')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('11').size() != 0}">
            <tr>
                <td>
                    <div class="count">11画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('11')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('12').size() != 0}">
            <tr>
                <td>
                    <div class="count">12画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('12')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('13').size() != 0}">
            <tr>
                <td>
                    <div class="count">13画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('13')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('14').size() != 0}">
            <tr>
                <td>
                    <div class="count">14画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('14')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('15').size() != 0}">
            <tr>
                <td>
                    <div class="count">15画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('15')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('16').size() != 0}">
            <tr>
                <td>
                    <div class="count">16画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('16')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('17').size() != 0}">
            <tr>
                <td>
                    <div class="count">17画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('17')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('18').size() != 0}">
            <tr>
                <td>
                    <div class="count">18画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('18')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('19').size() != 0}">
            <tr>
                <td>
                    <div class="count">19画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('19')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('20').size() != 0}">
            <tr>
                <td>
                    <div class="count">20画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('20')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('21').size() != 0}">
            <tr>
                <td>
                    <div class="count">21画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('21')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('22').size() != 0}">
            <tr>
                <td>
                    <div class="count">22画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('22')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('23').size() != 0}">
            <tr>
                <td>
                    <div class="count">23画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('23')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('24').size() != 0}">
            <tr>
                <td>
                    <div class="count">24画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('24')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('25').size() != 0}">
            <tr>
                <td>
                    <div class="count">25画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('25')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('26').size() != 0}">
            <tr>
                <td>
                    <div class="count">26画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('26')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('27').size() != 0}">
            <tr>
                <td>
                    <div class="count">27画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('27')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('28').size() != 0}">
            <tr>
                <td>
                    <div class="count">28画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('28')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('29').size() != 0}">
            <tr>
                <td>
                    <div class="count">29画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('29')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('30').size() != 0}">
            <tr>
                <td>
                    <div class="count">30画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('30')}">
                            <li><a>${item.getHanzi()}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:if>
        <c:if test="${result.get('other').size() != 0}">
            <tr>
                <td>
                    <div class="count">其他画</div>
                </td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${result.get('other')}">
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
