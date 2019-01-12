package com.clx.apps.tt.domain.controller;

import com.clx.apps.tt.db.model.Branch;
import com.clx.apps.tt.db.model.Player;
import com.clx.apps.tt.db.service.BranchService;
import com.clx.apps.tt.db.service.LevelService;
import com.clx.apps.tt.db.service.MatchService;
import com.clx.apps.tt.db.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

  @Autowired private BranchService branchService;

  @Autowired private LevelService levelService;

  @Autowired private MatchService matchService;

  @Autowired private PlayerService playerService;

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("message", "Hello world!");
    return "index";
  }

  @GetMapping("/addPlayer")
  public String addPlayer(Model model) {
    model.addAttribute("branches", branchService.findAllBranches());
    model.addAttribute("player", new Player());
    model.addAttribute("branch", new Branch());
    return "addPlayer";
  }

  @PostMapping("/addPlayer")
  public String addPlayer(@Valid @ModelAttribute Player player, Model model) {
    try {
      playerService.savePlayer(player);
      model.addAttribute("successMessage", "Player saved successfully.");
    } catch (Exception e) {
      model.addAttribute("errorMessage", "Error saving player. Try again!");
    }
    model.addAttribute("branches", branchService.findAllBranches());
    model.addAttribute("player", new Player());
    model.addAttribute("branch", new Branch());
    return "addPlayer";
  }

  @PostMapping("/addBranch")
  private String addBranch(@Valid @ModelAttribute Branch branch, Model model) {
    try {
      branchService.saveBranch(branch);
      model.addAttribute("successMessage", "Branch saved successfully.");
    } catch (Exception e) {
      model.addAttribute("errorMessage", "Error saving branch. Try again!");
    }

    model.addAttribute("branches", branchService.findAllBranches());
    model.addAttribute("player", new Player());
    model.addAttribute("branch", new Branch());
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
