import java.util.StringTokenizer;

public class BirthdayStrings {
	public static void main(String[] args) {

		String birthMonth;
		String birthDate;
		String birthYear;

		String birthDay = "07/09/1966";
		StringTokenizer bDay = new StringTokenizer(birthDay, "/");

		birthMonth = bDay.nextToken();
		birthDate = bDay.nextToken();
		birthYear = bDay.nextToken();

		System.out.println("I was born in Month " + birthMonth + ", on Day "
				+ birthDate + ", in the year " + birthYear + ".");
	}
}
