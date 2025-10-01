package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MariaDbConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void mariaDbConnectionTest() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Database URL: " + connection.getMetaData().getURL());  //jdbc:mariadb://localhost/edu1?user=edu1&password=***
            assertThat(connection.isValid(2)).isTrue();  //연결이유효한지 2초 동안 동작을 확인해라.   assertThat(...).isTrue()는 테스트 어서션
        }
    }
}
