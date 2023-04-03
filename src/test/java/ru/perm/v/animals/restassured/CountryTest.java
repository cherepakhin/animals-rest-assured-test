package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

@Epic("REST API Country")
@Feature("Verify Operations getAll(), getById(id) on Country")
public class CountryTest {

    private final static String COUNTRY_PATH = HOST + "country/";

    @Test
//    @Step("Step Country GET ID Request")
    @DisplayName("Country GET ID Request")
//    @Story("Country GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the HTTP answer of country id=1 is status=200")
    public void getId_1andStatusCode200() {
        given().when().get(COUNTRY_PATH + "1").then().statusCode(400);
    }

    @Test
//    @Step("Step Country GET ID=1 Request")
    @DisplayName("Country GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of country of id=1")
    public void getId_1() {
        CountryDto example = new CountryDto(1L, "Германия");
        CountryDto receivedDto = given().when().get(COUNTRY_PATH + "1").andReturn().as(CountryDto.class);
        assert example.equals(receivedDto);
    }

    @Test
    @DisplayName("Show failed Animal GET ID Request")
    @Story("Animal GET ID Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Show failed test")
    public void getId_1andStatusCode400() {
        given().when().get(COUNTRY_PATH + "1").then().statusCode(200);
    }
}
