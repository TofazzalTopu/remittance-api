CREATE TABLE REM_EXC_HOUSE_PROP(
EXCHANGE_CODE VARCHAR2(20) NOT NULL,
KEY_LABEL VARCHAR2(32) NOT NULL,
KEY_VALUE VARCHAR2(500) NOT NULL,
primary key (EXCHANGE_CODE,KEY_LABEL)
);

/*
insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'ria-ApiVersion', 'v1');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'BEAN', 'RiaFinancialService');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'DOWNLOADABLE_RIA', 'https://stagingapi.rialink.net/PayOrders/Orders/Downloadable');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'search_url', 'https://stagingapi.rialink.net/PayOrders/Order/CashPickUp');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'payment_url', 'https://stagingapi.rialink.net/PayOrders/Order/CashPickUp/Payment');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'ria-AgentId', '7942014');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'Ocp-Apim-Subscription-Key', '8bd2eb77a0664b9b846272e55d4d9ef2');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'cashpickup_cancel_url', 'https://stagingapi.rialink.net/PayOrders/Order/CashPickUp/Payment');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'NOTIFY_REM_STATUS_RIA', 'https://stagingapi.rialink.net/PayOrders/Orders/Downloadable/Status');

insert into REM_EXC_HOUSE_PROP (EXCHANGE_CODE, KEY_LABEL, KEY_VALUE)
values ('1452070046', 'CANCEL_REQ_RIA', 'https://stagingapi.rialink.net/PayOrders/Orders/CancellationRequests');

commit;



*/