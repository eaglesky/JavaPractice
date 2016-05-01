import java.util.*;

class AnimalArrayTest {

	public static void printList(List<Object> list) {
	    for (Object elem : list)
	        System.out.println(elem + " ");
	    System.out.println();
	}

	public static void printListWildcard(List<?> list) {
	    for (Object elem: list)
	        System.out.println(elem + " ");
	    System.out.println();
	}

	public static void main(String[] args) {
		List<Object> animalObjects = new ArrayList<Object>();
		animalObjects.add(new Animal(1, 1));
		animalObjects.add(new Cat(2, 3, 4));
		printList(animalObjects);
		System.out.println("Printed with wildcard ..");
		printListWildcard(animalObjects);
	}
}