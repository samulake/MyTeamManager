package org.samulake.web.core.dto;

import java.util.Objects;

public class PersonDto {
    private Long id;

    private String firstName;

    private String lastName;

    private boolean isUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this;
    }

    public <T extends PersonDto> T cloneProto(T subclass){
        subclass.setId(getId());
        subclass.setFirstName(firstName);
        subclass.setLastName(lastName);
        return subclass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(id, personDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " ";
    }
}
