package com.emilburzo.datoriistat.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class AbstractParser<T> {

    private final String rootPath;
    private final Connection conn;

    private PreparedStatement st;

    public AbstractParser(String rootPath, Connection conn) throws Exception {
        this.rootPath = rootPath;
        this.conn = conn;

        System.out.println(getFolderName());

        st = conn.prepareStatement(getPreparedStatement());

        for (File file : getFiles()) {
            parse(file);
        }

        st.executeBatch();
        st.close();
    }

    protected void parse(File file) throws Exception {
        Reader in = new FileReader(file);

        Iterable<CSVRecord> records = getCsvFormat().parse(in);

        for (CSVRecord record : records) {
            T entity = getEntity(record);

            persist(entity, getSt());

            st.addBatch();
        }
    }

    public File[] getFiles() {
        File dir = new File(rootPath + getFolderName() + File.separator);

        File[] files = dir.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".csv");
            }
        });

        return files;
    }

    public PreparedStatement getSt() {
        return st;
    }

    protected abstract String getFolderName();

    protected abstract String getPreparedStatement();

    protected abstract CSVFormat getCsvFormat();

    protected abstract T getEntity(CSVRecord record);

    protected abstract void persist(T entity, PreparedStatement st) throws Exception;
}
