Изменение данных группы ТС в личном кабинете
Meta:
@arm lk
@tag component: транспортные средства

Описание:
Чтобы самостоятельно обновлять данные о группе ТС в системе ПО СВП
Как пользователь ЛК
Я хочу иметь возможность менять данные группы ТС в личном кабинете

Сценарий:
В личном кабинете у Главного менеджера и Менеджера ЛС есть возможность изменить данные группы ТС

Изначально пользователь находится на странице Транспортные средства в ЛК
Если пользователь под ролью <Role> перейдет во вкладку Группы
И изменит данные группы ТС vehiclesGroupName
То система сохранит новые данные группы ТС vehiclesGroupName

| Role             |
| Главный менеджер |
| Менеджер ЛС      |

Сценарий:
В личном кабинете у Менеджера группы ТС есть нет возможности изменить данные группы ТС

Изначально пользователь находится на странице Транспортные средства в ЛК
Если пользователь заходит под ролью Менеджер группы ТС
То ему не доступна вкладка Группы на странице Транспортные средства в ЛК