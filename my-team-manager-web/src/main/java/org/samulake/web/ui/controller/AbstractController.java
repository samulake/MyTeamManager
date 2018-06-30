package org.samulake.web.ui.controller;

import org.samulake.web.service.Model;
import org.samulake.web.ui.view.IView;

public abstract class AbstractController<VIEW extends IView, MODEL extends Model> {
    private VIEW view;
    private MODEL model;

    public void init(VIEW view, MODEL model) {
        this.view = view;
        this.model = model;
    }

    public VIEW getView() {
        return view;
    }

    public MODEL getModel() {
        return model;
    }

    public <DTO> void update(DTO dto) {
        model.updateData(dto);
    }
}
