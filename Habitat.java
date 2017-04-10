import java.io.Serializable;

public class Habitat implements Serializable {
	private String name = "Unknown place";

	public Habitat() {
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name;
	}
}