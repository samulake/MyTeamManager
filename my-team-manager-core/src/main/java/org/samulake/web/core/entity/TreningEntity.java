package org.samulake.web.core.entity;

import javax.persistence.*;

import static org.samulake.web.core.entity.TreningEntity.*;
import static org.samulake.web.core.util.EntityPropertiesUtils.*;

@Entity
@Table(name=TABLE_NAME)
@SequenceGenerator(name=SEQUENCE_GENERATOR_NAME, sequenceName = SEQUENCE_NAME)
@AttributeOverride(name = "id", column = @Column(name = TreningEntity.IDENTITY_COLUMN_NAME))
public class TreningEntity extends EventEntity {
    public static final String TABLE_NAME = "TRENING";
    public static final String SEQUENCE_NAME = DEFAULT_SEQUENCE_NAME_PREFIX + TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;
    public static final String SEQUENCE_GENERATOR_NAME = SEQUENCE_NAME + DEFAULT_SEQUENCE_GENERATOR_SUFFIX;
    public static final String IDENTITY_COLUMN_NAME = TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;

    @ManyToOne
    @JoinColumn(name = TeamEntity.IDENTITY_COLUMN_NAME)
    private TeamEntity team;

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }
}
