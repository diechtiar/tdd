package pl.sdacademy.tdd.examples;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

class PowerCalculatorTest {

	private PowerCalculator powerCalc = new PowerCalculator();

	@Test
	@DisplayName("2 ^ 10 = 1024")
	void shouldPowerTwoIntegers() {
		BigInteger base = BigInteger.valueOf(2);
		BigInteger power = BigInteger.valueOf(10);

		BigInteger result = powerCalc.calculate(base, power);

		// wbudowana asercja JUnit porównuje wartość oczekiwaną (pierwszy parametr) z wartością będącą wynikiem testu
		// a assertJ ma zupełnie inną budowę. Najpierw jest odwołąnie do testowanego
		// elementu (tutaj result) a następnie jest wykonywane sprawdzenie poprzez dedykowane metody
		// taki zapis ułatwia czytanie
		assertThat(result).isEqualTo(BigInteger.valueOf(1024));
	}

	@ParameterizedTest(name = "{0} ^ {1} = {2}")
	@CsvSource( {
			"0,    1,   0",
			"2,    0,   1",
			"10,  2, 100",
			"1,  100, 1"
	})
	void shouldPowerTwoIntegers(int baseParam, int powerParam, int expected) {
		BigInteger base = BigInteger.valueOf(baseParam);
		BigInteger power = BigInteger.valueOf(powerParam);

		BigInteger result = powerCalc.calculate(base, power);

		assertThat(result).isEqualTo(BigInteger.valueOf(expected));
	}

	@Test
	void shouldThrowExceptionIfBaseNull() {
		// blok given
		BigInteger power = BigInteger.valueOf(2);

		// w tym przypadku blok when i then są połączone. Wynika to faktu,
		// że działanie normalnie realizowane w bloku when, w przypadku wyjątków
		// jest od razu przedmiotem testu
		// assetJ pozwala nie tylko kontrolować fakt wystąpienia wyjątku, jego typu ale również sprawdzać
		// inne cechy (w tym przypadku komunikat) w jednym złożonym poleceniu
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> powerCalc.calculate(null, power))
				.withMessage("Base cannot be null");

	}

	@Test
	void shouldThrowExceptionIfPowerNull() {
		BigInteger base = BigInteger.valueOf(2);

		// skórcona forma kontroli określonego typu wyjątku (patrz przykład wyżej)
		assertThatIllegalArgumentException().isThrownBy(() -> powerCalc.calculate(base, null))
				.withMessage("Power cannot be null");

	}
}
