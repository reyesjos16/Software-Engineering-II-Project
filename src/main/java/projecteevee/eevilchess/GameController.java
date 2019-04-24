package projecteevee.eevilchess;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController
{
    @GetMapping("/startgame")
    public String newGameForm(Model model)
    {
        model.addAttribute("new_game", new Game());
        return "new_game";
    }

    @PostMapping("/startgame")
    public String newGameSubmit(@ModelAttribute Game game)
    {
        return "result";
    }
}