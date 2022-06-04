package com.metanet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="LIKES")
@Data
public class Likes {
   
   @Id
   @Column(name = "LIKES_NUMBER")
   private int likesNumber;
   
   @Column(name = "USER_NUMBER")
   private int usersNumber;
   
   @Column(name = "VIDEO_NUMBER")
   private int videoNumber;
   
   @Column(name = "LIKES_CRDA")
   private String likesCrda;
   
   @Column(name = "LIKES_UPDA")
   private String likesUpda;
   
   @Column(name = "LIKES_DEDA")
   private String likesDeda;   
}