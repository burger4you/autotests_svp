package ru.progresspoint.svp12;

import net.thucydides.core.steps.ScenarioSteps;
import org.joda.time.DateTime;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.capitalize;

/**
 * Вспомогательный класс для генерации случайных строк
 */
public class RandomGenerators extends ScenarioSteps {

    final Random randomNum = new Random();

    /**
     * Генератор случайного слова на латиннице
     *
     * @param count - количество символов в результате
     * @return - случайное слово на латиннице в LowerCase формате
     */
    public String getRandomAlphabeticString(int count) {
        return randomAlphabetic(count).toLowerCase();
    }

    /**
     * Генератор случайного слова на кириллице
     *
     * @param count - количество символов в результате
     * @return - случайное слово на кириллице в ProperCase формате
     */
    public String getRandomCyrillicProperString(int count) {
        String result = random(count, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        return capitalize(result);
    }

    /**
     * Генератор случайного слова из цифр от 1 до 9
     *
     * @param count - количество цифр в результате
     * @return - случайное слово состоящие из цифр
     */
    public String getRandomNumber(int count) {
        String result = "";
        for (int i = 0; i < count; i++) result += String.valueOf(randomNum.nextInt(9)+1);
        return result;
    }

    /**
     * Генератор случайной даты
     *
     * @return - случайная дата между 1940 и 2015 годом
     */
    public String getRandomDate() {

        DateTime date;
        long ms;

        // Получить значение Epoch между 1940 и 2015:
        // -946771200000L = 1 января, 1940
        // прибавить к этому 75 лет
        ms = -946771200000L + (Math.abs(randomNum.nextLong()) % (75L * 365 * 24 * 60 * 60 * 1000));

        // Собрать дату
        date = new DateTime(ms);
        return String.valueOf(date.toString("dd.MM.yyyy"));
    }
}
