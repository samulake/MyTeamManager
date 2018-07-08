package org.samulake.web.service;

import java.util.Collection;
import java.util.List;

public interface Model<DTO> {
    List<DTO> getAllData();

    void updateData(DTO data);

    void updateDataCollection(Collection<? extends DTO> dataCollection);

    void create(DTO data);

    void remove(DTO data);

    void removeCollection(Collection<DTO> data);
}
