Отмена маршрутных карт в АРМ ЦИПП
Meta:
@arm cpp
@tag component route maps

Описание:
Чтобы вернуть ВТС денежные средства за ненужные МК
Как оператор ЦИПП
Я хочу иметь возможность отменять МК

Сценарий: Оператор может отменить неоплаченную МК

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК по <Triger>
То система отменит МК
И отобразит ее со статусом Отменена в списке МК

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

Сценарий: Оператор может отменить оплаченную МК

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК по <Triger>
То система отменит МК
И вернет стоимость МК на ЛС

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

Сценарий: Оператор не может отменить оплаченную МК с истекшим периодом действия

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК по <Triger> с истекшим периодом действия
То система отобразит сообщение о невозможности отмены МК

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |