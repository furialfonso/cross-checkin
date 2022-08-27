package com.crossing.entities;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "payments")
public class Payment implements Serializable {
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
	@JsonIgnoreProperties(value = { "payments", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Detail detail;
	private Long value;
	private String description;
	private Date date;
	private Timestamp createdAt;
	private Timestamp updatedAt;

}
