package POJO_with_Builder;

public class Notifications {
    private boolean email;
    private boolean sms;
    private Push push;

    private Notifications(Builder builder) {
        this.email = builder.email;
        this.sms = builder.sms;
        this.push = builder.push;
    }

    public static class Builder {
        private boolean email;
        private boolean sms;
        private Push push;

        public Builder setEmail(boolean email) {
            this.email = email;
            return this;
        }

        public Builder setSms(boolean sms) {
            this.sms = sms;
            return this;
        }

        public Builder setPush(Push push) {
            this.push = push;
            return this;
        }

        public Notifications build() {
            return new Notifications(this);
        }
    }
}

