package POJO_with_Builder;

import java.util.List;

public class User {
    private int id;
    private Name name;
    private String email;
    private boolean isVerified;
    private String createdAt;
    private List<String> roles;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.isVerified = builder.isVerified;
        this.createdAt = builder.createdAt;
        this.roles = builder.roles;
    }

    public static class Builder {
        private int id;
        private Name name;
        private String email;
        private boolean isVerified;
        private String createdAt;
        private List<String> roles;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setVerified(boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        public Builder setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setRoles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

