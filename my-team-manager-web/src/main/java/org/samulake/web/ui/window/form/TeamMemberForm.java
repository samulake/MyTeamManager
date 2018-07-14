package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.TextField;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.ui.controller.CrudEventHandler;

import java.util.HashMap;
import java.util.Map;

public class TeamMemberForm extends AbstractFormWindow<PersonDto> {
    public static final String FIRST_NAME_PROPERTY_ID = "firstName";
    public static final String LAST_NAME_PROPERTY_ID = "lastName";

    public TeamMemberForm(PersonDto teamDto, CrudEventHandler eventHandler) {
        super(teamDto, eventHandler);
    }

    @Override
    protected void bindComponents(PersonDto personDto) {
        defaultBindComponent(FIRST_NAME_PROPERTY_ID);
        defaultBindComponent(LAST_NAME_PROPERTY_ID);
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldMap = new HashMap<>();
        fieldMap.put("firstName", new TextField("First name"));
        fieldMap.put("lastName", new TextField("Last name"));
        return fieldMap;
    }
}
