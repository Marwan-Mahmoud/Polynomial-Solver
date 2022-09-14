public class Polynomial {

	private int[] coefficients;

	public Polynomial() {
		coefficients = new int[] { 0 };
	}

	public Polynomial(int[] coefficients) {
		this.coefficients = coefficients;
	}

	public int[] getCoefficients() {
		return coefficients.clone();
	}

	public void setCoefficients(int[] coefficients) {
		this.coefficients = coefficients;
	}

	public int evaluatePolynomial(float value) {
		if (size() == 0)
			throw new RuntimeException("Polynomials can not be empty.");

		int result = 0;
		for (int exponent = size() - 1; exponent >= 0; exponent--) {
			int coefficient = coefficients[size() - 1 - exponent];
			result += coefficient * Math.pow(value, exponent);
		}
		return result;
	}

	public int size() {
		return coefficients.length;
	}

	public void clear() {
		coefficients = new int[] { 0 };
	}

	@Override
	public String toString() {
		if (coefficients.length == 0)
			throw new RuntimeException("Polynomials can not be empty.");

		StringBuilder builder = new StringBuilder();
		for (int exponent = size() - 1; exponent >= 0; exponent--) {
			int coefficient = coefficients[size() - 1 - exponent];
			if (coefficient == 0)
				continue;
			if (coefficient != 1)
				builder.append(coefficient);
			if (exponent > 0) {
				builder.append("x");
				if (exponent > 1)
					builder.append("^" + exponent);
				builder.append("+");
			}
		}

		String polynomialString = "0";
		if (builder.length() > 0) {
			polynomialString = builder.toString();
			polynomialString = polynomialString.replaceAll("\\+-", "-");
		}
		return polynomialString;
	}
}
