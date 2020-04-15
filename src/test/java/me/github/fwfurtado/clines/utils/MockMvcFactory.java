package me.github.fwfurtado.clines.utils;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import me.github.fwfurtado.clines.infra.GlobalExceptionHandler;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public final class MockMvcFactory {
    private MockMvcFactory() {
    }

    public static void configureMvcContextBy(Object controller) {
        var mockMvc = standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler());

        RestAssuredMockMvc.standaloneSetup(mockMvc);
    }

}
