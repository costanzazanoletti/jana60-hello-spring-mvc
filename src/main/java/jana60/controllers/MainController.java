package jana60.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

  @GetMapping("/home")
  public String home(
      @RequestParam(name = "name", required = false, defaultValue = "a tutti") String nameInput,
      Model model) {

    model.addAttribute("queryStringName", nameInput);
    return "home";
  }

  @GetMapping("/ora")
  public String time(Model model) {
    LocalDateTime currentDateTime = LocalDateTime.now();
    String currentDTFormat =
        currentDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    model.addAttribute("oraEsatta", currentDTFormat);
    return "time";
  }



}
