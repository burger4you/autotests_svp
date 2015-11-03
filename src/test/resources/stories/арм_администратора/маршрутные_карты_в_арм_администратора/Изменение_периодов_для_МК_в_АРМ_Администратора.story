Изменение периодов для МК в АРМ Администратора
Meta:
@arm admin
@tag component: маршрутные карты

Описание:
Чтобы настроить МК
Как администратор
Я хочу устанавливать периоды оформления и начала действия МК в АРМ Администратора

Сценарий: В АРМ Администратора возможно настраивать различные периоды для МК
Meta: @issue 11134

Изначально администратор находится на странице Маршрутные карты в АРМ Администратора
Если администратор изменит <Period> на <Duration> <Scaling>
То система сохранит новые настройки для выбранного <Period>

Примеры:
| Period                                                        | Duration           | Scaling |
| Максимальный период покупки МК                                | 1                  | Месяц   |
| Период оплаты в статусе Оформлена                             | 1                  | Час     |
| Время действия МК оформленной в Личный кабинет                | 2                  | Час     |
| Время действия МК оформленной в ТСО                           | 3                  | Час     |
| Время действия МК оформленной в Call-центр                    | 4                  | Час     |
| Время действия МК оформленной в МП                            | 5                  | Час     |
| Время действия МК оформленной в ЦИПП                          | 6                  | Час     |
| Время действия МК оформленной в QIWI                          | 7                  | Минута  |
| Период действия МК от даты/времени актиции                    | 3                  | Месяц   |
| Период отмены МК в статусе оплачена до даты времени активации | 1                  | День    |