Отмена маршрутных карт в АРМ ЦИПП
Meta:
@arm cpp
@tag component: маршрутные карты

Описание:
Чтобы вернуть ВТС денежные средства за ненужные МК
Как оператор ЦИПП
Я хочу иметь возможность отменять МК

Сценарий: Оператор может отменить неоплаченную МК для верифицированного ВТС
Meta:
@tag component: оповещения

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК по <Triger> для верифицированного ВТС
То система отменит МК
И отобразит ее со статусом Отменена в списке МК
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> о отмене МК

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

| Channels                 |
| ЛК (Web), Sms, E-mail    |

Сценарий: Оператор может отменить неоплаченную МК для не верифицированного ВТС
Meta:
@tag component: оповещения

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК по <Triger> для не верифицированного ВТС
То система отменит МК
И отобразит ее со статусом Отменена в списке МК
И ВТС придет уведомление в соответствии с выбранным каналом <Channels> о отмене МК

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

| Channels                 |
| ЛК (Web), Sms, E-mail    |

Сценарий: Оператор может отменить оплаченную с ЛС МК для верифицрованного ВТС
Meta:
@tag component: оповещения

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК, оплаченную с ЛС,  по <Triger> для верифицированного ВТС
То система отменит МК
И вернет стоимость МК на ЛС
И ВТС придет уведомления <Notification> в соответствии с выбранным каналом <Channels>

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

| Notification                                  | Channels                        |
| МК отменена                                   | ЛК (Web), Sms, E-mail           |
| Возврат средств на ЛС                         | ЛК (Web), Sms, E-mail           |

Сценарий: Оператор может отменить оплаченную банковской картой МК для верифицрованного ВТС
Meta:
@tag component: оповещения

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК, оплаченную банковской картой,  по <Triger> для верифицированного ВТС
То система отменит МК
И вернет стоимость МК на ЛС
И ВТС придет уведомления <Notification> в соответствии с выбранным каналом <Channels>

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

| Notification                                  | Channels                        |
| МК отменена                                   | ЛК (Web), Sms, E-mail           |
| Возврат средств на ЛС                         | ЛК (Web), Sms, E-mail           |

Сценарий: Оператор может отменить оплаченную с ЛС МК для не верифицрованного ВТС
Meta:
@tag component: оповещения

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК, оплаченную с ЛС,  по <Triger> для не верифицированного ВТС
То система отменит МК
И вернет стоимость МК на ЛС
И ВТС придет уведомления <Notification> в соответствии с выбранным каналом <Channels>

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

| Notification                                  | Channels                        |
| МК отменена                                   | ЛК (Web), Sms, E-mail           |
| Возврат средств на ЛС                         | ЛК (Web), Sms, E-mail           |

Сценарий: Оператор может отменить оплаченную банковской картой МК для не верифицрованного ВТС
Meta:
@tag component: оповещения

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК, оплаченную банковской картой,  по <Triger> для не верифицированного ВТС
То система отменит МК
И вернет стоимость МК на ЛС
И ВТС придет уведомления <Notification> в соответствии с выбранным каналом <Channels>

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

| Notification                                  | Channels                        |
| МК отменена                                   | ЛК (Web), Sms, E-mail           |
| Возврат средств на ЛС                         | ЛК (Web), Sms, E-mail           |

Сценарий: Оператор не может отменить оплаченную МК с истекшим периодом действия

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК по <Triger> с истекшим периодом действия
То система отобразит сообщение о невозможности отмены МК

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

Сценарий: Оператор может отменить активированную МК  для верифицированного ВТС
Meta:
@tag component: оповещения

Изначально оператор находится на странице Отмена МК
Если оператор отменит МК по <Triger> для верифицированного ВТС
То система отменит МК
И отобразит ее со статусом Отменена в списке МК
И вернет стоимость МК на ЛС
И ВТС придет уведомления <Notification> в соответствии с выбранным каналом <Channels>

Примеры:
| Triger    |
| Номеру МК |
| ГРЗ       |

| Notification                                  | Channels                        |
| МК отменена                                   | ЛК (Web), Sms, E-mail           |
| Возврат средств на ЛС                         | ЛК (Web), Sms, E-mail           |

