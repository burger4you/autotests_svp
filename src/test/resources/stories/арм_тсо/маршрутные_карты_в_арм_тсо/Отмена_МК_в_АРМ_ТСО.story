Отмена МК в АРМ ТСО
Meta:
@arm tso
@tag component: route maps

Описание:
Чтобы самостоятельно вернуть оплату за МК в системе ПО СВП
Как владелец ТС
Я хочу иметь возможность отменять МК в АРМ ТСО

Сценарий:
В АРМ ТСО есть возможность отменять МК для верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если верифицированный пользователь отменяет МК stripMapName
То система отменит МК stripMapName
И на почту ВТС придет уведомление об отмене МК

Сценарий:
В АРМ ТСО есть возможность отменять МК для не верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если не верифицированный пользователь отменяет МК stripMapName
То система отменит МК stripMapName
И на почту ВТС придет уведомление об отмене МК