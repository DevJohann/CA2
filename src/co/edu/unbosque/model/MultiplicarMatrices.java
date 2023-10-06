package co.edu.unbosque.model;

public class MultiplicarMatrices {
	public MultiplicarMatrices() {

	}

	public void multiplyWithDYV() {

	}

	public int[][] multiplyWithoutDYV(int[][] M_A, int[][] M_B) {

		int rowsA = M_A.length;
		int colsA = M_A[0].length;
		int colsB = M_B[0].length;

		int[][] res = new int[rowsA][colsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				int sum = 0;
				for (int k = 0; k < colsA; k++) {
					sum += M_A[i][k] * M_B[k][j];
				}
				res[i][j] = sum;
			}
		}

		return res;
	}
}
