DROP TABLE datorii;
DROP TABLE firme;
DROP TABLE stari;

CREATE TABLE firme (
  id         BIGSERIAL PRIMARY KEY,
  cif        BIGINT                 NOT NULL,
  denumire   TEXT                   NOT NULL,
  cod        CHARACTER VARYING(50)  NOT NULL,
  stari      CHARACTER VARYING(200) NOT NULL,
  judet      CHARACTER VARYING(50),
  localitate CHARACTER VARYING(50)
);

CREATE INDEX ON firme (cif);
CREATE INDEX ON firme ((lower(denumire)));

CREATE TABLE datorii (
  id          BIGSERIAL PRIMARY KEY,
  cif         BIGINT  NOT NULL UNIQUE,
  denumire    TEXT    NOT NULL,

  op_stat     INTEGER NOT NULL    DEFAULT 0,
  oa_stat     INTEGER NOT NULL    DEFAULT 0,
  oc_stat     INTEGER NOT NULL    DEFAULT 0,

  op_social   INTEGER NOT NULL    DEFAULT 0,
  oa_social   INTEGER NOT NULL    DEFAULT 0,
  oc_social   INTEGER NOT NULL    DEFAULT 0,

  op_somaj    INTEGER NOT NULL    DEFAULT 0,
  oa_somaj    INTEGER NOT NULL    DEFAULT 0,
  oc_somaj    INTEGER NOT NULL    DEFAULT 0,

  op_sanatate INTEGER NOT NULL    DEFAULT 0,
  oa_sanatate INTEGER NOT NULL    DEFAULT 0,
  oc_sanatate INTEGER NOT NULL    DEFAULT 0,

  total       BIGINT  NOT NULL    DEFAULT 0
);

CREATE INDEX ON datorii (cif);
CREATE INDEX ON datorii ((lower(denumire)));

CREATE TABLE stari (
  cod      INTEGER PRIMARY KEY,
  denumire TEXT NOT NULL
);
