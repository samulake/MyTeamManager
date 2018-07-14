package org.samulake.web.core.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class EventEntity {
    public static final String DEFAULT_GENERATOR_NAME = "default_event_seq_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = DEFAULT_GENERATOR_NAME)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_TIME")
    private Date dateTime;

    @ManyToOne
    @JoinColumn(name = PlaceEntity.IDENTITY_COLUMN_NAME)
    private PlaceEntity place;

    public EventEntity() {
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
