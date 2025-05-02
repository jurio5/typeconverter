package hello.typeconverter.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class RestFormatterController {

    @GetMapping("/formatter/body")
    public ResponseEntity<FormDto> restFormatter(@RequestParam Integer num) {
        Form form = new Form(num, LocalDateTime.now());
        String formatDateTime = form.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String formatNumber = form.getFormattedNumber();
        return new ResponseEntity<>(new FormDto(formatNumber,formatDateTime), HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    static class Form {
        private Integer number;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;

        @JsonProperty("formattedNumber")
        private String getFormattedNumber() {
            return new DecimalFormat("#,###").format(number);
        }
    }

    @Data
    @AllArgsConstructor
    static class FormDto {
        private String formattedNumber;
        private String formattedDateTime;
    }


}
