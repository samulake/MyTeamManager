package org.samulake.web.core.entity;

import javax.persistence.*;

import static org.samulake.web.core.entity.MatchEntity.*;
import static org.samulake.web.core.util.EntityPropertiesUtils.*;

@Entity
@Table(name=TABLE_NAME)
@AttributeOverride(name = "id", column = @Column(name=MatchEntity.IDENTITY_COLUMN_NAME))
@SequenceGenerator(name=EventEntity.DEFAULT_GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
public class MatchEntity extends EventEntity {
    public static final String TABLE_NAME = "MATCH";
    public static final String SEQUENCE_NAME = DEFAULT_SEQUENCE_NAME_PREFIX + TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;
    public static final String SEQUENCE_GENERATOR_NAME = SEQUENCE_NAME + DEFAULT_SEQUENCE_GENERATOR_SUFFIX;
    public static final String IDENTITY_COLUMN_NAME = TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;

    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_KEY")
    private TeamEntity homeTeam;

    @ManyToOne
    @JoinColumn(name = "VISITOR_TEAM_KEY")
    private TeamEntity visitorTeam;

    @Column(name = "RESULT")
    private String result;

    public MatchEntity() {
    }

    public TeamEntity getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamEntity homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamEntity getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(TeamEntity visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
