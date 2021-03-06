Регистрация ВТС в АРМ ЦИПП
Meta:
@arm cpp
@tag component: registration

Описание:
Чтобы регистрировать ТС в системе ПО СВП
Как оператор ЦИПП
Я хочу предварительно зарегистрировать владельцев ТС

Сценарий: В АРМ ЦИПП после регистрации ВТС на указанную почту прийдет письмо с доступом к ЛК
Meta: @tag component: notifications

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор зарегистрирует ВТС как <ClientType> (<Email>)
То система отправит на <Email> ссылку с доступом к ЛК

Примеры:
| ClientType                     | Email                   |
| Физическое лицо                | test3@svp-mail.svp.test |
| Индивидуальный предприниматель | test3@svp-mail.svp.test |
| Юридическое лицо               | test3@svp-mail.svp.test |

Сценарий: В АРМ ЦИПП доступна регистрация ВТС из других стран
Meta: @tag component: notifications

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор зарегистрирует ВТС из <ClientCountry> как <ClientType> (<Email>)
То система отправит на <Email> ссылку с доступом к ЛК

Примеры:
| ClientCountry | ClientType       | Email                   |
| Украина       | Физическое лицо  | test3@svp-mail.svp.test |
| Реюньон       | Юридическое лицо | test3@svp-mail.svp.test |

Сценарий: В АРМ ЦИПП при регистрации ЮЛ значение поля ОГРН проходит проверку на дублирование

Изначально оператор находится на странице Регистрации ВТС в АРМ ЦИПП
Если оператор укажет ОГРН уже зарегистрированного ВТС (7995467064220)
То система отобразит сообщение, что ВТС с таким ОГРН уже зарегистрирован в системе
Если оператор нажмет на кнопку Перейти к зарегистрированному ВТС
Система отобразит страницу Изменение регистрационных данных этого ВТС