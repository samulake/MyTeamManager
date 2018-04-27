package org.samulake.web.ui.view;

public interface View<MODEL> extends com.vaadin.navigator.View {
    String getUrl();

    void init(MODEL model);

    MODEL getModel();
}
