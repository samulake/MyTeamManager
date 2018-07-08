package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.TextField;
import org.samulake.web.core.dto.CityDto;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.ui.events.SaveEventHandler;

import java.util.HashMap;
import java.util.Map;

public class EventForm<DTO extends EventDto> extends AbstractFormWindow<DTO>{
    public EventForm(DTO eventDto, SaveEventHandler eventHandler) {
        super(eventDto, eventHandler);
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldsMap = new HashMap<>();
        fieldsMap.put("title", new TextField("Title"));
        fieldsMap.put("place.city", new ComboBox<CityDto>());
        fieldsMap.put("dateTime", new DateTimeField("Date and time"));
        return fieldsMap;
    }



}
