import java.io.*;

public class Dog extends Animal implements Serializable {

	public String name = "";

	public Dog(int age, int size, String name) {
		super(age, size);
		this.name = name;
	}

	public String toString() {
		return super.toString() + ", Dog's name = " + name;
	}

	private void writeObject(ObjectOutputStream out)  throws IOException {

        // Take care of this class's field first by calling defaultWriteObject
        out.defaultWriteObject();

        /*
         * Since the superclass does not implement the Serializable interface
         * we explicitly do the saving... Since these fields are not private
         * we can access them directly. If they were private, the superclass
         * would have to implement get and set methods that would allow the
         * subclass this necessary access for proper saving.
         */
        out.writeInt(age);
        out.writeInt(size);
        out.writeObject(habitat);
    }

	private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {

        /*
         * Take care of this class's fields first by calling
         * defaultReadObject
         */
        in.defaultReadObject();

        /*
         * Since the superclass does not implement the Serializable
         * interface we explicitly do the restoring... Since these fields
         * are not private we can access them directly. If they were
         * private, the superclass would have to implement get and set
         * methods that would allow the subclass this necessary access
         * for proper saving or restoring.
         */
        age = in.readInt();
        size = in.readInt();
        habitat = (Habitat)in.readObject();
    }
}