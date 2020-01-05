package pl.sdacademy.tdd.examples;

import java.math.BigInteger;
import java.util.Objects;

public class PowerCalculator implements Power {

	// eliminacja parametrów konstruktora pozwoliła przekształcić
	// klasę w przykład klasy bezstanowej (nie ma żadnych atrybutów, są tylko metody).
	// Takie klasy są łatwiejsze w używaniu,

	@Override
	public BigInteger calculate(BigInteger base, BigInteger power) {
		if (Objects.isNull(base)) {
			throw new IllegalArgumentException("Base cannot be null");
		}
		if (Objects.isNull(power)) {
			throw new IllegalArgumentException("Power cannot be null");
		}

		BigInteger result = BigInteger.ONE;
		for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
			result = result.multiply(base);
		}
		return result;
	}
}
