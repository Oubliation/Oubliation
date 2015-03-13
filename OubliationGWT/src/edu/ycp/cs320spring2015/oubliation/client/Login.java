package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.test.Debug;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	@UiField TextBox username;
	@UiField PasswordTextBox password;
	@UiField Label error;
	
	DataKeeperAsync dataKeeper;

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		dataKeeper = (DataKeeperAsync) GWT.create(DataKeeper.class);
	}
	
	private void login() {
    	error.setText("You logged in!");
    	this.removeFromParent();
    	RootPanel.get("gwtapp").add(new ViewOutskirts(Debug.makeProfile()));
    	
	}

	@UiHandler("loginButton")
	void onClick(ClickEvent e) {
		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
		    public void onSuccess(Boolean isValid) {
		    	if (isValid.equals(true)) {
			    	login();
		    	} else {
			    	error.setText("Username or password is incorrect.");
		    	}
		    }

		    public void onFailure(Throwable caught) {
		    	error.setText(caught.getMessage());
		    }
		  };
	
		dataKeeper.validateLogin(username.getText(), password.getText(), callback);
	}

}
