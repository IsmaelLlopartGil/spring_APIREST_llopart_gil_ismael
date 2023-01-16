package s05t02n01_llopart_gil_ismael.model.domain;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "roll")
public class Roll implements Serializable{

	private static final long serialVersionUID = 7630255444827266069L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@NotBlank
	@Column(name = "first_dice")
	private Integer firstDice;
	
	@NotBlank
	@Column(name = "second_dice")
	private Integer secondDice;
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn (name="id_player")
	private Player player;
	
	public Roll (Player player) {
		this.player = player;
		SecureRandom secureRandom = new SecureRandom();
		firstDice = secureRandom.nextInt(6 - 1) + 1;
		secondDice = secureRandom.nextInt(6 - 1) + 1;
	}
	
	public Roll () {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFirstDice() {
		return firstDice;
	}

	public void setFirstDice(Integer firstDice) {
		this.firstDice = firstDice;
	}

	public Integer getSecondDice() {
		return secondDice;
	}

	public void setSecondDice(Integer secondDice) {
		this.secondDice = secondDice;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Roll [id=" + id + "]";
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
		Roll other = (Roll) obj;
		return Objects.equals(id, other.id);
	}
}
