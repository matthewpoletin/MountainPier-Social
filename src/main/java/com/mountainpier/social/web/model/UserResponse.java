package com.mountainpier.social.web.model;

import com.mountainpier.social.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserResponse {

	private String id;
	private String username;
	private String avatar;
	private String regEmail;
	private Date regDate;
	private String status;
	private Date birthDate;

	public UserResponse(User user) {
		this.id = user.getId().toString();
		this.username = user.getUsername();
		this.avatar = user.getAvatar();
		this.regEmail = user.getRegEmail();
		this.regDate = user.getRegDate();
		this.status = user.getStatus();
		this.birthDate = user.getBirthDate();
	}
}
