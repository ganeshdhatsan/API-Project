package POJO_with_Builder;

import java.util.List;

public class Profile {
    private String bio;
    private List<SocialLink> socialLinks;
    private Preferences preferences;

    private Profile(Builder builder) {
        this.bio = builder.bio;
        this.socialLinks = builder.socialLinks;
        this.preferences = builder.preferences;
    }

    public static class Builder {
        private String bio;
        private List<SocialLink> socialLinks;
        private Preferences preferences;

        public Builder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder setSocialLinks(List<SocialLink> socialLinks) {
            this.socialLinks = socialLinks;
            return this;
        }

        public Builder setPreferences(Preferences preferences) {
            this.preferences = preferences;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }
}

