import java.io.*;

public class GameCharacter implements Serializable {
	private int power;
	private String type;
	private String[] weapons;
	
	public GameCharacter(int p, String t, String[] w) {
		this.power = p;
		this.type = t;
		this.weapons = w;
		
	}
	
	public int getPower() {
		return this.power;
		
	}
	
	public String getType() {
		return this.type;
		
	}
	
	public String getWeapons() {
		String weaponList = "";
		
		for (int i = 0; i < weapons.length; i++) {
			weaponList += weapons[i];
			
			if (i == (weapons.length - 1)) {
				weaponList += ".";
			} else {
				weaponList += ", ";
			}
		}
		
		
		return weaponList;
	}
}
