package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.TextField;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.ui.controller.CrudEventHandler;

import java.util.HashMap;
import java.util.Map;

public class TeamMemberForm extends AbstractFormWindow<PersonDto> {
    public TeamMemberForm(PersonDto teamDto, CrudEventHandler eventHandler) {
        super(teamDto, eventHandler);
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldMap = new HashMap<>();
        fieldMap.put("firstName", new TextField("First name"));
        fieldMap.put("lastName", new TextField("Last name"));
        return fieldMap;
    }
}
