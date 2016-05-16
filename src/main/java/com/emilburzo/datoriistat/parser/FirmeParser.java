package com.emilburzo.datoriistat.parser;

import com.emilburzo.datoriistat.pojo.Firma;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FirmeParser extends AbstractParser<Firma> {

    public FirmeParser(String rootPath, Connection conn) throws Exception {
        super(rootPath, conn);
    }

    @Override
    protected String getFolderName() {
        return "firme";
    }

    @Override
    protected String getPreparedStatement() {
        return "INSERT INTO firme (cif, denumire, cod, stari, judet, localitate) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected CSVFormat getCsvFormat() {
        return CSVFormat.newFormat('|').withFirstRecordAsHeader();
    }

    @Override
    protected Firma getEntity(CSVRecord record) {
        String denumire = record.get("\uFEFFDENUMIRE");
        String cif = record.get("CUI");
        String cod = record.get("COD_INMATRICULARE");
        String stari = record.get("STARE_FIRMA");
        String judet = record.get("JUDET");

        String localitate = null;
        if (record.isMapped("LOCALITATE")) {
            localitate = record.get("LOCALITATE");
        }

        return new Firma(denumire, cif, cod, stari, judet, localitate);
    }

    @Override
    protected void persist(Firma entity, PreparedStatement st) throws Exception {
        int i = 1;
        st.setLong(i++, entity.cif);
        st.setString(i++, entity.denumire);
        st.setString(i++, entity.cod);
        st.setString(i++, entity.stari);
        st.setString(i++, entity.judet);
        st.setString(i++, entity.localitate);
    }
}
