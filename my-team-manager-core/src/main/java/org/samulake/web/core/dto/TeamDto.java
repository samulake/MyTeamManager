package org.samulake.web.core.dto;

import java.util.ArrayList;
import java.util.List;

public class TeamDto {
    private Long id;

    private String name;

    private List<PersonDto> members = new ArrayList<>();

    private PersonDto leader;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonDto> getMembers() {
        return members;
    }

    public void setMembers(List<PersonDto> members) {
        this.members = members;
    }

    public PersonDto getLeader() {
        return leader;
    }

    public void setLeader(PersonDto leader) {
        this.leader = leader;
    }
}
