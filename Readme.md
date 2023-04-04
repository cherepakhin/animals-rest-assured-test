### Behave тестирование RestAssured

Для проведения тестов использован RestAssured<br/>
 [https://github.com/rest-assured/rest-assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted).

Для просмотра отчетов Allure [https://docs.qameta.io/allure/](https://docs.qameta.io/allure/)

Скрипты выполнять из папки проекта с тестами Rest Assured

```shell
# Проведение теста
animals-restassured-test$ mvn clean test
# Просмотр отчета в браузере
animals-restassured-test$ ./allure serve target/surefire-reports/
```

### Скользкие вопросы

Где хранить классы DTO? В тестируемом проекте и в тестах они должны совпадать и т.к. JSON должны совпадать с ТЗ. 
Получается, что в тестах нужно вести свою модель DTO. 
Разработчик пишет свою модель DTO, а тестировщик ведет свою модель DTO. 

### Памятка

Тесты можно группировать.

- По строгости (критичности) - аннотация @Severity(SeverityLevel.NORMAL)
- [По пакетам](doc/group_by_package.png)  


тег Аннотации Epic, Suite