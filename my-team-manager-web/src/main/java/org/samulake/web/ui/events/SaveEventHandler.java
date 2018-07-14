package org.samulake.web.ui.events;

public interface SaveEventHandler {
    void onSaveClicked();

    default <T> void setFormData(T formData) {}
}
