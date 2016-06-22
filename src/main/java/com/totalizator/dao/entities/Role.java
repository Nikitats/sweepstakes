package com.totalizator.dao.entities;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by home
 */
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
	@Id
	@GeneratedValue(generator = "role_native")
	@GenericGenerator(name = "role_native", strategy = "native")
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false, unique = true, updatable = false)
	private RoleType type;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return this.getType().name();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Role role = (Role) o;
		if (id != 0 && role.id != 0)
			return id == role.id;
		return type == role.type;
	}

	@Override
	public int hashCode() {
		if (id != 0)
			return Objects.hash(id);
		return Objects.hash(type);
	}

	public RoleType getType() {
		return this.type;
	}

	public void setType(RoleType type) {
		this.type = type;
	}

	public enum RoleType implements IBaseEnumValueText {
		ROLE_ADMIN(1, "Администратор", "/");

		private final int value;
		private final String text;
		private final String homeUrl;

		RoleType(int value, String text, String homeUrl) {
			this.value = value;
			this.text = text;
			this.homeUrl = homeUrl;
		}

		@Override
		public int getValue() {
			return value;
		}

		@Override
		public String getDescription() {
			return text;
		}

		public String getHomeUrl() {
			return homeUrl;
		}
	}
}
