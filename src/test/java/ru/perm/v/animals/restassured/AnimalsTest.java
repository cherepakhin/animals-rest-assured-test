package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import ru.perm.v.animals.restassured.dto.AnimalDto;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

/**
 * Отчет о тестах в папке ./restassured-test/target/surefire-reports/index.html#
 */
@Epic("REST API Animal")
public class AnimalsTest {

    private final static String ANIMAL_PATH = HOST + "animal/";
    @Test
    @Feature("Verify CRUID Operations on Animal")
    @Story("Animal requests test")
    @Step("Step Animal GET ID=1 Request and STATUS_CODE=200")
    @Severity(SeverityLevel.NORMAL) // уровень критичности
    @DisplayName("Animal GET ID Request")
    @Description("Test Description : Verify the HTTP answer of animal id=1 is status=200")
    public void getAnimal_Id_1_and_StatusCode200() {
        given().when().get(ANIMAL_PATH + "1").then().statusCode(200);
    }

    @Test
    @Feature("Verify CRUID Operations on Animal")
    @Story("Animal requests test")
    @Step("Step Animal GET ID Request")
    @DisplayName("Animal GET ID Request")
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
    @Feature("Verify CRUID Operations on Animal")
    @Story("Animal requests test")
    @Step("Step Animal GET ID Request with allure parameter")
    @DisplayName("Animal GET ID Request with allure parameter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of animal of id=1 with allure parameter")
    public void getAnimal_Id_10() {
        Allure.addAttachment("Заголовок вложения", "1000");
        AnimalDto example = new AnimalDto(1L, "Волк");
        AnimalDto receivedDto = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(ANIMAL_PATH + "1")
                .then().statusCode(200)
                .extract().body()
                .as(AnimalDto.class)
                ;
        assert example.equals(receivedDto);
    }

    @Test
    @DisplayName("Show failed Animal GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Show failed test")
    public void getId_1_and_StatusCode400() {
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(ANIMAL_PATH + "1")
                .then()
                .statusCode(200);
    }
}
