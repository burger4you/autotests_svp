## Автоматизированное тестирование всех подсистем ПО СВП используя JBehave и WebDriver

Сценарии автоматизации написаны в BDD-стиле, их можно найти в дирректории `/src/test/resources/stories`.

Запуск всех тестов выполняется командой Maven:

```
mvn clean verify
```

При запуске тестов есть возможность их фильтровать с помощью -Dmetafilter:

```
mvn clean verify -Dmetafilter="+arm cpp"
```

При этом возможно указать не только какие тесты необходимо запустить, но и какие из них необходимо пропустить.
Используя эту команду, мы запустим все тесты для АРМа ЛК, исключая тесты на авторизацию:

```
mvn clean verify -Dmetafilter="+arm lk -component authorization"
```

А так мы запустим все тесты связанные с авторизацией и маршрутными картами для всех подсистем, за исключением АРМа ЦИПП:
 
```
mvn clean verify -Dmetafilter="+component authorization +component route maps -arm cpp"
```

Доступные мета фильтры:

arm: cpp, lk

component: authorization, registration, route maps, appeals, payments, profile, vehicles


Отчет генерируется в дирректорию `target/site/serenity`.

Отчет последнего прогона тестов на стеджинге: http://report-stage.progresspoint.ru

Отчет последнего прогона тестов на проде: 

