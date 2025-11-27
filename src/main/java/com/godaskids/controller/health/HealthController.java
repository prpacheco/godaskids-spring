package com.godaskids.controller.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> status = new HashMap<>();
        status.put("application", "UP");

        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(2)) {
                status.put("database", "UP");
                return ResponseEntity.ok(status);
            } else {
                status.put("database", "DOWN");
                return ResponseEntity.status(500).body(status);
            }
        } catch (Exception e) {
            status.put("database", "ERROR");
            return ResponseEntity.status(500).body(status);
        }
    }

}
