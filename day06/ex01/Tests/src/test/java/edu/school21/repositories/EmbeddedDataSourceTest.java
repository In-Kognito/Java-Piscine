package edu.school21.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;

public class EmbeddedDataSourceTest {

    private EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    private EmbeddedDatabase db;

    @BeforeEach
    void init() {
        db = builder.setType(EmbeddedDatabaseType.HSQL).addScript("schema.sql").addScript("data.sql").build();
    }

    @Test
    void getConnection() throws SQLException {
        Assertions.assertNotNull(db.getConnection());
    }
    
}
