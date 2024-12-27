package POJO_with_ParameterizedConstructor;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String bio;
    private ArrayList<SocialLink> socialLinks;
    private Preferences preferences;
	public Profile(String bio, ArrayList<SocialLink> socialLinks, Preferences preferences) {
		super();
		this.bio = bio;
		this.socialLinks = socialLinks;
		this.preferences = preferences;
	}

    
    }

