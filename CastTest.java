class CastTest {
	public static void main(String[] args) {
		Animal animal1 = new Animal(5, 6);
		Animal animal2 = new Cat(1, 2, 3);
		System.out.println("Animal 1 is " + animal1.getClass());
		System.out.println("Animal 2 is " + animal2.getClass());
		System.out.println(animal2);
		Cat cat2 = (Cat)animal2;
		Cat cat1 = (Cat)animal1; //Throws ClassCastException
	}
}