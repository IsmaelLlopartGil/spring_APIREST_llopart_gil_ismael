package s05t02n01_llopart_gil_ismael.model.dto;

import java.io.Serializable;
import java.security.SecureRandom;

public class RollDto implements Serializable {

	private static final long serialVersionUID = 8859548414568852469L;

	private String id;
	private int firstDice;
	private int secondDice;
	private int result;

	public RollDto () {
		SecureRandom secureRandom = new SecureRandom();
		firstDice = secureRandom.nextInt(6 - 1) + 1;
		secondDice = secureRandom.nextInt(6 - 1) + 1;
		setResult();
	}
	
	public boolean isWinner () {
		return result == 7;
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

	public int getResult () {
		return result;
	}
	
	public void setResult() {
		this.result = firstDice + secondDice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
