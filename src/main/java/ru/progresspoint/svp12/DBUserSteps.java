package ru.progresspoint.svp12;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.sql.*;

import static java.lang.String.format;
import static java.sql.DriverManager.getConnection;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Шаги пользователя системы ПО СВП при работе с базой данных
 */
public class DBUserSteps extends ScenarioSteps {

    // Продакшн зона

//    private static final String URL = "jdbc:postgresql://tvr1-pgm-svp-01.svp.prod/svp";
//    private static final String USER = "svp";
//    private static final String PASSWORD = "test3";

    //Тестовая зона

    private static final String URL = "jdbc:postgresql://tvr1-pgm-svp-01.svp.test/svp";
    private static final String USER = "svp";
    private static final String PASSWORD = "9gynsyfNpZ9jTQ==";


    @Step("Видит свежую запись в таблице appeals со значениями user_id {0} и client_id {1}")
    public void shouldSeeRecordInAppealsTableWith(int user_id, int client_id) throws SQLException {
        // Подключаемся к БД
        Connection dbh = getConnection(URL, USER, PASSWORD);
        // Подготавливаем запрос с переменными, отдающий количество требуемых записей в таблице
        PreparedStatement st = dbh.prepareStatement(
                        "SELECT COUNT(*) " +
                        "FROM appeals " +
                        "WHERE user_id = ? " +
                        "AND client_id = ? " +
                        "AND appeal_source_id = 1 " +
                        "AND created_at > CURRENT_TIMESTAMP - INTERVAL '3 hours' - INTERVAL '4 minutes'");
        // Подставляем переменные для конкретного кейса
        st.setInt(1, user_id);
        st.setInt(2, client_id);
        // Выполняем запрос
        ResultSet rs = st.executeQuery();
        // Переходим на первую строку таблицы результатов
        rs.next();
        // Узнаем количество записей в таблице результатов.
        int rowCount = rs.getInt(1);
        // Закрываем сессию
        rs.close();
        st.close();
        // И проверяем, что хотя бы одна запись есть в БД удовлетворяющая условиям запроса
        assertThat(rowCount)
                .overridingErrorMessage(format("В таблице appeals нет записей с user_id = %d и client_id = %d за последние пару минут", user_id, client_id))
                .isGreaterThan(0);
    }
}