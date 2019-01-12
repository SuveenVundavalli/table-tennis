package com.clx.apps.tt.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("message", "Hello world!");
    return "index";
  }

  @GetMapping("/addPlayer")
  public String addPlayer(Model model) {

    return "addPlayer";
  }

  @GetMapping("/startMatch")
  public String startMatch(Model model) {

    return "startMatch";
  }

  @GetMapping("/history")
  public String history(Model model) {

    return "history";
  }

  @GetMapping("/graphs")
  public String graphs(Model model) {

    return "graphs";
  }
}
