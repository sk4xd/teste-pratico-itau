CREATE TABLE TABELA_SALDOS
(
    id IDENTITY NOT NULL PRIMARY KEY ,
    conta DECIMAL NOT NULL ,
    saldo DECIMAL
);

CREATE TABLE TRANSACOES
(
    id IDENTITY NOT NULL PRIMARY KEY,
    correlation_id VARCHAR NOT NULL ,
    datetime TIMESTAMP WITH TIME ZONE NOT NULL ,
    conta_origem DECIMAL NOT NULL ,
    conta_destino DECIMAL NOT NULL ,
    valor DECIMAL NOT NULL
);

INSERT INTO TABELA_SALDOS (conta, saldo) VALUES (938485762, 180), (347586970, 1200), (2147483649, 0), (675869708, 4900), (238596054, 478), (573659065, 787), (210385733, 10), (674038564, 400), (563856300, 1200);