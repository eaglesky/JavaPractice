public class SingletonTest {
	public static void main(String[] args) {
		SingletonCat cat = SingletonCat.getInstance();
		cat.setAge(14);
		System.out.println("The cat's age is " + cat.getAge());
	}
}