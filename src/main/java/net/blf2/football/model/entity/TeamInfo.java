package net.blf2.football.model.entity;

import javax.persistence.*;

/**
 * Created by blf2 on 16-4-10.
 */
@Entity
@Table(name = "TeamInfo")
public class TeamInfo {
    private Integer teamId;
    private String teamName;
    private String teamHost;
    private String teamCoach;

    public TeamInfo() {
    }

    public TeamInfo(String teamName, String teamHost, String teamCoach) {
        this.teamName = teamName;
        this.teamHost = teamHost;
        this.teamCoach = teamCoach;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId")
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }



    @Column(name = "teamName",unique = true)
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    @Column(name = "teamHost")
    public String getTeamHost() {
        return teamHost;
    }

    public void setTeamHost(String teamHost) {
        this.teamHost = teamHost;
    }
    @Column(name = "teamCoach")
    public String getTeamCoach() {
        return teamCoach;
    }

    public void setTeamCoach(String teamCoach) {
        this.teamCoach = teamCoach;
    }
}
