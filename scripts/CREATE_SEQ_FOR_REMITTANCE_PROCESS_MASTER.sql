DECLARE
  MAX_ID NUMBER;
BEGIN
  SELECT (MAX(ID)+1) INTO MAX_ID FROM REMITTANCE_PROCESS_MASTER;     
  EXECUTE IMMEDIATE 'CREATE SEQUENCE REMITTANCE_PROCESS_MASTER_SEQ MINVALUE '|| MAX_ID ||'MAXVALUE 99999999999 START
    WITH '|| MAX_ID ||' INCREMENT BY 1 CACHE 500 CYCLE ORDER';
END;