package ru.progresspoint.svp12;

import java.util.Locale;

public class RuUserStories extends LocalizedUserStories {
    @Override
    protected Locale locale() {
        return new Locale("i18n/keywords_ru");
    }

    @Override
    protected String storyPattern() {
        return "**/*.story";
    }
}
