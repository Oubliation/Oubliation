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
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.HeadwearOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.ShieldOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.SuitOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.UtilityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.WeaponOverlay;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;
public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	@UiField TextBox usernameBox;
	@UiField PasswordTextBox passwordBox;
	@UiField Label error;

	private ProfileMemento transfer;
	private Map<String, HeadwearOverlay> headwearMap;
	private Map<String, SuitOverlay> suitMap;
	private Map<String, ShieldOverlay> shieldMap;
	private Map<String, Effect> effectMap;
	private Map<String, UtilityOverlay> utilityMap;
	private Map<String, WeaponOverlay> weaponMap;

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
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
				public void onSuccess(EntityResourceMap<HeadwearOverlay> entityMap) {
					setHeadwearMap(entityMap);
					tryBoot();
				}
				
				public void onFailure(Throwable caught) {
					error.setText(caught.getMessage());
				}
		};
		AsyncCallback<EntityResourceMap<SuitOverlay>>
			suitMapCallback = new AsyncCallback<EntityResourceMap<SuitOverlay>>() {
				public void onSuccess(EntityResourceMap<SuitOverlay> entityMap) {
					setSuitMap(entityMap);
					tryBoot();
				}
				
				public void onFailure(Throwable caught) {
					error.setText(caught.getMessage());
				}
		};
		AsyncCallback<EntityResourceMap<ShieldOverlay>>
			shieldMapCallback = new AsyncCallback<EntityResourceMap<ShieldOverlay>>() {
				public void onSuccess(EntityResourceMap<ShieldOverlay> entityMap) {
					setShieldMap(entityMap);
					tryBoot();
				}
				
				public void onFailure(Throwable caught) {
					error.setText(caught.getMessage());
				}
		};
		AsyncCallback<Map<String, Effect>> effectCallback = new AsyncCallback<Map<String, Effect>>() {
			public void onSuccess(Map<String, Effect> effectMap) {
				setEffectMap(effectMap);
				tryBoot();
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		AsyncCallback<EntityResourceMap<UtilityOverlay>>
			utilityMapCallback = new AsyncCallback<EntityResourceMap<UtilityOverlay>>() {
				public void onSuccess(EntityResourceMap<UtilityOverlay> entityMap) {
					setUtilityMap(entityMap);
					tryBoot();
				}
				
				public void onFailure(Throwable caught) {
					error.setText(caught.getMessage());
				}
		};
		AsyncCallback<EntityResourceMap<WeaponOverlay>>
		weaponMapCallback = new AsyncCallback<EntityResourceMap<WeaponOverlay>>() {
			public void onSuccess(EntityResourceMap<WeaponOverlay> entityMap) {
				setWeaponMap(entityMap);
				tryBoot();
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
	};
		Oubliation.getDataKeeper().loadProfile(usernameInput, transferCallback);
		new HeadwearOverlay.ResourceMap(new String[] {"/data/headwear.json"}, headwearMapCallback);
		new SuitOverlay.ResourceMap(new String[] {"/data/suits.json"}, suitMapCallback);
		new ShieldOverlay.ResourceMap(new String[] {"/data/shields.json"}, shieldMapCallback);
		Oubliation.getDataKeeper().getEffectMap(new String[] {}, effectCallback);
		new UtilityOverlay.ResourceMap(new String[] {"/data/utilities.json"}, utilityMapCallback);
		new WeaponOverlay.ResourceMap(new String[] {"/data/weapons.json"}, weaponMapCallback);
	}
	
	private void setTransfer(ProfileMemento transfer) {
		this.transfer = transfer;
	}

	private void setHeadwearMap(EntityResourceMap<HeadwearOverlay> entityMap) {
		headwearMap = entityMap;
	}
	private void setSuitMap(EntityResourceMap<SuitOverlay> entityMap) {
		suitMap = entityMap;
	}
	private void setShieldMap(EntityResourceMap<ShieldOverlay> entityMap) {
		shieldMap = entityMap;
	}
	private void setEffectMap(Map<String, Effect> effectMap) {
		this.effectMap = effectMap;
	}
	private void setUtilityMap(EntityResourceMap<UtilityOverlay> entityMap) {
		utilityMap = entityMap;
	}
	private void setWeaponMap(EntityResourceMap<WeaponOverlay> entityMap) {
		weaponMap = entityMap;
	}
	
	private void tryBoot() {
		if (transfer != null && headwearMap != null && suitMap != null && utilityMap != null && weaponMap != null) { bootGame(); }
	}
		
	private void bootGame() {
		Profile profile = constructProfile(transfer, headwearMap, suitMap, shieldMap, effectMap, utilityMap, weaponMap);
    	this.removeFromParent();
    	RootPanel.get("gwtapp").add(new ViewTown(profile));
	}

	private Profile constructProfile(ProfileMemento transfer, Map<String, HeadwearOverlay> headwearOverlayMap,
			Map<String, SuitOverlay> suitOverlayMap, Map<String, ShieldOverlay> shieldOverlayMap, Map<String, Effect> effectMap,
			Map<String, UtilityOverlay> utilityOverlayMap, Map<String, WeaponOverlay> weaponOverlayMap) {
		Map<String, Headwear> headwearMap = HeadwearOverlay.remapHeadwear(headwearOverlayMap);
		Map<String, Suit> suitMap = SuitOverlay.remapSuit(suitOverlayMap);
		Map<String, Shield> shieldMap = ShieldOverlay.remapShield(shieldOverlayMap);
		Map<String, Utility> utilityMap = UtilityOverlay.remapUtility(utilityOverlayMap, effectMap);
		Map<String, Weapon> weaponMap = WeaponOverlay.remapWeapon(weaponOverlayMap, effectMap);
		return transfer.constructProfile(headwearMap, suitMap, shieldMap, utilityMap, weaponMap);
	}
}
