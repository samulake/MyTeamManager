package org.samulake.web.service;

public interface Model<DTO> {
    DTO getData();

    void updateData(DTO data);
}
