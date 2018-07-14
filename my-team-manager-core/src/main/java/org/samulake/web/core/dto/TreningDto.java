package org.samulake.web.core.dto;

import java.util.HashSet;
import java.util.Set;

public class TreningDto extends EventDto {
    private TeamDto team;

    private Set<PersonDto> squad = new HashSet<>();

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }

    public Set<PersonDto> getSquad() {
        return squad;
    }

    public void setSquad(Set<PersonDto> squad) {
        this.squad = squad;
    }
}
