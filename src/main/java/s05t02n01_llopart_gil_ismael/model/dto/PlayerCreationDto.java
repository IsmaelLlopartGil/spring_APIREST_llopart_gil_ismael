package s05t02n01_llopart_gil_ismael.model.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class PlayerCreationDto  implements Serializable{
	private static final long serialVersionUID = 2552513427318593112L;
	
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	
	public PlayerCreationDto () {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
