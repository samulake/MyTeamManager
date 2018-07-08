package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.TextField;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.ui.controller.CrudEventHandler;

import java.util.HashMap;
import java.util.Map;

public class MatchForm extends EventForm<MatchDto> {

    public MatchForm(MatchDto matchDto, CrudEventHandler eventHandler) {
        super(matchDto, eventHandler);
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldsMap = new HashMap<>();
        fieldsMap.putAll(super.initComponents());
        fieldsMap.put("visitorTeam.name", new TextField("Rival"));
        return fieldsMap;
    }
}
