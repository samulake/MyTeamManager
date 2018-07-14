package org.samulake.web.core.dto;

public class MatchDto extends EventDto {

    private TeamDto homeTeam = new TeamDto();

    private TeamDto visitorTeam = new TeamDto();

    private String result;

    public TeamDto getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamDto homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamDto getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(TeamDto visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
