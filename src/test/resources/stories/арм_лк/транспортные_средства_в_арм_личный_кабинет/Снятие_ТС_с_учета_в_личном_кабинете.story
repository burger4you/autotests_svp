Снятие ТС с учета в личном кабинете
Meta:
@arm lk
@tag component vehicles

Описание:
Чтобы самостоятельно убирать ТС из системы ПО СВП
Как пользователь ЛК
Я хочу иметь возможность снимать ТС с учета в личном кабинете

Сценарий:
В личном кабинете есть возможность снять с учета ТС

Изначально пользователь находится на странице Транспортные средства в ЛК
Если пользователь снимет с учета ТС vehicleName
То система удалит данные о ТС vehicleName в ЛК

Сценарий:
В личном кабинете можно снять с учета ТС только без БУ

Изначально пользователь находится на странице Транспортные средства в ЛК
Если пользователь выберет vehicleName в списке ТС для проссмотра
То на странице проссмотра ТС не будет доступна кнопка Снять с учета
Если пользователь вернет БУ с ТС vehicleName
То на странице проссмотра ТС будет доступна кнопка Снять с учета

Сценарий:
В личном кабинете можно снять с учета ТС только не последнее

Изначально пользователь находится на странице Транспортные средства в ЛК
Если пользователь снимет с учета последнее ТС vehicleName
Система предложит зарегистрировать новое ТС