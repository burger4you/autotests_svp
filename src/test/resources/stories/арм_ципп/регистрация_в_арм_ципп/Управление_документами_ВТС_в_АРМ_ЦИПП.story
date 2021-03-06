Управление документами ВТС в АРМ ЦИПП
Meta:
@arm cpp
@tag component: registration

Описание:
Чтобы задокументировать оформление ВТС в системе СВП
Как оператор ЦИПП
Я хочу иметь возможность управлять документами, необходимыми для регистрации

Сценарий: Оператор может загрузить регистрационные документы ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он подгрузит для соответствующего типа ВТС <Tip_VTS> необходимые документы <Documents>
То система сохранит документы
И отобразит в списке документов ВТС количество страниц и место хранения каждого документа

| Tip_VTS       | Documents                                                                                                                                                                                                                                                                                                                                                             |
| Физ.лицо РФ   | Документ, подтверждающий полномочия лица на подписание договора                                                                                                                                                                                                                                                                                                       |
| Юр.лицо РФ    | Свидетельство о государственной регистрации, Свидетельство о постановке на налоговый учет, Устав (2 страница), Выписка из ЕГРЮЛ, Документ, подтверждающий полномочия лица на подписание договора                                                                                                                                                                      |
| ИП РФ         | Свидетельство о государственной регистрации, Свидетельство о постановке на налоговый учет, Выписка из ЕГРЮЛ, Документ, подтверждающий полномочия лица на подписание договора                                                                                                                                                                                          |
| Физ.лицо НеРФ | Документ, подтверждающий полномочия лица на подписание договора                                                                                                                                                                                                                                                                                                       |
| Юр.лицо НеРФ  | Справка налогового органа страны происхождения о регистрации, Свидетельство о постановке на учет в налоговом органе РФ, Положение о филиале/представительсве (при наличии в РФ), Выписка из реестра иностранных юридических лиц, Свидетельство о государственной регистрации иностранной организации, Документ, подтверждающий полномочия лица на подписание договора |

Сценарий: Оператор можеть распечатать бланк Заявления на регистрацию с реквизитами ВТС

Изначально Оператор находится на станице Управление документами ВТС
Если он нажмет кнопку Печать напротив строки Заявление на регистрацию и выберет подписанта
То система выведет на печать Заявление на регистрацию с реквизитами ВТС

Сценарий: Оператор может загрузить скан-копию Заявления на регистрацию с реквизитами ВТС

Изначально Оператор находится на станице Управление документами ВТС
Если он нажмет кнопку Загрузить напротив строки Заявление на регистрацию и приложит скан-копию подписанного Заявления на регистрацию
То система сохранит скан-копию подписанного Заявления на регистрацию с реквизитами ВТС


Сценарий: Оператор можеть распечатать бланк Заявления на открытие лицевого счета с реквизитами ВТС на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Печать напротив строки Заявление на открытие лицевого счета и выберет подписанта
То система выведет на печать Заявления на открытие лицевого счета с реквизитами ВТС

Сценарий: Оператор может загрузить скан-копию Заявления на открытие лицевого счета с реквизитами ВТС на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Загрузить напротив строки Заявление на открытие лицевого счета и приложит скан-копию подписанного Заявления на открытие лицевого счета
То система сохранит скан-копию подписанного Заявления на открытие лицевого счета с реквизитами ВТС

Сценарий: После загрузки Заявления на открытие лицевого счета с реквизитами ВТС его можно открыть на просмотр на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Просмотр напротив строки Заявление на открытие лицевого счета
То система выведет на экран скан-копию подписанного Заявления на открытие лицевого счета с реквизитами ВТС

Сценарий: После загрузки Заявления на открытие лицевого счета с реквизитами ВТС его можно удалить на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Удалить напротив строки Заявление на открытие лицевого счета
То система удалит загруженную скан-копию подписанного Заявления на открытие лицевого счета с реквизитами ВТС

Сценарий: Оператор можеть распечатать бланк Заявления на закрытие лицевого счета с реквизитами ВТС на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Печать напротив строки Заявление на закрытие лицевого счета и выберет подписанта
То система выведет на печать Заявление на закрытие лицевого счета с реквизитами ВТС

Сценарий: Оператор может загрузить скан-копию Заявления на закрытие лицевого счета с реквизитами ВТС на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Загрузить напротив строки Заявление на закрытие лицевого счета и приложит скан-копию подписанного Заявления на закрытие лицевого счета
То система сохранит скан-копию подписанного Заявление на закрытие лицевого счета с реквизитами ВТС

Сценарий: После загрузки Заявления на закрытие лицевого счета с реквизитами ВТС его можно открыть на просмотр на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Просмотр напротив строки Заявление на закрытие лицевого счета
То система выведет на экран скан-копию подписанного Заявления на закрытие лицевого счета с реквизитами ВТС

Сценарий: После загрузки Заявления на закрытие лицевого счета с реквизитами ВТС его можно удалить на странице Управление документами ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Удалить напротив строки Заявление на закрытие лицевого счета
То система удалит загруженную скан-копию подписанного Заявления на закрытие лицевого счета с реквизитами ВТС