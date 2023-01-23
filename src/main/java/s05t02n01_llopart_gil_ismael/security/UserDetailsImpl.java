package s05t02n01_llopart_gil_ismael.security;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import s05t02n01_llopart_gil_ismael.model.domain.Player;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 6562357950877813387L;
	private final Player player;
	
	public UserDetailsImpl(Player player) {
		super();
		this.player = player;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return player.getPassword();
	}

	@Override
	public String getUsername() {
		return player.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getName () {
		return player.getName();
	}

}
