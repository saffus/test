package com.app.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail", schema = "hibernate")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inst_detail_id")
	private int id;
	
	private String channel;
	
	private String hobby;
	
	//private Instructor inst;
	
	
	public InstructorDetail() {}

	public InstructorDetail(String channel, String hobby) {
		super();
		this.channel = channel;
		this.hobby = hobby;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/*
	 * public Instructor getInst() { return inst; }
	 * 
	 * public void setInst(Instructor inst) { this.inst = inst; }
	 */

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", channel=" + channel + ", hobby=" + hobby + /*", inst=" + inst +*/ "]";
	}
	
	

}
