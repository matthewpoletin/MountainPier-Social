package com.mountainpier.social.web.model;

import com.mountainpier.social.domain.Relation;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RelationResponse {
	
	private Integer id;
	private UUID userAId;
	private UUID userBId;
	private Date estDate;
	private String type;
	
	public RelationResponse(Relation relation) {
		this.id = relation.getId();
		this.userAId = relation.getUserA().getId();
		this.userBId = relation.getUserB().getId();
		this.estDate = relation.getEstDate();
		this.type = relation.getType();
	}
	
}

