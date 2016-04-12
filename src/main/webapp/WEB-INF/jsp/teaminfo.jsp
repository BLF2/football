<%@ page import="java.util.List" %>
<%@ page import="net.blf2.football.model.entity.TeamInfo" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: blf2
  Date: 16-4-10
  Time: 下午2:26
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
        <a href="/TeamInfo/toAddTeamInfo.action">增加球队信息</a>
      </li>
    </ul>
  </div>
  <div class="col-md-9 center-block">

<table class="table table-bordered">
  <tr>
    <td>
      球队名称
    </td>
    <td>
      球队主场
    </td>
    <td>
      主教练
    </td>
    <td>
      操作1
    </td>
    <td>
      操作2
    </td>
  </tr>

<%
  List<TeamInfo>teamInfoList = (List<TeamInfo>) request.getSession().getAttribute("teamInfoList");
  if(teamInfoList == null){%>
    <h3>无记录</h3>
  <%}else{
    Iterator<TeamInfo>iterator = teamInfoList.iterator();
    while(iterator.hasNext()){
      TeamInfo teamInfo = iterator.next();
  %>
<tr>
  <td>
    <%=teamInfo.getTeamName()%>
  </td>
  <td>
    <%=teamInfo.getTeamHost()%>
  </td>
  <td>
    <%=teamInfo.getTeamCoach()%>
  </td>
  <td>
    <a href="/TeamInfo/editTeamInfo.action?teamName=<%=teamInfo.getTeamName()%>"><button class="btn btn-primary">编辑</button></a>
  </td>
  <td>
    <a href="/TeamInfo/deleteTeamInfo.action?teamName=<%=teamInfo.getTeamName()%>"><button class="btn btn-primary">删除</button></a>
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
