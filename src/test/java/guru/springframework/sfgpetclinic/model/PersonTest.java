package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        //Given
        Person p = new Person(1l, "Joe", "Buck");

        //Then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", p.getFirstName()),
                () -> assertEquals("Buck", p.getLastName())
                );
    }

    @Test
    void groupedAssertionsMsg() {
        //Given
        Person p = new Person(1l, "Joe", "Buck");

        //Then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", p.getFirstName(), "First Name failed"),
                () -> assertEquals("Buck", p.getLastName(), "Last Name Failed")
                );
    }
}