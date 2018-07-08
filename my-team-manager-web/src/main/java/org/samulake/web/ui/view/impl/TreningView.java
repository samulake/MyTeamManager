package org.samulake.web.ui.view.impl;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.ui.controller.TreningController;
import org.samulake.web.ui.view.ITreningView;
import org.samulake.web.ui.view.layout.LayoutFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Observable;

import static org.samulake.web.ui.view.layout.LayoutFactory.*;

@UIScope
@SpringView(name= ITreningView.TRENING_VIEW_URL)
public class TreningView extends EventView<TreningController, IEventService<TreningDto>> implements ITreningView {

    @Autowired
    public TreningView(TreningController controller, @Qualifier("treningService") IEventService<TreningDto> model) {
        super(controller, model, getEventsManagementLayout());
    }

    @Override
    public String getUrl() {
        return ITreningView.TRENING_VIEW_URL;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
