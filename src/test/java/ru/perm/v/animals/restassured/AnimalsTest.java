package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import ru.perm.v.animals.restassured.dto.AnimalDto;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

/**
 * Отчет о тестах в папке ./restassured-test/target/surefire-reports/index.html#
 * Иерархия Epic->Feature->Story
 */
@Tag("animals")
@Epic("REST API Animal")
@DisplayName("Animals Test")
@Story("Animal GET requests test")
@Feature("Verify CRUD Operations on Animal")
public class AnimalsTest {

    private final static String ANIMAL_PATH = HOST + "animal/";

    @Test
    @Step("Step Animal GET Request ID=1 check STATUS_CODE=200")
    @Severity(SeverityLevel.NORMAL) // уровень критичности
    @Description("Test Description : Verify the HTTP answer of animal id=1 is status=200")
    @DisplayName("Animal GET Request ID=1 check STATUS_CODE=200")
    public void getAnimal_Id_1_and_StatusCode_200() {
        given().when().get(ANIMAL_PATH + "1").then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Step("Step Animal GET Request ID=1 check content")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of animal of id=1")
    public void getAnimal_Id_1() {
        AnimalDto example = new AnimalDto(1L, "Волк");
        AnimalDto receivedDto = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(ANIMAL_PATH + "1")
                .andReturn()
                .as(AnimalDto.class);
        assert example.equals(receivedDto);
    }

    @Test
    @Step("Step Animal GET ID Request with allure ATTACHMENT")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of animal of id=1 with allure parameter")
    public void getAnimal_Id_10() {
        Allure.addAttachment("Какой-то заголовок вложения", "Какое-то описание/уточнение/комментарий");
        AnimalDto example = new AnimalDto(1L, "Волк");
        AnimalDto receivedDto = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(ANIMAL_PATH + "1")
                .then().statusCode(200)
                .extract().body()
                .as(AnimalDto.class);
        assert example.equals(receivedDto);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Show failed test")
    public void getId_1_and_StatusCode_400() {
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(ANIMAL_PATH + "1")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @ParameterizedTest(name = "Verify animals from params - id = {0}, name = {1}")
    @CsvSource({"1,Волк", "2,Корова"})
    @Step("Step Animal GET ID Request with parameters from ANNOTATION!")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify animals with parameters from ANNOTATION!")
    public void getAnimalFromAnnotationParams(Long id, String name) {
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
