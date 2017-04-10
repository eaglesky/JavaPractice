import java.io.Serializable;

public class Person {
	private  String name;
	private  int age;
	public Person(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String name() {
		return name;
	}

	public int age() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "name = " + name + ", age = " + age;
	}
}