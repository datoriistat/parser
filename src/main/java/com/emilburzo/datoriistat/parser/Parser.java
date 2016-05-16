package com.emilburzo.datoriistat.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class Parser {

    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    private String ROOT_PATH = "/home/eaglex/devel/oss/datoriistat/parser/date/";

    private Connection conn;

    public Parser() throws Exception {
        initJdbc();

        new StariParser(ROOT_PATH, conn);

        new FirmeParser(ROOT_PATH, conn);

        new DatoriiParser(ROOT_PATH, conn);
    }

    private void initJdbc() throws Exception {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://datoriistat/datoriistat";
        Properties props = new Properties();
        props.setProperty("user", "datoriistat");
        props.setProperty("password", "secret");
        props.setProperty("ssl", "true");
        props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");

        conn = DriverManager.getConnection(url, props);
    }

}
