package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Label;
import org.samulake.web.core.dto.MatchDto;
import org.samulake.web.ui.controller.CrudEventHandler;

public class MatchDetailsPanel extends EventDetailsPanel<MatchDto> {
    private Label teamsLabel;

    public MatchDetailsPanel(MatchDto event, CrudEventHandler eventHandler) {
        super(event, eventHandler);
    }

    public MatchDetailsPanel(CrudEventHandler eventHandler) {
        super(eventHandler);
    }

    @Override
    protected void setOtherEventDetails(MatchDto event) {
        if(event != null)
            teamsLabel.setValue(event.getHomeTeam() + " - " + event.getVisitorTeam());
    }

    @Override
    protected AbstractComponent getOtherEventDetailsComponent() {
        teamsLabel = new Label();
        return teamsLabel;
    }
}
