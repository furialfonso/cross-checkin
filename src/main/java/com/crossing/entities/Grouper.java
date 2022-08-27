package com.crossing.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groupers")
public class Grouper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnoreProperties(value = { "payments", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;
	@JsonIgnoreProperties(value = { "groupers", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Detail detail;
	@Column(length = 10)
	private String name;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
