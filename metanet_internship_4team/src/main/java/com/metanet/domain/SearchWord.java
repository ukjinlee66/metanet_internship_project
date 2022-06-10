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
@Table(name="SEARCH_WORD")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(	name = "SEARCH_WORD_SEQ_GEN",
sequenceName = "SEARCH_WORD_SEQ",
initialValue = 1,
allocationSize =50)
public class SearchWord {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAVE_SEQ_GEN")
	@Column(name = "SEARCH_WORD_NUMBER")
	private int searchWordNumber;

	@Column(name = "SEARCH_WORD_NAME")
	private String searchWordName;
	
	@Column(name = "SEARCH_WORD_COUNT")
	private int searchWordCount;
	
}
