package org.samulake.web.core.dto;

public class TreningDto extends EventDto {
    private TeamDto team;

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }
}
