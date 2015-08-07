package ru.progresspoint.svp12;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import javax.mail.*;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.SearchTerm;
import java.io.IOException;
import java.util.Properties;

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
    private static final String PROTOCOL = "mail.store.protocol";
    private static final String IMAPS = "imaps";
    private static final String GMAIL = "imap.gmail.com";
    private static final String PASSWORD = "GameAtPlay";
    private static final String INBOX = "inbox";
    private Properties props;
    private Session session;
    private Store store;
    private Folder folder;
    private Message[] messages;

    /**
     * Получает письмо со ссылкой на завершение регистрации
     *
     * @param gmailBox - адрес почтового ящика на gmail
     * @throws MessagingException
     * @throws IOException
     */
    @Step("Получает письмо со ссылкой на завершение регистрации")
    public void waitsForEmailWithConfirmationLink(String gmailBox) throws IOException, MessagingException {
        waitABit(5000);
        // Устанавливаем протокол
        props = new Properties();
        props.setProperty(PROTOCOL, IMAPS);
        // Получаем сессию
        session = Session.getInstance(props, null);
        // Получаем место в сессии
        store = session.getStore();
        // Коннектимся к ящику
        store.connect(GMAIL, gmailBox, PASSWORD);
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
        String fullText = (String) message.getContent();
        // И колдуем: делим тело письма на 2 части (до ссылки и после)
        String[] array = fullText.split("http://10.0.12.225/\\S+"); //http://10.0.12.225/\S+  </div><p>
        // Что бы потом удалить их из общего текста и оставить нужную нам урлу.
        String url = fullText.replace(String.valueOf(array[0]), "").replace(String.valueOf("</div><p>С"+array[1]), "");
        // Которую и запоминаем
        getCurrentSession().put("confirmationLink", url);
    }

    /**
     * Удаляет все письма от системы Платон
     *
     * @param gmailBox - адрес почтового ящика
     * @throws MessagingException
     */
    @Step("Удаляет все письма от системы Платон")
    public void deletesAllMessagesFromProgresspoint(String gmailBox) throws MessagingException {
        // Все по старой схеме
        props = new Properties();
        props.setProperty(PROTOCOL, IMAPS);
        session = Session.getInstance(props, null);
        store = session.getStore();
        store.connect(GMAIL, gmailBox, PASSWORD);
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
    public void clicksToConfirmationLink() {
        String url = (String) Serenity.getCurrentSession().get("confirmationLink");
        getDriver().get(url);
    }

    @Step("Получает письмо с историей подачи и обработки всех обращений данного пользователя")
    public void waitsForEmailWithVAppealsHistory() {
    }
}