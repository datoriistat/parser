package com.emilburzo.datoriistat.parser;

import com.emilburzo.datoriistat.pojo.Datorie;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatoriiParser extends AbstractParser<Datorie> {

    public DatoriiParser(String rootPath, Connection conn) throws Exception {
        super(rootPath, conn);
    }

    @Override
    protected String getFolderName() {
        return "datorii";
    }

    @Override
    protected String getPreparedStatement() {
        return "INSERT INTO datorii (cif, denumire, op_stat, oa_stat, oc_stat, op_social, oa_social, oc_social, op_somaj, oa_somaj, oc_somaj, op_sanatate, oa_sanatate, oc_sanatate, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected CSVFormat getCsvFormat() {
        return CSVFormat.TDF.withFirstRecordAsHeader();
    }

    @Override
    protected Datorie getEntity(CSVRecord record) {
        String cif = record.get("cod identificare fiscala");
        String denumire = record.get("denumire");

        String op_stat = record.get("obligatii principale la bugetul de stat");
        String oa_stat = record.get("obligatii accesorii la bugetul de stat");
        String oc_stat = record.get("obligatii contestate la bugetul de stat");

        String op_social = record.get("obligatii principale la bugetul asigurarilor sociale");
        String oa_social = record.get("obligatii accesorii la bugetul asigurarilor sociale");
        String oc_social = record.get("obligatii contesate la bugetul asigurarilor sociale");

        String op_somaj = record.get("obligatii principale la bugetul asigurarilor de somaj");
        String oa_somaj = record.get("obligatii accesorii la bugetul asigurarilor de somaj");
        String oc_somaj = record.get("obligatii contestate la bugetul asigurarilor de somaj");

        String op_sanatate = record.get("obligatii principale la bugetul de sanatate");
        String oa_sanatate = record.get("obligatii accesorii la bugetul de sanatate");
        String oc_sanatate = record.get("obligatii contestate la bugetul de sanatate");

        return new Datorie(cif, denumire, op_stat, oa_stat, oc_stat, op_social, oa_social, oc_social, op_somaj, oa_somaj, oc_somaj, op_sanatate, oa_sanatate, oc_sanatate);
    }

    @Override
    protected void persist(Datorie entity, PreparedStatement st) throws Exception {
        int i = 1;
        st.setLong(i++, entity.cif);
        st.setString(i++, entity.denumire);

        st.setInt(i++, entity.op_stat);
        st.setInt(i++, entity.oa_stat);
        st.setInt(i++, entity.oc_stat);

        st.setInt(i++, entity.op_social);
        st.setInt(i++, entity.oa_social);
        st.setInt(i++, entity.oc_social);

        st.setInt(i++, entity.op_somaj);
        st.setInt(i++, entity.oa_somaj);
        st.setInt(i++, entity.oc_somaj);

        st.setInt(i++, entity.op_sanatate);
        st.setInt(i++, entity.oa_sanatate);
        st.setInt(i++, entity.oc_sanatate);

        st.setLong(i++, entity.total);
    }
}
