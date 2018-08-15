package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.ComboBox;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.core.dto.TeamDto;
import org.samulake.web.service.impl.DataSourceFacade;
import org.samulake.web.ui.controller.CrudEventHandler;

import java.util.HashMap;
import java.util.Map;

public class MatchForm extends EventForm<MatchDto> {
    public static final String VISITOR_TEAM_PROPERTY_ID = "visitorTeam";
    private ComboBox<TeamDto> rivalTextField;

    public MatchForm(MatchDto matchDto, CrudEventHandler eventHandler) {
        super(matchDto, eventHandler);
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldsMap = new HashMap<>();
        fieldsMap.putAll(super.initComponents());

        rivalTextField = new ComboBox<>("Rival");
        fieldsMap.put(VISITOR_TEAM_PROPERTY_ID, rivalTextField);
        return fieldsMap;
    }

    @Override
    protected void bindComponents(MatchDto dto) {
        super.bindComponents(dto);
        binder.forField(rivalTextField).bind(matchDto -> matchDto.getVisitorTeam(), (matchDto, team) -> matchDto.setVisitorTeam(team));
    }

    public void setDataSource(DataSourceFacade dataSource) {
        super.setFormData(dataSource);
        rivalTextField.setItems(dataSource.getAllTeams());
    }
}
