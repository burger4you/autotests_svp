Подача обращения в АРМ ЛК
Meta:
@arm lk
@tag component: appeals

Описание:
Чтобы получать техническую поддержку
Как пользователь
Я хочу создавать обращения в АРМ ЛК

Сценарий: В АРМ ЛК Главный менеджер имеет возможность подать обращение

Изначально Главный менеджер находится на странице Обращения в АРМ ЛК
Если он создаст новое обращение
То система отобразит это обращение в общем списке обращений
Если он нажмет на это обращение
То обращение откроется для просмотра деталей

Сценарий: В АРМ ЛК Менеджер ЛС имеет возможность подать обращение

Изначально Менеджер ЛС находится на странице Обращения в АРМ ЛК
Если он создаст новое обращение
То система отобразит это обращение в общем списке обращений
Если он нажмет на это обращение
То обращение откроется для просмотра деталей

Сценарий: В АРМ ЛК Менеджер группы имеет возможность подать обращение

Изначально Менеджер группы находится на странице Обращения в АРМ ЛК
Если он создаст новое обращение
То система отобразит это обращение в общем списке обращений
Если он нажмет на это обращение
То обращение откроется для просмотра деталей

Сценарий: В АРМ ЛК Главный менеджер может просматривать обращения, созданные Менеджером ЛС и Менеджером группы

Изначально Главный менеджер находится на странице Профиль в АРМ ЛК
Если он перейдет на страницу Профиль в АРМ ЛК
То система отобразит список обращений созданных Главным менеджером, Менеджером ЛС и Менеджером группы

Сценарий: В АРМ ЛК Менеджер ЛС может просматривать только свои обращения

Изначально Менеджер ЛС находится на странице Профиль в АРМ ЛК
Если он перейдет на страницу Профиль в АРМ ЛК
То система отобразит только список обращений созданных Менеджером ЛС

Сценарий: В АРМ ЛК Менеджер группы может просматривать только свои обращения

Изначально Менеджер группы находится на странице Профиль в АРМ ЛК
Если он перейдет на страницу Профиль в АРМ ЛК
То система отобразит только список обращений созданных Менеджером группы

Сценарий: В АРМ ЛК есть возможность запросить историю обращений на электронную почту

Изначально пользователь находится на странице Обращения в АРМ ЛК
Если он запросит историю обращений с <startDate> по <endDate> на электронную почту
То система отправит письмо на email учетной записи с историей обращений

Примеры:
| startDate             | endDate               |
| 03.09.2015            | 03.12.2015            |