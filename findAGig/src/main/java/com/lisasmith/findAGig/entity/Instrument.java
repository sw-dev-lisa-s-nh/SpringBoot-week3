package com.lisasmith.findAGig.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instrument {

	private Long instrumentId;
	private String name;
	
	@JsonIgnore
	private Set<User> musicians;
	
	@JsonIgnore
	private Set<Gig> gigs;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getInstrumentId() {
		return instrumentId;
	}
	
	public void setInstrumentId(Long id) {
		this.instrumentId = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "musician_instrument",
			joinColumns = @JoinColumn(name = "instrumentId", referencedColumnName = "instrumentId"),
			inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"))
	public Set<User> getMusicians() {
		return musicians;
	}
	
	public void setMusicians(Set<User> musicians) {
		this.musicians = musicians;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gig_instrument",
			joinColumns = @JoinColumn(name = "instrumentId", referencedColumnName = "instrumentId"),
			inverseJoinColumns = @JoinColumn(name = "gigId", referencedColumnName = "gigId"))
	public Set<Gig> getGigs() {
		return gigs;
	}
	
	public void setGigs(Set<Gig> gigs) {
		this.gigs = gigs;
	}
}
