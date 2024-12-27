package POJO_with_ParameterizedConstructor;

public class Notifications {
    private boolean email;
    private boolean sms;
    private Push push;
	public Notifications(boolean email, boolean sms, Push push) {
		super();
		this.email = email;
		this.sms = sms;
		this.push = push;
	}

    }

