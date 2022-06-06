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

@Entity
@Table(name="SAVE")
@NoArgsConstructor
@AllArgsConstructor
@Data

@SequenceGenerator(	name = "SAVE_SEQ_GEN",
sequenceName = "SAVE_SEQ",
initialValue = 1,
allocationSize =1
)

public class Save {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAVE_SEQ_GEN")
	@Column(name = "SAVE_NUMBER")
	private int saveNumber;

	@Column(name = "USER_NUMBER")
	private int usersNumber;
	
	@Column(name = "VIDEO_NUMBER")
	private int videoNumber;
	
	@Column(name = "SAVE_CRDA")
	private java.sql.Date saveCrda;
	
	@Column(name = "SAVE_DEDA")
	private java.sql.Date saveDeda;

		
}

