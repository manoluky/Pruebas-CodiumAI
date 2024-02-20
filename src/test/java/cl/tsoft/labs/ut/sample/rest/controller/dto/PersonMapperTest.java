package cl.tsoft.labs.ut.sample.rest.controller.dto;

import cl.tsoft.labs.ut.sample.rest.entitie.Person;
import cl.tsoft.labs.ut.sample.rest.entitie.type.Rut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    @Test
    public void test_mapping_from_person_to_persondto() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        person.setRut(new Rut(12345678, 'K'));
        person.setName("John");
        person.setPaternalLastName("Doe");
        person.setMaternalLastName("Smith");
        person.setBirthDate(LocalDate.of(1990, 1, 1));
        person.setHomeAddress("123 Main St");
        person.setCellPhone("555-1234");
        person.setMail("john.doe@example.com");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertEquals(person.getId(), personDto.getId());
        assertEquals(person.getRut().toString(), personDto.getRut());
        assertEquals(person.getName() + " " + person.getPaternalLastName() + " " + person.getMaternalLastName(), personDto.getFullName());
        assertEquals(person.getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE), personDto.getBirthDate());
        assertEquals(person.getHomeAddress(), personDto.getHomeAddress());
        assertEquals(person.getCellPhone(), personDto.getCellPhone());
        assertEquals(person.getMail(), personDto.getMail());
    }

    @Test
    public void test_mapping_id_field() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        person.setRut(new Rut(12345678, 'K'));
        person.setName("John");
        person.setPaternalLastName("Doe");
        person.setMaternalLastName("Smith");
        person.setBirthDate(LocalDate.of(1990, 1, 1));
        person.setHomeAddress("123 Main St");
        person.setCellPhone("555-1234");
        person.setMail("john.doe@example.com");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertEquals(person.getId(), personDto.getId());
    }
    @Test
    public void test_null_person_to_persondto() {
        // Arrange
        Person person = null;

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertNull(personDto);
    }
    @Test
    public void test_null_rut_field() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        person.setRut(null);
        person.setName("John");
        person.setPaternalLastName("Doe");
        person.setMaternalLastName("Smith");
        person.setBirthDate(LocalDate.of(1990, 1, 1));
        person.setHomeAddress("123 Main St");
        person.setCellPhone("555-1234");
        person.setMail("john.doe@example.com");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertNull(personDto.getRut());
    }
    @Test
    public void test_null_birthdate_field() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        person.setRut(new Rut(12345678, 'K'));
        person.setName("John");
        person.setPaternalLastName("Doe");
        person.setMaternalLastName("Smith");
        person.setBirthDate(null);
        person.setHomeAddress("123 Main St");
        person.setCellPhone("555-1234");
        person.setMail("john.doe@example.com");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertNull(personDto.getBirthDate());
    }

    @Test
    public void test_mapping_from_person_to_persondto_returns_non_null_persondto_with_correct_values() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        person.setRut(new Rut(12345678, 'K'));
        person.setName("John");
        person.setPaternalLastName("Doe");
        person.setMaternalLastName("Smith");
        person.setBirthDate(LocalDate.of(1990, 1, 1));
        person.setHomeAddress("123 Main St");
        person.setCellPhone("555-1234");
        person.setMail("john.doe@example.com");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertNotNull(personDto);
        assertEquals(person.getId(), personDto.getId());
        assertEquals(person.getRut().toString(), personDto.getRut());
        assertEquals(person.getName() + " " + person.getPaternalLastName() + " " + person.getMaternalLastName(), personDto.getFullName());
        assertEquals(person.getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE), personDto.getBirthDate());
        assertEquals(person.getHomeAddress(), personDto.getHomeAddress());
        assertEquals(person.getCellPhone(), personDto.getCellPhone());
        assertEquals(person.getMail(), personDto.getMail());
    }
    @Test
    public void test_mapping_from_person_to_persondto_handles_null_person_object() {
        // Arrange
        Person person = null;
        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertNull(personDto);
    }
    @Test
    public void test_personDtoToPerson() {
        // Arrange
        PersonDto personDto = new PersonDto();
        personDto.setId(1L);
        personDto.setRut("12345678-K");
        personDto.setFullName("John Doe Smith");
        personDto.setBirthDate("1990-01-01");
        personDto.setHomeAddress("123 Main St");
        personDto.setCellPhone("555-1234");
        personDto.setMail("john.doe@example.com");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        Person person = mapper.personDtoToPerson(personDto);

        // Assert
        assertEquals(personDto.getId(), person.getId());
        assertEquals(personDto.getRut(), person.getRut().toString());
        assertEquals(personDto.getFullName(), person.getName() + " " + person.getPaternalLastName() + " " + person.getMaternalLastName());
        assertEquals(LocalDate.parse(personDto.getBirthDate()), person.getBirthDate());
        assertEquals(personDto.getHomeAddress(), person.getHomeAddress());
        assertEquals(personDto.getCellPhone(), person.getCellPhone());
        assertEquals(personDto.getMail(), person.getMail());
    }
}
