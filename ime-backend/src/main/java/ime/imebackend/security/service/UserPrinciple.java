package ime.imebackend.security.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ime.imebackend.entity.role;
import ime.imebackend.entity.user;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;
	 
	  private String id;
	 
	    private String username;
	 
	    @JsonIgnore
	    private String password;
	 
	    private Collection authorities;
	    
	    private static Set<String> roles = new HashSet<String>();
	 
	    public UserPrinciple(String name, String password, Collection authorities) {
	        this.username = name;
	        this.password = password;
	        this.authorities = authorities;
	    }
	 
	    public static UserPrinciple build(user user) {
	    	role roleUser = user.getRole();
	    	Collections.addAll(roles, roleUser.getIntitule());
	        //SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(role.getIntitule());
	        List authorities = roles.stream().map(role ->
            new SimpleGrantedAuthority(roleUser.getIntitule())).collect(Collectors.toList());
	 
	        return new UserPrinciple(
	                user.getIduser(),
	                user.getPw(),
	                authorities
	        );
	    }
	 
	    public String getId() {
	        return id;
	    }
	 
	    public String getUsername() {
	        return username;
	    }
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public Collection getAuthorities() {
	        return authorities;
	    }
	 
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    public boolean isEnabled() {
	        return true;
	    }
	 
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        UserPrinciple user = (UserPrinciple) o;
	        return Objects.equals(id, user.id);
	    }
	
}
