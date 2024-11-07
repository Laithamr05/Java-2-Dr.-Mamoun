
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Activity3 {
	

	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
		// int sum = 0;
		//
		// // FileOutputStream fo = new FileOutputStream("data.dat", true);
		// // DataOutputStream da = new DataOutputStream(fo);
		// // for (int i = 0; i < 100; i++) {
		// // da.writeInt((int) (Math.random() * 100));
		// // }
		// // da.close();
		//
		// try (DataOutputStream dodo = new DataOutputStream(new
		// FileOutputStream("data2.dat", true))) {
		// for (int i = 0; i < 100; i++) {
		// dodo.writeInt((int) (Math.random() * 100));
		// }
		// dodo.close();
		// }
		// FileInputStream fifi = new FileInputStream("data2.dat");
		// DataInputStream didi = new DataInputStream(fifi);
		// while (didi.available() != 0) {
		// sum += (didi.readInt());
		//
		// }
		// System.out.println(sum);
		// }
		FileOutputStream fofo = new FileOutputStream("students.data");
		ObjectOutputStream oooo = new ObjectOutputStream(fofo);
		Student s1 = new Student("Laith", 19);
		oooo.writeObject(s1);
		Student s2 = new Student("Saddam", 23);
		oooo.writeObject(s2);
		Student s3 = new Student("Ali", 20);
		oooo.writeObject(s3);
		oooo.close();

		ArrayList<Student> soso = new ArrayList<>();
		FileInputStream fifi = new FileInputStream("students.data");
		ObjectInputStream oioi = new ObjectInputStream(fifi);
		while (fifi.available() != 0) {
			soso.add((Student) oioi.readObject());
			
		}
		Collections.sort(soso,new NameComparator());
		System.out.println(soso);
	}
}
