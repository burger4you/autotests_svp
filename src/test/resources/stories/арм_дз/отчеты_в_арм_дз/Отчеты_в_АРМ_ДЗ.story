Отчеты в АРМ ДЗ
Meta:
@arm dz
@tag component: reports

Описание:
Чтобы просмотреть отчет по интересующим ВТС с задолженностью в АРМ ДЗ
Как аналитик
Я хочу отобрать ВТС по требуемым параметрам

Сценарий: Просмотр информации по ВТС и сумме задолженности в отчете по дебиторской задолженности

Изначально аналитик находится на странице Отчеты в АРМ ДЗ
Если аналитик выберет действие Отчет по дебиторской задолженности ВТС и задаст требуемые параметры для фильтра ВТС
То система отобразит отчет с информацие по ВТС и сумме задолженности

Сценарий: Формирование отчетности по сравнительноый сумме ДЗ в АРМ ДЗ

Изначально руководитель находиться на странице Отчеты в АРМ ДЗ
Если руководитель выберет фильтр Сумма ДЗ, укажет его значение <Value> и параметр Больше/Меньше <Parameter>
То система отобразит отчет по ВТС с соответствующими статусами

Примеры:
| Value               | Parameter     |
| 0, 100, 1000, 10000 | Больше, Меньше|

Сценарий: Формирование отчетности по ДЗ в АРМ ДЗ

Изначально руководитель находиться на странице Отчеты в АРМ ДЗ
Если руководитель выберет фильтр <Filter> и укажет значение <Value> для поиска по задолженности ВТС
То система отобразит отчет по ВТС с соответствующими статусами

Примеры:
| Filter                             | Value                              |
| Нижняя граница интервала суммы ДЗ  | 0, 100, 1000, 10000                |
| Верхняя граница интервала суммы ДЗ | 0, 100, 1000, 10000                |
| Дата возникновения задолженности   | 01.09.2015, 09.09.2015, 27.09.2015 |
| Документы в суд для отправки       | Сформированы, Не сформированы      |
| Претензии                          | Направлены, Не направлены          |
| Документы в суд                    | Направлены, Не направлены          |
| Документы приставам                | Переданы, Не переданы              |