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
| Triger                                         |
| Баланс ЛС Восстановлен                         |
| БУ заблокировано                               |
| Возврат средств на ЛС                          |
| Возврат средств с ЛС                           |
| Возникновение задолженности                    |
| ВТС снято с учета                              |
| Данные ВТС изменены                            |
| Данные ТС изменены                             |
| Документы ВТС верифицированы                   |
| Документы отправлены на верификацию            |
| Документы ТС верифицированы                    |
| ДС поступили на ЛС                             |
| Заказ ВТС готов к выдаче                       |
| Истек срок действия МК                         |
| МК активирована                                |
| МК оплачена                                    |
| МК отменена                                    |
| Маршрутная карта оформлена                     |
| Низкий баланс ЛС                               |
| Отказ верификации документов ВТС               |
| Отказ верификации документов ТС                |
| Передача исполнительного листа в ФССП          |
| Подготовка документов для предоставления в суд |
| Превышен порог списания с ЛС для группы ТС     |
| ТС снято с учета                               |
| Формирование претензии                         |

Сценарий: В АРМ Администратора можно настроить каналы уведомлений ВТС
Изначально администратор находится на странице Управление оповещениями в АРМ Администратора
Если администратор укажет каналы <Channels> в триггере <Triger> уведомлений ВТС
То система отобразит каналы <Channels> для триггера <Triger> в списке уведомлений владельцев ТС

Примеры:
| Triger                                         | Channels                        |
| Баланс ЛС Восстановлен                         | E-mail, БУ, ЛК (Web)            |
| БУ заблокировано                               | ЛК (Web), Sms, E-mail, Push     |
| Возврат средств на ЛС                          | ЛК (Web), Sms, E-mail           |
| Возврат средств с ЛС                           | ЛК (Web), Sms, E-mail           |
| Возникновение задолженности                    | ЛК (Web), Sms, E-mail           |
| ВТС снято с учета                              | ЛК (Web), Sms, E-mail, Push     |
| Данные ВТС изменены                            | ЛК (Web), Sms, E-mail, Push     |
| Данные ТС изменены                             | ЛК (Web), Sms, E-mail           |
| Документы ВТС верифицированы                   | ЛК (Web), Sms, E-mail           |
| Документы отправлены на верификацию            | ЛК (Web), Sms, E-mail, Push     |
| Документы ТС верифицированы                    | ЛК (Web), Sms, E-mail           |
| ДС поступили на ЛС                             | ЛК (Web), Sms, E-mail           |
| Заказ ВТС готов к выдаче                       | ЛК (Web), Sms, E-mail           |
| Истек срок действия МК                         | ЛК (Web), Sms, E-mail           |
| МК активирована                                | ЛК (Web), Sms, E-mail           |
| МК оплачена                                    | ЛК (Web), Sms, E-mail           |
| МК отменена                                    | ЛК (Web), Sms, E-mail           |
| Маршрутная карта оформлена                     | ЛК (Web), Push, E-mail          |
| Низкий баланс ЛС                               | ЛК (Web), БУ, Push, Sms, E-mail |
| Отказ верификации документов ВТС               | ЛК (Web), Sms, E-mail           |
| Отказ верификации документов ТС                | ЛК (Web), Sms, E-mail           |
| Передача исполнительного листа в ФССП          | ЛК (Web), Sms, E-mail           |
| Подготовка документов для предоставления в суд | ЛК (Web), Sms, E-mail           |
| Превышен порог списания с ЛС для группы ТС     | ЛК (Web), Sms, E-mail           |
| ТС снято с учета                               | ЛК (Web), Sms, E-mail           |
| Формирование претензии                         | ЛК (Web), Sms, E-mail           |


Сценарий: В АРМ Администратора можно настроить типы владельце ТС для уведомления
Изначально администратор находится на странице Управление оповещениями в АРМ Администратора
Если администратор укажет Тип владельце ТС <TipVTS> в триггере <Triger> уведомлений ВТС
То система отобразит Тип владельцев ТС <TipVTS> для триггера <Triger> в списке уведомлений владельцев ТС

Примеры:
| Triger                                         | TipVTS                                                            |
| Баланс ЛС Восстановлен                         | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| БУ заблокировано                               | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Возврат средств на ЛС                          | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Возврат средств с ЛС                           | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Возникновение задолженности                    | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| ВТС снято с учета                              | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Данные ВТС изменены                            | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Данные ТС изменены                             | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Документы ВТС верифицированы                   | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Документы отправлены на верификацию            | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Документы ТС верифицированы                    | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| ДС поступили на ЛС                             | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Заказ ВТС готов к выдаче                       | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Истек срок действия МК                         | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| МК активирована                                | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| МК оплачена                                    | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| МК отменена                                    | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Маршрутная карта оформлена                     | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Низкий баланс ЛС                               | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Отказ верификации документов ВТС               | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Отказ верификации документов ТС                | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Передача исполнительного листа в ФССП          | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Подготовка документов для предоставления в суд | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Превышен порог списания с ЛС для группы ТС     | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| ТС снято с учета                               | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |
| Формирование претензии                         | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо |

Сценарий: В АРМ Администратора можно настроить категории ЮЛ для уведомления
Изначально администратор находится на странице Управление оповещениями в АРМ Администратора
Если администратор укажет категорию ЮЛ <KategoriyaUL> в триггере <Triger> уведомлений ВТС
То система отобразит категорию ЮЛ <KategoriyaUL> для триггера <Triger> в списке уведомлений владельцев ТС

Примеры:
| Triger                                         | KategoriyaUL                      |
| Баланс ЛС Восстановлен                         | Мелкое, Среднее, Крупное (холдинг)|
| БУ заблокировано                               | Мелкое, Среднее, Крупное (холдинг)|
| Возврат средств на ЛС                          | Мелкое, Среднее, Крупное (холдинг)|
| Возврат средств с ЛС                           | Мелкое, Среднее, Крупное (холдинг)|
| Возникновение задолженности                    | Мелкое, Среднее, Крупное (холдинг)|
| ВТС снято с учета                              | Мелкое, Среднее, Крупное (холдинг)|
| Данные ВТС изменены                            | Мелкое, Среднее, Крупное (холдинг)|
| Данные ТС изменены                             | Мелкое, Среднее, Крупное (холдинг)|
| Документы ВТС верифицированы                   | Мелкое, Среднее, Крупное (холдинг)|
| Документы отправлены на верификацию            | Мелкое, Среднее, Крупное (холдинг)|
| Документы ТС верифицированы                    | Мелкое, Среднее, Крупное (холдинг)|
| ДС поступили на ЛС                             | Мелкое, Среднее, Крупное (холдинг)|
| Заказ ВТС готов к выдаче                       | Мелкое, Среднее, Крупное (холдинг)|
| Истек срок действия МК                         | Мелкое, Среднее, Крупное (холдинг)|
| МК активирована                                | Мелкое, Среднее, Крупное (холдинг)|
| МК оплачена                                    | Мелкое, Среднее, Крупное (холдинг)|
| МК отменена                                    | Мелкое, Среднее, Крупное (холдинг)|
| Маршрутная карта оформлена                     | Мелкое, Среднее, Крупное (холдинг)|
| Низкий баланс ЛС                               | Мелкое, Среднее, Крупное (холдинг)|
| Отказ верификации документов ВТС               | Мелкое, Среднее, Крупное (холдинг)|
| Отказ верификации документов ТС                | Мелкое, Среднее, Крупное (холдинг)|
| Передача исполнительного листа в ФССП          | Мелкое, Среднее, Крупное (холдинг)|
| Подготовка документов для предоставления в суд | Мелкое, Среднее, Крупное (холдинг)|
| Превышен порог списания с ЛС для группы ТС     | Мелкое, Среднее, Крупное (холдинг)|
| ТС снято с учета                               | Мелкое, Среднее, Крупное (холдинг)|
| Формирование претензии                         | Мелкое, Среднее, Крупное (холдинг)|