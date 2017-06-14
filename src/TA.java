import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TA extends Thread {
	private String name;
	private int id;
	
	private OutputStream os;
	private ObjectOutputStream oos;
	
	private OutputStream os2;
	
	TA(String name, int id, OutputStream os, ObjectOutputStream oos, OutputStream os2) {
		this.name = name;
		this.id = id;
		this.os = os;
		this.oos = oos;
		this.os2 = os2;
	}// constructor

	// TA sends primitive data to TB and objects to TC
	public void run() {
		System.out.println(name + " starting execution. \n");
		try {
			//creating primitive data
			int data = 9;
			os.write(data);
			
			Message m = new Message();
			m.theMessage = id + " checking in!";
			String[] s = { "Hello", "this is", "TA" };
			m.someLines = s;
			m.someNumber = 64;
			
			
			oos = new ObjectOutputStream(os2);
			oos.writeObject(m);
			
			System.out.println(name + " sends " + data + " to ThreadB \n");
			System.out.println(name + " sends to TC the following \n" + m);
		} // end TRY
		catch (Exception exc) {
			exc.printStackTrace();
		} // end CATCH

	} // end METHOD run
}// TA class
