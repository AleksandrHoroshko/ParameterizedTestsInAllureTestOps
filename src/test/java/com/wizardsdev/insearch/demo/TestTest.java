package com.wizardsdev.insearch.demo;

import io.qameta.allure.Allure;
import io.qameta.allure.Param;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestTest {

    @ParameterizedTest(name = "{displayName} ({argumentsWithNames})")
    @ValueSource(strings = {"a", "b"})
    void secondTest(@Param(name = "some value") String value) {
    }

    @ParameterizedTest(name = "Parameterized test with manually pushed parameter ({argumentsWithNames})")
    @ValueSource(strings = {"a", "b"})
    void thirdTest(String value) {
        Allure.parameter("Name of parameter", value);
    }

}
