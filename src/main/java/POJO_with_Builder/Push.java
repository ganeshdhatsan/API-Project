package POJO_with_Builder;

public class Push {
    private boolean enabled;
    private String sound;

    private Push(Builder builder) {
        this.enabled = builder.enabled;
        this.sound = builder.sound;
    }

    public static class Builder {
        private boolean enabled;
        private String sound;

        public Builder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder setSound(String sound) {
            this.sound = sound;
            return this;
        }

        public Push build() {
            return new Push(this);
        }
    }
}
