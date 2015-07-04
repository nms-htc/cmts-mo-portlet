package com.cmcti.cmts.portlet.telnet;

public class TelnetTerminalException extends RuntimeException {

	private static final long serialVersionUID = 7347805555654540780L;

	public TelnetTerminalException() {
		super();
	}

	public TelnetTerminalException(String msg) {
		super(msg);
	}
	
	public TelnetTerminalException(Throwable t) {
		super(t);
	}
	
	public TelnetTerminalException(String msg, Throwable t) {
		super(msg, t);
	}

}
