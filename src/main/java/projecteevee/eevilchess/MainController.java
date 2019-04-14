package projecteevee.eevilchess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import projecteevee.eevilchess.Game;
import projecteevee.eevilchess.GameRepository;

@Controller
@RequestMapping(path="/eevee")
public class MainController
{
    @Autowired
    private GameRepository gameRepository;

    @GetMapping(path="/newgame")
    public @ResponseBody String createNewGame (@RequestParam String gameID, @RequestParam String player1, @RequestParam String player2)
    {
        Game new_game = new Game();
        new_game.setGameID(gameID);
        new_game.setPlayer1(player1);
        new_game.setPlayer2(player2);

        gameRepository.save(new_game);

        return "New Game Created";
    }

    @GetMapping(path="/games")
    public @ResponseBody Iterable<Game> listGames()
    {
        return gameRepository.findAll();
    }