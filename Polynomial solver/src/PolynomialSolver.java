public class PolynomialSolver {

	public Polynomial add(Polynomial poly1, Polynomial poly2) {
		int size1 = poly1.size();
		int size2 = poly2.size();
		if (size1 == 0 || size2 == 0)
			throw new RuntimeException("Polynomials can not be empty.");

		int[] coefficients1 = poly1.getCoefficients();
		int[] coefficients2 = poly2.getCoefficients();
		int[] result;
		if (size1 > size2) {
			result = coefficients1;
			for (int i = 0; i < size2; i++)
				result[i] += coefficients2[i];
		} else {
			result = coefficients2;
			for (int i = 0; i < size1; i++)
				result[i] += coefficients1[i];
		}
		return new Polynomial(result);
	}

	public Polynomial subtract(Polynomial poly1, Polynomial poly2) {
		int[] temp = poly2.getCoefficients();
		for (int i = 0; i < temp.length; i++)
			temp[i] *= -1;

		Polynomial result = add(poly1, new Polynomial(temp));
		return result;
	}

	public Polynomial multiply(Polynomial poly1, Polynomial poly2) {
		int size1 = poly1.size();
		int size2 = poly2.size();
		if (size1 == 0 || size2 == 0)
			throw new RuntimeException("Polynomials can not be empty.");

		int[] coefficients1 = poly1.getCoefficients();
		int[] coefficients2 = poly2.getCoefficients();
		int[] result = new int[size1 + size2 - 1];
		for (int i = 0; i < result.length; i++)
			result[i] = 0;

		for (int i = size1 - 1; i >= 0; i--) {
			for (int j = size2 - 1; j >= 0; j--)
				result[i + j] += coefficients1[i] * coefficients2[j];
		}
		return new Polynomial(result);
	}
}