Авторизация пользователя в АРМ Личный Кабинет
Meta:
@arm lk
@tag component: авторизация

Описание:
Чтобы войти в Личный Кабинет
Как владелец ТС
Я хочу при входе в АРМ ЛК пройти авторизацию

Сценарий: Для входа в АРМ ЛК владельцу ТС с необходимыми правами необходимо ввести логин и пароль

Изначально владелец ТС находится на странице Авторизации в АРМ ЛК
Если владелец ТС введет логин и пароль соответствующей роли для авторизации в ЛК
То система предоставит доступ к личному кабинету пользователя с необходимыми правами

Примеры:
| Тип ВТС       | Роль                                              |
| Физ.лицо РФ   | Главный менеджер, Менеджер ЛС, Менеджер группы ТС |
| Юр.лицо РФ    | Главный менеджер, Менеджер ЛС, Менеджер группы ТС |
| ИП РФ         | Главный менеджер, Менеджер ЛС, Менеджер группы ТС |
| Физ.лицо НеРФ | Главный менеджер, Менеджер ЛС, Менеджер группы ТС |
| Юр.лицо НеРФ  | Главный менеджер, Менеджер ЛС, Менеджер группы ТС |

Сценарий: После введения неверных данных для входа в АРМ ЛК 5 раз и более, учетная запись блокируется на 5 минут

Изначально владелец ТС находится на странице Авторизации в АРМ ЛК
Если владелец ТС введет логин и пароль для авторизации в ЛК неверно 5 раз подряд
То система отобразит сообщение "Ваша учетная запись заблокирована на 5 минут"

Сценарий: Владелец ТС может восстановить забытый пароль для доступа в АРМ ЛК

Изначально владелец ТС находится на странице Авторизации в АРМ ЛК
Если владелец ТС нажмет кнопку "Забыли пароль?" и введет e-mail
То на указанный e-mail система вышлет сообщение со ссылкой для восстановления пароля