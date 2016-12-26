public class TestBitwiseOperations {
	public static void main(String[] args) {
		int num = (1 << 30);
		System.out.println("num = " + num);
		System.out.println("After arithmetic shifting left by 1: " + (num << 1));
		System.out.println("num = " + (num));
		System.out.println((num << 1) - 1);
		System.out.println(Integer.toBinaryString((num << 1) - 1));
		System.out.println(Integer.toBinaryString(-1));
		//There is no '<<<'

		System.out.println(Integer.SIZE);

		System.out.println(Integer.toBinaryString(4));
		System.out.println(Integer.toBinaryString(-4));
		System.out.println(Integer.toBinaryString(-5));
	}
}