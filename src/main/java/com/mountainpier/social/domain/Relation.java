package com.mountainpier.social.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "relations", schema = "public")
public class Relation {
	
	@Id
	@Column(name = "relations_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "relations_user_a_id")
	private User userA;
	
	@ManyToOne
	@JoinColumn(name = "relations_user_b_id")
	private User userB;
	
	@Column(name = "relations_est_date")
	private Date estDate;
	
	@Column(name = "relations_type")
	private String type;

}
