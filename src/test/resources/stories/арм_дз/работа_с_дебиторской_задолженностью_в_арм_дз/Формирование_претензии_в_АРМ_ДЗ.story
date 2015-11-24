Формирование претензии в АРМ ДЗ
Meta:
@arm dz
@tag component: задолженность

Описание:
Чтобы уведомить ВТС о невыплате задолженности
Как Оператор СВП
Я хочу сформировать претензию в АРМ ДЗ

Сценарий: Формирование претензии в АРМ ДЗ
Meta: @tag component: оповещения

Изначально Оператор СВП находится на странице Формирование претензии в АРМ ДЗ
Если Оператор СВП сформирует претензию на 15 рублей для ВТС clientName
То система отобразит статус притензия сформировна
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об сформировании претензии

Примеры:
| Channels
| Sms, E-mail   |