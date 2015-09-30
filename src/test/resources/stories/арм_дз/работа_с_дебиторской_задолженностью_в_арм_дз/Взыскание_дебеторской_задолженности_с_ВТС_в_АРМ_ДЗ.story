Взыскание дебеторской задолженности с ВТС в АРМ ДЗ
Meta:
@arm dz
@tag component: claims

Описание:
Чтобы взыскать задолженность с ВТС
Как аналитик
Я хочу зарегистрировать исковое заявление в АРМ ДЗ и довести его до ФССП

Сценарий: В АРМ ДЗ отображаются все ВТС имеющие дебеторскую задолженность
Изначально


Сценарий: В АРМ ДЗ регистрируется исковое заявление

Изначально аналитик находится на странице Регистрация искового заявления в АРМ ДЗ
Если аналитик нажмет кнопку Создать исковое заявление и укажет сумму взыскания
То система зарегистрирует исковое заявление

Сценарий: В АРМ ДЗ исковое заявление передается в суд
Meta: @tag component: notifications

Изначально оператор находится на странице Регистрация искового заявления в АРМ ДЗ
Если аналитик направит исковое заявление в суд
То система отобразит статус искового заявления как Документы переданы в суд
И на почту ВТС придет уведомление об отправке документов в суд

Сценарий: В АРМ ДЗ исполнительный лист после суда передается в ФССП
Meta: @tag component: notifications

Изначально аналитик находится на странице Регистрация искового заявления в АРМ ДЗ
Если аналитик направит исполнительный лист по исковому заявлению служебным приставам
То система отобразит статус искового заявления как Исполнительный лист передан в ФССП
И на почту ВТС придет уведомление об отправке документов в ФССП