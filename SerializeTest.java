import java.io.*;

// Test serializing to binary stream and serializing subclass of non-serializable class. 

public class SerializeTest {

	private static void testSerializeAnimal(Animal animal) {
		byte[] animalBytes = null;

		System.out.println(animal.getClass());
		System.out.println(animal.toString());

		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(animal);
			animalBytes = bos.toByteArray();		
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		Animal animalDes = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(animalBytes);
			ObjectInputStream in = new ObjectInputStream(bis);
			animalDes = (Animal)in.readObject();				
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println(animalDes.getClass());
		System.out.println(animalDes.toString());
	}

	public static void main (String[] args) {
		//Cat is serializable, but its super class Animal is not.
		Animal animal1 = new Cat(10, 30, 20);
		animal1.setOwner(new Person("Yalun", 20));
		animal1.setHabitatName("Earth");

		// If the super class is not serializable, none of its field will be serialized by default.
		// Output of deserialized object should be:
		// class Cat
		// Age = -1; Size = -1; Habitat: Unknown place, tailSize = 20
		testSerializeAnimal(animal1);

		//We can serialize the fields of superclass by overriding readObject and writeObject in the subclass,
		//if the superclass is not serializble.
		//References:https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/examples/nonserialsuper/sources.html
		Animal animal2 = new Dog(20, 40, "Bob");
		animal2.setOwner(new Person("Bill", 20));
		animal2.setHabitatName("Bill's house");

		//Output of deserialized object should be:
		//Age = 20; Size = 40; Habitat: Bill's house, Dog's name = Bob
		testSerializeAnimal(animal2);

	}
}