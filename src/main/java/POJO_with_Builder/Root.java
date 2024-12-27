package POJO_with_Builder;

import java.util.List;

public class Root {
    private User user;
    private Profile profile;
    private List<Transaction> transactions;
    private Metadata metadata;

    private Root(Builder builder) {
        this.user = builder.user;
        this.profile = builder.profile;
        this.transactions = builder.transactions;
        this.metadata = builder.metadata;
    }

    public static class Builder {
        private User user;
        private Profile profile;
        private List<Transaction> transactions;
        private Metadata metadata;

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setProfile(Profile profile) {
            this.profile = profile;
            return this;
        }

        public Builder setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
            return this;
        }

        public Builder setMetadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Root build() {
            return new Root(this);
        }
    }
}

