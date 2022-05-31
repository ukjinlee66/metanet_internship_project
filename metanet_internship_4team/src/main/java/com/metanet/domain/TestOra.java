package com.metanet.domain;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TESTORA")
@Data
public class TestOra 
{
	@Id
	private int user_id;
	private String user_name;
}
