package org.samulake.web.ui.window.form;

import com.vaadin.data.Binder;
import com.vaadin.data.HasItems;
import com.vaadin.data.HasValue;
import com.vaadin.data.converter.LocalDateTimeToDateConverter;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Window;
import org.samulake.web.ui.events.SaveEventHandler;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFormWindow<BEAN> extends Window {
    private AbstractLayout layout;

    private Button saveButton;

    protected Binder<BEAN> binder;

    protected final Map<String, HasValue<?>> fieldsMap;

    public AbstractFormWindow(BEAN bean, SaveEventHandler eventHandler) {
        layout = new FormLayout();
        setContent(layout);
        binder = new Binder(bean.getClass());
        binder.setBean(bean);
        saveButton = new Button("Save");
        fieldsMap = initComponents();
        bindComponents(bean);
        addFieldsToLayout(fieldsMap);
        setModal(true);
        setWidth("40%");
        addListenersToComponents(eventHandler);
    }

    protected void addFieldsToLayout(Map<String, HasValue<?>> fieldsMap) {
        layout.addComponents(fieldsMap.values().toArray(new Component[fieldsMap.values().size()]));
        layout.addComponent(saveButton);
    }

    protected void addListenersToComponents(SaveEventHandler eventHandler) {
        saveButton.addClickListener(event -> {
            eventHandler.onSaveClicked();
            close();
        });
    }

    protected abstract void bindComponents(BEAN bean);

    protected void defaultBindComponent(String propertyId) {
        binder.forField(fieldsMap.get(propertyId)).bind(propertyId);
    }

    protected void defaultDateTimeBindComponent(String propertyId) {
        if(fieldsMap.get(propertyId) instanceof DateTimeField) {
                binder
                    .forField((DateTimeField)fieldsMap.get(propertyId))
                    .withConverter(new LocalDateTimeToDateConverter(ZoneId.systemDefault()))
                    .bind(propertyId);
            }
    }

    public abstract Map<String, HasValue<?>> initComponents();

    public void setFormData(BEAN formData) {
        binder.setBean(formData);
    }

    public BEAN getFormData() {
        return binder.getBean();
    }
}
