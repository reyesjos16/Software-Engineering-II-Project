package hello;

import org.springframework.data.repository.CrudRepository;
import hello.User;

// This will be Auto Implemented by Spring into a Bean called userRepository
// CRUD references the Create, Read, Update, & Delete operations

public interface UserRepository extends CrudRepository<User, Integer>
{
    
}

