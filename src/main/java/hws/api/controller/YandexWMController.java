package hws.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YandexWMController {

    @GetMapping("/index.html")
    public String index() {
        return printPage();
    }

    @GetMapping
    public String root() {
        return printPage();
    }

    private String printPage() {
        return "<html>" +
                "<head>" +
                "   <meta name=\"yandex-verification\" content=\"04b0d0b7dc326de7\" />" +
                "</head>" +
                "<body>" +
                "   <h1>Index</h1>" +
                "</body>" +
                "</html>";
    }
}
