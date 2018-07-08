package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Label;
import org.samulake.web.core.dto.TreningDto;

public class TreningDetailsPanel extends EventDetailsPanel<TreningDto> {
    private Label squadLabel;

    public TreningDetailsPanel(TreningDto event) {
        super(event);
        squadLabel = new Label(event.getTeam().getMembers().toString());
    }

    @Override
    protected void setOtherEventDetails(TreningDto event) {
        squadLabel.setValue(event.getTeam().getMembers().toString());
    }

    @Override
    protected AbstractComponent getOtherEventDetailsComponent() {
        return squadLabel;
    }
}
