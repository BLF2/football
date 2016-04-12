package net.blf2.football.model.entity;

import net.blf2.football.model.entity.enumfile.Position;

import javax.persistence.*;

/**
 * Created by blf2 on 16-4-10.
 */
@Entity
@Table(name="TeamMate")
public class TeamMate {
    private Integer teamMateId;
    private String teamMateName;
    private String teamMateToTeam;
    private Integer teamMateNum;
    private Position teamMatePosition;
    private Double teamMateHigh;
    private Double teamMateHeavy;
    private String teamMateBirthday;

    public TeamMate() {
    }

    public TeamMate(String teamMateName, String teamMateToTeam, Integer teamMateNum, Position teamMatePosition, Double teamMateHigh, Double teamMateHeavy, String teamMateBirthday) {
        this.teamMateName = teamMateName;
        this.teamMateToTeam = teamMateToTeam;
        this.teamMateNum = teamMateNum;
        this.teamMatePosition = teamMatePosition;
        this.teamMateHigh = teamMateHigh;
        this.teamMateHeavy = teamMateHeavy;
        this.teamMateBirthday = teamMateBirthday;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamMateId")
    public Integer getTeamMateId() {
        return teamMateId;
    }

    public void setTeamMateId(Integer teamMateId) {
        this.teamMateId = teamMateId;
    }
    @Column(name = "teamMateName")
    public String getTeamMateName() {
        return teamMateName;
    }
    public void setTeamMateName(String teamMateName) {
        this.teamMateName = teamMateName;
    }
    @Column(name = "teamMateToTeam")
    public String getTeamMateToTeam() {
        return teamMateToTeam;
    }

    public void setTeamMateToTeam(String teamMateToTeam) {
        this.teamMateToTeam = teamMateToTeam;
    }

    @Column(name = "teamMateNum",unique = true)
    public Integer getTeamMateNum() {
        return teamMateNum;
    }

    public void setTeamMateNum(Integer teamMateNum) {
        this.teamMateNum = teamMateNum;
    }
    @Column(name = "teamMatePosition")
    public Position getTeamMatePosition() {
        return teamMatePosition;
    }

    public void setTeamMatePosition(Position teamMatePosition) {
        this.teamMatePosition = teamMatePosition;
    }
    @Column(name = "teamMateHigh")
    public Double getTeamMateHigh() {
        return teamMateHigh;
    }

    public void setTeamMateHigh(Double teamMateHigh) {
        this.teamMateHigh = teamMateHigh;
    }
    @Column(name = "teamMateHeavy")
    public Double getTeamMateHeavy() {
        return teamMateHeavy;
    }

    public void setTeamMateHeavy(Double teamMateHeavy) {
        this.teamMateHeavy = teamMateHeavy;
    }
    @Column(name = "teamMateBirthday")
    public String getTeamMateBirthday() {
        return teamMateBirthday;
    }

    public void setTeamMateBirthday(String teamMateBirthday) {
        this.teamMateBirthday = teamMateBirthday;
    }
}
