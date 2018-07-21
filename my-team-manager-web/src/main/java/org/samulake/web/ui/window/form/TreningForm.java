package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.TwinColSelect;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.impl.EventModelService;
import org.samulake.web.ui.events.SaveEventHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TreningForm extends EventForm<TreningDto> {
    public static final String SQUAD_PROPERTY_ID = "squad";
    private TwinColSelect<PersonDto> squadTwinColSelect;

    public TreningForm(TreningDto eventDto, SaveEventHandler eventHandler) {
        super(eventDto, eventHandler);
        setWidth("60%");
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldsMap = new HashMap<>();
        fieldsMap.putAll(super.initComponents());
        squadTwinColSelect = new TwinColSelect<>("Squad");
        fieldsMap.put(SQUAD_PROPERTY_ID, squadTwinColSelect);
        return fieldsMap;
    }

    @Override
    protected void bindComponents(TreningDto dto) {
        super.bindComponents(dto);
        binder.forField(squadTwinColSelect).bind(treningDto -> treningDto.getSquad(), (treningDto, personDtos) -> treningDto.setSquad(personDtos));
        squadTwinColSelect.setValue(dto.getSquad());
    }

    public void setDataSource(EventModelService dataSource) {
        super.setFormData(dataSource);
        squadTwinColSelect.setItems(dataSource.getUserTeamSquad());
    }
}
