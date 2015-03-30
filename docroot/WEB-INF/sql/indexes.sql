create index IX_BECBE498 on CMTS_MONITOR_CableModem (dsPower);
create index IX_D70334CA on CMTS_MONITOR_CableModem (dsSNR);
create index IX_25CCE227 on CMTS_MONITOR_CableModem (fecCorrected);
create index IX_41EFF1A9 on CMTS_MONITOR_CableModem (fecUncorrectable);
create index IX_975743A9 on CMTS_MONITOR_CableModem (usPower);
create index IX_5A4D241B on CMTS_MONITOR_CableModem (usSNR);

create index IX_69221D84 on CMTS_MONITOR_Cmts (userId);

create unique index IX_280C4177 on CMTS_MONITOR_CustomerMacMapping (macAddress);
create index IX_5B1073D8 on CMTS_MONITOR_CustomerMacMapping (userId);

create index IX_B74EA8C0 on CMTS_MONITOR_UpstreamChannel (avgOnlineCmDsSNR);
create index IX_DD2E2577 on CMTS_MONITOR_UpstreamChannel (avgOnlineCmRxPower);
create index IX_5B70379 on CMTS_MONITOR_UpstreamChannel (avgOnlineCmTxPower);
create index IX_56D4770B on CMTS_MONITOR_UpstreamChannel (cmtsId);
create index IX_52399F0C on CMTS_MONITOR_UpstreamChannel (fecCorrected);
create index IX_BE39B40E on CMTS_MONITOR_UpstreamChannel (fecUncorrectable);
create index IX_376DC6F7 on CMTS_MONITOR_UpstreamChannel (ifSigQSNR);