package swb.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public interface ExplicitWait extends SearchScope {
	int TIMEOUT = 180;
	int POLLING_INTERVAL = 1000;
	
	
    default Element await(Supplier<By> by) {
        return await((SearchScope e) -> e.findElement(by));
    }

    default void await(Predicate<SearchScope> predicate) {
        await((Function<SearchScope, Boolean>) predicate::test);
    }

    default <T> T await(Function<SearchScope, T> function) {
        return new FluentWait<>(this)
            .withTimeout(TIMEOUT, SECONDS)
            .pollingEvery(POLLING_INTERVAL, MILLISECONDS)
            .ignoring(Exception.class)
            .until(
                (SearchScope where) -> function.apply(where)
            );
    }

    default String getText(Supplier<By> by) {
        return await(by).getText();
    }

    default String getUpperText(Supplier<By> by) {
        return await(by).getText().toUpperCase();
    }

    default void click(Supplier<By> by) {
        await(by).click();
    }
}
