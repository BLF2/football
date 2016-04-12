package net.blf2.football.controller;

import net.blf2.football.model.entity.TeamInfo;
import net.blf2.football.model.entity.TeamMate;
import net.blf2.football.model.entity.enumfile.Position;
import net.blf2.football.model.service.TeamMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by blf2 on 16-4-10.
 */
@Controller
@RequestMapping("/TeamMate/")
public class TeamMateController {
    @Autowired
    private TeamMateService teamMateService;
    @RequestMapping("toTeamMate")
    public String toTeamMate(HttpSession httpSession){
        List<TeamMate> teamMateList = teamMateService.queryTeamMateAll();
        httpSession.setAttribute("teamMateList",teamMateList);
        return "teammate";
    }
    @RequestMapping(value = "toAddTeamMate")
    public String toAddTeamMate(){

        return "addTeamMate";
    }
    @RequestMapping(value = "addTeamMate",method = {RequestMethod.POST})
    public String addTeamMate(HttpSession httpSession,String teamMateName,String teamMateToTeam,String teamMateNum,String teamMatePosition,String teamMateHigh,
                              String teamMateHeavy,String teamMateBirthday){
        TeamMate teamMate = new TeamMate();
        Position position;
        if(teamMatePosition.equals("0"))
            position = Position.goalkeeper;
        else if(teamMatePosition.equals("1"))
            position = Position.guard;
        else
            position = Position.forward;
        teamMate.setTeamMateName(teamMateName);
        teamMate.setTeamMateToTeam(teamMateToTeam);
        teamMate.setTeamMateNum(Integer.parseInt(teamMateNum));
        teamMate.setTeamMatePosition(position);
        teamMate.setTeamMateHigh(Double.parseDouble(teamMateHigh));
        teamMate.setTeamMateHeavy(Double.parseDouble(teamMateHeavy));
        teamMate.setTeamMateBirthday(teamMateBirthday);
        if(teamMateService.addTeamMate(teamMate) != null){
            List<TeamMate> teamMateList = teamMateService.queryTeamMateAll();
            httpSession.setAttribute("teamMateList",teamMateList);
            return "teammate";
        }
        return "insertError";
    }
    @RequestMapping("deleteTeamMate")
    public String deleteTeamMate(String teamMateNum,HttpSession httpSession){
        if(teamMateService.deleteTeamMateByTeamMateNum(Integer.parseInt(teamMateNum))){
            List<TeamMate> teamMateList = teamMateService.queryTeamMateAll();
            httpSession.setAttribute("teamMateList",teamMateList);
            return "teammate";
        }
        return "deleteError";
    }
    @RequestMapping("editTeamMate")
    public String editTeamMate(String teamMateNum,HttpSession httpSession){
        TeamMate teamMate = teamMateService.queryTeamMateByTeamMateNum(Integer.parseInt(teamMateNum));
        httpSession.setAttribute("editTeamMate",teamMate);
        return "editTeamMate";
    }
    @RequestMapping(value = "updateTeamMate",method = {RequestMethod.POST})
    public String updateTeamMate(HttpSession httpSession,String teamMateName,String teamMateToTeam,String teamMateNum,String teamMatePosition,String teamMateHigh
                                 ,String teamMateHeavy,String teamMateBirthday,String teamMateId){
        TeamMate teamMate = new TeamMate();
        Position position;
        if(teamMatePosition.equals("0"))
            position = Position.goalkeeper;
        else if(teamMatePosition.equals("1"))
            position = Position.guard;
        else
            position = Position.forward;
        teamMate.setTeamMateId(Integer.parseInt(teamMateId));
        teamMate.setTeamMateName(teamMateName);
        teamMate.setTeamMateToTeam(teamMateToTeam);
        teamMate.setTeamMateNum(Integer.parseInt(teamMateNum));
        teamMate.setTeamMatePosition(position);
        teamMate.setTeamMateHigh(Double.parseDouble(teamMateHigh));
        teamMate.setTeamMateHeavy(Double.parseDouble(teamMateHeavy));
        teamMate.setTeamMateBirthday(teamMateBirthday);
        if(teamMateService.updateTeamMate(teamMate)){
            List<TeamMate> teamMateList = teamMateService.queryTeamMateAll();
            httpSession.setAttribute("teamMateList",teamMateList);
            return "teammate";
        }
        return "updateError";
    }
}
