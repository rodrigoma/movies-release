package com.rodrigoma.moviesrelease;

import org.junit.jupiter.api.Test;

import static com.rodrigoma.moviesrelease.domain.Stores.getColorBy;
import static org.junit.jupiter.api.Assertions.*;

class StoresTest {

    @Test
    void getColors() {
        assertEquals("orange", getColorBy("AMAZON"));
        assertEquals("red", getColorBy("CLASSICLINE"));
        assertEquals("gray", getColorBy("FAMDVD"));
        assertEquals("yellow", getColorBy("OBRASPRIMAS"));
        assertEquals("blue", getColorBy("THEORIGINALS"));
        assertEquals("gold", getColorBy("VERSATIL"));
        assertEquals("green", getColorBy("TODOS"));
    }
}