package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractComponent;
import org.samulake.web.core.dto.MatchDto;

public class MatchDetailsPanel extends EventDetailsPanel<MatchDto> {
    public MatchDetailsPanel(MatchDto event) {
        super(event);
    }

    @Override
    protected void setOtherEventDetails(MatchDto event) {

    }

    @Override
    protected AbstractComponent getOtherEventDetailsComponent() {
        return null;
    }
}
