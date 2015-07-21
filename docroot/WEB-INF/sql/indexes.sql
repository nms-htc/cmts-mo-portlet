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

create index IX_B591D47E on CMTS_Merchant (code_);
create index IX_2079B57E on CMTS_Merchant (userId);

create index IX_EEA81014 on CMTS_MerchantScope (cmtsId);
create index IX_C0EC3211 on CMTS_MerchantScope (cmtsId, ifIndex);
create index IX_EEE76DC5 on CMTS_MerchantScope (merchantCode);
create index IX_860E1DA8 on CMTS_MerchantScope (merchantCode, cmtsId, ifIndex);
create index IX_603BD276 on CMTS_MerchantScope (userId);

create index IX_EE22FC09 on CMTS_Option (optionKey);
create index IX_E6AEC0B4 on CMTS_Option (optionType);
create index IX_4AD039A6 on CMTS_Option (optionType, optionKey);
create index IX_2A76356B on CMTS_Option (userId);

create index IX_1C6A78EC on CMTS_UCHis (cmtsId);
create index IX_29A0EB11 on CMTS_UCHis (ifIndex);

create index IX_1DB5811F on CMTS_UpChannelMetadata (cmtsId);
create index IX_1A95BD66 on CMTS_UpChannelMetadata (cmtsId, ifIndex);

create index IX_4947D345 on CMTS_UpstreamChannel (avgOnlineCmDsSNR);
create index IX_D586C2BC on CMTS_UpstreamChannel (avgOnlineCmRxPower);
create index IX_FE0FA0BE on CMTS_UpstreamChannel (avgOnlineCmTxPower);
create index IX_516313D0 on CMTS_UpstreamChannel (cmtsId);
create index IX_AB8ED411 on CMTS_UpstreamChannel (fecCorrected);
create index IX_5032DE93 on CMTS_UpstreamChannel (fecUncorrectable);
create index IX_D1633812 on CMTS_UpstreamChannel (ifSigQSNR);