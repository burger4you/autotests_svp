Управление уведомлениями ВТС в АРМ Администратора
Meta:
@arm admin
@tag component: notifications

Описание:
    Чтобы информировать ВТС о событиях в системе ПО СВП
    Как администратор
    Я хочу настраивать уведомления ВТС в АРМ Администратора

Сценарий: В АРМ Администратора можно включить и выключить любое из уведомлений ВТС
Изначально администратор находится на странице Управление оповещениями в АРМ Администратора
Если администратор выключит триггер <Triger> уведомлений ВТС
То система отобразит триггер <Triger> с выключенным запуском в списке уведомлений владельцев ТС
Если администратор включит триггер <Triger> уведомлений ВТС
То система отобразит триггер <Triger> с включенным запуском в списке уведомлений владельцев ТС

Примеры:
| Triger                                                   |
| Баланс ЛС Восстановлен                                   |
| Низкий баланс ЛС                                         |
| МК отменена                                              |
| ТС снято с учета                                         |
| Возникновение задолженности                              |
| МК оформлена, код оплаты через терминалы партнеров ХХХХХ |
| Документы отправлены на верификацию                      |
| Документы верифицированы                                 |
| Отказ верификации документов                             |
| ВТС снято с учета                                        |
| Данные ВТС изменены                                      |
| Учетная запись заблокирована                             |

Сценарий: В АРМ Администратора можно настроить каналы уведомлений ВТС
Изначально администратор находится на странице Управление оповещениями в АРМ Администратора
Если администратор укажет каналы <Channels> в триггере <Triger> уведомлений ВТС
То система отобразит каналы <Channels> для триггера <Triger> в списке уведомлений владельцев ТС

Примеры:
| Triger                                                   | Channels                        |
| ТС снято с учета                                         | E-mail, ЛК (Web)                |
| Возникновение задолженности                              | ЛК (Web), E-mail                |
| МК оформлена, код оплаты через терминалы партнеров ХХХХХ | ЛК (Web), Push, E-mail          |
| Баланс ЛС Восстановлен                                   | E-mail, БУ, ЛК (Web)            |
| Низкий баланс ЛС                                         | ЛК (Web), БУ, Push, Sms, E-mail |
| МК отменена                                              | ЛК (Web), Push, E-mail          |
| Подготовка документов для предоставления в суд           | ЛК (Web), Sms, E-mail           |
| Передача исполнительного листа в ФССП                    | ЛК (Web), Sms, E-mail           |
| Подготовка документов для предоставления в суд           | ЛК (Web), Sms, E-mail           |
| Документы отправлены на верификацию                      | ЛК (Web), Push, Sms, E-mail     |
| Документы верифицированы                                 | ЛК (Web), Sms, E-mail           |
| Отказ верификации документов                             | ЛК (Web), Sms, E-mail           |
| ВТС снято с учета                                        | E-mail, ЛК (Web)                |
| Данные ВТС изменены                                      | ЛК (Web), Sms, E-mail           |
| Учетная запись заблокирована                             | Sms, E-mail                     |
