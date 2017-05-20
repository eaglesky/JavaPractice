// Design the code to throw NullPointerException at runtime.
// The code should be compiled successfully as there is no checked exception.
// NullPointerException should be thrown from getAnimalOwner and caught in
// invokeGetAnimalOwner.
public class UncheckedExceptionTest {
	private static Person getAnimalOwner(Animal animal) {
		try {
			return animal.getOwner();
		} finally {
			System.out.println("getAnimalOwner clean up");

			// Don't include 'return' in finally! Otherwise the uncaught execption will be lost!
			//return null;
		}
	}

	// Comment the try-catch block out if you want to see the propagation of execption
	private static Person invokeGetAnimalOwner(Animal animal) {
		try {
			Person owner = getAnimalOwner(animal);
			System.out.println("This should never be executed!");
			return owner;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Caught runtime exception!");
			return null;
		}
		
	}

	private static String testAfterFinally() {
		String str = "";
		try {
			throw new RuntimeException("Throwed an exception inside try!");
		} finally {
			System.out.println("Statements inside finally");
			str = "Finally";
		}
		/* This part won't be reached! It's a compilation error if you uncomment it.
		System.out.println("Statements after finally!");
		return str;
		*/
	}

	public static void main(String[] args) {
		Animal animal = null;
		try {
			Person owner = invokeGetAnimalOwner(animal);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("This statement should only be executed when " + 
				"invokeGetAnimalOwner doesn't caught the execption");
		}
		String testStr = testAfterFinally();
		System.out.println("testStr = " + testStr);
	}
}