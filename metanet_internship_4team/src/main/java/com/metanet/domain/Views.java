package com.metanet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="VIEWS")
@Data
public class Views {
	@Id
	private int View_Number;
	private int User_Number;
	private String Is_View;
	private int date;
}
