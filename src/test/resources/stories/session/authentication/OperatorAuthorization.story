Авторизация оператора

Narrative:
In order to работать с системой "Платон" под своим логином
As a оператор
I want to при входе проходить авторизацию

Scenario:
Для входа в систему необходимо ввести логин и пароль
Given оператор находится на странице "Авторизация"
When он вводит логин admin_cpp@svp12.ru и пароль test для авторизации
Then открывается страница "Заключить новый договор"