package org.samulake.web.persistence.dao;

import java.util.List;

public interface DataAccessObject<DTO> {

    void delete(DTO dto);

    void save(DTO dto);

    List<DTO> findAll();

    void removeAll(List<DTO> data);
}
