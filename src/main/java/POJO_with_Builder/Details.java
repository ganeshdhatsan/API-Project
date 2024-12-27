package POJO_with_Builder;

public class Details {
    private String type;
    private String lastFour;
    private String brand;
    private String email;

    private Details(Builder builder) {
        this.type = builder.type;
        this.lastFour = builder.lastFour;
        this.brand = builder.brand;
        this.email = builder.email;
    }

    public static class Builder {
        private String type;
        private String lastFour;
        private String brand;
        private String email;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setLastFour(String lastFour) {
            this.lastFour = lastFour;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Details build() {
            return new Details(this);
        }
    }
}

