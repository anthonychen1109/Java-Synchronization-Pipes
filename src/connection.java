import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class connection {
	
	//pipe for TA to TB
	private static PipedOutputStream pos1;
	private static PipedInputStream pis1;
	
	//pipe for TA to TC
	private static PipedOutputStream pos2;
	private static PipedInputStream pis2;
	
	//create objects
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	
	
	private static PipedOutputStream pos3;
	private static PipedInputStream pis3;
	
	public static void main(String argv[]) {
		try {

			// set up a pipe
			System.out.println("Pipe setup");
			pos1 = new PipedOutputStream();
			pis1 = new PipedInputStream(pos1);
			
			pos2 = new PipedOutputStream();
			pis2 = new PipedInputStream(pos2);
			
			pos3 = new PipedOutputStream();
			pis3 = new PipedInputStream(pos3);
			
			System.out.println("Object creation");
			TA thread1 = new TA("ThreadA", 1, pos1, oos, pos2);
			TB thread2 = new TB("ThreadB", 2, pis1);
			TC thread3 = new TC("ThreadC", 3, ois, pis2, pos3);

			System.out.println("Thread execution");
			thread1.start();
			thread2.start();
			thread3.start();

		} // end TRY
		catch (Exception exc) {
			exc.printStackTrace();
		} // end CATCH
	}

} // end CLASS ConnectionManager