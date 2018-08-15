package org.samulake.web.ui.view.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.service.ITeamService;
import org.samulake.web.service.impl.DataSourceFacade;
import org.samulake.web.ui.component.MatchDetailsPanel;
import org.samulake.web.ui.controller.MatchController;
import org.samulake.web.ui.view.FormWindowHandler;
import org.samulake.web.ui.view.IMatchesView;
import org.samulake.web.ui.view.layout.LayoutFactory;
import org.samulake.web.ui.window.form.MatchForm;
import org.samulake.web.ui.window.form.WindowUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@UIScope
@SpringView(name= IMatchesView.MATCH_VIEW_URL)
public class MatchView extends EventView<MatchController, IEventService<MatchDto>> implements IMatchesView, FormWindowHandler<MatchDto> {
    private MatchForm matchForm;
    private MatchDto selectedData;

    @Autowired
    @Qualifier("teamService")
    private ITeamService teamService;

    @Autowired
    private DataSourceFacade dataSource;

    @Autowired
    public MatchView(MatchController controller, @Qualifier("matchService") IEventService<MatchDto> model) {
        super(controller, model, LayoutFactory.getMatchesManagementLayout());
        addDeletePanel.getAddButton().setCaption("Add Match");
        addDeletePanel.getAddButton().setWidth("150px");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        showMatches();
    }

    @Override
    public String getUrl() {
        return IMatchesView.MATCH_VIEW_URL;
    }

    @Override
    public void update(Observable o, Object arg) {
        showMatches();
    }

    @Override
    public void showMatches() {
        List<MatchDetailsPanel> matchPanels = new ArrayList<>();
        getModel().getAllData().stream().forEach(match -> matchPanels.add(new MatchDetailsPanel(match, getController())));
        addEvents(matchPanels);
    }

    @Override
    public void showFormWindow(MatchDto formData) {
        matchForm = new MatchForm(formData, getController());
        matchForm.setDataSource(dataSource);
        WindowUtils.addWindow(matchForm);
    }

    @Override
    public MatchDto getFormData() {
        return matchForm.getFormData();
    }
}
