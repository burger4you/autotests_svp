package ru.progresspoint.svp12;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterConverters;

import java.util.Locale;

/**
 * Запускает ВСЕ истории пользователя. Определяет конфигурацию для JBehave и Serenity в которой
 * задаются следующие настройки:
 * <ul>
 * <li>Локализованные на русский язык ключевые слова для историй JBehave</li>
 * </ul>
 * <ul>
 * <li>Возможность парсить тестовые данные из внешних источников
 * </ul>
 */
public class UserStoriesRunner extends SerenityStories {

    public static Configuration withRussianKeywords(Configuration cfg) {
        LocalizedKeywords keywords = new LocalizedKeywords(new Locale("ru"));
        return cfg
                .useKeywords(keywords)
                .useStoryParser(new RegexStoryParser(keywords))
                .useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
//                .useDefaultStoryReporter(new ConsoleOutput(keywords))
                .useParameterConverters(
                        cfg.parameterConverters().addConverters(
                                new ParameterConverters.ExamplesTableConverter(new ExamplesTableFactory(keywords))))
                .useStoryReporterBuilder(cfg.storyReporterBuilder().withKeywords(keywords));
    }

    /**
     * Режим "Parametrisation by name delimiters" позволяет параметризовывать одни и те же шаги различными аргументами
     * из таблиц примеров. А также инлайновыми аргументами. Этот режим решает проблему, описанную в
     * http://jira.codehaus.org/browse/JBEHAVE-981. В JBehave 4 этот режим будет включен по умолчанию. Активируем режим
     * для всех историй. Подробнее о режиме см. http://jbehave.org/reference/stable/parametrised-scenarios.html.
     */
    public static Configuration withParametrisationByNameDelimiters(Configuration cfg) {
        return cfg.useParameterControls(cfg.parameterControls().useDelimiterNamedParameters(true));
    }

    @Override
    public Configuration configuration() {
        return withParametrisationByNameDelimiters(withRussianKeywords(super.configuration()));
    }
}