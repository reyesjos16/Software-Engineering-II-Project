package projecteevee.eevilchess;

import org.springframework.data.repository.CrudRepository;

import projecteevee.eevilchess.Game;

public interface GameRepository extends CrudRepository<Game, Integer>
{
    
}