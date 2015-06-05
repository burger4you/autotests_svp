## Автоматизированное тестирование всех АРМов искользуя JBehave и WebDriver

Сценарии автоматизации написаны в BDD-стиле.

Запуск тестов выполняется командой Maven:

```
mvn clean verify -Dwebdriver.base.url=http://localhost:3000
```

Где http://localhost:3000 - адрес развернутого АРМа

Отчет генерируется в дирректорию `target/site/thucydides`.