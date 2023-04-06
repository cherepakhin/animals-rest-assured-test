package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.perm.v.animals.restassured.dto.CountryDto;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

// Иерархия над методами (не на КЛАССЕ!)
//@Epic → @Feature → @Story):
//@Epic(value = "Математика")
//@Feature(value = "Простые математические операции")
//@Story(value = "Вычитание")
@DisplayName("Тесты GET Country")
public class CountryTest {
    private final static String COUNTRY_PATH = HOST + "country/";

    @Epic("REST API Country")
    @Feature("Verify Operations getAll(), getById(id) on Country")
    @Story("Story Country GET ID Request")

    @DisplayName("Country GET ID Request id=1 is status=200")
//    @Step("Step Country GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the HTTP answer of country id=1 is status=200")
    @Test
    public void getCountryId_1_and_StatusCode_200() {
        given().when().get(COUNTRY_PATH + "1").then().statusCode(HttpStatus.SC_OK);
    }


    @Epic("REST API Country")
    @Feature("Verify Operations getAll(), getById(id) on Country")
    @Story("Story Country GET ID=1 Request")

    @DisplayName("Country GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of country of id=1")
    public void getCountryId(Integer id) {
        //TODO: Дать на вход ID COUNTRY
        CountryDto example = new CountryDto(1L, "Германия");
        CountryDto receivedDto = given().when().get(COUNTRY_PATH + "1").andReturn().as(CountryDto.class);
        assert example.equals(receivedDto);
    }

    @Test

    @Epic("REST API Country")
    @Feature("Verify Operations getAll(), getById(id) on Country")
    @Story("Story Country GET ID=1 Request and Status code 200")

    @DisplayName("Show failed Country GET ID Request")
//    @Step("Step Country GET ID=1 Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Show failed test")
    public void getCountryId_100_and_StatusCode_500() {
        String COUNTY_ID = "100";
        given().when().get(COUNTRY_PATH + COUNTY_ID).then().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @Test

    @Epic("REST API Country")
    @Feature("Verify Operations getAll(), getById(id) on Country")
    @Disabled("Disable for example") //пропускаемый тест, но в отчете будет подсвечен
    @Story("Story Skip example")

    @DisplayName("Show failed Country GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Show failed test")
    public void skippedExample() {
        given().when().get(COUNTRY_PATH + "100").then().statusCode(HttpStatus.SC_OK);
    }
}
