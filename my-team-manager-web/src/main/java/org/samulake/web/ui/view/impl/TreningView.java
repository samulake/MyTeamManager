package org.samulake.web.ui.view.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.impl.DataSourceFacade;
import org.samulake.web.ui.component.TreningDetailsPanel;
import org.samulake.web.ui.controller.TreningController;
import org.samulake.web.ui.view.FormWindowHandler;
import org.samulake.web.ui.view.ITreningView;
import org.samulake.web.ui.window.form.TreningForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static org.samulake.web.ui.view.layout.LayoutFactory.getTreningManagementLayout;
import static org.samulake.web.ui.window.form.WindowUtils.addWindow;

@UIScope
@SpringView(name= ITreningView.TRENING_VIEW_URL)
public class TreningView extends EventView<TreningController, IEventService<TreningDto>> implements ITreningView, FormWindowHandler<TreningDto> {
    private TreningForm treningForm;

    @Autowired
    @Qualifier("teamService")
    private ITeamService teamService;

    @Autowired
    private DataSourceFacade dataSource;

    @Autowired
    public TreningView(TreningController controller, @Qualifier("treningService") IEventService<TreningDto> model) {
        super(controller, model, getTreningManagementLayout());
        addDeletePanel.getAddButton().setCaption("Add Trening");
        addDeletePanel.getAddButton().setWidth("150px");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        showTrenings();
    }

    @Override
    public String getUrl() {
        return ITreningView.TRENING_VIEW_URL;
    }

    @Override
    public void update(Observable o, Object arg) {
        showTrenings();
    }

    @Override
    public void showFormWindow(TreningDto formData) {
        treningForm = new TreningForm(formData, getController());
        treningForm.setDataSource(dataSource);
        addWindow(treningForm);
    }

    @Override
    public TreningDto getFormData() {
        return treningForm.getFormData();
    }

    @Override
    public void showTrenings() {
        List<TreningDetailsPanel> treningEventsPanels = new ArrayList<>();
        List<TreningDto> userTeamEvents = getModel().getUserTeamEvents();
        userTeamEvents.stream().forEach(trening -> treningEventsPanels.add(new TreningDetailsPanel(trening, getController())));
        addEvents(treningEventsPanels);
    }
}
