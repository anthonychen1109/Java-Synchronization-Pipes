import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TB extends Thread {
	private String name;
	private int id;
	
	private InputStream is;
	
	TB(String name, int id, InputStream is) {
		this.name = name;
		this.id = id;
		this.is = is;
	}// constructor

	// Send objects back to TA and receives Objects from TC
	public void run() {
		System.out.println(name + " starting execution. \n");
		try {
			int dataFromTA;
			dataFromTA = is.read();
			
			System.out.println( name + " receives " + dataFromTA + " from ThreadA \n" );
		} // end TRY
		catch (Exception exc) {
			exc.printStackTrace();
		} // end CATCH

	} // end METHOD run
}// TB class
