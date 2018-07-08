package org.samulake.web.ui.view;

public interface FormWindowHandler<DTO> {
    void showFormWindow(DTO formData);

    DTO getFormData();
}
