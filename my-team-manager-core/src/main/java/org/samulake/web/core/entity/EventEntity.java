package org.samulake.web.core.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class EventEntity {

    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_TIME")
    private Date dateTime;

    @ManyToOne
    @JoinColumn(name = PlaceEntity.IDENTITY_COLUMN_NAME)
    private PlaceEntity place;

    protected EventEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }
}
