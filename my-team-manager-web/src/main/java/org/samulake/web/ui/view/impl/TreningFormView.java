package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import org.samulake.web.service.IEventService;
import org.samulake.web.ui.controller.EventFormController;
import org.samulake.web.ui.view.IEventFormView;

import java.util.Observable;

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

    @Override
    public void initModel(IEventService model) {

    }

    @Override
    public void initController(EventFormController controller) {

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
