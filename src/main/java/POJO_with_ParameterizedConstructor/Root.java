package POJO_with_ParameterizedConstructor;

import java.util.ArrayList;
import java.util.List;

public class Root {
    private User user;
    private Profile profile;
    private ArrayList<Transaction> transactions;
    private Metadata metadata;
	public Root(User user, Profile profile, ArrayList<Transaction> transactions, Metadata metadata) {
		super();
		this.user = user;
		this.profile = profile;
		this.transactions = transactions;
		this.metadata = metadata;
	}


    }

