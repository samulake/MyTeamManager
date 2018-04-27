CREATE TABLE PERSON (
    PERSON_KEY  NUMBER PRIMARY KEY,
    FIRST_NAME  VARCHAR2(64) NOT NULL,
    LAST_NAME   VARCHAR2(64),
    IS_USER     NUMBER(1,0) DEFAULT 0 NOT NULL
);

CREATE SEQUENCE SQ_PERSON_KEY
START WITH 1
INCREMENT BY 1;

CREATE TABLE CITY (
    CITY_KEY    INTEGER PRIMARY KEY,
    NAME        VARCHAR2(128) NOT NULL
);

CREATE SEQUENCE SQ_CITY_KEY
START WITH 1
INCREMENT BY 1;

CREATE TABLE PLACE (
    PLACE_KEY       INTEGER PRIMARY KEY,
    STREET_AND_NR   VARCHAR2(100) NOT NULL,
    CITY_KEY        INTEGER NOT NULL,

    CONSTRAINT FK_PLACE_CITY FOREIGN KEY (CITY_KEY) REFERENCES CITY
);

CREATE SEQUENCE SQ_PLACE_KEY
START WITH 1
INCREMENT BY 1;

CREATE TABLE MTM_USER (
    PERSON_KEY          NUMBER NOT NULL UNIQUE,
    USERNAME            VARCHAR2(32) NOT NULL UNIQUE,
    ENCODED_PASSWORD    VARCHAR(256) NOT NULL,

    CONSTRAINT FK_MTM_USER_PERSON FOREIGN KEY (PERSON_KEY) REFERENCES PERSON
);

CREATE TABLE TEAM (
    TEAM_KEY    NUMBER PRIMARY KEY,
    NAME        VARCHAR(128) UNIQUE,
    LEADER_KEY  NUMBER NULL,

    CONSTRAINT FK_TEAM_LEADER FOREIGN KEY (TEAM_KEY) REFERENCES PERSON (PERSON_KEY)
);

CREATE SEQUENCE SQ_TEAM_KEY
START WITH 1
INCREMENT BY 1;

CREATE TABLE TEAM_MEMBERS (
    TEAM_KEY NUMBER,
    PERSON_KEY NUMBER,

    CONSTRAINT FK_TEAM_MEMBERS_TEAM FOREIGN KEY (TEAM_KEY) REFERENCES TEAM,
    CONSTRAINT FK_TEAM_MEMBERS_PERSON FOREIGN KEY (PERSON_KEY) REFERENCES PERSON
);

CREATE TABLE MATCH (
    MATCH_KEY           NUMBER PRIMARY KEY,
    DATE_TIME           DATE,
    PLACE_KEY           NUMBER,
    HOME_TEAM_KEY       NUMBER,
    VISITOR_TEAM_KEY    NUMBER,
    RESULT              VARCHAR2(8),

    CONSTRAINT FK_MATCH_PLACE FOREIGN KEY (PLACE_KEY) REFERENCES PLACE,
    CONSTRAINT FK_MATCH_HOME_TEAM FOREIGN KEY (HOME_TEAM_KEY) REFERENCES TEAM,
    CONSTRAINT FK_MATCH_VISITOR_TEAM FOREIGN KEY (VISITOR_TEAM_KEY) REFERENCES TEAM,
    CONSTRAINT CK_DIFFERENT_TEAMS CHECK (HOME_TEAM_KEY != VISITOR_TEAM_KEY)
);

CREATE SEQUENCE SQ_MATCH_KEY
START WITH 1
INCREMENT BY 1;

CREATE TABLE TRENING (
    TRENING_KEY     NUMBER PRIMARY KEY,
    DATE_TIME       DATE,
    PLACE_KEY       NUMBER,
    TEAM_KEY        NUMBER,

    CONSTRAINT FK_TRENING_PLACE FOREIGN KEY (PLACE_KEY) REFERENCES PLACE,
    CONSTRAINT FK_TRENING_TEAM FOREIGN KEY (TEAM_KEY) REFERENCES TEAM
);

CREATE SEQUENCE SQ_TRENING_KEY
START WITH 1
INCREMENT BY 1;

