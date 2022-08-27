package com.crossing.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Grouper> groups;
	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Payment> payments;
	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Detail> details;
	@Column(nullable = false, length = 45)
	private String name;
	@Column(nullable = false, length = 45)
	private String lastName;
	@Column(unique = true, nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 16)
	private String password;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public void setCreatedAt(Timestamp createdAt) {
		Timestamp ts = Timestamp.from(Instant.now());
		this.createdAt = ts;
	}

}
