package edu.ycp.cs320spring2015.oubliation.client;

import java.util.Map;

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
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.HeadwearOverlay;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;
public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	@UiField TextBox usernameBox;
	@UiField PasswordTextBox passwordBox;
	@UiField Label error;
	
	private Map<String, HeadwearOverlay> headwearMap;
	private ProfileMemento transfer;

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
//		AsyncCallback<Void> callback  = new AsyncCallback<Void>() {
//			@Override
//			public void onSuccess(Void _) {}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				error.setText(caught.getMessage());
//			}
//		};
//		Oubliation.getDataKeeper().createDb(callback);
		usernameBox.setFocus(true);
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
	
	@UiHandler("registerButton")
	void onClickRegister(ClickEvent e) {
		final String usernameInput = usernameBox.getText();
		final String passwordInput = passwordBox.getText();
		
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {
			public void onSuccess(Void _) {
				loadProfile(usernameInput);
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
//				} else {
//				error.setText("Username is already taken.");
//				usernameBox.setText("");
//				passwordBox.setText("");
//				
//				usernameBox.setFocus(true);
			}
		};
		Oubliation.getDataKeeper().createProfile(usernameInput, passwordInput, callback);
	}
	
	private void loadProfile(String usernameInput) {
		AsyncCallback<ProfileMemento> transferCallback = new AsyncCallback<ProfileMemento>() {
			public void onSuccess(ProfileMemento transfer) {
				setTransfer(transfer);
				tryBoot();
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		AsyncCallback<EntityResourceMap<HeadwearOverlay>>
			headwearMapCallback = new AsyncCallback<EntityResourceMap<HeadwearOverlay>>() {
				public void onSuccess(EntityResourceMap<HeadwearOverlay> headwearMap) {
					setHeadwearMap(headwearMap);
					tryBoot();
				}
				
				public void onFailure(Throwable caught) {
					error.setText(caught.getMessage());
				}
		};
		Oubliation.getDataKeeper().loadProfile(usernameInput, transferCallback);
		new HeadwearOverlay.ResourceMap(new String[] {"/data/headwear.json"}, headwearMapCallback);
	}
	
	private void setTransfer(ProfileMemento transfer) {
		this.transfer = transfer;
	}

	private void setHeadwearMap(EntityResourceMap<HeadwearOverlay> headwearMap) {
		this.headwearMap = headwearMap;
	}
	
	private void tryBoot() {
		if (transfer != null && headwearMap != null) { bootGame(); }
	}
		
	private void bootGame() {
		Profile profile = constructProfile(transfer, headwearMap);
    	this.removeFromParent();
    	RootPanel.get("gwtapp").add(new ViewTown(profile));
	}

	private Profile constructProfile(ProfileMemento transfer, Map<String, HeadwearOverlay> headwearOverlayMap) {
		Map<String, Headwear> headwearMap = HeadwearOverlay.remapHeadwear(headwearOverlayMap);
		return transfer.constructProfile(headwearMap);
	}

}
