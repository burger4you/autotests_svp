Оплата МК в АРМ ТСО
Meta:
@arm tso
@tag component: route maps

Описание:
Чтобы купить МК в терминале самообслуживания
Как владелец ТС
Я хочу иметь возможность оплатить МК в АРМ ТСО

Сценарий:
В АРМ ТСО есть возможность оплатить МК банковской картой для верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если верифицированный пользователь оплачивает МК stripMapName банковской картой cardName
То система принимает оплату МК stripMapName
И на почту ВТС придет уведомление об оплате МК

Сценарий:
В АРМ ТСО есть возможность оплатить МК банковской картой для не верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если не верифицированный пользователь оплачивает МК stripMapName банковской картой cardName
То система принимает оплату МК stripMapName
И на почту ВТС придет уведомление об оплате МК

Сценарий:
В АРМ ТСО есть возможность оплатить МК с лицевого счета для верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если верифицированный пользователь оплачивает МК stripMapName с лицевого счета
То система принимает оплату МК stripMapName
И на почту ВТС придет уведомление об оплате МК

Сценарий:
В АРМ ТСО есть возможность оплатить МК с лицевого счета для не верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если не верифицированный пользователь оплачивает МК stripMapName с лицевого счета
То система принимает оплату МК stripMapName
И на почту ВТС придет уведомление об оплате МК