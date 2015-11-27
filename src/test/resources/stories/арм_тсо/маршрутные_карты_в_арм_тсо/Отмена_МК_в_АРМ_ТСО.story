Отмена МК в АРМ ТСО
Meta:
@arm tso
@tag component: маршрутные карты

Описание:
Чтобы самостоятельно вернуть оплату за МК в системе ПО СВП
Как владелец ТС
Я хочу иметь возможность отменять МК в АРМ ТСО

Сценарий:
В АРМ ТСО есть возможность отменять МК для верифицированного ВТС
Meta: @tag component: оповещения

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если верифицированный пользователь отменяет МК stripMapName
То система отменит МК stripMapName
И ВТС придет уведомления <Notification> в соответствии с выбранным каналом <Channels>

Примеры:
| Notification                                  | Channels                        |
| МК отменена                                   | ЛК (Web), Sms, E-mail           |
| Возврат средств на ЛС                         | ЛК (Web), Sms, E-mail           |

Сценарий:
В АРМ ТСО есть возможность отменять МК для не верифицированного ВТС
Meta: @tag component: оповещения

Изначально владелец ТС находится на стартовой странице терминала самообслуживания
Если не верифицированный пользователь отменяет МК stripMapName
То система отменит МК stripMapName
И ВТС придет уведомления <Notification> в соответствии с выбранным каналом <Channels>

Примеры:
| Notification                                  | Channels                        |
| МК отменена                                   | ЛК (Web), Sms, E-mail           |
| Возврат средств на ЛС                         | ЛК (Web), Sms, E-mail           |
