package com.self.weatherdiary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherdiaryApplicationTests {

    @Test
    void equalTest() {
        assertEquals(1, 1);
    }

    @Test
    void nullTest() {
        assertNull(null);
    }

    @Test
    void tureTest() {
        assertTrue(1 == 1);
    }

}
