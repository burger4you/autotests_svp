Снятие ВТС с учета в АРМ ЦИПП
Meta:
@arm cpp
@tag component: registration

Описание:
Чтобы снять ВТС с учета в системе ПО СВП
Как оператор АРМ ЦИПП
Я хочу иметь возможность снять ВТС с учета в АРМ ЦИПП

Сценарий: В АРМ ЦИПП невозможно снять с учета ВТС при наличии выданных БУ

Изначально оператор находится на странице Снятие ВТС с учета
Если он нажмет кнопку Завершить снятие с учета при наличии у ВТС выданных БУ
То система отобразит сообщение о том, что для снятия ВТС с учета необходимо сначала принять БУ

Сценарий: В АРМ ЦИПП невозможно снять с учета ВТС при наличии оплаченных и не активированных МК

Изначально оператор находится на странице Снятие ВТС с учета
Если он нажмет кнопку Завершить снятие с учета при наличии у ВТС оплаченных и не активированных МК
То система отобразит сообщение о том, что для снятия ВТС с учета необходимо отменить МК

Сценарий: В АРМ ЦИПП невозможно снять с учета ВТС при отрицательном балансе хотя бы одного из ЛС

Изначально оператор находится на странице Снятие ВТС с учета
Если он нажмет кнопку Завершить снятие с учета при отрицательном балансе хотя бы одного из ЛС
То система отобразит сообщение о том, что для снятия ВТС с учета необходимо погасить задолженность

Сценарий: В АРМ ЦИПП есть возможность снять с учета ВТС при отсутствии выданных БУ оплаченных и не активированных МК и положительном балансе всех ЛС

Изначально оператор находится на странице Снятие ВТС с учета
Если он нажмет кнопку Завершить снятие с учета
И подтвердит снятие с учета, прикрепив соответствующие документы
То система удалит все ТС данного ВТС из системы ПО СВП
И проставит ВТС статус Снят с учета