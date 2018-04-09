package com.mountainpier.social.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "users", schema = "public")
public class User {
	
	@Id
	@Column(name = "users_id")
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
	@GenericGenerator(
		name = "uuid2",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;
	
	// TODO: Make unique case-insensitive
	@Column(name = "users_username", unique = true)
	private String username;
	
	@Column(name = "users_avatar")
	private String avatar;
	
	// TODO: Make unique case-insensitive
	@Column(name = "users_reg_email", unique = true)
	private String regEmail;
	
	@Column(name = "users_reg_date")
	private Date regDate;
	
	@Column(name = "users_status")
	private String status;
	
	@Column(name = "users_birth_date")
	private Date birthDate;
	
	@OneToMany(mappedBy = "userA", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relation> related = new ArrayList<>();
	
	@OneToMany(mappedBy = "userB", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Relation> relating = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Collection> collections = new ArrayList<>();
	
}
