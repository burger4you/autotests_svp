Регистрация ТС в личном кабинете
Meta:
@arm cpp
@component vehicles

Описание:
Чтобы добавлять новые ТС в систему ПО СВП
Как оператор АРМ ЦИПП
Я хочу иметь возможность регистрировать ТС в АРМ ЦИПП

Сценарий:
В АРМ ЦИПП есть возможность регистрировать ТС

Изначально оператор находится на странице Регистрации ВТС в ЦИПП
Если оператор зарегистрирует новое ТС
То система отобразит его в общем списке ТС
Если он нажмет на это ТС
То ТС откроется для просмотра деталей
И в Истории текущего обращения добавится строка Регистрация ТС со статусом Выполнено

Сценарий:
В АРМ ЦИПП нет возможности регистрировать ТС с данными, уже существующими в системе ПО СВП

Изначально оператор находится на странице Регистрации ВТС в ЦИПП
Если оператор при регистрации вводит данные зарегистрированного ТС(Страна регистрации ТС Российская Федерация, ГРЗ T234TT233, Серия и номер СТС 1345324345)
То система отобразит сообщение, что ТС с такими данными уже зарегистрировано в системе
И в Истории текущего обращения добавится строка Регистрация ТС со статусом Не выполнено