package pl.sdacademy.tdd.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class PowerCalculatorTest {

	// wprowadzenie zmiennej reprezentującej testowany obiekt na początku klasy jest  często stosowaną praktyką.
	// Jedna z konwencji podaje by taka zmienna miała nazwę sut - System Under Test
	private PowerCalculator powerCalc;

	@Test
	@DisplayName("2 ^ 10 = 1024")
	void shouldPowerTwoIntegers() {
		// blok Given
		// często w projecie, dla podniesienia czytelności, poszczególne składowe testowanej operacji są wprost podane w tym bloku
		// alternatywnie mogło by być: powerCalc = new PowerCalculator(2, 10)
		BigInteger base = BigInteger.valueOf(2);
		BigInteger power = BigInteger.valueOf(10);
		powerCalc = new PowerCalculator(base, power);

		// blok when
		BigInteger result = powerCalc.calculate();

		// blok then
		// wbudowana asercja JUnit porównuje wartość oczekiwaną (pierwszy parametr) z wartością będącą wynikiem testu
		assertEquals(BigInteger.valueOf(1024), result);
	}

}
