create index IX_9DA6E090 on CMTS_CMHis (cmtsId);
create index IX_4EF55391 on CMTS_CMHis (macAddress);

create index IX_87C9ABDD on CMTS_CableModem (dsPower);
create index IX_94E4094F on CMTS_CableModem (dsSNR);
create index IX_7D11DE02 on CMTS_CableModem (fecCorrected);
create index IX_344D8804 on CMTS_CableModem (fecUncorrectable);
create index IX_60550AEE on CMTS_CableModem (usPower);
create index IX_182DF8A0 on CMTS_CableModem (usSNR);

create index IX_93F5C9DF on CMTS_Cmts (userId);

create unique index IX_CCEBE457 on CMTS_CusMacMap (macAddress);
create index IX_7F486B8 on CMTS_CusMacMap (userId);

create unique index IX_F95DAD12 on CMTS_CustomerMacMapping (macAddress);
create index IX_F505E4F3 on CMTS_CustomerMacMapping (userId);

create index IX_1C6A78EC on CMTS_UCHis (cmtsId);
create index IX_29A0EB11 on CMTS_UCHis (ifIndex);

create index IX_4947D345 on CMTS_UpstreamChannel (avgOnlineCmDsSNR);
create index IX_D586C2BC on CMTS_UpstreamChannel (avgOnlineCmRxPower);
create index IX_FE0FA0BE on CMTS_UpstreamChannel (avgOnlineCmTxPower);
create index IX_516313D0 on CMTS_UpstreamChannel (cmtsId);
create index IX_AB8ED411 on CMTS_UpstreamChannel (fecCorrected);
create index IX_5032DE93 on CMTS_UpstreamChannel (fecUncorrectable);
create index IX_D1633812 on CMTS_UpstreamChannel (ifSigQSNR);

create index IX_9F29EF33 on CableModem (dsPower);
create index IX_21092A25 on CableModem (dsSNR);
create index IX_E924406C on CableModem (fecCorrected);
create index IX_B234A56E on CableModem (fecUncorrectable);
create index IX_77B54E44 on CableModem (usPower);
create index IX_A4531976 on CableModem (usSNR);

create index IX_3A0DECA3 on CableModemHis (cmtsId);
create index IX_A021E24 on CableModemHis (macAddress);

create index IX_777331A5 on CableModemHistory (cmtsId);
create index IX_D9591226 on CableModemHistory (macAddress);

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

create index IX_E3EEF308 on UpstreamChannelHis (cmtsId);
create index IX_52ABB475 on UpstreamChannelHis (ifIndex);

create index IX_A2F07D8A on UpstreamChannelHistory (cmtsId);
create index IX_73DB7A33 on UpstreamChannelHistory (ifIndex);