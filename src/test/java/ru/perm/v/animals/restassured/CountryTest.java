package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.perm.v.animals.restassured.dto.CountryDto;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

@Epic("REST API Country")
@Feature("Verify Operations getAll(), getById(id) on Country")
@DisplayName("Тесты GET Country")
public class CountryTest {

    private final static String COUNTRY_PATH = HOST + "country/";

    @Test
    @Step("Step Country GET ID Request")
    @DisplayName("Country GET ID Request id=1")
    @Story("Country GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the HTTP answer of country id=1 is status=200")
    public void getCountryId_1_and_StatusCode_200() {
        given().when().get(COUNTRY_PATH + "1").then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getCountryById_0() {
        getCountryId(0);
    }

    @Test
    public void getCountryById_1() {
        getCountryId(1);
    }

    @DisplayName("Country GET ID Request ")
    @Step("Step Country GET ID=1 Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of country of id=1")
    public void getCountryId(Integer id) {
        CountryDto example = new CountryDto(1L, "Германия");
        CountryDto receivedDto = given().when().get(COUNTRY_PATH + "1").andReturn().as(CountryDto.class);
        assert example.equals(receivedDto);
    }

    @Test
    @DisplayName("Show failed Country GET ID Request")
    @Step("Step Country GET ID=1 Request")
    @Story("Country GET ID Request and Status code 400")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Show failed test")
    public void getCountryId_100_and_StatusCode_400() {
        given().when().get(COUNTRY_PATH + "100").then().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
}
