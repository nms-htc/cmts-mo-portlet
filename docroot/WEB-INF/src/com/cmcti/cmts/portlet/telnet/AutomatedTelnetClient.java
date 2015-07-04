package com.cmcti.cmts.portlet.telnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Serializable;

import org.apache.commons.net.telnet.TelnetClient;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;

public class AutomatedTelnetClient implements Serializable {

	private static final long serialVersionUID = 2372962404524691356L;
	private static final Logger logger = LoggerFactory.getLogger(AutomatedTelnetClient.class);
	
	private final TelnetClient telnet = new TelnetClient();
    private final InputStream in;
    private final PrintStream out;
    private final String prompt = ">";

    public AutomatedTelnetClient(String server, String user, String password) throws Exception {
        // Connect to the specified server
        telnet.connect(server, 23);

        // Get input and output stream references
        in = telnet.getInputStream();
        out = new PrintStream(telnet.getOutputStream());

        // Log the user on
        readUntil("Username: ");
        write(user);
        readUntil("Password: ");
        write(password);

        // Advance to a prompt
        readUntil(prompt);
    }

    public String readUntil(String pattern) throws IOException {
        char lastChar = pattern.charAt(pattern.length() - 1);
        StringBuilder sb = new StringBuilder();
        char ch = (char) in.read();
        while (true) {
            sb.append(ch);
            if (sb.toString().endsWith("Closing connection")) {
                throw new TelnetTerminalException("wrong-telnet-arguments-passed");
            }
            if (sb.toString().endsWith(prompt) && !pattern.equals(prompt)) {
                return sb.toString();
            }
            if (ch == lastChar) {
                if (sb.toString().endsWith(pattern)) {
                    return sb.toString();
                }
            }
            ch = (char) in.read();
        }
    }

    public void write(String value) {
        out.println(value);
        out.flush();
    }

    public String sendCommand(String command) {
        write(command);
        try {
			return readUntil(prompt);
		} catch (Exception e) {
			logger.error("AutomatedTelnetClient::sendCommand(), Error: {0}", e.getMessage());
    		throw new TelnetTerminalException("error-read-output-after-send-command-to-server");
		}
    }

    public void disconnect() {
    	try {
    		telnet.disconnect();
    	} catch (IOException e) {
    		logger.error("Error when disconnect AutomatedTelnetClient, Error: {0}", e.getMessage());
    		throw new TelnetTerminalException("error-when-disconnect-client");
    	}
    }

}
