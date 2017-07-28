import java.math.*;

public class BigDecimalTest {

	//BigDecimal uses unscaled value(BigInteger) and scale(int) to
	//represent any decimal number. value = unscaled_value * 10^(-scale)
	private static void checkBigDecimal(BigDecimal bd) {
		System.out.println("BigDecimal = " + bd);
		System.out.println("Unscaled = " + bd.unscaledValue());
		System.out.println("Scale = " + bd.scale());
		System.out.println("Scale = 3(round half even): " + 
			bd.setScale(3, BigDecimal.ROUND_HALF_EVEN));
		System.out.println("Scale = -1(round half even): " + 
			bd.setScale(-1, BigDecimal.ROUND_HALF_EVEN));

		System.out.println("");
	}

	private static void checkDouble(Double d) {

		//The following will call d.toString(), which is the same as
		//Double.toString(d) and String.valueOf(d).
		//The actual value in d is not strictly equal to 5.1231
		//due to precision lost. The value of converted string x is selected
		//such that the actual value in d(say d_a) is the closest to x, 
		//and x has as least number of fractional digits as possible.
		//This way makes sure that there is a reversable mapping between
		//x and d_a. So that if the string is converted back to double,
		//it will be the same as the original one. And the results are 
		//the same no mattter how many times you do the conversion.
		//However multiple double string values could be mapped to the same
		//underlying doubel value, like in :
		//http://www.onjava.com/pub/a/onjava/2000/12/15/formatting_doubles.html
		//5.39E-322D and 5.41E-322D are stored as same double value. In this
		//case, the converted string value is 5.4E-322.
		System.out.println("d.toString() = " + d);

		//bd stores the exact underlying representation of d, instead of calling
		//d.toString() first.
		BigDecimal bd = new BigDecimal(d);
		checkBigDecimal(bd);
	}

	private static void checkDouble(String s) {
		System.out.println("String double = " + s);

		//There is a one-to-one mapping between the distinguishable
		//BigDecimal values and the string representation of it.
		//See Javadoc BigDecimal.toString()
		BigDecimal bd = new BigDecimal(s);
		checkBigDecimal(bd);
	}

	private static void testBigDecimalMethods() {
		BigDecimal bd1 = new BigDecimal("4.52");
		BigDecimal bd2 = new BigDecimal("-443.44893");
		BigDecimal bd3 = new BigDecimal("-3.52");

		//4.52 + -3.52 = 1.00
		//bd1 is immutable and the method returns a new object
		System.out.println(bd1 + " + " + bd3 + " = " + bd1.add(bd3));

		//4.52 + -443.44893 = -438.92893
		System.out.println(bd1 + " + " + bd2 + " = " + bd1.add(bd2));

		BigDecimal bd4 = new BigDecimal("1");
		BigDecimal bd5 = new BigDecimal("3");
		//The following throws an exception since the result is Non-terminating
		//and no rounding method is specified
		//System.out.println(bd4 + " / " + bd5 + " = " + bd4.divide(bd5));

		//1 / 3 = 0,  since bd4.scale() == 0
		System.out.println(bd4 + " / " + bd5 + " = "
			+ bd4.divide(bd5, BigDecimal.ROUND_HALF_DOWN));

		//1 / 3 = 0.333
		System.out.println(bd4 + " / " + bd5 + " = "
			+ bd4.divide(bd5, 3, BigDecimal.ROUND_HALF_DOWN));

		//4.52 x -443.44893 = -2004.3891636
		//Same as multiply(bd2, MathContext.UNLIMITED)
		System.out.println(bd1 + " x " + bd2 + " = "
			+ bd1.multiply(bd2));

		//4.52 x -443.44893 = -2004.39
		System.out.println(bd1 + " x " + bd2 + " = "
			+ bd1.multiply(bd2, new MathContext(6)));

		BigDecimal bd6 = new BigDecimal("4.5200");
		//False ! equals compares the contents of objects -- [unscaled_value, scale],
		//which are different since string representation and [unscaled_value, scale]
		//are one-to-one mapping.
		System.out.println("4.52 equals 4.5200 ? " + bd1.equals(bd6));

		//0, so they are equal in value.
		System.out.println("4.52 compareTo 4.5200 ?? " + bd1.compareTo(bd6));

		// a.signum() returns (-1 if a < 0), (0 if a == 0), (1 if a > 0)
		// In this case, returns 1
		System.out.println(bd6 + " sign = " + bd6.signum()); 
	}

	public static void main(String[] args) {
		//When the compiler compiles this, I guess it will treat '5.123' as
		//a string and call Double.valueOf on it.
		checkDouble(5.123);
		checkDouble(-21.3455555);
		checkDouble(173.0);
		checkDouble(Double.valueOf(0));
		checkDouble(1.0/3.0);

		checkDouble("123.456");
		checkDouble("123.456000");
		checkDouble("-344444444433.555555");

		//valueOf first calls Double.toString to convert the double to a string,
		//then call the constructor that takes a string as the parameter
		checkBigDecimal(BigDecimal.valueOf(123.456));
		checkBigDecimal(BigDecimal.valueOf(-3333.74444));

		testBigDecimalMethods();
	}
}