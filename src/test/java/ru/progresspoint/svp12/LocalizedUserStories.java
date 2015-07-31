package ru.progresspoint.svp12;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterConverters;

import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

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
public abstract class LocalizedUserStories extends SerenityStories {

    public Configuration withRussianKeywords(Configuration configuration) {
        Keywords keywords = new LocalizedKeywords(locale());
        return configuration
                .useKeywords(keywords)
                .useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
                .useStoryParser(new RegexStoryParser(keywords, new ExamplesTableFactory(new LoadFromClasspath(this.getClass()))))
//                .useDefaultStoryReporter(new ConsoleOutput(keywords))
                .useStoryReporterBuilder(configuration.storyReporterBuilder()
                        .withKeywords(keywords))
                .useParameterConverters(
                        configuration.parameterConverters()
                                .addConverters(new ParameterConverters.ExamplesTableConverter(new ExamplesTableFactory(keywords))))
                .useParameterControls(configuration.parameterControls().useDelimiterNamedParameters(true));

    }

    @Override
    public Configuration configuration() {
        return withRussianKeywords(super.configuration());
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(), asList(storyPattern()), null);
    }

    protected abstract Locale locale();

    protected abstract String storyPattern();
}