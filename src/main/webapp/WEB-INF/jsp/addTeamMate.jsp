<%--
  Created by IntelliJ IDEA.
  User: blf2
  Date: 16-4-12
  Time: 下午5:56
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
<form action="/TeamMate/addTeamMate.action" method="post">
  <table class="table table-bordered">
    <tr>
      <td>姓名：</td>
      <td><input name="teamMateName" type="text" /></td>
    </tr>
    <tr>
      <td>所属球队：</td>
      <td><input name="teamMateToTeam" type="text" /></td>
    </tr>
    <tr>
      <td>球员号码：</td>
      <td><input name="teamMateNum" type="text" /></td>
    </tr>
    <tr>
      <td>场上位置：</td>
      <td>
        <select name="teamMatePosition">
          <option value="0" selected="selected">goalkeeper</option>
          <option value="1">guard</option>
          <option value="2">forward</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>身高：</td>
      <td><input name="teamMateHigh" type="text" /></td>
    </tr>
    <tr>
      <td>体重：</td>
      <td><input name="teamMateHeavy" type="text" /></td>
    </tr>
    <tr>
      <td>生日：</td>
      <td><input name="teamMateBirthday" type="text" /></td>
    </tr>
    <tr>
      <td><button class="btn btn-primary" type="submit">提交</button></td>
      <td><button class="btn btn-primary" type="reset">重置</button></td>
    </tr>
  </table>
</form>
</body>
</html>
