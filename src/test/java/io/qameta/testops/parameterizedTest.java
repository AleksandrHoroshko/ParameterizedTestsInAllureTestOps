package io.qameta.testops;

import io.qameta.allure.Description;
import io.qameta.allure.Param;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.parameter;

public class parameterizedTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @Description("@Param(value = \"Title\", mode = Parameter.Mode.HIDDEN \n allows having a dymanic parameter in test, that is hidden from UI and \n" +
            "is not used the history ID calculations")
    @ParameterizedTest(name = "{displayName} ({argumentsWithNames})")
    @MethodSource("epochTimestamps")
    public void useCaseHiddenParameterTest(@Param("Title") long epochTimestamp) {
        Date date = new Date(epochTimestamp);
        String note = date.toString();

        parameter("note",note);
        parameter("owner",OWNER);
        parameter("repo",REPO);

        steps.createIssueWithTitle(OWNER, REPO, note);
        steps.closeIssueWithTitle(OWNER, REPO, note);

    }

    static Stream<Long> epochTimestamps() {
        long epochOne = System.currentTimeMillis();
        long epochTwo = System.currentTimeMillis() + 1000123;
        return Stream.of(epochOne, epochTwo);
    }



}
