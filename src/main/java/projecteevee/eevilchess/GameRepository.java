package projecteevee.eevilchess;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

import projecteevee.eevilchess.Game;

//public interface GameRepository extends CrudRepository<Game, Integer>
public interface GameRepository extends JpaRepository<Game, Integer>
{
    List<Game> findByGameID(@Param("gameID") String gameID);
    //Game findByGameID(String gameID);
    //@Query(value="SELECT FROM GAME WHERE GAMEID=?0", nativeQuery = true)
    //Game findByGameID(@Param("gid") String gid);
}
