Регистрация ФЛ в АРМ ЦИПП
Meta:
@arm cpp
@tag component: registration

Описание:
Чтобы регистрировать ТС частных лиц в системе ПО СВП
Как оператор ЦИПП
Я хочу регистрировать владельцев ТС как физическое лицо

Сценарий:
После регистрации ФЛ в АРМ ЦИПП, на указанную почту прийдет письмо с доступом к ЛК
Meta: @tag component: notifications
@1

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор зарегистрирует ВТС как Физическое лицо (test3)
То система отправит на test3 ссылку с доступом к ЛК

Сценарий:
После регистрации ФЛ нерезидента РФ в АРМ ЦИПП, на указанную почту прийдет письмо с доступом к ЛК
Meta: @tag component: notifications

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор зарегистрирует ВТС нерезидента РФ как Физическое лицо (fltestowner@gmail.com)
То система отправит на fltestowner@gmail.com ссылку с доступом к ЛК