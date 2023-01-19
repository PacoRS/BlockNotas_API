package restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfull.exeption.RecordNotFoundExeption;
import restfull.model.Usuario;
import restfull.respository.UsuarioRepository;

@Service
public class UsuarioServicie {
	@Autowired
	UsuarioRepository users;
	
	
	
	public List<Usuario> getAllUsers() {
		return users.findAll();
	}
	
	public Usuario getUserById(Long id) {
		Optional<Usuario> user= users.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new RecordNotFoundExeption("Usuario no encontrado", id);
		}
	}
	
	public Usuario createOrUpdateUser(Usuario user) {
		if(user.getId()!=null) {
			Optional<Usuario> n = users.findById(user.getId());
			if(n.isPresent()) {
				//existe, luego actualizo
				user = users.save(user);
			}else {
				throw new RecordNotFoundExeption("Usuario no encontrado", user.getId());
			}
		}else {
			user = users.save(user);
		}
		return user;
	}
	
	public void deleteByUser(Long id) {
		Optional<Usuario> u = users.findById(id);
		if(u.isPresent()) {
			users.deleteById(id);
		}else {
			//error
		}
	}
}
