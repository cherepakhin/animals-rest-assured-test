package ru.perm.v.animals.restassured;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.perm.v.animals.restassured.dto.AnimalDto;

import static io.restassured.RestAssured.given;
import static ru.perm.v.animals.restassured.VARS.HOST;

@Tag("animals")
@Epic("REST API Animal")
@DisplayName("Animals Test with test data from ANNOTATION")
@Story("Animal requests test with test data from ANNOTATION (story)")
@Feature("Verify CRUD Operations on Animal")
public class AnimalsWithTestDataFromParamsTest {

    private final static String ANIMAL_PATH = HOST + "animal/";

    @ParameterizedTest(name = "Verify animals from params - id = {0}, name = {1}")
    @CsvSource({"1,Волк", "2,Корова"})
    @Step("Step Animal GET ID Request with parameters from ANNOTATION!")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify animals with parameters from ANNOTATION!")
    public void getAnimalFromAnnotationParams(Long id, String name) throws InterruptedException {
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
