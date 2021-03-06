package com.mountainpier.social.web.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserRequest {
	
	@NotEmpty(message = "Not valid username")
	private String username;
	
	@NotEmpty(message = "Not valid regEmail")
	private String regEmail;
	
	private String avatar;
	
	@NotNull(message = "regDate not set")
	private Date regDate;
	
	private String status;
	
	private Date birthDate;
	
}
