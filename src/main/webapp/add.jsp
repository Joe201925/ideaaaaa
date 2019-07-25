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
        <h2>添加空气质量检测</h2>

        <form action="/add" method="post">
            分类:<select name="districtId">
            <option>请选择</option>
            <c:forEach items="${districts}" var="dis">
                <option value="${dis.id}">${dis.name}</option>
            </c:forEach>
        </select><br>
            监测日期:<input type="text" name="monitorTime"><br>
            PM10值:<input type="text" name="pm10"><br>
            PM2.5值:<input type="text" name="pm2_5"><br>

            <input type="submit" value="保存">
            <input type="reset" value="重置">
            <input type="button" value="返回">
        </form>
    </center>
</div>
</body>
</html>