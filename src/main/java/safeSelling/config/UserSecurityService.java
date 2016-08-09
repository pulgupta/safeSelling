package safeSelling.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import safeSelling.User;
import safeSelling.data.UserRepository;

public class UserSecurityService implements UserDetailsService {

	public final UserRepository userRepository;
	
	public UserSecurityService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(userName);
		if(user!=null){
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new org.springframework.security.core.userdetails.User(user.getUserName(),
					user.getPassword(),
					authorities);
		}
		throw new UsernameNotFoundException("user " + userName + " not found");
	}
}
