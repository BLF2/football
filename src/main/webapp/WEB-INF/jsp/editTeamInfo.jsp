<%@ page import="java.util.List" %>
<%@ page import="net.blf2.football.model.entity.TeamInfo" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: blf2
  Date: 16-4-10
  Time: 下午3:29
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
  String teamName = (String)request.getSession().getAttribute("editTeamName");
  List<TeamInfo>teamInfoList = (List<TeamInfo>) request.getSession().getAttribute("teamInfoList");

  TeamInfo editTeamInfo = null;
  if (teamInfoList != null && teamName != null){
    Iterator<TeamInfo>iterator = teamInfoList.iterator();
    while(iterator.hasNext()){
      editTeamInfo = iterator.next();
      if(editTeamInfo.getTeamName().equals(teamName)){
        break;
      }else{
        editTeamInfo = null;
      }
    }
    if(editTeamInfo != null){
      request.getSession().removeAttribute("editTeamName");

%>

<form action="/TeamInfo/updateTeamInfo.action" method="post">
  <input type="hidden" name="teamId" value="<%=editTeamInfo.getTeamId()%>" />
  <table class="table table-bordered">
    <tr>
      <td>球队名：</td>
      <td><input name="teamName" type="text" value="<%=editTeamInfo.getTeamName()%>" readonly/></td>
    </tr>
    <tr>
      <td>球队主场：</td>
      <td><input name="teamHost" type="text" value="<%=editTeamInfo.getTeamHost()%>" required/></td>
    </tr>
    <tr>
      <td>主教练：</td>
      <td><input name="teamCoach" type="text" value="<%=editTeamInfo.getTeamCoach()%>" required/></td>
    </tr>
    <tr>
      <td><button class="btn btn-primary" type="submit">提交</button></td>
      <td><button class="btn btn-primary" type="submit">重置</button></td>
    </tr>
  </table>
</form>
<% }else{%>
  <h1>无法操作!</h1>
<%}
}%>
</body>
</html>
