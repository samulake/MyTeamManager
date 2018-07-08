package org.samulake.web.ui.controller;

import org.samulake.web.ui.events.SaveEventHandler;

public interface CrudEventHandler extends SaveEventHandler {
    void onDeleteClicked();

    void onAddClicked();

    void onEditClicked();
}
