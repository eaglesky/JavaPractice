import java.io.*;

// Test serializing to binary stream and serializing subclass of non-serializable class. 

// Output should be:
// class Cat
// Age = -1, Size = -1, tailSize = 20
public class SerializeTest {
	public static void main (String[] args) {
		Animal animal1 = new Cat(10, 30, 20);

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