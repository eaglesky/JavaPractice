public class Animal implements Cloneable {
	protected int age;
	protected int size;
	protected Person owner;
	protected Habitat habitat = new Habitat();

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

	public String getHabitatName() {
		return habitat.getName();
	}

	public void setHabitatName(String name) {
		habitat.setName(name);
	}

	public String toString() {
		String output = "Age = " + age + "; Size = " + size + "; Habitat: " + habitat;
		if (owner != null )
			return output + "; Owner: " + owner;
		else {
			return output;
		}
	}

	@Override public Animal clone() {
		try {
			return (Animal)super.clone();
		} catch(CloneNotSupportedException e) {
			throw new AssertionError(); // Can't happen
		}	
	}
}