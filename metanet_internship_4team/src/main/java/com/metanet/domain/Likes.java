package com.metanet.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="LIKES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(	name = "LIKES_SEQ_GEN",
					sequenceName = "LIKES_SEQ",
					initialValue = 1,
					allocationSize =50
				   )

public class Likes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LIKES_SEQ")
	@Column(name = "LIKES_NUMBER")
	private int likesNumber;
	
	@Column(name = "USER_NUMBER")
	private int usersNumber;
	
	@Column(name = "VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "LIKES_CRDA")
	@NonNull
	private java.sql.Date likesCrda;
	
	@Column(name = "LIKES_UPDA")
	private java.sql.Date likesUpda;
	
	@Column(name = "LIKES_DEDA")
	private java.sql.Date likesDeda;	
}