Пополнение ЛС в АРМ ЛК
Meta:
@arm lk
@tag component: payments

Описание:
Чтобы самостоятельно пополнять лицевой счет
Как пользователь
Я хочу иметь соответствующий функционал в АРМ ЛК

Сценарий: В АРМ ЛК возможно пополнить ЛС с банковской карты
Meta: @tag component: notifications

Изначально пользователь находится на странице Платежи в АРМ ЛК
Если он пополнит счет на 100 рублей
То система увеличит баланс лицевого счета на 100 рублей
И на почту ВТС придет уведомление о пополнении баланса

Сценарий: В АРМ ЛК есть возможность сделать квитанцию на оплату

Изначально пользователь находится на странице Платежи в АРМ ЛК
Если он сделает квитанцию на 100 рублей для пополнения ЛС
То система сохранит файл print_receipt.pdf с суммой пополнения 100 рублей

Сценарий: В АРМ ЛК есть сохранить реквизиты на оплату

Изначально пользователь находится на странице Платежи в АРМ ЛК
Если он сделает реквизиты для пополнения ЛС
То система сохранит файл print.pdf с реквизитами для пополнения ЛС

Сценарий: В АРМ ЛК пополняется ЛС после оплаты счета
Meta: @tag component: notifications

Изначально пользователь сделал счет на 100 рублей для пополения ЛС
Если он оплатит его в банке
То система увеличит баланс лицевого счета на 100 рублей
И на почту ВТС придет уведомление о пополнении баланса