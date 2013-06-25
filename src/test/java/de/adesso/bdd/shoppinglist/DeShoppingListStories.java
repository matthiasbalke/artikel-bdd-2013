package de.adesso.bdd.shoppinglist;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.ConsoleOutput;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class DeShoppingListStories extends JUnitStories {

	@Override
	public Configuration configuration() {
		// @formatter:off

		// use German keywords for story files
		Keywords keywords = new LocalizedKeywords(Locale.GERMAN);

		Configuration configuration = new MostUsefulConfiguration()
				.useKeywords(keywords)
				.useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
				.useStoryParser(new RegexStoryParser(keywords))
				.useDefaultStoryReporter(new ConsoleOutput(keywords))
				.usePendingStepStrategy(new FailingUponPendingStep())

				// where to find the stories
				.useStoryLoader(new LoadFromClasspath(this.getClass()))

				// CONSOLE, HTML and XML reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder()
								.withDefaultFormats()
								.withFormats(Format.ANSI_CONSOLE, Format.HTML, Format.XML)
								.withKeywords(keywords));

		// @formatter:on
		return configuration;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(this.configuration(), new DeShoppingListAdd(), new DeShoppingListRemove());
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
				Arrays.asList("**/de_shopping_list*.story"), null);
	}

}
