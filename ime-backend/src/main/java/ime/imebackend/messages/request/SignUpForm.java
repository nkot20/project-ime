package ime.imebackend.messages.request;

import java.util.Set;

import javax.validation.constraints.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;
 
public class SignUpForm {
	
	@NotBlank
    @Size(min = 3, max = 50)
    private String idUser;
	
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;
    
    @NotBlank
    @JsonProperty("role")
    private String role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String pw;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(String role) {
		this.role = role;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
    
    
}
