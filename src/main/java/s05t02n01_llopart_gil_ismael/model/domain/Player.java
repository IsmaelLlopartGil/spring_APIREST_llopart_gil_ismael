package s05t02n01_llopart_gil_ismael.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "player")
public class Player implements Serializable {

	private static final long serialVersionUID = -153224905164150410L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "registration_date")
	private LocalDateTime registrationDate;
	
	@NotBlank
	@Column(name = "email" , unique = true, nullable = false)
	private String email;
	
	@NotBlank
	@Column(name = "password")
	private String password;

	@OneToMany (mappedBy = "player", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Roll> rolls;
	
	public Player(String name, LocalDateTime registrationDate, String email) {
		this.name = name;
		this.registrationDate = registrationDate;
		this.email = email;
		rolls = new ArrayList<>();
	}
	
	public Player (int id) {
		this.id = id;
	}
	
	public Player () {}
	
	public void addRoll (Roll roll) {
		rolls.add(roll);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
