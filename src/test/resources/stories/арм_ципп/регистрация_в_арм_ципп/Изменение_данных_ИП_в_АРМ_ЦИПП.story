Изменение данных ИП в АРМ ЦИПП
Meta:
@arm cpp
@tag component: registration

Описание:
Чтобы контролировать акутальность данных в системе ПО СВП
Как оператор ЦИПП
Я хочу иметь возможность изменять регистрационные данные индивидуального предпринимателя

Сценарий: При изменении регистрационных данных ИП в системе поля ОГРН и ИНН недоступны для изменения

Изначально оператор находится на странице Измененение регистрационных данных ВТС в АРМ ЦИПП
Если оператор попытается изменить ОГРН или ИНН ВТС
То он увидит, что эти поля недоступны для изменения(read only)

Сценарий: При изменении регистрационных данных ИП в системе сохранятся новые данные ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Измененение регистрационных данных ВТС в АРМ ЦИПП
Если оператор изменит адрес ВТС
И приложит скан-копию документа-основания для изменения данных
То на странице Информация о ВТС отобразится ВТС с новым адресом
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об изменении данных ВТС

Сценарий: После изменения регистрационных данных ВТС Оператор может распечатать бланк документа для обоснования изменения данных ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Печать напротив строки Документ-основание для изменения данных ВТС и выберет подписанта
То система выведет на печать бланк Документа-основания для изменения данных ВТС с заполненными рекивзитами

Сценарий: После изменения регистрационных данных ВТС Оператор может загрузить документ для обоснования изменения данных ВТС

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Загрузить напротив строки Документ-основание для изменения данных ВТС и приложит скан-копию подписанного Документа-основания для изменения данных ВТС
То система сохранит скан-копию подписанного Документа-основания для изменения данных ВТС

Сценарий: После загрузки документа для обоснования изменения данных ВТС его можно открыть на просмотр

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Просмотр напротив строки Документ-основание для изменения данных ВТС
То система выведет на экран скан-копию подписанного Документа-основания для изменения данных ВТС

Сценарий: После загрузки документа для обоснования изменения данных ВТС его можно удалить

Изначально Оператор находится на странице Управление документами ВТС
Если он нажмет кнопку Удалить напротив строки Документ-основание для изменения данных ВТС
То система удалит загруженную скан-копию подписанного Документа-основания для изменения данных ВТС