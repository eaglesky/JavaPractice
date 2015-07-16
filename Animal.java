public class Animal implements Cloneable {
	protected final int age;
	protected final int size;
	protected Person owner;

	public Animal() {
		this.age = -1;
		this.size = -1;
	}

	public Animal(int age, int size) {
		this.age = age;
		this.size = size;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person p) {
		owner = p;
	}

	public String toString() {
		return "Age = " + age + "; Size = " + size
				+ "; Owner = " + owner.name() + ", age = " + owner.age();
	}

	@Override public Animal clone() {
		try {
			return (Animal)super.clone();
		} catch(CloneNotSupportedException e) {
			throw new AssertionError(); // Can't happen
		}	
	}
}