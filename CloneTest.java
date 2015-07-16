public class CloneTest {
	public static void main(String[] args) {
		Animal animal1 = new Animal(3, 4);
		animal1.setOwner(new Person("Yalun", 25));
		Animal animal2 = animal1.clone();

		System.out.println("Animal1: " + animal1);
		System.out.println("Animal2: " + animal2);
		if (animal1 != animal2) {
			System.out.println("Animal2 is a different object from Animal1");
		}

		if (animal1.getOwner() == animal2.getOwner()) {
			System.out.println("Same owner objects!");
		}
	}
}