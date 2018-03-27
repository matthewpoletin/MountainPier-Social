package com.mountainpier.social.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "users", schema = "public")
public class User {
	
	@Id
	@Column(name = "users_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// TODO: Make unique case-insensitive
	@Column(name = "users_username", unique = true)
	private String username;
	
	@Column(name = "users_avatar")
	private String avatar;
	
	@Column(name = "users_reg_email")
	private String regEmail;
	
	@Column(name = "users_reg_date")
	private Date regDate;
	
	@Column(name = "users_status")
	private String status;
	
	@Column(name = "users_birth_date")
	private Date birthDate;
	
	@OneToMany(mappedBy = "userA", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relations> related = new ArrayList<>();
	
	@OneToMany(mappedBy = "userB", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relations> relating = new ArrayList<>();
	
	
}
