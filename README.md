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
mvn clean verify -Dmetafilter="+arm lk -tag component: authorization"
```

А так мы запустим все тесты связанные с авторизацией и маршрутными картами для всех подсистем, за исключением АРМа ЦИПП:
 
```
mvn clean verify -Dmetafilter="+tag component: authorization +tag component: route maps -arm cpp"
```

Доступные мета фильтры:

arm: 

admin - АРМ Администратора,
dz - АРМ Дебиторская задолженность,
treasury - АРМ Казначейства,
klad - АРМ Кладовщика,
call_centre - АРМ Колл-Центра,
ssk - АРМ Контроля Нарушений,
lk - АРМ Личный кабинет,
rso - АРМ РСО,
smk - АРМ СМК,
tso - АРМ ТСО,
cpp - АРМ ЦИПП,



component:

authorization - авторизация,
registration - регистрация,
route maps - маршрутные карты,
devices - бортовые устройства,
feedback - обратная связь,
appeals - обращения,
payments - платежи,
profile - профиль,
vehicles - транспортные средства,
notification - уведомления,
info - справочная информация

Отчет генерируется в дирректорию `target/site/serenity`.

Отчет последнего прогона тестов на стейджинге: http://report-stage.progresspoint.ru

Отчет последнего прогона тестов на проде: 

