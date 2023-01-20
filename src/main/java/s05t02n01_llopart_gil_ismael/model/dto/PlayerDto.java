package s05t02n01_llopart_gil_ismael.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PlayerDto implements Serializable{

	private static final long serialVersionUID = -258020059864984179L;

	private int id;
	private String name;
	private LocalDateTime registrationDate;
	private String password;
	private List<RollDto> rollList;
	
	public PlayerDto () {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<RollDto> getRolls() {
		return rollList;
	}

	public void setRolls(List<RollDto> rolls) {
		this.rollList = rolls;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PlayerDto [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDto other = (PlayerDto) obj;
		return id == other.id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
