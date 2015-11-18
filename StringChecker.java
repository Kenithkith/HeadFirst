public class StringChecker {
	public static void main(String[] args) {

		String str = "Would you like an apple pie with that?";
		System.out.println("The string is: " + str);
		System.out.println("Length of this string: " + str.length());
		System.out.println("The character at position 6: " + str.charAt(6));
		System.out.println("The substring from 26 to 32: "
				+ str.substring(26, 32));
		System.out.println("The index of the first 'a': " + str.indexOf('a'));
		System.out.println("The index of the beginning of the "
				+ "substring \"apple\": " + str.indexOf("apple"));
		System.out.println("The string in uppercase: " + str.toUpperCase());
		
		int accountBalance = 5005;
		System.out.format("\nBalance: $%,d%n", accountBalance);
		
		double pi = Math.PI;
		System.out.format("\nPi is equal to " + "%.11f%n", pi);
		
		
		
		//mac 90:68:c3:46:c7:a6
	}
}
