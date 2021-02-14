package com.lisasmith.findAGig.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lisasmith.findAGig.util.EventType;
import com.lisasmith.findAGig.util.GenreType;

@Entity
public class Gig {

	private Long gigId;
	private LocalDateTime gigEventDateTime;
	private Address address;
	private String phone;
	private EventType event;
	private GenreType genre;
	private Set<Instrument> instruments;

	@JsonIgnore
	private User planner;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getGigId() {
		return gigId;
	}
	
	public void setGigId(Long gigId) {
		this.gigId = gigId;
	}
	
	public LocalDateTime getGigEventDateTime() {
		return gigEventDateTime;
	}

	public void setGigEventDateTime(LocalDateTime gigEventDateTime) {
		this.gigEventDateTime = gigEventDateTime;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public EventType getEvent() {
		return event;
	}
	
	public void setEvent(EventType event) {
		this.event = event;
	}
	
	public GenreType getGenre() {
		return genre;
	}
	
	public void setGenre(GenreType genre) {
		this.genre = genre;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gig_instrument",
			joinColumns = @JoinColumn(name = "gigId", referencedColumnName = "gigId"),
			inverseJoinColumns = @JoinColumn(name = "instrumentId", referencedColumnName = "instrumentId"))
	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

//	@OneToMany
//	@JoinColumn(name = "id")
//	public User getPlanner() {
//		return planner;
//	}
//
//	public void setPlanner(User planner) {
//		this.planner = planner;
//	}
	
	
}
