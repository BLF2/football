package net.blf2.football.model.dao;

import net.blf2.football.model.entity.TeamInfo;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by blf2 on 16-4-10.
 */
@Repository("TeamInfoDao")
public class TeamInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TeamInfo insertTeamInfo(TeamInfo teamInfo){
        System.out.println("调用dao of insert");
        try {
            this.sessionFactory.getCurrentSession().save(teamInfo);
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
        return teamInfo;
    }
    public Boolean deleteTeamInfo(TeamInfo teamInfo){
        try {
            this.sessionFactory.getCurrentSession().delete(teamInfo);
        }catch (HibernateException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    public Boolean updateTeamInfo(TeamInfo teamInfo){


        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(teamInfo);
        }catch (HibernateException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    public TeamInfo queryTeamInfoByTeamName(String teamName){
        String hql = "from TeamInfo ti where ti.teamName='"+teamName+"'";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        if(query.list().size() > 0)
            return (TeamInfo)query.list().get(0);
        return null;
    }
    public List<TeamInfo> queryTeamInfoAll(){
        String hql = "from TeamInfo";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
       return query.list();
    }
}
