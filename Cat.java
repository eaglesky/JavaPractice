import java.io.Serializable;

public class Cat extends Animal implements Serializable {
	private final int tailSize;

	public Cat(int age, int size, int tailSize) {
		super(age, size);
		this.tailSize = tailSize;
	}

	public String toString() {
		return super.toString()
			   + ", tailSize = " + tailSize;
	}
}