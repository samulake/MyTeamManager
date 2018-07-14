package org.samulake.web.core.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name= UserEntity.TABLE_NAME)
public class UserEntity extends PersonEntity implements UserDetails {
	private static final long serialVersionUID = 1L;
	public static final String TABLE_NAME = "MTM_USER";

	@Column(name = "USERNAME", unique = true)
	private String username;

	@Column(name = "ENCODED_PASSWORD", nullable = false)
	private String password;

	@OneToOne(mappedBy="leader")
	@JoinColumn(name = TeamEntity.IDENTITY_COLUMN_NAME)
	private TeamEntity team;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}
}
