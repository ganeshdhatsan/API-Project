package POJO_with_ParameterizedConstructor;

public class Preferences {
    private String language;
    private String theme;
    private Notifications notifications;
	public Preferences(String language, String theme, Notifications notifications) {
		super();
		this.language = language;
		this.theme = theme;
		this.notifications = notifications;
	}

  }

