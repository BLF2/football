<%--
  Created by IntelliJ IDEA.
  User: blf2
  Date: 16-4-10
  Time: 下午3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <meta charset="utf-8"/>
  <link rel="stylesheet" href="../../css/bootstrap.min.css">

  <script src="../../js/jquery.min.js"></script>

  <script src="../../js/bootstrap.min.js"></script>
  <title></title>
</head>
<body>
<form action="/TeamInfo/addTeamInfo.action" method="post">
<table class="table table-bordered">
  <tr>
    <td>球队名：</td>
    <td><input name="teamName" type="text" required/></td>
  </tr>
  <tr>
    <td>球队主场：</td>
    <td><input name="teamHost" type="text" required/></td>
  </tr>
  <tr>
    <td>主教练：</td>
    <td><input name="teamCoach" type="text" required/></td>
  </tr>
  <tr>
    <td><button class="btn btn-primary" type="submit">提交</button></td>
    <td><button class="btn btn-primary" type="submit">重置</button></td>
  </tr>
</table>
  </form>
</body>
</html>
