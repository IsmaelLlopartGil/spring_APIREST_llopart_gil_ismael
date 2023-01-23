package s05t02n01_llopart_gil_ismael.model.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class PlayerNameUpdaterDto implements Serializable {
	private static final long serialVersionUID = 2536395367473310194L;
	
	private String name;
	@NotBlank
	private String email;

	
	public PlayerNameUpdaterDto () {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
