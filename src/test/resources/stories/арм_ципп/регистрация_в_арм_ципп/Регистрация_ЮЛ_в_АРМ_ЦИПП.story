Регистрация ЮЛ в АРМ ЦИПП
Meta:
@arm cpp
@component registration
@pending

Описание:
Чтобы регистрировать ТС организаций в системе ПО СВП
Как оператор ЦИПП
Я хочу регистрировать владельцев ТС как юридическое лицо

Сценарий:
После регистрации ЮЛ в АРМ ЦИПП на почту руководителя прийдет письмо с доступом к ЛК

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор зарегистрирует ВТС как Юридическое лицо (ultestowner@gmail.com)
То система отправит на ultestowner@gmail.com ссылку с доступом к ЛК

Сценарий:
После регистрации ЮЛ нерезидента РФ в АРМ ЦИПП на почту руководителя прийдет письмо с доступом к ЛК

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор зарегистрирует ВТС нерезидента РФ как Юридическое лицо (fltestowner@gmail.com)
То система отправит на fltestowner@gmail.com ссылку с доступом к ЛК

Сценарий:
При регистрации ЮЛ в АРМ ЦИПП значение поля ОГРН проходит проверку на дублирование

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор укажет ОГРН уже зарегистрированного ВТС (7995467064220)
То система отобразит сообщение, что ВТС с таким ОГРН уже зарегистрирован в системе
Если оператор нажмет на кнопку Перейти к зарегистрированному ВТС
Система отобразит страницу Изменение регистрационных данных этого ВТС