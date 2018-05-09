package org.samulake.web.core.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.samulake.web.core.entity.TeamEntity.TABLE_NAME;
import static org.samulake.web.core.util.EntityPropertiesUtils.*;

@Entity
@Table(name=TABLE_NAME)
public class TeamEntity {
	public static final String TABLE_NAME = "TEAM";
	public static final String SEQUENCE_NAME = DEFAULT_SEQUENCE_NAME_PREFIX + TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;
	public static final String SEQUENCE_GENERATOR_NAME = SEQUENCE_NAME + DEFAULT_SEQUENCE_GENERATOR_SUFFIX;
	public static final String IDENTITY_COLUMN_NAME = TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;

	@Id
	@GenericGenerator(
			name = SEQUENCE_GENERATOR_NAME,
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = @Parameter(name = "sequence_name", value = SEQUENCE_NAME)
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR_NAME)
	@Column(name = IDENTITY_COLUMN_NAME)
	private Long id;

	@Column(name = "NAME", nullable = false, unique = true)
	private String name;
	
	@OneToMany(cascade={CascadeType.ALL, CascadeType.REMOVE}, fetch= FetchType.EAGER)
	@JoinTable(
		name="TEAM_MEMBERS",
		joinColumns=@JoinColumn(name=TeamEntity.IDENTITY_COLUMN_NAME),
		inverseJoinColumns=@JoinColumn(name=PersonEntity.IDENTITY_COLUMN_NAME)
	)
	private List<PersonEntity> members = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "LEADER_KEY")
	private UserEntity leader;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PersonEntity> getMembers() {
		return members;
	}

	public void setMembers(List<PersonEntity> members) {
		this.members = members;
	}

	public UserEntity getLeader() {
		return leader;
	}

	public void setLeader(UserEntity leader) {
		this.leader = leader;
	}
}
