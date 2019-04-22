package projecteevee.eevilchess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import projecteevee.eevilchess.Game;
import projecteevee.eevilchess.GameRepository;

@Controller
@RequestMapping(path = "/eevee")
public class MainController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping(path = "/newgame")
    public @ResponseBody String createNewGame(@RequestParam String gameID, @RequestParam String player1,
            @RequestParam String player2) {
        Game new_game = new Game();
        new_game.setGameID(gameID);
        new_game.setPlayer1(player1);
        new_game.setPlayer2(player2);

        gameRepository.save(new_game);

        return "New Game Created";
    }

    @GetMapping(path = "/games")
    public @ResponseBody Iterable<Game> listGames() {
        return gameRepository.findAll();
    }

    // @GetMapping(path="game/{gameID}")
    // public @ResponseBody Integer displayGame(@RequestParam Integer gameID)
    // {
    // Integer id = gameID;
    // return id;
    // }

    @GetMapping(path = "games/{gameID}")
    public @ResponseBody String displayGame(@PathVariable String gameID)
    {
        Integer id = Integer.parseInt(gameID);
        Optional<Game> game = gameRepository.findById(id);
        //Boolean status = gameRepository.existsById(id);
        //return status.toString();
        return game.toString();
    }

    @GetMapping(path = "games/{gameID}/{playerID}/movelist")
    public @ResponseBody String displayMoveList(@PathVariable String gameID, @PathVariable String playerID)
    {
        Integer id = Integer.parseInt(gameID);
        String pID = playerID;
        return gameID + " " + playerID + "\n";
    }

    @PostMapping(path = "games/{gameID}/{playerID}/movelist")
    public @ResponseBody String updateMoveList(@PathVariable String gameID, @PathVariable String playerID, @RequestParam String piece, @RequestParam String current_tile, @RequestParam String new_tile)
    {
        //return gameID + " " + playerID + " " + piece + " " + current_tile + " " + new_tile + "\n";
        Integer id = Integer.parseInt(gameID);
        
        // Retrieve the Game from the database
        Optional<Game> game = gameRepository.findById(id);
        // Define a new Move
        // ToDo: JSON move
        String newMove = playerID + " " + piece + " " + current_tile + " " + new_tile + "\n";
        // Get the game object
        Game currentGame = game.get();
        // Update the move list & save
        currentGame.updateMoveList(playerID, newMove);
        gameRepository.save(currentGame);
        // Return the move that was made as confirmation
        return gameID + " " + playerID + " " + piece + " " + current_tile + " " + new_tile + "\n";
    }





    // The following URL endpoints will return HTML pages
    @GetMapping(path="/")
    public @ResponseBody String displayHomepage()
    {
        return "homepage";
    }

    @GetMapping(path="/profile")
    public @ResponseBody String displayProfile()
    {
        return "profile";
    }

    @GetMapping(path="/startgame")
    public @ResponseBody String startGame()
    {
        return "startgame";
    }
}