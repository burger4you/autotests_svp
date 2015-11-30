Активация МК

Meta:
@arm admin
@tag component: оповещения

Описание:
Чтобы информировать ВТС об активации МК
Как администратор
Я хочу настраивать уведомления ВТС об активации МК в АРМ Администратора

Сценарий: В АРМ Администратора можно включить и выключить уведомление ВТС об Маршрутная карта активирована

Изначально администратор находится на странице Управление оповещениями в АРМ Администратора
Если администратор выключит триггер <Triger> уведомлений ВТС
То система отобразит триггер <Triger> с выключенным запуском в списке уведомлений владельцев ТС
Если администратор включит триггер <Triger> уведомлений ВТС, укажет каналы <Channels>, тип владельцев ТС <TipVTS>, а так же категорию ЮЛ <KategoriyaUL>
То система отобразит триггер <Triger>, а так же каналы <Channels>, тип владельцев ТС <TipVTS> и категорию ЮЛ <KategoriyaUL> с включенным запуском в списке уведомлений владельцев ТС

Примеры:
| Triger                                 | Channels                        | TipVTS                                                            | KategoriyaUL                      |
| МК активирована                        | ЛК (Web), Sms, E-mail           | Индивидуальный предприниматель, Физическое лицо, Юридическое лицо | Мелкое, Среднее, Крупное (холдинг)|

Описание:
Чтобы настроить МК
Как администратор
Я хочу устанавливать периоды оформления и истечения срока действия МК в АРМ Администратора

Сценарий: В АРМ Администратора возможно настраивать различные периоды для МК
Meta: @issue 11134

Изначально администратор находится на странице Маршрутные карты в АРМ Администратора
Если администратор изменит <Period> на <Duration> <Scaling>
То система сохранит новые настройки для выбранного <Period>

Примеры:
| Period                                                        | Duration           | Scaling |
| Период действия МК от даты/времени активации                  | 20                 | День    |

Meta:
@arm cpp
@tag component: маршрутные карты
@tag component: оповещения

Описание:
Чтобы оформлять маршрутные карты прямо в АРМ ЦИПП
Как оператор ЦИПП
Я хочу иметь соответствующий функционал

Сценарий: Оператор может создать МК для конкретного верифицированного ТС

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное верифицированное ТС
То система зарегистрирует МК и через 20 дней активирует ее
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об оформлении МК и ее активации

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |

Сценарий: Оператор может создать МК для конкретного не верифицированного ТС

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное не верифицированное ТС
То система зарегистрирует МК и через 20 дней активирует ее
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об оформлении МК и ее активации

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |



