package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.client.town.ViewTown;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	@UiField TextBox usernameBox;
	@UiField PasswordTextBox passwordBox;
	@UiField Label error;

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		usernameBox.setFocus(true);
	}
	
	private void bootGame(ProfileMemento transfer) {
		Profile profile = transfer.constructProfile();
    	this.removeFromParent();
    	RootPanel.get("gwtapp").add(new ViewTown(profile));
    	//profile.increasePartyXP(300);  //For testing purposes
	}
	
	@UiHandler("loginButton")
	void onClickLogin(ClickEvent e) {
		processInput();
	}
	
	@UiHandler(value={"usernameBox", "passwordBox"})
	public void onKeyDown(KeyDownEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
        	processInput();
        }
	}
	
	private void processInput() {
		final String usernameInput = usernameBox.getText();
		final String passwordInput = passwordBox.getText();
		
		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean isValid) {
				if (isValid) {
					loadProfile(usernameInput);
				} else {
					error.setText("Username or password is incorrect.");
					usernameBox.setText("");
					passwordBox.setText("");
					
					usernameBox.setFocus(true);
				}
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		
		Oubliation.getDataKeeper().validateLogin(usernameInput, passwordInput, callback);
	}
	
	private void loadProfile(String usernameInput) {
		AsyncCallback<ProfileMemento> callback = new AsyncCallback<ProfileMemento>() {
			public void onSuccess(ProfileMemento transfer) {
				bootGame(transfer);
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		Oubliation.getDataKeeper().loadProfile(usernameInput, callback);
	}
	
	@UiHandler("registerButton")
	void onClickRegister(ClickEvent e) {
		final String usernameInput = usernameBox.getText();
		final String passwordInput = passwordBox.getText();
		
		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean usernameWasAvailable) {
				if (usernameWasAvailable) {
					loadProfile(usernameInput);
				} else {
					error.setText("Username is already taken.");
					usernameBox.setText("");
					passwordBox.setText("");
					
					usernameBox.setFocus(true);
				}
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		Oubliation.getDataKeeper().createProfile(usernameInput, passwordInput, callback);
	}
}
