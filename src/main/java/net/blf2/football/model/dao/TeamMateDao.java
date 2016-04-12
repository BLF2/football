package net.blf2.football.model.dao;

import net.blf2.football.model.entity.TeamMate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by blf2 on 16-4-10.
 */
@Repository("TeamMateDao")
public class TeamMateDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TeamMate insertTeamMate(TeamMate teamMate){
        try {
            this.sessionFactory.getCurrentSession().save(teamMate);
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
        return teamMate;
    }
    public Boolean deleteTeamMate(TeamMate teamMate){
        try {
            this.sessionFactory.getCurrentSession().delete(teamMate);
        }catch (HibernateException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    public Boolean updateTeamMate(TeamMate teamMate){
        try {
            this.sessionFactory.getCurrentSession().update(teamMate);
        }catch (HibernateException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    public TeamMate queryTeamMateByTeamMateNum(Integer teamMateNum){
        String hql = "from TeamMate tm where tm.teamMateNum="+teamMateNum;
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        if(query.list().size() > 0)
            return (TeamMate) query.list().get(0);
        return null;
    }
    public List<TeamMate> queryTeamMateAll(){
        String hql = "from TeamMate";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}
