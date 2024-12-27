package POJO_with_ParameterizedConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private int id;
    private Name name;
    private String email;
    private boolean isVerified;
    private String createdAt;
    private List<String> roles;
    
	public User(int id, Name name, String email, boolean isVerified, String createdAt, List<String> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.isVerified = isVerified;
		this.createdAt = createdAt;
		this.roles = roles;
	}  
	
	
	
   }

