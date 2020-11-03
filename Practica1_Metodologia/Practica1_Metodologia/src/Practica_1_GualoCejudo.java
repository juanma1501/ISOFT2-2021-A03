
public class Practica_1_GualoCejudo {

	public static void main(String[] args) {
		int n;
		double formula_t, iterative_t, recursive_t;
		long startTime, endTime;
		int[] valuesN = { 1, 2, 3, 4, 10, 20, 50, 100, 1000, 2000, 5000, 10000, 11000 };

		System.out.println("N \t / \t Valor \t \t / \t \t Formula \t  /  \t Iterative \t \t / \t \t Recursive");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < valuesN.length; i++) {
			startTime = System.nanoTime();
			first_equation_iterative(valuesN[i]);
			endTime = System.nanoTime();
			formula_t = (double) (endTime - startTime);

			startTime = System.nanoTime();
			second_equation_iterative(valuesN[i]);
			endTime = System.nanoTime();
			iterative_t = (double) (endTime - startTime);

			startTime = System.nanoTime();
			second_equation_recursive(valuesN[i]);
			endTime = System.nanoTime();
			recursive_t = (double) (endTime - startTime);
			System.out.println(valuesN[i] + "\t / \t" + (2 * (valuesN[i] * valuesN[i]) - valuesN[i]) + "\t \t / \t \t"
					+ formula_t + "\t \t / \t \t" + iterative_t + "\t \t / \t \t" + recursive_t);
		}
	}

	public static void first_equation_iterative(int n) {
		int result = 0;
		result = n * (2 * n - 1);
	}

	public static void second_equation_iterative(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += 4 * i + 1;
		}
	}

	public static int second_equation_recursive(int n) {
		int result = 0;
		if (n == 0) {
			return result;
		} else {
			result = ((4 * (n - 1) + 1)) + second_equation_recursive(n - 1);
		}
		return result;
	}
}
