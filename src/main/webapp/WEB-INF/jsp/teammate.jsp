<%@ page import="net.blf2.football.model.entity.TeamMate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: blf2
  Date: 16-4-12
  Time: 下午6:07
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
<div class="row">
  <div class="col-md-2">
    <ul class="nav nav-sidebar">
      <li class="active">
        <a href="#">可用操作：</a>
      </li>
      <li>
        <a href="/TeamMate/toAddTeamMate.action">增加球员信息</a>
      </li>
    </ul>
  </div>
  <div class="col-md-9 center-block">

    <table class="table table-bordered">
      <tr>
        <td>
          姓名：
        </td>
        <td>
          所属球队
        </td>
        <td>
          球衣号码
        </td>
        <td>
          场上位置
        </td>
        <td>
          身高
        </td>
        <td>
          体重
        </td>
        <td>
          出生日期
        </td>
        <td>
          操作1
        </td>
        <td>
          操作2
        </td>
      </tr>

      <%
        List<TeamMate> teamMateList = (List<TeamMate>) request.getSession().getAttribute("teamMateList");
        if(teamMateList == null){%>
      <h3>无记录</h3>
      <%}else{
        Iterator<TeamMate> iterator = teamMateList.iterator();
        while(iterator.hasNext()){
          TeamMate teamMate = iterator.next();
      %>
      <tr>
        <td>
          <%=teamMate.getTeamMateName()%>
        </td>
        <td>
          <%=teamMate.getTeamMateToTeam()%>
        </td>
        <td>
          <%=teamMate.getTeamMateNum()%>
        </td>
        <td>
          <%=teamMate.getTeamMatePosition()%>
        </td>
        <td>
          <%=teamMate.getTeamMateHigh()%>
        </td>
        <td>
          <%=teamMate.getTeamMateHeavy()%>
        </td>
        <td>
          <%=teamMate.getTeamMateBirthday()%>
        </td>
        <td>
          <a href="/TeamMate/editTeamMate.action?teamMateNum=<%=teamMate.getTeamMateNum()%>"><button class="btn btn-primary">编辑</button></a>
        </td>
        <td>
          <a href="/TeamMate/deleteTeamMate.action?teamMateNum=<%=teamMate.getTeamMateNum()%>"><button class="btn btn-primary">删除</button></a>
        </td>
      </tr>
      <%}
      }
      %>
    </table>
  </div>
</div>
</body>
</html>
