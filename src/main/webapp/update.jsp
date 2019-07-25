<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            $("form").submit(function(){
                //验证信息
                var str=$("[name='districtId']").val();
                if (str=='请选择'){
                    alert("请选择分类");
                    return false;
                }

                var  title=$("[name='monitorTime']").val();
                if ($.trim(title).length == 0){
                    alert("请填写监测时间");
                    return false;
                }

                var content=$("[name='pm10']").val();
                if ($.trim(content).length == 0){
                    alert("请输入PM10内容");
                    return false;
                }

                var content=$("[name='pm2_5']").val();
                if ($.trim(content).length == 0){
                    alert("请输入PM2.5内容");
                    return false;
                }

                return true;
            });
        })

    </script>

</head>

<body>
<div>
    <center>
        <h2>修改空气质量检测</h2>

        <form action="/update" method="post">
            <input type="hidden" name="id" value="${findbyid.id}">
            监测区域:<select name="districtId">
            <option>请选择</option>
            <c:forEach items="${districts}" var="dis">
                <option value="${dis.id}" ${dis.id==findbyid.districtId?"selected":""}>${dis.name}</option>
            </c:forEach>
        </select><br>
            监测日期:<input type="text" name="monitorTime" value="${findbyid.monitorTime}"><br>
            PM10值:<input type="text" name="pm10" value="${findbyid.pm10}"><br>
            PM2.5值:<input type="text" name="pm2_5" value="${findbyid.pm2_5}"><br>
            监测站:<input type="text" name="monitoringStation" value="${findbyid.monitoringStation}"><br>
            最后修改时间:<input type="text" name="lastModifyTime" value="${findbyid.lastModifyTime}"><br>


            <input type="submit" value="保存">
            <a href="/deletebyid?id=${findbyid.id}">删除</a>
            <input type="button" value="返回">
        </form>
    </center>
</div>
</body>
</html>