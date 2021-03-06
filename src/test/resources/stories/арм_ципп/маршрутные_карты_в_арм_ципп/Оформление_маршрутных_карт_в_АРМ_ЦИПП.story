Оформление маршрутных карт в АРМ ЦИПП
Meta:
@arm cpp
@tag component: route maps

Описание:
Чтобы оформлять маршрутные карты прямо в АРМ ЦИПП
Как оператор ЦИПП
Я хочу иметь соответствующий функционал

Сценарий: Оператор может создать МК для конкретного верифицированного ТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное верифицированное ТС
То система зарегистрирует МК
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об оформление МК

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |

Сценарий: Оператор может создать МК для конкретного не верифицированного ТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное не верифицированное ТС
То система зарегистрирует МК
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об оформление МК

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |