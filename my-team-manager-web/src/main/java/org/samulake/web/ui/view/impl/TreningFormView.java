package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import org.samulake.web.ui.controller.EventFormController;
import org.samulake.web.ui.view.IEventFormView;

@UIScope
@SpringView(name= IEventFormView.TRENING_VIEW_URL)
public class TreningFormView extends EventFormView{

    @Override
    public void showEventForm() {
        addComponent(new TextField("Trening"));
    }

    @Override
    public String getUrl() {
        return IEventFormView.TRENING_VIEW_URL;
    }
}
