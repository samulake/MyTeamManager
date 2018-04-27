package org.samulake.web.persistence.validation;

import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.persistence.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class TeamValidator implements ConstraintValidator<ValidTeam, TeamDto> {
    @Autowired
    private TeamDao teamDao;

    @Override
    public void initialize(ValidTeam constraintAnnotation) {
    }

    @Override
    public boolean isValid(TeamDto teamDto, ConstraintValidatorContext context) {
        return ! Optional.of(teamDao.findByName(teamDto.getName())).isPresent();
    }
}
