### Behave тестирование RestAssured

Для проведения тестов использован RestAssured<br/>
 [https://github.com/rest-assured/rest-assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted).

Для просмотра отчетов Allure [https://docs.qameta.io/allure/](https://docs.qameta.io/allure/)

Скрипты выполнять из папки проекта с тестами Rest Assured. 
Перед запуском тестов нужно запустить сам проект:
[https://github.com/cherepakhin/animals](https://github.com/cherepakhin/animals)

```shell
# Проведение теста
animals-restassured-test$ mvn clean test
# Просмотр отчета в браузере
animals-restassured-test$ ./`allure serve target/surefire-reports/`
```

### Скользкие вопросы

Где хранить классы DTO? В тестируемом проекте и в тестах они должны совпадать и т.к. JSON должны совпадать с ТЗ. 
Получается, что в тестах нужно вести свою модель DTO. 
Разработчик пишет свою модель DTO, а тестировщик ведет свою модель DTO. 

### TODO

1. Вкладка "Categories" пустая
2. Parametrized test
3. Упорядочить в дерево "Behaviors", "Categories"
4. Нет "Timeline"


### Памятка по группировке тестов allure


Пример:

```java
@Tag("animals")
@Epic("REST API Animal")
@DisplayName("Animals Test") 
@Story("Animal requests test")
@Feature("Verify CRUD Operations on Animal")
public class AnimalsTest {
 
}

```

По пакетам:

![По пакетам](doc/group_by_package.png)

По строгости (критичности) - аннотация @Severity(SeverityLevel.NORMAL). Работа аннотаций @Epic, @Suite:

![@DisplayName или Suites](doc/group_by_suites.png)

Отчет с ошибками:

![Отчет с ошибками](doc/result_test_error.png)

### Шпаргалка по вложенности

![Epic-Feature-Story](doc/hierarchy.png)

### Закладки

https://docs.qameta.io/allure/
https://allure-framework.github.io/allure-demo/5/#suites/a2891ce60e520f56ae25e6caf68ea773/448aea45096280d4/

~/prog/java/allure-examples/allure-junit5

````shell
$ cd ~/prog/java/allure-examples/allure-junit5
$ mvn clean test
$ allure serve allure-results/
````

~/prog/java/allure-examples/allure-junit5-example

````shell
$ cd ~/prog/java/allure-examples/allure-junit5-example
$ mvn clean test
$ ~/prog/java/allure-examples/allure-junit5-example$ allure serve allure-results/
````

