import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		Double d = 5.1231;
		BigDecimal bd1 = new BigDecimal(d);

		//The following will call d.toString(), which is the same as
		//Double.toString(d) and String.valueOf(d).
		//The actual value in d is not strictly equal to 5.1231
		//due to precision lost. The value of converted string x is selected
		//such that the actual value in d(say d_a) is the closest to x, 
		//and x has as least number of fractional digits as possible.
		//This way makes sure that there is a one to one mapping between
		//x and d_a. So that if the string is converted back to double,
		//it will be the same as the original one. And the results are 
		//the same no mattter how many times you do the conversion.
		System.out.println(d);
		System.out.format("%.20f\n", d);
		System.out.println(bd1);
	}
}