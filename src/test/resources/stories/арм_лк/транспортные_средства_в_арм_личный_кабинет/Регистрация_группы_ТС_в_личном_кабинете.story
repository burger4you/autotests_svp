Регистрация группы ТС в личном кабинете
Meta:
@arm lk
@tag component: транспортные средства

Описание:
Чтобы самостоятельно добавлять свои группы ТС в систему ПО СВП
Как пользователь ЛК
Я хочу иметь возможность регистрировать группы ТС в личном кабинете

Сценарий:
В личном кабинете есть возможность регистрировать группы ТС в роли Главный менеджер и Менеджер ЛС

Изначально пользователь находится на странице Транспортные средства в ЛК
Если он под ролью <Role> зарегистрирует новую группу ТС для 2 -х своих ТС
То система отобразит её в общем списке групп ТС
Если он нажмет на эту группу ТС
То группа ТС откроется для просмотра деталей

| Role             |
| Главный менеджер |
| Менеджер ЛС      |

Сценарий:
При создании группы ТС происходит проверка лимита денежных средств в месяц на отрицательное значение

Изначально пользователь находится на странице Транспортные средства в ЛК
Если он под ролью <Role> зарегистрирует новую группу ТС для 2 -х своих ТС и указывает лимит в месяц меньше нуля
То система отобразит сообщение о необходимости введения неотрицательного значения лимита в месяц

| Role             |
| Главный менеджер |
| Менеджер ЛС      |

Сценарий:
В личном кабинете у Менеджера группы ТС есть нет возможности зарегистрировать группы ТС

Изначально пользователь находится на странице Транспортные средства в ЛК
Если пользователь заходит под ролью Менеджер группы ТС
То ему не доступна вкладка Группы на странице Транспортные средства в ЛК