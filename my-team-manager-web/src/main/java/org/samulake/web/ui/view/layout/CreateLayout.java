package org.samulake.web.ui.view.layout;

import com.vaadin.ui.Component;

import java.util.Map;

@FunctionalInterface
public interface CreateLayout {
    Component createLayout(Map<String, Component> viewComponents);
}
