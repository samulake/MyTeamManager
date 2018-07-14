package org.samulake.web.core.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.samulake.web.core.dto.PersonDto;

import javax.persistence.*;

import static org.samulake.web.core.util.EntityPropertiesUtils.*;

@Entity
@Table(name=PersonEntity.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity {
	public static final String TABLE_NAME = "PERSON";
	public static final String SEQUENCE_NAME = DEFAULT_SEQUENCE_NAME_PREFIX + TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;
	public static final String SEQUENCE_GENERATOR_NAME = SEQUENCE_NAME + DEFAULT_SEQUENCE_GENERATOR_SUFFIX;
	public static final String IDENTITY_COLUMN_NAME = TABLE_NAME + DEFAULT_IDENTITY_COLUMN_NAME_SUFFIX;

	@Id
	@GenericGenerator(
			name = SEQUENCE_GENERATOR_NAME,
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = @Parameter(name = "sequence_name", value = SEQUENCE_NAME)
	)
	@GeneratedValue(generator = SEQUENCE_GENERATOR_NAME)
	@Column(name = IDENTITY_COLUMN_NAME)
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	private boolean isUser;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public <T extends PersonEntity> T cloneProto(T subclass){
        subclass.setId(getId());
        subclass.setFirstName(firstName);
        subclass.setLastName(lastName);
        return subclass;
    }

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean user) {
		isUser = user;
	}

}
