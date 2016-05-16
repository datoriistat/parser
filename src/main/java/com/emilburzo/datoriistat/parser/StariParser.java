package com.emilburzo.datoriistat.parser;

import com.emilburzo.datoriistat.pojo.Stare;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StariParser extends AbstractParser<Stare> {

    public StariParser(String rootPath, Connection conn) throws Exception {
        super(rootPath, conn);
    }

    @Override
    protected String getFolderName() {
        return "stari";
    }

    @Override
    protected String getPreparedStatement() {
        return "INSERT INTO stari (cod, denumire) VALUES (?, ?)";
    }

    @Override
    protected CSVFormat getCsvFormat() {
        return CSVFormat.newFormat('|');
    }

    @Override
    protected Stare getEntity(CSVRecord record) {
        String cod = record.get(0);
        String denumire = record.get(1);

        return new Stare(cod, denumire);
    }

    @Override
    protected void persist(Stare entity, PreparedStatement st) throws Exception {
        int i = 1;

        st.setInt(i++, entity.cod);
        st.setString(i++, entity.denumire);
    }
}
