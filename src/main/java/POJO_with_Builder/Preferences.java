package POJO_with_Builder;

public class Preferences {
    private String language;
    private String theme;
    private Notifications notifications;

    private Preferences(Builder builder) {
        this.language = builder.language;
        this.theme = builder.theme;
        this.notifications = builder.notifications;
    }

    public static class Builder {
        private String language;
        private String theme;
        private Notifications notifications;

        public Builder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder setTheme(String theme) {
            this.theme = theme;
            return this;
        }

        public Builder setNotifications(Notifications notifications) {
            this.notifications = notifications;
            return this;
        }

        public Preferences build() {
            return new Preferences(this);
        }
    }
}

