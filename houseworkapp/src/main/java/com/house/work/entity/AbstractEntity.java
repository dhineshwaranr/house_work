package com.house.work.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

@MappedSuperclass
public class AbstractEntity {

	private Long id;
	private DateTime createdDate;
	private DateTime modifiedDate;
	private DateTime lastActiveDate;
	private boolean isDeleted;
	private DateTime deletedDate;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@NotNull
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	public DateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	public DateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(DateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@NotNull
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public DateTime getDeletedDate() {
		return deletedDate;
	}
	public void setDeletedDate(DateTime deletedDate) {
		this.deletedDate = deletedDate;
	}
	public DateTime getLastActiveDate() {
		return lastActiveDate;
	}
	public void setLastActiveDate(DateTime lastActiveDate) {
		this.lastActiveDate = lastActiveDate;
	}
	
	
}
