package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        this.indexController = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", this.indexController.index());
        assertEquals("index", this.indexController.index(), "Wrong returned view name");
        assertEquals("index", this.indexController.index(), () -> "Expensive message Wrong returned view name");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {

        assertThrows(ValueNotFoundException.class, () -> this.indexController.oupsHandler());

        /*
        assertTrue("notimplemented".equalsIgnoreCase(this.indexController.oupsHandler()));
        assertTrue("notimplemented".equalsIgnoreCase(this.indexController.oupsHandler()), () -> "Expensive message in case of failure");
        */
    }
}