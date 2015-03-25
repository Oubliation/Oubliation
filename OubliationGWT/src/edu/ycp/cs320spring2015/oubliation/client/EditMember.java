/**
 * 
 */
package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 *
 */
public class EditMember extends Composite{

	private static EditMemberUiBinder uiBinder = GWT
			.create(EditMemberUiBinder.class);

	interface EditMemberUiBinder extends UiBinder<Widget, EditMember> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public EditMember() {
		initWidget(uiBinder.createAndBindUi(this));
	}
//
//	@UiField
//	Label name;
//
//	public EditMember(String firstName) {
//		initWidget(uiBinder.createAndBindUi(this));
//
//		// Can access @UiField after calling createAndBindUi
//		button.setText(firstName);
//	}
//
//	@UiHandler("button")
//	void onClick(ClickEvent e) {
//		Window.alert("Hello!");
//	}
//
//	public void setText(String text) {
//		button.setText(text);
//	}
//
//	/**
//	 * Gets invoked when the default constructor is called
//	 * and a string is provided in the ui.xml file.
//	 */
//	public String getText() {
//		return button.getText();
//	}

}
