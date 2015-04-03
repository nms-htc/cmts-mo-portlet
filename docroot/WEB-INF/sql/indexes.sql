create index IX_9F29EF33 on CableModem (dsPower);
create index IX_21092A25 on CableModem (dsSNR);
create index IX_E924406C on CableModem (fecCorrected);
create index IX_B234A56E on CableModem (fecUncorrectable);
create index IX_77B54E44 on CableModem (usPower);
create index IX_A4531976 on CableModem (usSNR);

create index IX_AE08FB49 on Cmts (userId);

create unique index IX_99F317FC on CustomerMacMapping (macAddress);
create index IX_A60954DD on CustomerMacMapping (userId);

create index IX_952C881B on UpstreamChannel (avgOnlineCmDsSNR);
create index IX_BB119A12 on UpstreamChannel (avgOnlineCmRxPower);
create index IX_E39A7814 on UpstreamChannel (avgOnlineCmTxPower);
create index IX_6DA5BC26 on UpstreamChannel (cmtsId);
create index IX_EA8B63E7 on UpstreamChannel (fecCorrected);
create index IX_9C179369 on UpstreamChannel (fecUncorrectable);
create index IX_8266A7FC on UpstreamChannel (ifSigQSNR);