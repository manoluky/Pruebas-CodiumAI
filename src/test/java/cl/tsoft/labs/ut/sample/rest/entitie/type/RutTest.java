package cl.tsoft.labs.ut.sample.rest.entitie.type;

import cl.tsoft.labs.ut.sample.rest.entitie.converter.RutConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RutTest {

    @Test
    public void test_convert_valid_rut_to_string_representation() {
        // Arrange
        RutConverter converter = new RutConverter();
        Rut rut = new Rut(12345678, 'K');

        // Act
        String result = converter.convertToDatabaseColumn(rut);

        // Assert
        assertEquals("12345678-K", result);
    }

    @Test
    public void test_convert_null_rut_to_null() {
        // Arrange
        RutConverter converter = new RutConverter();

        // Act
        String result = converter.convertToDatabaseColumn(null);

        // Assert
        assertNull(result);
    }

    @Test
    public void test_convert_empty_string_to_null() {
        // Arrange
        RutConverter converter = new RutConverter();

        // Act
        Rut result = converter.convertToEntityAttribute("");

        // Assert
        assertNull(result);
    }

    @Test
    public void test_convert_valid_string_representation_to_rut_object() {
        // Arrange
        RutConverter converter = new RutConverter();
        String rutString = "12345678-K";

        // Act
        Rut result = converter.convertToEntityAttribute(rutString);

        // Assert
        assertEquals(new Rut(12345678, 'K'), result);
    }

    @Test
    public void test_convert_string_representation_with_lowercase_digit_to_rut_object() {
        // Arrange
        RutConverter converter = new RutConverter();
        String rutString = "12345678-k";

        // Act
        Rut result = converter.convertToEntityAttribute(rutString);

        // Assert
        assertEquals(new Rut(12345678, 'K'), result);
    }
    @Test
    public void test_convert_rut_object_with_maximum_number_to_string_representation() {
        // Arrange
        RutConverter converter = new RutConverter();
        Rut rut = new Rut(99999999, '0');

        // Act
        String result = converter.convertToDatabaseColumn(rut);

        // Assert
        assertEquals("99999999-0", result);
    }
    @Test
    public void test_convert_rut_object_with_minimum_number_to_string_representation() {
        // Arrange
        RutConverter converter = new RutConverter();
        Rut rut = new Rut(1, '0');

        // Act
        String result = converter.convertToDatabaseColumn(rut);

        // Assert
        assertEquals("1-0", result);
    }
    @Test
    public void test_convert_rut_object_with_digit_0_to_string_representation() {
        // Arrange
        RutConverter converter = new RutConverter();
        Rut rut = new Rut(12345678, '0');

        // Act
        String result = converter.convertToDatabaseColumn(rut);

        // Assert
        assertEquals("12345678-0", result);
    }
    @Test
    public void test_convert_rut_object_with_digit_K_to_string_representation() {
        // Arrange
        RutConverter converter = new RutConverter();
        Rut rut = new Rut(12345678, 'K');

        // Act
        String result = converter.convertToDatabaseColumn(rut);

        // Assert
        assertEquals("12345678-K", result);
    }
    @Test
    public void test_convert_string_representation_with_maximum_number_to_rut_object() {
        // Arrange
        RutConverter converter = new RutConverter();
        String rutString = "99999999-0";

        // Act
        Rut result = converter.convertToEntityAttribute(rutString);

        // Assert
        assertEquals(new Rut(99999999, '0'), result);
    }

    @Test
    public void test_convert_string_representation_with_uppercase_digit() {
        // Arrange
        RutConverter converter = new RutConverter();
        String dbData = "12345678-K";

        // Act
        Rut result = converter.convertToEntityAttribute(dbData);

        // Assert
        assertEquals(new Rut(12345678, 'K'), result);
    }
    @Test
    public void test_convert_string_representation_with_leading_zeros() {
        // Arrange
        RutConverter converter = new RutConverter();
        String dbData = "00001234-5";

        // Act
        Rut result = converter.convertToEntityAttribute(dbData);

        // Assert
        assertEquals(new Rut(1234, '5'), result);
    }
    @Test
    public void test_convert_string_representation_with_minimum_number() {
        // Arrange
        RutConverter converter = new RutConverter();
        String dbData = "1-0";

        // Act
        Rut result = converter.convertToEntityAttribute(dbData);

        // Assert
        assertEquals(new Rut(1, '0'), result);
    }
    @Test
    public void test_convert_rut_with_digit_0_to_rut_object() {
        // Arrange
        RutConverter converter = new RutConverter();
        String rutString = "12345678-0";

        // Act
        Rut result = converter.convertToEntityAttribute(rutString);

        // Assert
        assertEquals(new Rut(12345678, '0'), result);
    }
    @Test
    public void test_convert_rut_with_digit_K_to_rut_object() {
        // Arrange
        RutConverter converter = new RutConverter();
        String rutString = "12345678-K";

        // Act
        Rut result = converter.convertToEntityAttribute(rutString);

        // Assert
        assertEquals(new Rut(12345678, 'K'), result);
    }
    @Test
    public void test_convert_invalid_rut_string_to_rut_object() {
        // Arrange
        RutConverter converter = new RutConverter();
        String rutString = "12345678-A";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> converter.convertToEntityAttribute(rutString));
    }

    @Test
    public void test_create_rut_with_valid_number_and_digit() {
        long number = 12345678;
        char digit = 'K';

        Rut rut = new Rut(number, digit);

        assertEquals(number, rut.getNumber());
        assertEquals(digit, rut.getDigit());
    }

    @Test
    public void test_isValid_with_valid_number_and_lowercase_digit() {
        // Arrange
        long number = 12345678;
        char digit = 'k';

        // Act
        boolean result = Rut.isValid(number, digit);

        // Assert
        assertTrue(result);
    }

    @Test
    public void test_isValid_with_invalid_number_and_digit() {
        long number = -1;
        char digit = 'A';

        boolean result = Rut.isValid(number, digit);

        assertFalse(result);
    }

    @Test
    public void test_isValid_with_number_greater_than_99999999() {
        Rut rut = new Rut(100000000, '0');

        boolean result = rut.isValid();

        assertFalse(result);
    }
    @Test
    public void test_isValid_with_number_less_than_or_equal_to_0() {
        Rut rut = new Rut(0, 'K');

        boolean result = rut.isValid();

        assertFalse(result);
    }
 }