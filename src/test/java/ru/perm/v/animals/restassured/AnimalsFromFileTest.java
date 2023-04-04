package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.perm.v.animals.restassured.dto.AnimalDto;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

@Tag("animals")
@Epic("REST API Animal")
@DisplayName("Animals Test from FIlE")
@Story("Animal requests test")
@Feature("Verify CRUD Operations on Animal")
public class AnimalsFromFileTest {

    private final static String ANIMAL_PATH = HOST + "animal/";

    @ParameterizedTest(name = "Verify animals from params file - id = {0}, name = {1}")
    @Step("Step Animal GET ID Request with allure parameter from FILE ./animals.csv")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description : Verify by allure parameter from FILE ./animals.csv")
    @CsvFileSource(resources = "/animals.csv", numLinesToSkip = 1)
    public void getAnimalFromFileWithParams(Long id, String name) {
        AnimalDto example = new AnimalDto(id, name);
        AnimalDto receivedDto = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(ANIMAL_PATH + id)
                .then().statusCode(HttpStatus.SC_OK)
                .extract().body()
                .as(AnimalDto.class);
        assert example.equals(receivedDto);
    }
}
