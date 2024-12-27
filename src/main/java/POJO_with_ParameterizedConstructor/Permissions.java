package POJO_with_ParameterizedConstructor;

import java.util.ArrayList;
import java.util.List;

public class Permissions {
    private boolean admin;
    private boolean editor;
    private ArrayList<String> access;
	public Permissions(boolean admin, boolean editor, ArrayList<String> access) {
		super();
		this.admin = admin;
		this.editor = editor;
		this.access = access;
	}


    }

