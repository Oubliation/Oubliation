package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.targets.ActionTarget;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public class Healthy extends Status {
	private static final long serialVersionUID = -245305006902248841L;
	
	public Healthy() {
		super(new NameTag("Healthy", "Oll Korrect"));
	}
	
	@Override
	public PartyController onTurnStart(PartyController controller) {
		return controller;
	}
	
	private abstract class HealthyModifier implements ActionModifier {
		@Override
		public Status getStatus() {
			return Healthy.this;
		}
		@Override
		public String getStatusName() {
			return Healthy.this.getName();
		}
	}
	
	@Override
	public ActionModifier getActionModifier(final ActionTarget source, final Actor target) {
		final ActionModifier targetModifier = target.getTargetModifier();
		return new HealthyModifier() {
			@Override
			public boolean onHitTest(int accuracy) {
				return targetModifier.onHitTest(accuracy);
			}
			@Override
			public int onReceiveDamage(int damage, Element element) {
				return targetModifier.onReceiveDamage(damage, element);
			}
			@Override
			public int onReceiveHealing(int amount) {
				return targetModifier.onReceiveHealing(amount);
			}
			@Override
			public ActionTarget getSource() {
				return source;
			}
			@Override
			public ActionTarget getTarget() {
				return target;
			}
			@Override
			public ActionModifier getTargetModifier() {
				return targetModifier;
			}
		};
	}

	@Override
	public ActionModifier getTargetModifier(final ActionTarget target) {
		return new HealthyModifier() {
			@Override
			public boolean onHitTest(int accuracy) {
				return target.hitTest(accuracy);
			}
			@Override
			public int onReceiveDamage(int damage, Element element) {
				return target.receiveDamage(damage, element);
			}
			@Override
			public int onReceiveHealing(int amount) {
				return target.receiveHealing(amount);
			}
			@Override
			public ActionTarget getSource() {
				return null;
			}
			@Override
			public ActionTarget getTarget() {
				return target;
			}
			@Override
			public ActionModifier getTargetModifier() {
				return null;
			}
		};
	}
	@Override
	public Status refresh() {
		return new Healthy();
	}
}
