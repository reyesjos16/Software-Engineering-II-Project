package projecteevee.eevilchess;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import projecteevee.eevilchess.Game;
import projecteevee.eevilchess.GameRepository;

import projecteevee.eevilchess.chessgame.Board;
import projecteevee.eevilchess.chessgame.Player;

@Controller
@RequestMapping(path = "/eevee")
public class MainController {
    @Autowired
    private GameRepository gameRepository;

    // Create a persistent board for a game of chess
    public Player p1 = new Player("white");
    public Player p2 = new Player("black");
    public Board b = new Board(8,8);
    //b.populateTableEevil(p1, p2);
    
    @PostMapping(path = "/newgame")
    public @ResponseBody String createNewGame(@RequestParam String gameID, @RequestParam String player1,
            @RequestParam String player2) {
        Game new_game = new Game();
        new_game.setGameID(gameID);
        new_game.setPlayer1(player1);
        new_game.setPlayer2(player2);

        gameRepository.save(new_game);

        return "New Game Created\n";
    }

    @PostMapping(path = "/games/{gameID}/setparameters")
    public @ResponseBody String setGameParameters(@PathVariable String gameID, @RequestParam Integer eevilNum, @RequestParam Integer boardDimensions)
    {
        Integer id = Integer.parseInt(gameID);
        Optional<Game> game = gameRepository.findById(id);
        Game currentGame = game.get();

        // Set the eevil number for each player
        // Note: current identical; may add ability to set different difficulties later
        currentGame.setEevilNumber(1, eevilNum);
        currentGame.setEevilNumber(2, eevilNum);
        
        // Set the board dimensions
        currentGame.setBoardDimensions(boardDimensions);

        // Save the game object
        gameRepository.save(currentGame);

        return "Game Parameters Set\n";
    }

    @CrossOrigin(origins = "http://localhost:9000")
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


    @PostMapping(path = "/games/{gameID}/{playerID}/pieces")
    public @ResponseBody String setPieceList(@PathVariable String gameID, @PathVariable String playerID,
    @RequestParam String pieceList)
    {
        Integer id = Integer.parseInt(gameID);
        
        // Retrieve the Game from the database
        Optional<Game> game = gameRepository.findById(id);
        // Create initial piece list
        // ToDo:
        // Get the game object
        Game currentGame = game.get();
        // Update the move list & save
        currentGame.initializePieceList(playerID, pieceList);
        gameRepository.save(currentGame);
        // Return the move that was made as confirmation
        return pieceList + "\n";
    }


    // The following URL endpoints will return HTML pages
    // @GetMapping(path="/")
    // public @ResponseBody String displayHomepage()
    // {
    //     return "homepage\n";
    // }

    @GetMapping(path="/")
    public String displayHomepage()
    {
        return "index";
    }

    // @GetMapping(path="/profile")
    // public @ResponseBody String displayProfile()
    // {
    //     return "profile\n";
    // }
    @GetMapping(path="/profile")
    public String displayProfile()
    {
        return "profile";
    }

    // @GetMapping(path="/startgame")
    // public @ResponseBody String startGame()
    // {
    //     return "startgame\n";
    // }
    @GetMapping(path="/startgame")
    public String startGame()
    {
        return "startgame";
    }

    @GetMapping(path="/play-game")
    public String playGame()
    {
        return "play-game";
    }

    @PostMapping(path = "/move")
    public @ResponseBody String makeMove(@RequestParam String start_x, @RequestParam String start_y, @RequestParam String target_x, @RequestParam String target_y)
    {
        this.b.checkmove(Integer.parseInt(start_x), Integer.parseInt(start_y), Integer.parseInt(target_x), Integer.parseInt(target_y));
        return start_x + " " + start_y + " " + target_x + " " + target_y + "\n";
    }

    @GetMapping(path="/getnormalboardjson")
    public @ResponseBody String getNormalBoardJSON()
    {
        // Create board with default size
        // Player p1 = new Player("white");
        // Player p2 = new Player("black");
        // Board b = new Board(8,8);
        this.b.populateTableNormal(p1, p2);
        JSONObject json = b.getBoardJSON();
        String brd = json.toString();
        return brd;
    }

    @GetMapping(path="/getrandomboardjson")
    public @ResponseBody String getRandomBoardJSON()
    {
        // Create board with default size
        // Player p1 = new Player("white");
        // Player p2 = new Player("black");
        this.b = new Board(8,8);
        this.b.populateTableEevil(p1, p2);
        JSONObject json = b.getBoardJSON();
        String brd = json.toString();
        return brd;
    }

    @GetMapping(path="/getcurrentboard")
    public @ResponseBody String getCurrentBoard()
    {
        JSONObject json = this.b.getBoardJSON();
        String brd = json.toString();
        return brd;
    }


}
