<%--
  Created by IntelliJ IDEA.
  User: LINAN
  Date: 2018-06-27
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>3500字笔顺动画</title>
    <script src="${resourceServer}/assets/js/jquery-1.8.3.min.js?v=${versionNo}"></script>
    <link rel="stylesheet" type="text/css"  href="${resourceServer}/assets/css/bootstrap.css?v=${versionNo}"/>
    <link rel="stylesheet" type="text/css" href="${resourceServer}/assets/css/style.css?v=${versionNo}"/>
    <script type="text/javascript">
        function prev() {
            window.location.href = "index.htm";
        }
        function getNum(num){
            $("#hanzi").val(num);
            alert(num);
            document.form.submit();
        }
    </script>
</head>
<body class="radical">
<div class="title tct">
    <img src="${resourceServer}/assets/img/radical.png">
</div>
<div class="home"><img src="${resourceServer}/assets/img/home.png" onclick="prev()"></div>
<div class="rdlist">
    <form method="post" action="/bishun/bushou.htm" name="form">
        <input id="hanzi" name="hanzi" style="display: none" value=""/>
        <input id="bushou" name="bushou" style="display: none" value=""/>
    </form>
    <table>
        <div class="info">请点击部首进行查找</div>
        <tr>
            <td>
                <div class="count">1画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('1')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">2画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('2')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">3画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('3')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">4画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('4')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">5画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('5')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">6画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('6')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">7画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('7')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">8画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('8')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">9画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('9')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">10画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('10')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">11画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('11')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">12画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('12')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">13画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('13')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr><td colspan="2"><div class="divider"></div></td></tr>
        <tr>
            <td>
                <div class="count">14画</div>
            </td>
            <td>
                <ul>
                    <c:forEach var="item" items="${result.get('14')}">
                        <li><a onclick="getNum('${item.getId()}')">${item.getBushou()}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </table>
</div>
<div class="footer tct">
    copyrights @FLTRP
</div>
</body>
</html>
