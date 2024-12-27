package POJO_with_Builder;

public class SocialLink {
    private String platform;
    private String url;
    private String username;

    private SocialLink(Builder builder) {
        this.platform = builder.platform;
        this.url = builder.url;
        this.username = builder.username;
    }

    public static class Builder {
        private String platform;
        private String url;
        private String username;

        public Builder setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public SocialLink build() {
            return new SocialLink(this);
        }
    }
}

