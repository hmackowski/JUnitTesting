import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

/**
 * 
 */

/**
 * @author hmack
 *
 */
class TestDemoTest {

	private TestDemo testDemo;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@SuppressWarnings("null")
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException ) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive(){		
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(4, 4, 8, false),
				arguments(-1, 4, 5, true),
				arguments(-2, 4, 4, true)
				);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect(){
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberedSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	

}
