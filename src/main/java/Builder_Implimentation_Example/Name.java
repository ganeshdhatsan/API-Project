package Builder_Implimentation_Example;

public class Name {
    private String first;
    private String last;

    // Private constructor to enforce the use of the Builder
    private Name(Builder builder) {
        this.first = builder.first;
        this.last = builder.last;
    }

    // Getter methods (optional, for accessing fields later if needed)
    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    // Static Builder Class
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

