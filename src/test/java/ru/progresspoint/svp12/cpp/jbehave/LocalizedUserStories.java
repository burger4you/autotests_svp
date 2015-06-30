package ru.progresspoint.svp12.cpp.jbehave;

import net.serenitybdd.jbehave.SerenityReporter;
import net.serenitybdd.jbehave.SerenityStepFactory;
import net.serenitybdd.jbehave.SerenityStories;
import net.serenitybdd.jbehave.UTF8StoryLoader;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.jbehave.core.reporters.Format.*;

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

    private static final CrossReference xref = new CrossReference();
    private List<Format> formats = Arrays.asList(CONSOLE, HTML, XML);

    public Configuration ruConfiguration() {
        Keywords keywords = new LocalizedKeywords(new Locale("ru"));
        return configuration()
                .useKeywords(keywords)
                .useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
                .useStoryParser(
                        new RegexStoryParser(
                                keywords,
                                new ExamplesTableFactory(
                                        new LoadFromClasspath(this.getClass()))))
                .useDefaultStoryReporter(
                        new ConsoleOutput(keywords))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withKeywords(keywords)
                                .withMultiThreading(true)
                                .withDefaultFormats()
                                .withFormats((Format[]) formats.toArray())
                                .withCrossReference(xref)
                                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                                .withFailureTrace(true).withFailureTraceCompression(true)
                                .withReporters(new SerenityReporter(getSystemConfiguration())))
                .useStoryLoader(new UTF8StoryLoader())
                .useParameterConverters(
                        new ParameterConverters()
                                .addConverters(new ParameterConverters.ExamplesTableConverter(new ExamplesTableFactory(keywords))))
                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return SerenityStepFactory.withStepsFromPackage(rootPackage(), ruConfiguration()).andClassLoader(getClassLoader());
    }

    protected abstract String rootPackage();
}
