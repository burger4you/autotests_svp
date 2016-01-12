package ru.progresspoint.svp12;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;

import javax.mail.*;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.SearchTerm;
import java.io.IOException;
import java.util.Properties;

import static java.lang.String.valueOf;
import static javax.mail.Flags.Flag;
import static javax.mail.Folder.READ_ONLY;
import static javax.mail.Folder.READ_WRITE;
import static net.serenitybdd.core.Serenity.getCurrentSession;


/**
 * Шаги пользователя системы ПО СВП при работе с электронной почтой
 */
public class EmailUserSteps extends ScenarioSteps {

    private static final long serialVersionUID = 7L;
    private static final String NO_REPLY_PLATON_RU = "no-reply@platon.ru";
    private static final String NO_REPLY_SVP12_RU = "noreply@svp12.ru";
    private static final String PROTOCOL_PROP = "mail.store.protocol";

    /** Продакшн зона (Gmail) **/

//    private static final String PROTOCOL_TYPE = "imaps";
//    private static final String IMAP = "imap.gmail.com";
//    private static final String PASSWORD = "GameAtPlay";
//    private static final String INBOX = "inbox";
//    private static final String URL_LK = "http://lk.platon.ru";

    /** Тестовая зона **/

    private static final String PROTOCOL_TYPE = "imap";
    private static final String IMAP = "svp-mail.svp.test";
    private static final String PASSWORD = "test3";
    private static final String INBOX = "inbox";
    private static final String URL_LK = "http://lk.12tons.ru";

    private Properties props;
    private Session session;
    private Store store;
    private Folder folder;
    private Message[] messages;

    @Step("Получает письмо на {0} с уведомлением {1}")
    public void waitsForEmailWithNotification(String emailBox, String notification) throws IOException, MessagingException {
        waitABit(5000);
        // Устанавливаем протокол
        props = new Properties();
        props.setProperty(PROTOCOL_PROP, PROTOCOL_TYPE);
        // Получаем сессию
        session = Session.getInstance(props, null);
        // Получаем место в сессии
        store = session.getStore();
        // Коннектимся к ящику
        store.connect(IMAP, emailBox.replaceAll("@\\S+", ""), PASSWORD);
        // В ящике ищмем папку "Входящие"
        folder = store.getFolder(INBOX);
        // Открываем папку в режиме чтения
        if (!folder.isOpen()) folder.open(READ_ONLY);
        // Нас интересуют письма от системы ПО СВП
        SearchTerm totalTerm = new FromStringTerm(NO_REPLY_SVP12_RU);
        // Которые еще не прочитаны
        FlagTerm flagSeen = new FlagTerm(new Flags(Flag.SEEN), false);
        // Объединяем эти параметры и ищем нужные письма
        totalTerm = new AndTerm(flagSeen, totalTerm);
        messages = folder.search(totalTerm);
        // Берем последнее письмо
        Message message = folder.getMessage(1);
//        // И парсим его
//        Multipart multipart = (Multipart) message.getContent();
//        // В данном случае, нам важно тело письма
//        BodyPart bodyPart = multipart.getBodyPart(0);
//        // Форматируем его в текст
//        String fullText = bodyPart.getContent().toString();
        // Берем текст письма
        String fullText = valueOf(message.getContent());
        // И запоминаем его
        getCurrentSession().put("notificationText", fullText);
        Assertions.assertThat(fullText).isEqualTo(notification);
    }

    @Step("Получает письмо на {0} со ссылкой на завершение регистрации")
    public void waitsForEmailWithConfirmationLink(String emailBox) throws IOException, MessagingException {
        waitABit(5000);
        // Устанавливаем протокол
        props = new Properties();
        props.setProperty(PROTOCOL_PROP, PROTOCOL_TYPE);
        // Получаем сессию
        session = Session.getInstance(props, null);
        // Получаем место в сессии
        store = session.getStore();
        // Коннектимся к ящику
        store.connect(IMAP, emailBox.replaceAll("@\\S+", ""), PASSWORD);
        // В ящике ищмем папку "Входящие"
        folder = store.getFolder(INBOX);
        // Открываем папку в режиме чтения
        if (!folder.isOpen()) folder.open(READ_ONLY);
        // Нас интересуют письма от системы ПО СВП
        SearchTerm totalTerm = new FromStringTerm(NO_REPLY_PLATON_RU);
        // Которые еще не прочитаны
        FlagTerm flagSeen = new FlagTerm(new Flags(Flag.SEEN), false);
        // Объединяем эти параметры и ищем нужные письма
        totalTerm = new AndTerm(flagSeen, totalTerm);
        messages = folder.search(totalTerm);
        // Берем последнее письмо
        Message message = folder.getMessage(1);
//        // И парсим его
//        Multipart multipart = (Multipart) message.getContent();
//        // В данном случае, нам важно тело письма
//        BodyPart bodyPart = multipart.getBodyPart(0);
//        // Форматируем его в текст
//        String fullText = bodyPart.getContent().toString();
        String fullText = valueOf(message.getContent());
        // И колдуем: делим тело письма на 2 части (до ссылки и после)
        String[] array = fullText.split("\"" + URL_LK + "/\\S+\"");
        // Что бы потом удалить их из общего текста и оставить нужную нам урлу.
        String url = fullText.replace(valueOf(array[0] + "\""), "").replace(valueOf("\"" + array[1]), "");
        // Которую и запоминаем
        getCurrentSession().put("linkFromEmail", url);
    }

    @Step("Удаляет все письма в {0} от системы Платон")
    public void deletesAllMessagesFromPlaton(String emailBox) throws MessagingException {
        // Все по старой схеме
        props = new Properties();
        props.setProperty(PROTOCOL_PROP, PROTOCOL_TYPE);
        session = Session.getInstance(props, null);
        store = session.getStore();
        store.connect(IMAP, emailBox.replaceAll("@\\S+", ""), PASSWORD);
        folder = store.getFolder(INBOX);
        // Единственное, что папку входящих необходимо открыть в режиме редактирования
        if (folder.isOpen()) folder.close(true);
        folder.open(READ_WRITE);
        // Находим все письма от системы ПО СВП
        SearchTerm totalTerm = new FromStringTerm(NO_REPLY_PLATON_RU);
        messages = folder.search(totalTerm);
        // Выставляем им флаги на удаление
        for (Message message : messages) message.setFlag(Flag.DELETED, true);
        // И закрываем папку с параметром true, как раз для того, что бы письма с флагами удалились
        folder.close(true);
        store.close();
    }

    @Step("Переходит по ссылке из письма")
    public void clicksToLinkFromEmail() {
        String url = (String) Serenity.getCurrentSession().get("linkFromEmail");
        getDriver().get(url);
    }

    @Step("Получает письмо с историей подачи и обработки всех обращений данного пользователя")
    public void waitsForEmailWithAppealsHistory() {
    }

    @Step("Получает письмо на {0} со ссылкой на личный кабинет, для установки пароля")
    public void waitsForEmailWithSetLKPasswordLink(String emailBox) throws IOException, MessagingException {
        // Немного ждем
        waitABit(5000);
        // Устанавливаем протокол
        props = new Properties();
        props.setProperty(PROTOCOL_PROP, PROTOCOL_TYPE);
        // Получаем сессию
        session = Session.getInstance(props, null);
        // Получаем место в сессии
        store = session.getStore();
        // Коннектимся к ящику
        store.connect(IMAP, emailBox.replaceAll("@\\S+", ""), PASSWORD);
        // В ящике ищмем папку "Входящие"
        folder = store.getFolder(INBOX);
        // Открываем папку в режиме чтения
        if (!folder.isOpen()) folder.open(READ_ONLY);
        // Нас интересуют письма от системы ПО СВП
        SearchTerm totalTerm = new FromStringTerm(NO_REPLY_PLATON_RU);
        // Которые еще не прочитаны
        FlagTerm flagSeen = new FlagTerm(new Flags(Flag.SEEN), false);
        // Объединяем эти параметры и ищем нужные письма
        totalTerm = new AndTerm(flagSeen, totalTerm);
        messages = folder.search(totalTerm);
        // Берем последнее письмо
        Message message = folder.getMessage(1);
        // Достаем из него текст
        String fullText = valueOf(message.getContent());
        // И колдуем: делим тело письма на 2 части (до ссылки и после)
        String[] array = fullText.split("\"" + URL_LK + "/\\S+\"");
        // Что бы потом удалить их из общего текста и оставить нужную нам урлу.
        String url = fullText.replace(valueOf(array[0] + "\""), "").replace(valueOf("\"" + array[1]), "");
        // Которую и запоминаем
        getCurrentSession().put("linkFromEmail", url);
    }

    @Step("Удаляет все письма в {0} от системы СВП 12")
    public void deletesAllMessagesFromSVP12(String emailBox) throws MessagingException {
        // Все по старой схеме
        props = new Properties();
        props.setProperty(PROTOCOL_PROP, PROTOCOL_TYPE);
        session = Session.getInstance(props, null);
        store = session.getStore();
        store.connect(IMAP, emailBox.replaceAll("@\\S+", ""), PASSWORD);
        folder = store.getFolder(INBOX);
        // Единственное, что папку входящих необходимо открыть в режиме редактирования
        if (folder.isOpen()) folder.close(true);
        folder.open(READ_WRITE);
        // Находим все письма от системы ПО СВП
        SearchTerm totalTerm = new FromStringTerm(NO_REPLY_SVP12_RU);
        messages = folder.search(totalTerm);
        // Выставляем им флаги на удаление
        for (Message message : messages) message.setFlag(Flag.DELETED, true);
        // И закрываем папку с параметром true, как раз для того, что бы письма с флагами удалились
        folder.close(true);
        store.close();
    }
}