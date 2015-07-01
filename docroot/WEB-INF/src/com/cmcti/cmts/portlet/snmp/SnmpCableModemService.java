package com.cmcti.cmts.portlet.snmp;

import com.cmcti.cmts.domain.model.CableModem;

public interface SnmpCableModemService {
	public CableModem getCableModem(String macAddress);
}
