package com.Xswinger.uazService.db;

import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
public class Init {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String mainPath = "src/main/resources/db/";
    private final String[] initFileNames = {"model"};
    private final String[] dropFileNames = {"drop"};
    private final String[] insertFileNames = {"insert"};

    @PostConstruct
    public void run() {
        String query;

        for (int i = 0; i < insertFileNames.length; i++) {
            try {
                query = new String(Files.readAllBytes(Paths.get(mainPath + insertFileNames[i] + ".sql")));
                jdbcTemplate.execute(query);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
