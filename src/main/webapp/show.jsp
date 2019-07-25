<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<div >
    <center>

        <h2>空气质量检测信息库</h2>

        <form action="/findall" method="post">
            按区域查询:<select name="districtId" >

                             <option>请选择</option>
                 <c:forEach items="${district}" var="dis">
                             <option value="${dis.id}"  ${did==dis.id?"selected":""}>${dis.name}</option>
                 </c:forEach>
                      </select>
            <input type="submit" value="提交">
        </form>

        <a href="/getdistricts">添加空气质量信息</a>

        <form>
            <table border="2px" width="60%">

                <tr>
                    <td align="center">序号</td>
                    <td align="center">区域</td>
                    <td align="center">检测时间</td>
                    <td align="center">PM10数据</td>
                    <td align="center">PM2.5数据</td>
                    <td align="center">检测站</td>
                </tr>

                <c:forEach items="${list}" var="page" >
                    <tr>
                        <td align="center">${page.id}</td>
                        <td align="center"><a href="findbyid?id=${page.id}">${page.district.name}</a></td>
                        <td align="center">${page.monitorTime}"</td>
                        <td align="center">${page.pm10}</td>
                        <td align="center">${page.pm2_5}</td>
                        <td align="center">${page.monitoringStation}</td>
                    </tr>
                </c:forEach>
                <tr >
                    <td align="center" colspan="6">
                        <a href="findall?index=${pageinfo.firstPage}&districtId=${did}">首页</a>
                        <a href="findall?index=${pageinfo.prePage==0?1:pageinfo.prePage}&districtId=${did}">上一页</a>
                        <a href="findall?index=${pageinfo.nextPage==0?pageinfo.lastPage:pageinfo.nextPage}&districtId=${did}">下一页</a>
                        <a href="findall?index=${pageinfo.lastPage}&districtId=${did}">尾页</a>
                        第${pageinfo.pageNum}页/共${pageinfo.pages}页
                    </td>
                </tr>

            </table>
        </form>
    </center>
</div>
</body>
</html>