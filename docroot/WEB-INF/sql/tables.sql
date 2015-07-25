create table CMTS_CMHis (
	cmHisId LONG not null primary key,
	macAddress VARCHAR(75) null,
	createDate DATE null,
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

create table CMTS_CableModem (
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
	status INTEGER,
	exist BOOLEAN
);

create table CMTS_Cmts (
	cmtsId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	host VARCHAR(75) null,
	community VARCHAR(75) null,
	description VARCHAR(75) null,
	enable BOOLEAN
);

create table CMTS_CusMacMap (
	customerMacId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	macAddress VARCHAR(75) null
);

create table CMTS_Merchant (
	merchantId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	code_ VARCHAR(75) null,
	parentId LONG,
	parentCode VARCHAR(75) null,
	description VARCHAR(75) null
);

create table CMTS_MerchantScope (
	merchantScopeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	cmtsId LONG,
	ifIndex INTEGER,
	merchantCode VARCHAR(75) null
);

create table CMTS_Option (
	optionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	optionType VARCHAR(75) null,
	optionKey VARCHAR(75) null,
	optionValue VARCHAR(75) null,
	description VARCHAR(75) null
);

create table CMTS_UCHis (
	ucHisId LONG not null primary key,
	cmtsId LONG,
	ifIndex INTEGER,
	createDate DATE null,
	qam VARCHAR(75) null,
	avgOnlineCmDsPower DOUBLE,
	avgOnlineCmUsPower DOUBLE,
	avgOnlineCmMicRef DOUBLE,
	avgOnlineCmDsSNR DOUBLE,
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
	ifDesc VARCHAR(75) null
);

create table CMTS_UpChannelMetadata (
	metaId LONG not null primary key,
	cmtsId LONG,
	ifIndex INTEGER,
	dsFrequency VARCHAR(75) null,
	dsQam VARCHAR(75) null
);

create table CMTS_UpstreamChannel (
	ifIndex INTEGER not null,
	cmtsId LONG not null,
	createDate DATE null,
	modifiedDate DATE null,
	qam VARCHAR(75) null,
	avgOnlineCmDsPower DOUBLE,
	avgOnlineCmUsPower DOUBLE,
	avgOnlineCmMicRef DOUBLE,
	avgOnlineCmDsSNR DOUBLE,
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
	exist BOOLEAN,
	primary key (ifIndex, cmtsId)
);