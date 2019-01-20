package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Tests",
                () -> assertAll("Person properties",
                        ()-> assertEquals("Joe", owner.getFirstName(), "First Name did not match"),
                        ()-> assertEquals("Buck", owner.getLastName(), "Last Name did not match")
                ),
                () -> assertAll("Owner properties",
                        ()-> assertEquals("Key West", owner.getCity(), "City did not match"),
                        ()-> assertEquals("1231231234", owner.getTelephone(), "Telephone did not match")
                )
                );
    }
}