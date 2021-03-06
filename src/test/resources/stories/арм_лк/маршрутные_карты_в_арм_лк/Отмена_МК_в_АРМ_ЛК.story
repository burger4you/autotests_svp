Отмена МК в АРМ ЛК

Meta:
@arm lk
@tag component: route maps

Описание:
Чтобы самостоятельно вернуть оплату за МК в системе ПО СВП
Как пользователь
Я хочу иметь возможность отменять МК в АРМ ЛК

Сценарий: В АРМ ЛК верифицированного ВТС есть возможность отменять МК
Meta: @tag component: notifications

Изначально верифицированный пользователь находится на странице Маршрутные карты в АРМ ЛК
Если верифицированный пользователь отменяет МК stripMapName
То система отменит МК stripMapName
И на почту ВТС придет уведомление об отмене МК

Сценарий: В АРМ ЛК не верифицированного ВТС есть возможность отменять МК
Meta: @tag component: notifications
@ignore

Изначально не верифицированный пользователь находится на странице Маршрутные карты в АРМ ЛК
Если не верифицированный пользователь отменяет МК stripMapName
То система отменит МК stripMapName
И на почту ВТС придет уведомление об отмене МК