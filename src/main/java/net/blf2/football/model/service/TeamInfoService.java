package net.blf2.football.model.service;

import net.blf2.football.model.dao.TeamInfoDao;
import net.blf2.football.model.entity.TeamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by blf2 on 16-4-10.
 */
@Service("TeamInfoService")
public class TeamInfoService {
    @Autowired
    private TeamInfoDao teamInfoDao;

    public TeamInfoDao getTeamInfoDao() {
        return teamInfoDao;
    }

    public void setTeamInfoDao(TeamInfoDao teamInfoDao) {
        this.teamInfoDao = teamInfoDao;
    }

    public TeamInfo addTeamInfo(TeamInfo teamInfo){
        return teamInfoDao.insertTeamInfo(teamInfo);
    }
    public Boolean deleteTeamInfoByTeamName(String teanName){
        TeamInfo teamInfo = teamInfoDao.queryTeamInfoByTeamName(teanName);
        return teamInfoDao.deleteTeamInfo(teamInfo);
    }
    public Boolean updateTeamInfo(TeamInfo teamInfo){
        return teamInfoDao.updateTeamInfo(teamInfo);
    }
    public TeamInfo queryTeamInfoByTeamName(String teamName){
        return teamInfoDao.queryTeamInfoByTeamName(teamName);
    }
    public List<TeamInfo> queryTeamInfoAll(){
        return teamInfoDao.queryTeamInfoAll();
    }
}
