Изменение данных ИП в АРМ ЦИПП
Meta:
@arm cpp
@tag component: регистрация

Описание:
Чтобы контролировать акутальность данных в системе ПО СВП
Как оператор АРМ ЦИПП
Я хочу иметь возможность изменять регистрационные данные индивидуального предпринимателя

Сценарий:
При изменении регистрационных данных ИП в системе поля ОГРН и ИНН недоступны для изменения

Изначально оператор находится на странице Измененение регистрационных данных ВТС в АРМ ЦИПП
Если оператор попытается изменить ОГРН или ИНН ВТС
То он увидит, что эти поля недоступны для изменения(read only)

Сценарий:
При изменении регистрационных данных ИП в системе сохранятся новые данные ВТС
Meta: @tag component: оповещения

Изначально оператор находится на странице Измененение регистрационных данных ВТС в АРМ ЦИПП
Если оператор изменит адрес ВТС
И приложит скан-копию документа-основания для изменения данных
То на странице Информация о ВТС отобразится ВТС с новым адресом
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об изменении данных ВТС

Примеры:
| Channels
| ЛК (Web), Sms, E-mail
