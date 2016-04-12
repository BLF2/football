package net.blf2.football.controller;

import net.blf2.football.model.entity.TeamInfo;
import net.blf2.football.model.service.TeamInfoService;
import net.blf2.football.model.service.TeamMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 * Created by blf2 on 16-4-10.
 */
@Controller
@RequestMapping("/TeamInfo/")
public class TeamInfoController {
    @Autowired
    private TeamInfoService teamInfoService;
    @RequestMapping("toTeamInfo")
    public String toTeamInfo(HttpSession httpSession){
        List<TeamInfo>teamInfoList = teamInfoService.queryTeamInfoAll();
        httpSession.setAttribute("teamInfoList",teamInfoList);
        return "teaminfo";
    }
    @RequestMapping("toAddTeamInfo")
    public String toAddTeamInfo(){
        return "addTeamInfo";
    }
    @RequestMapping(value = "addTeamInfo",method = {RequestMethod.POST})
    public String addTeamInfo(HttpSession httpSession,TeamInfo teamInfo){
        teamInfo.setTeamId(-1);
        if(teamInfoService.addTeamInfo(teamInfo) == null)
            return "insertError";
        List<TeamInfo>teamInfoList = teamInfoService.queryTeamInfoAll();
        httpSession.setAttribute("teamInfoList",teamInfoList);
        return "teaminfo";
    }
    @RequestMapping("editTeamInfo")
    public String editTeamInfo(HttpSession httpSession,String teamName){

        httpSession.setAttribute("editTeamName",teamName);
        return "editTeamInfo";
    }
    @RequestMapping(value = "updateTeamInfo",method = {RequestMethod.POST})
    public String updateTeamInfo(HttpSession httpSession,TeamInfo teamInfo){

        if(!teamInfoService.updateTeamInfo(teamInfo))
            return "updateError";
        List<TeamInfo>teamInfoList = teamInfoService.queryTeamInfoAll();
        for(TeamInfo lteamInfo : teamInfoList){
            System.out.println("------------------------------>");
            System.out.println(lteamInfo.getTeamId()+" "+lteamInfo.getTeamName()+" "+lteamInfo.getTeamHost()+" "+lteamInfo.getTeamCoach());
            System.out.println("------------------------------>");
        }
        httpSession.setAttribute("teamInfoList",teamInfoList);
        return "teaminfo";
    }
    @RequestMapping(value = "deleteTeamInfo")
    public String deleteTeamInfo(HttpSession httpSession,String teamName){
        System.out.println("teamName=" + teamName);
        if(!teamInfoService.deleteTeamInfoByTeamName(teamName))
            return "deleteError";
        List<TeamInfo>teamInfoList = teamInfoService.queryTeamInfoAll();
        httpSession.setAttribute("teamInfoList",teamInfoList);
        return "teaminfo";
    }
}
