package s05t02n01_llopart_gil_ismael.model.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document("rolls")
public class Roll implements Serializable {

	private static final long serialVersionUID = 7630255444827266069L;

	@Id
	private String id;

	@NotNull
	private Integer firstDice;

	@NotNull
	private Integer secondDice;

	public Roll(String id, int firstDice, int secondDice) {
		this.id = id;
		this.firstDice = firstDice;
		this.secondDice = secondDice;

	}

	public Roll() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFirstDice() {
		return firstDice;
	}

	public void setFirstDice(int firstDice) {
		this.firstDice = firstDice;
	}

	public int getSecondDice() {
		return secondDice;
	}

	public void setSecondDice(int secondDice) {
		this.secondDice = secondDice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
