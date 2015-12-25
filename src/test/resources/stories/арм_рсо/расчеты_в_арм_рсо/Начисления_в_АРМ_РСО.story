Возврат ДС на ЛС в АРМ РСО
Meta:
@arm rso
@tag component: payments

Описание:
Чтобы  в АРМ РСО
Как оператор
Я хочу вернуть ДС на ЛС ВТС

Сценарий: В АРМ РСО для поиска начислений ВТС оператор вводит параметры операций

Изначально оператор находится на странице Расчеты с ВТС в АРМ РСО
Если оператор войдет во вкладку Возврат ДС ВТС в АРМ РСО
И задаст поиск ВТС по <Query>, ЛС, сумму возврата, ID задания в iTop
То система снимет с учета ВТС и совершит возврат денег в АРМ РСО

Примеры:
| Тип данных      | Query           |
| ОГРН            | 7995467064220   |
| ФИО             | Физическое      |
| ИНН             | 5568362148      |


