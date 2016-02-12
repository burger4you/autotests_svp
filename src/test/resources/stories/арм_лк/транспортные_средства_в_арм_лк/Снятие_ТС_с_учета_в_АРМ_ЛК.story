Снятие ТС с учета в АРМ ЛК
Meta:
@arm lk
@tag component: vehicles

Описание:
Чтобы самостоятельно убирать ТС из системы ПО СВП
Как пользователь
Я хочу иметь возможность снимать ТС с учета в АРМ ЛК

Сценарий: В АРМ ЛК есть возможность снять с учета ТС

Изначально пользователь находится на странице Транспортные средства в АРМ ЛК
Если пользователь снимет с учета ТС vehicleName
То система удалит данные о ТС vehicleName в АРМ ЛК

Сценарий: В АРМ ЛК можно снять с учета ТС только без БУ

Изначально пользователь находится на странице Транспортные средства в АРМ ЛК
Если пользователь выберет vehicleName в списке ТС для проссмотра
То на странице просмотра ТС не будет доступна кнопка Снять с учета
Если пользователь вернет БУ с ТС vehicleName
То на странице проссмотра ТС будет доступна кнопка Снять с учета

Сценарий: В АРМ ЛК можно снять с учета ТС только не последнее

Изначально пользователь находится на странице Транспортные средства в АРМ ЛК
Если пользователь попытается снять с учета последнее ТС vehicleName
Система отобразит сообщение о невозможности снять ТС с учета в АРМ ЛК