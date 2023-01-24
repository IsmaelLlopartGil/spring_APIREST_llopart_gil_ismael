package s05t02n01_llopart_gil_ismael.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document("players")
public class Player implements Serializable {

	private static final long serialVersionUID = -153224905164150410L;

	@Id
	private String id;

	private String name;

	private LocalDateTime registrationDate;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;

	@DBRef
	private List<Roll> rolls;
	
	public Player(String id, String name, LocalDateTime registrationDate, String email, String password, List<Roll> rolls) {
		this.id=id;
		this.name = name;
		this.registrationDate = registrationDate;
		this.email = email;
		this.password=password;
		this.rolls=rolls;
	}
	
	public Player(String name, LocalDateTime registrationDate, String email) {
		this.name = name;
		this.registrationDate = registrationDate;
		this.email = email;
		rolls = new ArrayList<>();
	}
	
	public Player (String id) {
		this.id = id;
	}
	
	public Player () {}
	
	public void addRoll (Roll roll) {
		rolls.add(roll);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(List<Roll> rolls) {
		this.rolls = rolls;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate (LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
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
