package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        this.indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", this.indexController.index());
        assertEquals("index", this.indexController.index(), "Wrong returned view name");
        assertEquals("index", this.indexController.index(), () -> "Expensive message Wrong returned view name");
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equalsIgnoreCase(this.indexController.oupsHandler()));
        assertTrue("notimplemented".equalsIgnoreCase(this.indexController.oupsHandler()), () -> "Expensive message in case of failure");
    }
}