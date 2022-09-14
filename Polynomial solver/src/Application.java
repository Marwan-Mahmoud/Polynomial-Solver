public class Application {

	private Polynomial polynomialA;
	private Polynomial polynomialB;
	private Polynomial polynomialC;
	private Polynomial accumulator;
	private PolynomialSolver solver;

	public Application() {
		polynomialA = new Polynomial();
		polynomialB = new Polynomial();
		polynomialC = new Polynomial();
		accumulator = new Polynomial();
		solver = new PolynomialSolver();
	}

	public void setPolynomial(char poly, int[] coefficients) {
		Polynomial polynomial = getPolynomial(poly);
		polynomial.setCoefficients(coefficients);
	}

	public void printPolynomial(char poly) {
		Polynomial polynomial = getPolynomial(poly);
		System.out.println(polynomial);
	}

	public void add(char poly1, char poly2) {
		Polynomial operand1 = getPolynomial(poly1);
		Polynomial operand2 = getPolynomial(poly2);
		Polynomial result = solver.add(operand1, operand2);
		addToAccumlator(result);
	}

	public void subtract(char poly1, char poly2) {
		Polynomial operand1 = getPolynomial(poly1);
		Polynomial operand2 = getPolynomial(poly2);
		Polynomial result = solver.subtract(operand1, operand2);
		addToAccumlator(result);
	}

	public void multiply(char poly1, char poly2) {
		Polynomial operand1 = getPolynomial(poly1);
		Polynomial operand2 = getPolynomial(poly2);
		Polynomial result = solver.multiply(operand1, operand2);
		addToAccumlator(result);
	}

	public int evaluatePolynomial(char polynomialName, int value) {
		Polynomial polynomial = getPolynomial(polynomialName);
		return polynomial.evaluatePolynomial(value);
	}

	public void clearPolynomial(char poly) {
		Polynomial polynomial = getPolynomial(poly);
		polynomial.clear();
	}

	private void addToAccumlator(Polynomial result) {
		accumulator = solver.add(accumulator, result);
	}

	private Polynomial getPolynomial(char polynomialName) {
		switch (polynomialName) {
		case 'A':
			return polynomialA;
		case 'B':
			return polynomialB;
		case 'C':
			return polynomialC;
		case 'R':
			return accumulator;
		default:
			throw new IllegalArgumentException("Unexpected value: " + polynomialName);
		}
	}
}
