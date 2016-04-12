package net.blf2.football.model.service;

import net.blf2.football.model.dao.TeamMateDao;
import net.blf2.football.model.entity.TeamMate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by blf2 on 16-4-10.
 */
@Service("TeamMateService")
public class TeamMateService {
    @Autowired
    private TeamMateDao teamMateDao;

    public TeamMateDao getTeamMateDao() {
        return teamMateDao;
    }

    public void setTeamMateDao(TeamMateDao teamMateDao) {
        this.teamMateDao = teamMateDao;
    }

    public TeamMate addTeamMate(TeamMate teamMate){
        return teamMateDao.insertTeamMate(teamMate);
    }
    public Boolean deleteTeamMateByTeamMateNum(Integer teamMateNum){
        TeamMate teamMate = teamMateDao.queryTeamMateByTeamMateNum(teamMateNum);
        return  teamMateDao.deleteTeamMate(teamMate);
    }
    public Boolean updateTeamMate(TeamMate teamMate){
        return teamMateDao.updateTeamMate(teamMate);
    }
    public TeamMate queryTeamMateByTeamMateNum(Integer teamMateNum){
        return teamMateDao.queryTeamMateByTeamMateNum(teamMateNum);
    }
    public List<TeamMate> queryTeamMateAll(){
        return teamMateDao.queryTeamMateAll();
    }
}
