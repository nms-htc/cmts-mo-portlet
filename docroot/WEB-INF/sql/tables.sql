create table CMTS_MONITOR_CableModem (
	macAddress VARCHAR(75) not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	fecUncorrectable DOUBLE,
	fecCorrected DOUBLE,
	microRef LONG,
	rxPower INTEGER,
	txPower INTEGER,
	usPower INTEGER,
	dsPower INTEGER,
	uncorrectables LONG,
	correcteds LONG,
	unerroreds LONG,
	dsSNR INTEGER,
	usSNR INTEGER,
	ucIfIndex INTEGER,
	dcIfIndex INTEGER,
	cmSubIndex VARCHAR(75) null,
	cmtsId LONG,
	cmIndex INTEGER,
	status INTEGER
);

create table CMTS_MONITOR_CableModemHistory (
	macAddress VARCHAR(75) not null,
	createDate DATE not null,
	fecUncorrectable DOUBLE,
	fecCorrected DOUBLE,
	microRef LONG,
	rxPower INTEGER,
	txPower INTEGER,
	usPower INTEGER,
	dsPower INTEGER,
	uncorrectables LONG,
	correcteds LONG,
	unerroreds LONG,
	dsSNR INTEGER,
	usSNR INTEGER,
	ucIfIndex INTEGER,
	dcIfIndex INTEGER,
	cmSubIndex VARCHAR(75) null,
	cmtsId LONG,
	cmIndex INTEGER,
	status INTEGER,
	primary key (macAddress, createDate)
);

create table CMTS_MONITOR_Cmts (
	cmtsId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	enable BOOLEAN,
	title VARCHAR(75) null,
	host VARCHAR(75) null,
	community VARCHAR(75) null,
	description VARCHAR(75) null
);

create table CMTS_MONITOR_CustomerMacMapping (
	customerMacId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	macAddress VARCHAR(75) null
);

create table CMTS_MONITOR_UpstreamChannel (
	ifIndex INTEGER not null,
	cmtsId LONG not null,
	createDate DATE null,
	modifiedDate DATE null,
	qam VARCHAR(75) null,
	avgOnlineCmDsPower DOUBLE,
	avgOnlineCmUsPower DOUBLE,
	avgOnlineCmMicRef DOUBLE,
	avgOnlineCmTxPower DOUBLE,
	avgOnlineCmRxPower DOUBLE,
	fecUncorrectable DOUBLE,
	fecCorrected DOUBLE,
	upChannelCmTotal INTEGER,
	upChannelCmRegistered INTEGER,
	upChannelCmActive INTEGER,
	upChannelModProfile INTEGER,
	upChannelWidth LONG,
	upChannelFrequency LONG,
	ifSigQUncorrectables LONG,
	ifSigQCorrecteds LONG,
	ifSigQUnerroreds LONG,
	ifSigQSNR DOUBLE,
	ifAlias VARCHAR(75) null,
	ifDesc VARCHAR(75) null,
	primary key (ifIndex, cmtsId)
);

create table CMTS_MONITOR_UpstreamChannelHistory (
	cmtsId LONG not null,
	ifIndex INTEGER not null,
	createDate DATE not null,
	qam VARCHAR(75) null,
	avgOnlineCmDsPower DOUBLE,
	avgOnlineCmUsPower DOUBLE,
	avgOnlineCmMicRef DOUBLE,
	avgOnlineCmTxPower DOUBLE,
	avgOnlineCmRxPower DOUBLE,
	fecUncorrectable DOUBLE,
	fecCorrected DOUBLE,
	upChannelCmTotal INTEGER,
	upChannelCmRegistered INTEGER,
	upChannelCmActive INTEGER,
	upChannelModProfile INTEGER,
	upChannelWidth LONG,
	upChannelFrequency LONG,
	ifSigQUncorrectables LONG,
	ifSigQCorrecteds LONG,
	ifSigQUnerroreds LONG,
	ifSigQSNR DOUBLE,
	ifAlias VARCHAR(75) null,
	ifDesc VARCHAR(75) null,
	primary key (cmtsId, ifIndex, createDate)
);