package de.adesso.bdd.shoppinglist;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class EnShoppingListStories extends JUnitStories {

	@Override
	public Configuration configuration() {
		// @formatter:off

		return new MostUsefulConfiguration()
				.usePendingStepStrategy(new FailingUponPendingStep())
				// where to find the stories
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				// CONSOLE, HTML and XML reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
								.withFormats(Format.ANSI_CONSOLE, Format.HTML, Format.XML));
		// @formatter:on
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(this.configuration(), new EnShoppingListAdd(), new EnShoppingListRemove());
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
				Arrays.asList("**/en_shopping_*.story"), null);
	}

}
