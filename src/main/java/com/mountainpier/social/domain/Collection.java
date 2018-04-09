package com.mountainpier.social.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "collections", schema = "public")
public class Collection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collections_id")
	Integer id;
	
	@Column(name = "collections_game_id")
	UUID gameId;

	@ManyToOne
	User user;
	
}
