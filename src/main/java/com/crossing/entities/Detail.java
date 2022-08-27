package com.crossing.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "details")
public class Detail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnoreProperties(value = { "detail", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "detail", cascade = CascadeType.ALL)
	private List<Payment> payments;
	@JsonIgnoreProperties(value = { "details", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;
	@JsonIgnoreProperties(value = { "detail", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "detail", cascade = CascadeType.ALL)
	private List<Grouper> groupers;
	@Column(length = 2)
	private Integer percentage;
	@Column(length = 1)
	private String status;
}
