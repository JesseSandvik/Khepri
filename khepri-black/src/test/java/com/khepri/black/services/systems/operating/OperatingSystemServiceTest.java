package com.khepri.black.services.systems.operating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatingSystemServiceTest {
    private OperatingSystemService operatingSystemService;

    @BeforeEach
    void initializeOperatingSystemService() {
        operatingSystemService = new OperatingSystemServiceImpl();
    }

    @Test
    void get_current_directory_returns_home_directory() {
        String expected = System.getProperty("user.home");
        String actual = operatingSystemService.getUserHomeDirectory();
        assertEquals(expected, actual);
    }
}
