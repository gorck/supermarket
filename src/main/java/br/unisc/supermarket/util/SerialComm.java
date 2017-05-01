package br.unisc.supermarket.util;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 * This program uses the RxTx library: http://rxtx.qbang.org/ Installed plugin:
 * http://rxtx.qbang.org/eclipse/ (it might also work without the plugin)
 *
 * In a Java Project: copy C:\Program Files
 * (x86)\Eclipse\plugins\gnu.io.rxtx.win32.x86_2.1.7.3_v20071015\os\win32\x86\*
 * to the root of Eclipse-project and add the jar-file to the project:
 * C:\Program Files (x86)\Eclipse\plugins\gnu.io.rxtx_2.1.7.4_v20071016.jar via
 * Project > Properties, Add External JAR
 *
 * http://electronics.stackexchange.com/questions/38503/issue-on-serial-port-
 * communication-in-java
 *
 * TROUBLESHOOTING If you get an error (eg. PortInUseException), try right-click
 * in Console > Terminate/Disconnect all
 *
 * @author Fjodor van Slooten
 */
public class SerialComm implements SerialPortEventListener {

    SerialPort serialPort;

    /**
     * The port we're normally going to use.
     */
    private static final String PORT = "COM5";
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    public void initialize() {

        // the next line is for Raspberry Pi and
        // gets us into the while loop and was suggested here was suggested
        // http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        // System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
        System.setProperty("gnu.io.rxtx.SerialPorts", PORT);

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        // First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum
                    .nextElement();
            if (currPortId.getName().equals(PORT)) {
                portId = currPortId;
                break;
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(
                    serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     *
     * @param oEvent
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                if (inputLine.startsWith("UUID:")) {

                    System.out.println("TAG ID:" + inputLine.substring(6, 16));
                }
                System.out.println(inputLine);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

}
