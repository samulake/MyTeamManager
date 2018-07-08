package org.samulake.web.ui.window.form;

import com.vaadin.data.Binder;
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
import java.util.function.Consumer;

public abstract class AbstractFormWindow<BEAN> extends Window {
    private AbstractLayout layout;

    private Button saveButton;

    private Binder<BEAN> binder;

    private Map<String, HasValue<?>> fieldsMap;

    public AbstractFormWindow(BEAN bean, SaveEventHandler eventHandler) {
        layout = new FormLayout();
        setContent(layout);
        fieldsMap = new HashMap<>();
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

    protected void bindComponents(BEAN bean) {
        binder = new Binder(bean.getClass());
        binder.setBean(bean);
        fieldsMap.entrySet().stream().forEach(BindComponentConsumer());
    }

    private Consumer<Map.Entry<String, HasValue<?>>> BindComponentConsumer() {
        return fieldEntry -> {
            if(fieldEntry.getValue() instanceof DateTimeField) {
                binder
                    .forField((DateTimeField)fieldEntry.getValue())
                    .withConverter(new LocalDateTimeToDateConverter(ZoneId.systemDefault()))
                    .bind(fieldEntry.getKey());
            } else if (!isFirstLevelProperty(fieldEntry.getKey())){
                defaultBindComponent(fieldEntry);
            }
        };
    }

    private boolean isFirstLevelProperty(String propertyName) {
        return propertyName.contains(".");
    }

    private void defaultBindComponent(Map.Entry<String, HasValue<?>> fieldEntry) {
        binder.forField(fieldEntry.getValue()).bind(fieldEntry.getKey());
    }

    public abstract Map<String, HasValue<?>> initComponents();

    public void setFormData(BEAN formData) {
        binder.setBean(formData);
    }

    public BEAN getFormData() {
        return binder.getBean();
    }
}
