package org.samulake.web.ui.view.impl;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import org.samulake.web.service.Model;
import org.samulake.web.ui.controller.AbstractController;
import org.samulake.web.ui.view.IView;
import org.samulake.web.ui.view.layout.CreateLayout;
import org.samulake.web.ui.window.form.AbstractFormWindow;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import static org.samulake.web.ui.view.utils.ComponentsExtractorUtils.extractViewComponents;

public abstract class AbstractView<CONTROLLER extends AbstractController, MODEL extends Model> implements IView<CONTROLLER, MODEL>, Observer {
    private CONTROLLER controller;
    private MODEL model;
    private CreateLayout layout;

    AbstractView(CONTROLLER controller, MODEL model, CreateLayout layout) {
        this.controller = controller;
        this.model = model;
        this.layout = layout;
        controller.init(this, model);
        ((Observable)model).addObserver(this);
        initViewComponents();
    }

    public CONTROLLER getController() {
        return controller;
    }

    public void setController(CONTROLLER controller) {
        this.controller = controller;
    }

    public MODEL getModel() {
        return model;
    }

    public void setModel(MODEL model) {
        this.model = model;
    }

    @Override
    public final Component getViewComponent() {
        Map<String, Component> componentMap = getViewComponentMap();
        return layout.createLayout(componentMap);
    }

    protected Map<String, Component> getViewComponentMap() {
        return extractViewComponents(this);
    }
}
