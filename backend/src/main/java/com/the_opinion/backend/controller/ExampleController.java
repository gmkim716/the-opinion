package com.the_opinion.backend.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@RestController
public class ExampleController {
    @Operation(summary = "문자열 반복", description = "문자열을 반복하여 반환합니다.")
    @Parameter(name="str", required = true, description = "반복할 문자열")
    @GetMapping("/returnStr")
    public String returnStr(@RequestParam String str) {
        return str + "\n" + str;
    }

    @GetMapping("/example")
    public String example() {
        return "예시 API";
    }

    @Hidden
    @GetMapping("/ignore")
    public String ignore() {
        return "무시되는 API";
    }
}
