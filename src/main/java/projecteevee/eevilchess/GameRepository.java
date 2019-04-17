package projecteevee.eevilchess;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import projecteevee.eevilchess.Game;

//public interface GameRepository extends CrudRepository<Game, Integer>
public interface GameRepository extends JpaRepository<Game, Integer>

{
    
}