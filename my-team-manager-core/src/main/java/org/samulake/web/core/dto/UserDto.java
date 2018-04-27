package org.samulake.web.core.dto;

public class UserDto extends PersonDto {

    private String username;

    private String password;

    private PersonDto personDetails;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonDto getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDto personDetails) {
        this.personDetails = personDetails;
    }
}

