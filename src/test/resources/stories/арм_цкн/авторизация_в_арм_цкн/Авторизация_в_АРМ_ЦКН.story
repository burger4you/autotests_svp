Авторизация в АРМ ЦКН
Meta:
@arm ckn
@tag component: authorization

Описание:
Чтобы войти в АРМ ЦКН
Как пользователь
Я хочу иметь собственные логин и пароль для авторизации

Сценарий:
Для входа в АРМ ЦКН пользователю необходимо ввести логин и пароль

Изначально пользователь находится на странице Авторизации в АРМ ЦКН
Если пользователь введет логин <Login> и пароль <Password> для авторизации в АРМ ЦКН
То система предоставит доступ к АРМ ЦКН для роли <Role>

Примеры:
| Role          | Login       | Password   |
| Оператор      | operator_kn | Test789)   |
|-- Руководитель  |             |            |
|-- Администратор |             |            |