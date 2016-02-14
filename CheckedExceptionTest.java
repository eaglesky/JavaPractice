import java.io.*;

public class CheckedExceptionTest {

	// Remove the try..catch block to see unreported error during compiling.
	// out.writeObject function throws some checked exceptions that must be 
	// either caught or explicitly thrown out(toByteArray2). Failing to do this
	// will cause compiling error: unreported exception...
	private static byte[] toByteArray(Animal animal) {
		byte[] animalBytes = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(animal);
			animalBytes = bos.toByteArray();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("toByteArray ends");
		return animalBytes;
	}

	// If this function throws checked exceptions, they must be caught by the caller
	// of this function, or explicitly thrown out again.
	private static byte[] toByteArray2(Animal animal) throws InvalidClassException, 
	NotSerializableException, IOException  {
		byte[] animalBytes = null;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(animal);
		animalBytes = bos.toByteArray();		

		System.out.println("toByteArray2 ends");
		return animalBytes;
	}

	public static void main(String[] args) {
		Animal animal = new Animal(10, 30);

		// Uncomment the following code to see the NotSerializableException
		//animal.setOwner(new Person("Yalun", 25));

		byte[] animalBytes = toByteArray(animal);

		try {
			byte[] animalBytes2 = toByteArray2(animal);		
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("CheckedExceptionTest ends");
	}
}