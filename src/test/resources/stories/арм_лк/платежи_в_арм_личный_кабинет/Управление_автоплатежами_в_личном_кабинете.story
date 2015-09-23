Управление автоплатежами в личном кабинете
Meta:
@arm lk
@tag component payments

Описание:
Чтобы автоматически пополнять лицевой счет
Как пользователь ЛК
Я хочу при необходимости включать и отключать автоплатеж

Сценарий: В личном кабинете есть возможность включить автоплатеж по минимальному остатку

Изначально пользователь находится на странице Платежи в ЛК
Если он включит автоплатеж 500 рублей по минимальному остатку на неделю с ближайшим платежом сегодня
То система автоматически пополнит лицевой счет при достижении минимального остатка

Сценарий: В личном кабинете есть возможность включить автоплатеж периодически

Изначально пользователь находится на странице Платежи в ЛК
Если он включит автоплатеж 500 рублей по периоду с ближайшим платежом завтра
То система автоматически пополнит лицевой счет при наступлении завтра
И система автоматически пополнит лицевой счет через месяц

Сценарий: В личном кабинете есть возможность выключить автоплатеж по минимальному остатку

Изначально пользователь находится на странице Платежи в ЛК
Если он включит автоплатеж 500 рублей по минимальному остатку на неделю с ближайшим платежом сегодня
И выключит автоплатеж
То система не будет пополнять лицевой счет при достижении минимального остатка

Сценарий: В личном кабинете есть возможность выключить автоплатеж на период

Изначально пользователь находится на странице Платежи в ЛК
Если он включит автоплатеж 500 рублей по периоду с ближайшим платежом завтра
И выключит автоплатеж
То система не будет пополнять лицевой счет при наступлении завтра