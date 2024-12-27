package POJO_with_ParameterizedConstructor;

public class Metadata {
    private String ipAddress;
    private String userAgent;
    private String lastLogin;
    private Permissions permissions;
	public Metadata(String ipAddress, String userAgent, String lastLogin, Permissions permissions) {
		super();
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
		this.lastLogin = lastLogin;
		this.permissions = permissions;
	}
    

    }

