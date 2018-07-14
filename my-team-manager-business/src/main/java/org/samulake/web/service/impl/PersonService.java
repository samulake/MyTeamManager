package org.samulake.web.service.impl;

import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.persistence.dao.PersonDao;
import org.samulake.web.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<PersonDto, PersonDao> implements IPersonService {
    @Autowired
    public PersonService(PersonDao personDao) {
        super(personDao);
    }
}
