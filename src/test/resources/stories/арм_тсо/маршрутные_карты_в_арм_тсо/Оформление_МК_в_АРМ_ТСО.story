Оформление МК в АРМ ТСО
Meta:
@arm tso
@tag component: route maps

Описание:
Чтобы купить МК в терминале самообслуживания
Как владелец ТС
Я хочу иметь возможность оформить МК в АРМ ТСО

Сценарий: В АРМ ТСО есть возможность оформить МК для верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если верифицированный пользователь заполняет данные МК stripMapName для оформления
То система зарегистрирует МК stripMapName
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об оформление МК

Сценарий: В АРМ ТСО есть возможность оформить МК для не верифицированного ВТС
Meta: @tag component: notifications

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если не верифицированный пользователь заполняет данные МК stripMapName для оформления
То система зарегистрирует МК stripMapName
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об оформление МК