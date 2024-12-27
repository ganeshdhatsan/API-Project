package POJO_with_Builder;

public class Metadata {
    private String ipAddress;
    private String userAgent;
    private String timestamp;
    private Permissions permissions;

    private Metadata(Builder builder) {
        this.ipAddress = builder.ipAddress;
        this.userAgent = builder.userAgent;
        this.timestamp = builder.timestamp;
        this.permissions = builder.permissions;
    }

    public static class Builder {
        private String ipAddress;
        private String userAgent;
        private String timestamp;
        private Permissions permissions;

        public Builder setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setPermissions(Permissions permissions) {
            this.permissions = permissions;
            return this;
        }

        public Metadata build() {
            return new Metadata(this);
        }
    }
}

