package org.samulake.web.ui.window.form;

import com.vaadin.data.Binder;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Window;
import org.samulake.web.ui.controller.CrudEventHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class AbstractFormWindow<BEAN> extends Window {
    private AbstractLayout layout;

    private Button saveButton;

    private Binder<BEAN> binder;

    private Map<String, AbstractField> fieldsMap;

    public AbstractFormWindow(BEAN bean, CrudEventHandler eventHandler) {
        layout = new FormLayout();
        setContent(layout);
        fieldsMap = new HashMap<>();
        saveButton = new Button("Save");
        fieldsMap = initComponents();
        bindComponents(bean);
        addFieldsToLayout(fieldsMap);
        setModal(true);
        setWidth("20%");
        addListenersToComponents(eventHandler);
    }

    private void addFieldsToLayout(Map<String, AbstractField> fieldsMap) {
        layout.addComponents(fieldsMap.values().toArray(new Component[fieldsMap.values().size()]));
        layout.addComponent(saveButton);
    }

    protected void addListenersToComponents(CrudEventHandler eventHandler) {
        saveButton.addClickListener(event -> eventHandler.onSaveClicked());
    }

    protected void bindComponents(BEAN bean) {
        binder = new Binder(bean.getClass());
        binder.setBean(bean);
        fieldsMap.entrySet().stream().forEach(bindComponentConsumer());
    }

    private Consumer<Map.Entry<String, AbstractField>> bindComponentConsumer() {
        return fieldEntry -> binder.forField(fieldEntry.getValue()).bind(fieldEntry.getKey());
    }

    public abstract Map<String, AbstractField> initComponents();

    public void setFormData(BEAN formData) {
        binder.setBean(formData);
    }

    public BEAN getFormData() {
        return binder.getBean();
    }
}
