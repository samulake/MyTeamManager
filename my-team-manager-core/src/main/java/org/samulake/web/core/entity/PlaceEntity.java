package org.samulake.web.core.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

import static org.samulake.web.core.util.EntityPropertiesUtils.*;

@Entity
@Table(name=PlaceEntity.TABLE_NAME)
public class PlaceEntity {
	public static final String TABLE_NAME = "PLACE";
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
	private Integer id;

	@Column(name = "STREET_AND_NR")
	private String streetAndNr;
	
	@ManyToOne
	@JoinColumn(name=CityEntity.IDENTITY_COLUMN_NAME)
	private CityEntity city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetAndNr() {
		return streetAndNr;
	}

	public void setStreetAndNr(String streetAndNr) {
		this.streetAndNr = streetAndNr;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}
}
