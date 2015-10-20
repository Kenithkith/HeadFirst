import java.io.*;

public class GameSaverTest {
	public static void main(String[] args) {
		GameCharacter one = new GameCharacter(50, "Elf", new String[] { "bow",
				"sword", "dust" });
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {
				"bare hands", "big ax" });
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {
				"spells", "invisibility" });

		// imagine code that does things with the characters that might change
		// there state values.

		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("Game.ser"));
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		one = null;
		two = null;
		three = null;

		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(
					"Game.ser"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();

			System.out.println("Character One is a Level "
					+ oneRestore.getPower() + " " + oneRestore.getType()
					+ " that controls the following items: "
					+ oneRestore.getWeapons());
			System.out.println("Character Two is a Level "
					+ twoRestore.getPower() + " " + twoRestore.getType()
					+ " that controls the following items: "
					+ twoRestore.getWeapons());
			System.out.println("Character Three is a Level "
					+ threeRestore.getPower() + " " + threeRestore.getType()
					+ " that controls the following items: "
					+ threeRestore.getWeapons());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
