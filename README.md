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

arm: 

cpp - АРМ ЦИПП, 
lk - АРМ Личный кабинет, 
dz - АРМ Дебиторская задолженность,
klad - АРМ Кладовщика,
admin - АРМ Администратора,
tso - АРМ ТСО,
rso - АРМ РСО,
call_centre - АРМ Колл-Центра,
treasury - АРМ Казначейства


component:

authorization - авторизация,
registration - регистрация,
route maps - маршрутные карты,
appeals - обращения,
payments - платежи,
profile - профиль,
vehicles - транспортные средства

Отчет генерируется в дирректорию `target/site/serenity`.

Отчет последнего прогона тестов на стеджинге: http://report-stage.progresspoint.ru

Отчет последнего прогона тестов на проде: 

