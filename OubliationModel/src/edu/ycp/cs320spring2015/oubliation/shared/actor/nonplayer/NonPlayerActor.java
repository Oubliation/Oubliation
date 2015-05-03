package edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer;

import java.util.EnumMap;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;
/**
 * 
 * For actors not controlled by player; extends Actor
 *
 */
public abstract class NonPlayerActor extends Actor {
	private static final long serialVersionUID = 663010937548176787L;
	
	private final transient NonPlayerIdentity identity;
	private final transient NonPlayerStats stats;
	
	
	
	/**
	 * 
	 * @param nameTag {@link NameTag} 
	 * @param loadout {@link Loadout}
	 * @param identity {@link NonPlayerIdentity}
	 * @param stats {@link NonPlayerStats}
	 */
	public NonPlayerActor(NameTag nameTag, Status status,
			Loadout loadout, EnumMap<Element, Double> elementalMods,
			NonPlayerIdentity identity, NonPlayerStats stats) {
		super(nameTag, stats.getMaxHp(), status, loadout, elementalMods);
		this.identity = identity;
		this.stats = stats;
	}
	
	public String getBackgroundName() {
		return identity.getBackgroundName();
	}
	public String getBackgroundDescription() {
		return identity.getBackgroundDescription();
	}
	public String getSpeciesName() {
		return identity.getSpeciesName();
	}
	public String getSpeciesDescription() {
		return identity.getSpeciesDescription();
	}
	public String getJobName() {
		return identity.getJobName();
	}
	public String getJobDescription() {
		return identity.getJobDescription();
	}

	public int getMaxHealth() {
		return stats.getMaxHp();
	}
	public int getHitCount() {
		return stats.getHitCount();
	}

	public int getInitiative() {
		return stats.getInitiative();
	}

	public int getAttackMod() {
		return stats.getAttackMod();
	}

	public int getAccuracyMod() {
		return stats.getAccuracyMod();
	}

	public int getEvasion() {
		return stats.getEvasion();
	}
	
	public void selectAnyBattleBehavior(BattleController controller) {
		stats.selectBattleBehavior(controller);
	}
	
	
}