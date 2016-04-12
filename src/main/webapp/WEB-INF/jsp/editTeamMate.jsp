<%@ page import="net.blf2.football.model.entity.TeamMate" %>
<%@ page import="net.blf2.football.model.entity.enumfile.Position" %>
<%--
  Created by IntelliJ IDEA.
  User: blf2
  Date: 16-4-12
  Time: 下午6:20
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
<%
  TeamMate teamMate = (TeamMate) request.getSession().getAttribute("editTeamMate");
%>
<form action="/TeamMate/updateTeamMate.action" method="post">
  <input type="hidden" name="teamMateId" value="<%=teamMate.getTeamMateId()%>" />
  <table class="table table-bordered">
    <tr>
      <td>姓名：</td>
      <td><input name="teamMateName" type="text" value="<%=teamMate.getTeamMateName()%>"/></td>
    </tr>
    <tr>
      <td>所属球队：</td>
      <td><input name="teamMateToTeam" type="text" value="<%=teamMate.getTeamMateToTeam()%>"/></td>
    </tr>
    <tr>
      <td>球员号码：</td>
      <td><input name="teamMateNum" type="text" value="<%=teamMate.getTeamMateNum()%>" readonly="readonly"/></td>
    </tr>
    <tr>
      <td>场上位置：</td>
      <td>
        <select name="teamMatePosition">
          <%if(teamMate.getTeamMatePosition() == Position.goalkeeper){%>
          <option value="0" selected="selected">goalkeeper</option>
          <%}else{%>
          <option value="0">goalkeeper</option>
            <%}
            if(teamMate.getTeamMatePosition() == Position.guard){%>
          <option value="1" selected="selected">guard</option>
          <%}else{%>
          <option value="1" >guard</option>
          <%}
            if(teamMate.getTeamMatePosition() == Position.forward){
          %>
          <option value="2" selected="selected">forward</option>
          <%}else{%>
          <option value="2">forward</option>
          <%}%>
        </select>
      </td>
    </tr>
    <tr>
      <td>身高：</td>
      <td><input name="teamMateHigh" type="text" value="<%=teamMate.getTeamMateHigh()%>"/></td>
    </tr>
    <tr>
      <td>体重：</td>
      <td><input name="teamMateHeavy" type="text" value="<%=teamMate.getTeamMateHeavy()%>"/></td>
    </tr>
    <tr>
      <td>生日：</td>
      <td><input name="teamMateBirthday" type="text" value="<%=teamMate.getTeamMateBirthday()%>"/></td>
    </tr>
    <tr>
      <td><button class="btn btn-primary" type="submit">提交</button></td>
      <td><button class="btn btn-primary" type="reset">重置</button></td>
    </tr>
  </table>
</form>
</body>
</html>

