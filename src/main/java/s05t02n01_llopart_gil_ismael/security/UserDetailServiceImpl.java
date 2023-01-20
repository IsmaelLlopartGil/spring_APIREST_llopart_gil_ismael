package s05t02n01_llopart_gil_ismael.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import s05t02n01_llopart_gil_ismael.model.domain.Player;
import s05t02n01_llopart_gil_ismael.model.repository.PlayerRepositoryMysql;

@Component
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	PlayerRepositoryMysql playerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Player player = playerRepository
			.findOneByName(name)
			.orElseThrow(() -> new UsernameNotFoundException("L'usuari amb nom "+ name + "no existeix."));
		
		return new UserDetailsImpl(player);
	}
}
