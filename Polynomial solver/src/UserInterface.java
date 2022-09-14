import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Application application = new Application();
		while (scanner.hasNextLine()) {
			String operation = scanner.nextLine();
			try {
				switch (operation) {
				case "set":
					char polynomialName = scanner.nextLine().charAt(0);
					String input = scanner.nextLine();
					String[] numbersStrings = input.replaceAll("\\[|\\]| ", "").split(",");
					int[] numbers = new int[numbersStrings.length];
					for (int i = 0; i < numbersStrings.length; i++)
						numbers[i] = Integer.parseInt(numbersStrings[i]);
					application.setPolynomial(polynomialName, numbers);
					break;
				case "print":
					polynomialName = scanner.nextLine().charAt(0);
					application.printPolynomial(polynomialName);
					break;
				case "add":
					char poly1 = scanner.nextLine().charAt(0);
					char poly2 = scanner.nextLine().charAt(0);
					application.add(poly1, poly2);
					application.printPolynomial('R');
					break;
				case "sub":
					poly1 = scanner.nextLine().charAt(0);
					poly2 = scanner.nextLine().charAt(0);
					application.subtract(poly1, poly2);
					application.printPolynomial('R');
					break;
				case "mult":
					poly1 = scanner.nextLine().charAt(0);
					poly2 = scanner.nextLine().charAt(0);
					application.multiply(poly1, poly2);
					application.printPolynomial('R');
					break;
				case "clear":
					polynomialName = scanner.nextLine().charAt(0);
					application.clearPolynomial(polynomialName);
					break;
				case "eval":
					polynomialName = scanner.nextLine().charAt(0);
					int value = scanner.nextInt();
					System.out.println(application.evaluatePolynomial(polynomialName, value));
					break;
				default:
					System.out.println("Error");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("Error");
				System.exit(0);
			}
		}
		scanner.close();
	}
}
