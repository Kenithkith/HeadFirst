import java.util.Scanner;


public class VolcanoConstructors {

	private String status;
	private int speed;
	private float temperature;
	
	VolcanoConstructors(String status, int speed, float temp) {
		this.status = status;
		this.speed = speed;
		this.temperature = temp;
	}
	
	
	public void checkTemperature() {
		if (temperature > 660) {
			status = "Returning home";
			speed = 5;
		}
	}
	
	public void showAttributes() {
		System.out.println("Status:  " + status);
		System.out.println("Speed:  " + speed);
		System.out.println("Temperature: " + temperature);
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is the name of the robot?");
		String robotName = input.nextLine();
		
		System.out.println("What is its current status?");
		String robotStatus = input.nextLine();
		
		System.out.println("What is its current speed?");
		int robotSpeed = input.nextInt();
		
		System.out.println("What is the current temperature?");
		float robotTemp = input.nextFloat();
		
		VolcanoConstructors robot1 = new VolcanoConstructors(robotStatus, robotSpeed, robotTemp);
		
		System.out.println("Here is the report on " + robotName + ":");
		System.out.println("Status: " + robotStatus);
		System.out.println("Speed: " + robotSpeed);
		System.out.println("Temperature: " + robotTemp);
		
		/** VolcanoConstructors dante = new VolcanoConstructors("exploring", 2, 510);
		
		
		dante.showAttributes();
		System.out.println("Increasing speed to 3.");
		dante.speed = 3;
		dante.showAttributes();
		System.out.println("Changing temperature to 670");
		dante.temperature = 670;
		dante.showAttributes();
		System.out.println("Checking the temperature.");
		dante.checkTemperature();
		dante.showAttributes(); */
	
	input.close();
	}
}
