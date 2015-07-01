package com.cmcti.cmts.portlet.util;

import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpUtils {
	
	public static ResponseEvent get(String address, String community, OID[] oids) throws IOException {
		CommunityTarget target = new CommunityTarget();
		Address targetAddress = GenericAddress.parse(address);

		target.setAddress(targetAddress);
		target.setCommunity(new OctetString(community));
		target.setVersion(SnmpConstants.version2c);
		target.setRetries(2);
		target.setTimeout(2000);

		// prepare session
		TransportMapping transportMapping = new DefaultUdpTransportMapping();		
		Snmp snmp = new Snmp(transportMapping);
		transportMapping.listen();

		// prepare request
		PDU requestPDU = new PDU();
		for (OID oid : oids) {
			requestPDU.add(new VariableBinding(oid));
		}

		ResponseEvent responseEvent = snmp.get(requestPDU, target);

		snmp.close();

		return responseEvent;
	}
}
