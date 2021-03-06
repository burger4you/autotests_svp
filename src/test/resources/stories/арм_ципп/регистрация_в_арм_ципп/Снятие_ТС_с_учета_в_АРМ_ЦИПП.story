Снятие ТС с учета в АРМ ЦИПП
Meta:
@arm cpp
@tag component: vehicles

Описание:
Чтобы убирать ТС из системы ПО СВП
Как оператор ЦИПП
Я хочу иметь возможность снимать ТС с учета в АРМ ЦИПП

Сценарий: В АРМ ЦИПП есть возможность снять с учета ТС
Meta: @tag component: notifications

Изначально оператор находится на странице Снятие ТС с учета в АРМ ЦИПП
Если пользователь снимет с учета ТС vehicleName
То система удалит данные о ТС vehicleName
И система отправит на email уведомление notification

Сценарий: В АРМ ЦИПП нельзя снять с учета ТС с БУ

Изначально оператор находится на странице Снятие ТС с учета в АРМ ЦИПП
Если оператор АРМ ЦИПП найдет по ГРЗ ТС vehicleName в списке ТС для снятия ТС с учета
То после нажатия кнопки Снять ТС с учета на странице просмотра ТС появится сообщение Для снятия ТС с учета необходимо принять БУ
Если оператор АРМ ЦИПП вернет БУ с ТС vehicleName
То система удалит данные о ТС vehicleName

Сценарий: В АРМ ЦИПП нельзя снять с учета последнее ТС

Изначально оператор находится на странице Снятие ТС с учета в АРМ ЦИПП
Если оператор снимет с учета последнее ТС vehicleName
Система предложит зарегистрировать новое ТС

Cценарий: В АРМ ЦИПП нельзя снять с учета ТС с оплаченной МК

Изначально оператор находится на странице Снятие ТС с учета в АРМ ЦИПП
Если оператор найдет по ГРЗ ТС vehicleName в списке ТС для снятия ТС с учета
То после нажатия кнопки Снять ТС с учета на странице просмотра ТС появится сообщение Для снятия с учета необходимо отменить МК
Если оператор отменит МК с ТС vehicleName
То после нажатия кнопки Снять ТС с учета на странице просмотра ТС система удалит данные о ТС vehicleName