Удаление МК в АРМ ЛК

Meta:
@arm lk
@tag component: route maps

Описание:
Чтобы самостоятельно убирать оформленные МК из системы ПО СВП
Как владелец ТС
Я хочу иметь возможность удалять МК в АРМ ЛК

Сценарий: В АРМ ЛК есть возможность удалять оформленные МК

Изначально владелец ТС находится на странице Маршрутные карты в АРМ ЛК
Если пользователь удаляет МК stripMapName со статусом "оформлена"
То система удалит данные МК stripMapName в АРМ ЛК

Сценарий: В АРМ ЛК есть возможность удалять оплаченные МК

Изначально владелец ТС находится на странице Маршрутные карты в АРМ ЛК
Если пользователь удаляет МК stripMapName со статусом "оплачена"
То система удалит данные МК stripMapName в АРМ ЛК
И пополнил ЛС ВТС на сумму удаленной МК

Сценарий: В АРМ ЛК есть возможность удалять активированные МК

Изначально владелец ТС находится на странице Маршрутные карты в АРМ ЛК
Если пользователь удаляет МК stripMapName со статусом "активирована"
То система удалит данные МК stripMapName в АРМ ЛК
И пополнил ЛС ВТС на сумму удаленной МК