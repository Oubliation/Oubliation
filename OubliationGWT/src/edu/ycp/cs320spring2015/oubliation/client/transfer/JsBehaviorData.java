package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.NoEffect;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAlliedColumns;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAlliedGroup;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAlliedRows;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAlliedUnits;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAnyOpposingColumns;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAnyOpposingRows;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAnyOpposingUnits;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectFrontOpposingRow;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectFrontOpposingUnits;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectOpposingGroup;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectSelf;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetAdaptor;

public class JsBehaviorData extends JavaScriptObject {
	protected JsBehaviorData() {}
	
	final protected Effect getEffect(String name) {
		switch (name) {
		case "NoEffect":
			return new NoEffect();
		}
		throw new IllegalStateException();
	}

	final protected TargetAdaptor getPartyTarget(String name) {
		switch (name) {
			case "SelectAlliedUnits": return new SelectAlliedUnits();
			case "SelectAlliedRows": return new SelectAlliedRows();
			case "SelectAlliedColumns": return new SelectAlliedColumns();
			case "SelectAlliedGroup": return new SelectAlliedGroup();
			case "SelectSelf": return new SelectSelf();
		}
		throw new IllegalStateException();
	}
	final protected TargetAdaptor getBattleTarget(String name) {
		switch (name) {
			case "SelectAlliedUnits": return new SelectAlliedUnits();
			case "SelectAlliedRows": return new SelectAlliedRows();
			case "SelectAlliedColumns": return new SelectAlliedColumns();
			case "SelectAlliedGroup": return new SelectAlliedGroup();
			case "SelectSelf": return new SelectSelf();
			case "SelectAnyOpposingUnits": return new SelectAnyOpposingUnits();
			case "SelectAnyOpposingRows": return new SelectAnyOpposingRows();
			case "SelectAnyOpposingColumns": return new SelectAnyOpposingColumns();
			case "SelectFrontOpposingUnits": return new SelectFrontOpposingUnits();
			case "SelectFrontOpposingRow": return new SelectFrontOpposingRow();
			case "SelectOpposingGroup": return new SelectOpposingGroup();
		}
		throw new IllegalStateException();
	}

	final public native String getPrimaryEffectName() /*-{
		return this.primaryEffect;
	}-*/;
	
	final protected Effect getPrimaryEffect() {
		return getEffect(getPrimaryEffectName());
	}

	final public native String getTargetName() /*-{
		return this.target;
	}-*/;

	final protected native int getHealthDeltaMin() /*-{
		return this.healthDeltaMin;
	}-*/;

	final protected native int getHealthDeltaRange() /*-{
		return this.healthDeltaRange;
	}-*/;

	final protected native int getAccuracy() /*-{
		return this.accuracy;
	}-*/;

	final protected native String getElementName() /*-{
		return this.element;
	}-*/;
	
	final protected Element getElement() {
		return Element.valueOf(getElementName());
	}

	final public native String getSecondaryEffectName() /*-{
		return this.secondaryEffect;
	}-*/;

	final protected Effect getSecondaryEffect() {
		return getEffect(getSecondaryEffectName());
	}

	final protected native int getPotency() /*-{
		return this.potency;
	}-*/;

	final protected native String getActionDescriptor() /*-{
		return this.actionDescriptor;
	}-*/;

	final protected native String getPrimaryDescriptor() /*-{
		return this.primaryDescriptor;
	}-*/;

	final protected native String getSecondaryDescriptor() /*-{
		return this.secondaryDescriptor;
	}-*/;
	
	final public Behavior getBehavior() {
		return new Behavior(getPrimaryEffect(), getBattleTarget(getTargetName()), getHealthDeltaMin(), getHealthDeltaRange(),
				getAccuracy(), getElement(), getSecondaryEffect(), getPotency(),
				getActionDescriptor(), getPrimaryDescriptor(), getSecondaryDescriptor());
	}
}
