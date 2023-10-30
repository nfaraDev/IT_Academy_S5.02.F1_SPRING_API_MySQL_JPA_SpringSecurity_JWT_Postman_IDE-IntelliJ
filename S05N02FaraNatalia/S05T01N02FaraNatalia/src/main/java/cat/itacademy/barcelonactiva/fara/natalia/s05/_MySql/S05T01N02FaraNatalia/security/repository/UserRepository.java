package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.security.repository;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);

}
