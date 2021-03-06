Оплата маршрутных карт в АРМ ЦИПП
Meta:
@arm cpp
@tag component: route maps

Описание:
Чтобы принимать оплату маршрутных карт ВТС
Как оператор ЦИПП
Я хочу снимать ДС со счета ВТС или его банковской карты в АРМ ЦИПП

Сценарий: Оператор не может оплатить МК при недостаточном балансе ЛС

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное ТС
И выберет оплату с ЛС при недостаточном балансе
То система отобразит сообщение о недостаточности средств на ЛС

Сценарий: Оператор может оплатить МК при достаточном балансе ЛС для верифицированного ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное ТС верифицированного ВТС
И выберет оплату с ЛС при достаточном балансе
То МК отобразится со статусом Оплачена
И баланс ЛС уменьшится на стоимость МК
И ВТС придет уведомление об оплате МК в соответствии с выбранным каналом <Channels>

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |

Сценарий: Оператор может оплатить МК при достаточном балансе ЛС для не верифицированного ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное ТС не верифицированного ВТС
И выберет оплату с ЛС при достаточном балансе
То МК отобразится со статусом Оплачена
То баланс ЛС уменьшится на стоимость МК
И ВТС придет уведомление об оплате МК в соответствии с выбранным каналом <Channels>

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |

Сценарий: Оператор не может оплатить МК при превышении лимита по группе
Meta: @tag component: notifications

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления
И выберет ТС входящие в группу, которая за текущий месяц наездила на "Лимит в месяц" установленный в АРМ ЛК
И нажмет оплатить
То система отобразит сообщение о превышение порога списания с ЛС
И ВТС придет уведомление об оплате МК в соответствии с выбранным каналом <Channels>

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |

Сценарий: Оператор может оплатить МК банковской картой для верифицированного ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное ТС верифицированного ВТС
И выберет оплату Банковской картой
То МК отобразится со статусом Оплачена
И ВТС придет уведомление об оплате МК в соответствии с выбранным каналом <Channels>

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |

Сценарий: Оператор может оплатить МК банковской картой для не верифицированного ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оформление МК
Если оператор заполнит данные МК для оформления на конкретное ТС не верифицированного ВТС
И выберет оплату Банковской картой
То МК отобразится со статусом Оплачена
И ВТС придет уведомлениеоб оплате МК в соответствии с выбранным каналом <Channels>

Примеры:
| Channels              |
| ЛК (Web), Sms, E-mail |

Сценарий: Оператор может оплатить МК банковской картой для верифицированного ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оплатить маршрутную карту
Если оператор будет искать МК у которой статус оформлена по <Triger> верифицированного ВТС
И выберет оплату Банковской картой
То МК отобразится со статусом Оплачена
И ВТС придет уведомление об оплате МК в соответствии с выбранным каналом <Channels>

Примеры:
| Triger    | Channels              |
| Номеру МК | ЛК (Web), Sms, E-mail |
| ГРЗ       | ЛК (Web), Sms, E-mail |

Сценарий: Оператор может оплатить МК при достаточном балансе ЛС для верифицированного ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оплатить маршрутную карту
Если оператор будет искать МК у которой статус оформлена по <Triger> верифицированного ВТС
И выберет оплату с ЛС при достаточном балансе
То МК отобразится со статусом Оплачена
И ВТС придет уведомление об оплате МК в соответствии с выбранным каналом <Channels>

Примеры:
| Triger    | Channels              |
| Номеру МК | ЛК (Web), Sms, E-mail |
| ГРЗ       | ЛК (Web), Sms, E-mail |

Сценарий: Оператор может оплатить МК через интернет платеж для верифицированного ВТС
Meta: @tag component: notifications

Изначально оператор находится на странице Оплатить маршрутную карту
Если оператор будет искать МК у которой статус оформлена по <Triger> верифицированного ВТС
И выберет оплату через интернет платеж
То МК отобразится со статусом Оплачена
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> об оплате МК

Примеры:
| Triger    | Channels              |
| Номеру МК | ЛК (Web), Sms, E-mail |
| ГРЗ       | ЛК (Web), Sms, E-mail |