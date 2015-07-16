import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class UnmodifiableListTest {
	private static void printPersons(List<Person> persons) {
		for (Person p : persons) {
			System.out.print(p.name() + ", ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Yalun", 25));
		persons.add(new Person("Jack", 30));
		persons.add(new Person("Lucy", 16));
		List<Person> unmodifiablePersons = Collections.unmodifiableList(persons);
		System.out.println("Original: ");
		printPersons(unmodifiablePersons);

		// Try changing the collection through the view
		try {
			//unmodifiablePersons.add(new Person("Tim", 44));
			unmodifiablePersons.remove(0);
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException!");
		}
		System.out.println("Now the array content is still:");
		printPersons(unmodifiablePersons);
		
		// Make a change to one element throught the view
		try {
			for (Person p : unmodifiablePersons) {
				if (p.name().equals("Lucy")) {
					p.setName("Jane");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception!");
		}
		System.out.println("After making changes of an element through the view:");
		printPersons(unmodifiablePersons);
		System.out.println("Original list now is: ");
		printPersons(persons);

		// Remove the first element in the original array
		try {
			persons.remove(0);
			persons.add(new Person("Tim", 44));
		} catch (Exception e) {
			System.out.println("Exception!");
		}
		System.out.println("After changing the original array: ");
		printPersons(persons);
		System.out.println("Through the view:");
		printPersons(unmodifiablePersons);
	}
}