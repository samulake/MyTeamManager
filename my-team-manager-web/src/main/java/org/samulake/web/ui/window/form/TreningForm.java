package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.TwinColSelect;
import org.samulake.web.core.dto.PersonDto;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.service.impl.DataSourceFacade;
import org.samulake.web.ui.events.SaveEventHandler;

import java.util.HashMap;
import java.util.Map;

public class TreningForm extends EventForm<TreningDto> {

    public TreningForm(TreningDto eventDto, SaveEventHandler eventHandler) {
        super(eventDto, eventHandler);
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldsMap = new HashMap<>();
        fieldsMap.putAll(super.initComponents());
        return fieldsMap;
    }

    @Override
    protected void bindComponents(TreningDto dto) {
        super.bindComponents(dto);
    }

    public void setDataSource(DataSourceFacade dataSource) {
        super.setFormData(dataSource);
    }
}
