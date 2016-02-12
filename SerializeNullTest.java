import java.io.*;

// Test serializing a class with non-serializable field of null value 
// If the Person field in Animal class is non-serializable and its value is null, 
// the Animal object can still be serialized without throwing NotSeri;alizableException
// However if Person is not null(animal1.setOwner(..)) is called, then that exception will be thrown.
// To resolve it, just declare Person class to be Serializable.
public class SerializeNullTest {
	public static void main (String[] args) {
		Animal animal1 = new Animal(10, 30);

		//animal1.setOwner(new Person("Yalun", 25));

		byte[] animalBytes = null;

		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(animal1);
			animalBytes = bos.toByteArray();		
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		Animal animal2 = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(animalBytes);
			ObjectInputStream in = new ObjectInputStream(bis);
			animal2 = (Animal)in.readObject();				
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println(animal2.getClass());
		System.out.println(animal2.toString());

	}
}