Добавление контактных лиц в АРМ ЛК
Meta:
@arm lk
@tag component: profile
@tag component: registration

Описание:
Чтобы дать доступ к ЛК сотрудникам организации
Как Главный менеджер
Я хочу добавлять контактных лиц в АРМ ЛК

Сценарий: В АРМ ЛК у Главного менеджера есть возможность пригласить Менеджера ЛС в разделе Профиль в АРМ ЛК

Изначально Главный менеджер находится на странице Контактные лица в разделе Профиль в АРМ ЛК
Если добавит контактное лицо с ролью Менеджер ЛС и укажет ЛС
То система отобразит его в списке контактных лиц
И на почту Менеджера ЛС придет приглашение для регистрации в АРМ ЛК

Сценарий: Менеджер ЛС может авторизоваться в АРМ ЛК после получения приглашения

Изначально Менеджер ЛС находится в почтовом ящике
Если он перейдет по ссылке из письма с приглашением
И заполнит контактные данные
То система позволит ему авторизоваться в АРМ ЛК с его логином и паролем

Сценарий: В АРМ ЛК у Главного менеджера есть возможность пригласить Менеджера группы в разделе Профиль в АРМ ЛК

Изначально Главный менеджер находится на странице Контактные лица в разделе Профиль в АРМ ЛК
Если добавит контактное лицо с ролью Менеджера группы и укажет группу ТС
То система отобразит его в списке контактных лиц
И на почту Менеджера группы придет приглашение для регистрации в АРМ ЛК

Сценарий: Менеджер Группы может авторизоваться в АРМ ЛК после получения приглашения

Изначально Менеджер Группы  находится в почтовом ящике
Если он перейдет по ссылке из письма с приглашением
И заполнит контактные данные
То система позволит ему авторизоваться в АРМ ЛК с его логином и паролем

Сценарий: В АРМ ЛК у Менеджера ЛС и Менеджера группы ТС нет возможности приглашать контактных лиц в разделе Профиль в АРМ ЛК

Изначально пользователь находится на странице авторизации в АРМ ЛК
Если он авторизуется с ролью <Role> и войдет в раздел Профиль в АРМ ЛК
То система не отобразит вкладку Контактные лица в разделе Профиль

| Role               |
| Менеджер группы ТС |
| Менеджер ЛС        |

Сценарий: Главный менеджер может авторизоваться в АРМ ЛК после получения приглашения

Изначально Главный менеджер находится в почтовом ящике
Если он перейдет по ссылке из письма с приглашением
И заполнит контактные данные
То система позволит ему авторизоваться в АРМ ЛК с его логином и паролем