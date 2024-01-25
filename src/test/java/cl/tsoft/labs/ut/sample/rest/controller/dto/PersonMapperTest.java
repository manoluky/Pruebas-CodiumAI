package cl.tsoft.labs.ut.sample.rest.controller.dto;

import cl.tsoft.labs.ut.sample.rest.entitie.Person;
import cl.tsoft.labs.ut.sample.rest.entitie.type.Rut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonMapperTest {

    // Mapping a Person object to a PersonDto object
    @Test
    public void test_mapping_person_to_personDto() {
        Person person = new Person();
        person.setName("John");
        person.setPaternalLastName("Doe");
        person.setMaternalLastName("Smith");
        person.setRut(null);

        PersonDto personDto = PersonMapper.INSTANCE.personToPersonDto(person);

        assertEquals("John Doe Smith", personDto.getFullName());
        assertNull(personDto.getRut());
    }
}