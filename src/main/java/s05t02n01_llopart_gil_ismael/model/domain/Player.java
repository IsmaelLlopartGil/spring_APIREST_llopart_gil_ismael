package s05t02n01_llopart_gil_ismael.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

	@NotBlank(message = "El nom és obligatori.")
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "registration_date")
	private LocalDateTime registrationDate;
	
	@NotBlank
	@Column(name = "password")
	private String password;

	@OneToMany (mappedBy = "player", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Roll> rolls;
	
	public Player(String name, LocalDateTime registrationDate) {
		this.name = name;
		this.registrationDate = registrationDate;
		rolls = new ArrayList<>();
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
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}	
}
