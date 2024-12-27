package POJO_with_Builder;

public class Name {
    private String first;
    private String last;

    private Name(Builder builder) {
        this.first = builder.first;
        this.last = builder.last;
    }

    public static class Builder {
        private String first;
        private String last;

        public Builder setFirst(String first) {
            this.first = first;
            return this;
        }

        public Builder setLast(String last) {
            this.last = last;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }
}

