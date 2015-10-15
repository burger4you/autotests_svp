Просмотр истории обращений ВТС в АРМ ЛК
Meta:
@arm lk
@tag component: appeals

Сценарий:
В личном кабинете есть возможность просмотреть историю обращений за последние 3 месяца

Изначально пользователь находится на странице Обращения в ЛК
Если он просмотрит историю своих обращений
То найдет только обращения, поданные за последние три месяца

Сценарий:
В личном кабинете есть возможность запросить историю обращений на электронную почту

Изначально пользователь находится на странице Обращения в ЛК
Если он запросит историю обращений с <startDate> по <endDate> на электронную почту
То система отправит письмо на email учетной записи с историей обращений

Примеры:
| startDate             | endDate               |
| 03.09.2015            | 03.11.2015            |

Сценарий:
В личном кабинете Главный менеджер может просматривать обращения, созданные Менеджером ЛС и Менеджером группы

Изначально Главный менеджер находится на странице Профиль в ЛК
Если он перейдет на страницу Профиль в ЛК
То система отобразит список обращений созданных Главным менеджером, Менеджером ЛС и Менеджером группы

Сценарий:
В личном кабинете Менеджер ЛС может просматривать только свои обращения

Изначально Менеджер ЛС находится на странице Профиль в ЛК
Если он перейдет на страницу Профиль в ЛК
То система отобразит список обращений созданных Менеджером ЛС

Сценарий:
В личном кабинете Менеджер группы может просматривать только свои обращения

Изначально Менеджер группы находится на странице Профиль в ЛК
Если он перейдет на страницу Профиль в ЛК
То система отобразит список обращений созданных Менеджером группы