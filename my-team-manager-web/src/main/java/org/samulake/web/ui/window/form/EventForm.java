package org.samulake.web.ui.window.form;

import com.vaadin.data.HasValue;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.TextField;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField;
import org.samulake.web.core.dto.EventDto;
import org.samulake.web.core.dto.PlaceDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.IPlaceService;
import org.samulake.web.service.impl.EventModelService;
import org.samulake.web.ui.events.SaveEventHandler;

import java.util.HashMap;
import java.util.Map;

public class EventForm<DTO extends EventDto> extends AbstractFormWindow<DTO>{
    public static final String PLACE_PROPERTY_ID = "place";
    private ComboBox<PlaceDto> placeDtoComboBox;
    public static final String DATETIME_PROPERTY_ID = "dateTime";

    public EventForm(DTO eventDto, SaveEventHandler eventHandler) {
        super(eventDto, eventHandler);
    }

    @Override
    protected void bindComponents(DTO dto) {
        defaultDateTimeBindComponent(DATETIME_PROPERTY_ID);
        defaultBindComponent(PLACE_PROPERTY_ID);
    }

    @Override
    public Map<String, HasValue<?>> initComponents() {
        Map<String, HasValue<?>> fieldsMap = new HashMap<>();
        placeDtoComboBox = new ComboBox<>("Place");
        fieldsMap.put(PLACE_PROPERTY_ID, placeDtoComboBox);
        fieldsMap.put(DATETIME_PROPERTY_ID, new DateTimeField("Date and time"));
        return fieldsMap;
    }

    public void setFormData(EventModelService eventModel) {
        placeDtoComboBox.setItems(eventModel.getEventPlaces());
    }
}
