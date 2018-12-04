import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;



public class Rxtx implements SerialPortEventListener {
	SerialPort serialPort;
	Model model;
        /** The port we're normally going to use. */
	//private static final String PORT_NAMES[] = {"COM6"// Windows
	//};
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results codepage independent
	*/
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	public void initialize() {
                // the next line is for Raspberry Pi and 
                // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
               // System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
		CommPortIdentifier serialPortId = null;

		Enumeration enumComm;

		enumComm = CommPortIdentifier.getPortIdentifiers();

		while(enumComm.hasMoreElements())
		{
		serialPortId = (CommPortIdentifier)enumComm.nextElement();
		if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL)
		{
		System.out.println(serialPortId.getName());
		}
		}
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		if (serialPortId == null) {
			System.out.println("Could not find COM port.");
			return;
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) serialPortId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=input.readLine();
				if (inputLine.startsWith("Humidity :")) {
					String humidity="";
					for(int i =10;i<inputLine.length();i++) {
						humidity +=inputLine.charAt(i);
					}
					getModel().setHumidity(Float.parseFloat(humidity));
					
					//System.out.println("humidity :"+humidity);
				}
				else if (inputLine.startsWith("temperature thermistance interieur :")) {
					String interieur="";
					for(int i =36;i<inputLine.length();i++) {
						interieur +=inputLine.charAt(i);
					}
					getModel().getDataBase().addTime(Time.getTime(System.currentTimeMillis()));
					getModel().setTempInt(Float.parseFloat(interieur));
					//System.out.println("temperature thermistance interieur :"+interieur);
				}
				else if (inputLine.startsWith("temperature thermistance exterieur :")) {
					String exterieur="";
					for(int i =36;i<inputLine.length();i++) {
						exterieur +=inputLine.charAt(i);
					}
					getModel().setTempExt(Float.parseFloat(exterieur));
					//System.out.println("temperature thermistance exterieur :"+exterieur);
				}
				else if (inputLine.startsWith("temperature thermistance Peltier :")) {
					String peltier="";
					for(int i =34;i<inputLine.length();i++) {
						peltier +=inputLine.charAt(i);
					}
					getModel().setTempPeltier(Float.parseFloat(peltier));
					//System.out.println("temperature thermistance exterieur :"+exterieur);
				}
				 if (inputLine.startsWith("consigne :")) {
					String consigne="";
					for(int i =10;i<inputLine.length();i++) {
						consigne +=inputLine.charAt(i);
					}
					//getModel().setTempPeltier(Float.parseFloat(peltier));
					System.out.println("temperature thermistance consigne :"+consigne);
				 }
			} catch (Exception e) {
				//System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}
	
    public void writeData(int a)
    {
        try
        {
            output.write(a);
            output.flush();
            //System.out.println("a :"+a);
            }
        catch (Exception e)
        {
        }
    }
	
	public void start() {
		initialize();
//		Thread t = new Thread() {
//			public void run() {
//				//the following line will keep this app alive for 1000 seconds,
//				//waiting for events to occur and responding to them (printing incoming messages to console).
//				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
//			}
//		};
//		t.start();
//		System.out.println("Started");
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	

}