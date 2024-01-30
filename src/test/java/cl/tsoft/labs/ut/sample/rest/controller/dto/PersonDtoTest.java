package cl.tsoft.labs.ut.sample.rest.controller.dto;

// Generated by CodiumAI
import cl.tsoft.labs.ut.sample.rest.entitie.Person;
import cl.tsoft.labs.ut.sample.rest.entitie.type.Rut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class PersonDtoTest {



// Generated by CodiumAI


        // Create a PersonDto with all fields correctly set and check if all fields are correctly set
        @Test
        public void test_create_personDto_with_all_fields_correctly_set() {
            PersonDto personDto = PersonDto.builder()
                    .id(1L)
                    .rut("12345678-9")
                    .fullName("John Doe")
                    .birthDate("1990-01-01")
                    .homeAddress("123 Main St")
                    .cellPhone("+1234567890")
                    .mail("john.doe@example.com")
                    .build();

            assertNotNull(personDto);
            assertEquals((Long) 1L, personDto.getId());
            assertEquals("12345678-9", personDto.getRut());
            assertEquals("John Doe", personDto.getFullName());
            assertEquals("1990-01-01", personDto.getBirthDate());
            assertEquals("123 Main St", personDto.getHomeAddress());
            assertEquals("+1234567890", personDto.getCellPhone());
            assertEquals("john.doe@example.com", personDto.getMail());
        }

        // Update a PersonDto with new values and check if the new values are correctly set
        @Test
        public void test_update_personDto_with_new_values() {
            PersonDto personDto = PersonDto.builder()
                    .fullName("John Doe")
                    .birthDate("1990-01-01")
                    .build();

            personDto.setRut("12345678-9");
            personDto.setHomeAddress("123 Main St");
            personDto.setCellPhone("+1234567890");
            personDto.setMail("john.doe@example.com");

            assertEquals("12345678-9", personDto.getRut());
            assertEquals("123 Main St", personDto.getHomeAddress());
            assertEquals("+1234567890", personDto.getCellPhone());
            assertEquals("john.doe@example.com", personDto.getMail());
        }

        // Create a PersonDto with null values and check if all fields are null
        @Test
        public void test_create_personDto_with_null_values() {
            PersonDto personDto = new PersonDto();

            assertNull(personDto.getId());
            assertNull(personDto.getRut());
            assertNull(personDto.getFullName());
            assertNull(personDto.getBirthDate());
            assertNull(personDto.getHomeAddress());
            assertNull(personDto.getCellPhone());
            assertNull(personDto.getMail());
        }

        // Create a PersonDto with a very long fullName and check if the fullName is correctly set
        @Test
        public void test_create_personDto_with_very_long_fullName() {
            String longFullName = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl ac aliquam tincidunt, nunc nisl tincidunt nunc, nec lacinia nisl mi id lectus. Nulla facilisi. Sed id semper mauris. Sed nec semper nunc. Nulla facilisi. Sed id semper mauris. Sed nec semper nunc. Nulla facilisi. Sed id semper mauris. Sed nec semper nunc.";

            PersonDto personDto = PersonDto.builder()
                    .fullName(longFullName)
                    .build();

            assertNotNull(personDto);
            assertNull(personDto.getId());
            assertNull(personDto.getRut());
            assertEquals(longFullName, personDto.getFullName());
            assertNull(personDto.getBirthDate());
            assertNull(personDto.getHomeAddress());
            assertNull(personDto.getCellPhone());
            assertNull(personDto.getMail());
        }

        // Map a Person to a PersonDto and check if the mapping is correct
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

        // Create a PersonDto with an empty string as fullName and check if the fullName is correctly set
        @Test
        public void test_create_personDto_with_empty_fullName() {
            PersonDto personDto = PersonDto.builder()
                    .fullName("")
                    .build();

            assertNotNull(personDto);
            assertNull(personDto.getId());
            assertNull(personDto.getRut());
            assertEquals("", personDto.getFullName());
            assertNull(personDto.getBirthDate());
            assertNull(personDto.getHomeAddress());
            assertNull(personDto.getCellPhone());
            assertNull(personDto.getMail());
        }

        // Create a PersonDto with an empty string as rut and check if the rut is correctly set
        @Test
        public void test_create_personDto_with_empty_rut() {
            PersonDto personDto = PersonDto.builder()
                    .rut("")
                    .build();

            assertNotNull(personDto);
            assertNull(personDto.getId());
            assertEquals("", personDto.getRut());
            assertNull(personDto.getFullName());
            assertNull(personDto.getBirthDate());
            assertNull(personDto.getHomeAddress());
            assertNull(personDto.getCellPhone());
            assertNull(personDto.getMail());
        }

        // Create a PersonDto with an empty string as birthDate and check if the birthDate is correctly set
        @Test
        public void test_create_personDto_with_empty_birthDate() {
            PersonDto personDto = PersonDto.builder()
                    .birthDate("")
                    .build();

            assertNotNull(personDto);
            assertNull(personDto.getId());
            assertNull(personDto.getRut());
            assertNull(personDto.getFullName());
            assertEquals("", personDto.getBirthDate());
            assertNull(personDto.getHomeAddress());
            assertNull(personDto.getCellPhone());
            assertNull(personDto.getMail());
        }

    }

