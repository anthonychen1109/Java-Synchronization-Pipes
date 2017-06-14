import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TC extends Thread {
	private String name;
	private int id;
	
	private ObjectInputStream ois;
	private InputStream is;
	
	private ObjectOutputStream oos;
	private OutputStream os;
	
	TC(String name, int id, ObjectInputStream ois, InputStream is, OutputStream os) {
		this.name = name;
		this.id = id;
		this.ois = ois;
		this.is = is;
		this.oos = oos;
		this.os = os;
	}// constructor

	// Send Object data to TB
	public void run() {
		//System.out.println(name + " starting execution.");
		try {
			ois = new ObjectInputStream(is);
			Message m = (Message)ois.readObject();
			
			oos = new ObjectOutputStream(os);
			oos.writeObject(m);
			
			System.out.println(name + " receives from TA the following: \n" + m);
			System.out.println(name + " sends to TB the following \n" + m);
		} // end TRY
		catch (Exception exc) {
			exc.printStackTrace();
		} // end CATCH

	} // end METHOD run
}// TC class
