package org.samulake.web.service.impl;

import org.samulake.web.persistence.dao.DataAccessObject;
import org.samulake.web.service.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

public abstract class AbstractService<DTO, DAO extends DataAccessObject<DTO>> extends Observable implements Model<DTO> {

    private DAO dao;

    public AbstractService(DAO dao) {
        this.dao = dao;
    }

    public DAO getDao() {
        return dao;
    }

    @Override
    public List<DTO> getAllData() {
        return dao.findAll();
    }

    @Override
    public void updateData(DTO data) {
        dao.save(data);
        notifyObservers();
    }

    @Override
    public void updateDataCollection(Collection<? extends DTO> dataCollection) {
        dataCollection.stream().forEach(data -> dao.save(data));
        notifyObservers();
    }

    @Override
    public void create(DTO data) {
        dao.save(data);
        notifyObservers();
    }


    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }

    @Override
    public void remove(DTO data) {
        dao.delete(data);
        notifyObservers();
    }

    @Override
    public void removeCollection(Collection<DTO> data) {
        dao.removeAll(new ArrayList(data));
        notifyObservers();
    }
}
