package org.samulake.web.core.dto;

import java.util.ArrayList;
import java.util.List;

public class TeamDto {
    private Long id;

    private String name;

    private List<PersonDto> members = new ArrayList<>();

    private UserDto leader;

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

    public UserDto getLeader() {
        return leader;
    }

    public void setLeader(UserDto leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return name;
    }
}
