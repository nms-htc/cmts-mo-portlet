package com.cmcti.cmts.portlet.snmp;

import com.cmcti.cmts.domain.model.UpstreamChannel;

public interface SnmpUpstreamChannelService {
	
	public UpstreamChannel getUpstreamChannel(long cmtsId, int ifIndex);
}
