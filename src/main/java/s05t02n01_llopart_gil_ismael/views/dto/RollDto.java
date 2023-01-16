package s05t02n01_llopart_gil_ismael.views.dto;

import java.io.Serializable;
import java.util.Objects;

public class RollDto implements Serializable {

	private static final long serialVersionUID = 8859548414568852469L;

	private int id;
	private int firstDice;
	private int secondDice;
	private int result;
	
	public RollDto () {
	}
	
	public boolean isWinnner () {
		return result == 7;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getResult () {
		return result;
	}
	public void setResult() {
		this.result = firstDice + secondDice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RollDto [id=" + id + "]";
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
		RollDto other = (RollDto) obj;
		return id == other.id;
	}
}
