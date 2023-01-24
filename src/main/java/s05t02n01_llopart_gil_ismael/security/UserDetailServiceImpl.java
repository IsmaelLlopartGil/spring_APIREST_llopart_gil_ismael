package s05t02n01_llopart_gil_ismael.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import s05t02n01_llopart_gil_ismael.model.domain.Player;
import s05t02n01_llopart_gil_ismael.model.repository.PlayerRepositoryMongoDB;

@Component
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	PlayerRepositoryMongoDB playerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Player player = playerRepository
			.findOneByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("L'usuari amb email "+ email + "no existeix."));
		
		return new UserDetailsImpl(player);
	}
}
