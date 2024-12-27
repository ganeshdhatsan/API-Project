package POJO_with_Builder;

import java.util.List;

public class Permissions {
    private boolean admin;
    private boolean editor;
    private List<String> access;

    private Permissions(Builder builder) {
        this.admin = builder.admin;
        this.editor = builder.editor;
        this.access = builder.access;
    }

    public static class Builder {
        private boolean admin;
        private boolean editor;
        private List<String> access;

        public Builder setAdmin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public Builder setEditor(boolean editor) {
            this.editor = editor;
            return this;
        }

        public Builder setAccess(List<String> access) {
            this.access = access;
            return this;
        }

        public Permissions build() {
            return new Permissions(this);
        }
    }
}

