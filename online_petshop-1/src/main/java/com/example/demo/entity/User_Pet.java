package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class User_Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_petid;
	private int userid;
	private Long petid;
	private Long quantitysold;



}
