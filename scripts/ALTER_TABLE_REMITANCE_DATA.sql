ALTER TABLE remittance_data ADD SENDER_ID_TYPE VARCHAR2(32);
ALTER TABLE remittance_data ADD SENDER_GENDER VARCHAR2(16);
ALTER TABLE remittance_data ADD RECEIVER_GENDER VARCHAR2(16);
ALTER TABLE remittance_data ADD SENDER_OCCUPATION VARCHAR2(64);
ALTER TABLE remittance_data ADD RECEIVER_OCCUPATION VARCHAR2(64);

ALTER TABLE remittance_data MODIFY RECEIVER_ADDRESS VARCHAR2(255);
ALTER TABLE remittance_data MODIFY SENDER_ID_TYPE VARCHAR2(55);
ALTER TABLE remittance_data MODIFY SENDER_NAME VARCHAR2(255);