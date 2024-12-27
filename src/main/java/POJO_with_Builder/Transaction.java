package POJO_with_Builder;

public class Transaction {
    private String id;
    private double amount;
    private String currency;
    private String timestamp;
    private String status;
    private Details details;

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.details = builder.details;
    }

    public static class Builder {
        private String id;
        private double amount;
        private String currency;
        private String timestamp;
        private String status;
        private Details details;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setDetails(Details details) {
            this.details = details;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}

