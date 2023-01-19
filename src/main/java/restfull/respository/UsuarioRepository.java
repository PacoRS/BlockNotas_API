package restfull.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import restfull.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

}
