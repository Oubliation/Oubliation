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
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileTransfer;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	@UiField TextBox username;
	@UiField PasswordTextBox password;
	@UiField Label error;

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		username.setFocus(true);
	}
	
	private void bootGame(ProfileTransfer transfer) {
		Profile profile = transfer.constructProfile();
    	this.removeFromParent();
    	RootPanel.get("gwtapp").add(new ViewTown(profile));
	}
	
	@UiHandler("loginButton")
	void onClickLogin(ClickEvent e) {
		processInput();
	}
	
	@UiHandler(value={"username", "password"})
	public void onKeyDown(KeyDownEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
        	processInput();
        }
	}
	
	private void processInput() {
		AsyncCallback<ProfileTransfer> callback = new AsyncCallback<ProfileTransfer>() {
			public void onSuccess(ProfileTransfer transfer) {
				if (transfer != null) {
					bootGame(transfer);
				} else {
					error.setText("Username or password is incorrect.");
					username.setText("");
					password.setText("");
					
					username.setFocus(true);
				}
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		 };
	
		Oubliation.getDataKeeper().loadProfile(username.getText(), password.getText(), callback);
	}
	
	@UiHandler("registerButton")
	void onClickRegister(ClickEvent e) {
		AsyncCallback<ProfileTransfer> callback = new AsyncCallback<ProfileTransfer>() {
			public void onSuccess(ProfileTransfer transfer) {
				bootGame(transfer);
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		Oubliation.getDataKeeper().newProfile(username.getText(), password.getText(), callback);
	}
}
