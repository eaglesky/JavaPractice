class ArrayTest {
	public static void main(String[] args) {
		Object[] strings = new String[2];
		strings[0] = "hi";   // OK
		strings[1] = 100;    // A run-time ArrayStoreException is thrown.
	}
}