package co.edu.unbosque.model;

import java.math.BigInteger;

public class MultiplicarLargos {

	public MultiplicarLargos() {

	}

	public BigInteger ejecutar(BigInteger x, BigInteger y) {
		int N = Math.max(x.bitLength(), y.bitLength());

		if (N <= 2147483647) {
			return x.multiply(y);
		}

		N = (N / 2) + (N % 2);

		BigInteger xHigh = x.shiftRight(N);
		BigInteger xLow = x.subtract(xHigh.shiftLeft(N));
		BigInteger yHigh = y.shiftRight(N);
		BigInteger yLow = y.subtract(yHigh.shiftLeft(N));

		BigInteger a = ejecutar(xHigh, yHigh);
		BigInteger b = ejecutar(xLow, yLow);
		BigInteger c = ejecutar(xHigh.add(xLow), yHigh.add(yLow));

		return a.shiftLeft(2 * N).add(c.subtract(a).subtract(b)).shiftLeft(N).add(b);
	}
}
