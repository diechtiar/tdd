package pl.sdacademy.tdd.examples;

import java.math.BigInteger;

public class PowerCalculator {
	private final BigInteger base;
	private final BigInteger power;
	private BigInteger result = BigInteger.ONE;

	public PowerCalculator(BigInteger base, BigInteger power) {
		this.base = base;
		this.power = power;
	}

	public BigInteger calculate() {

		for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
			result = result.multiply(base);
		}
		return result;
	}
}
