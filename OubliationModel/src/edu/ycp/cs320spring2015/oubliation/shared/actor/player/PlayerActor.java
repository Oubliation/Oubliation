package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.items.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.PlayerActorMemento;

/**
 * TODO: Come back here! Complete JavaDoc
 * An actor controlled by the player;extends Actor
 *
 */
final public class PlayerActor extends Actor implements Serializable {
	private static final long serialVersionUID = -6349964020742433276L;
	public PlayerActor () {}
	
	private PlayerIdentity identity;
	private PlayerStats stats;
	
	private LinkedList<Equipment> battleEquipQueue;
		
	public static EnumMap<Element, Double> makeElementalMods() {
		EnumMap<Element, Double> elementalMods = new EnumMap<Element, Double>(Element.class);
		elementalMods.put(Element.ice, 1.0);
		elementalMods.put(Element.lightning, 1.0);
		elementalMods.put(Element.magic, 1.0);
		elementalMods.put(Element.physical, 1.0);
		return  elementalMods;
	}
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param loadout {@link Loadout}
	 * @param health The amount of life-force that an actor has before death.
	 * @param identity {@link PlayerIdentity}
	 * @param stats {@link PlayerStats}
	 */
	public PlayerActor(NameTag nameTag, int health, Status status,
			Loadout loadout, PlayerIdentity identity, PlayerStats stats) {
		super(nameTag, health, status, loadout, makeElementalMods());
		this.identity = identity;
		this.stats = stats;
	}
	/**
	 * @see PlayerIdentity#getLevel()
	 */
	public int getLevel() {
		return identity.getLevel();
	}
	/**
	 * @see PlayerIdentity#updateLevel()
	 */
	public void updateLevel() {
		identity.updateLevel();
	}
	/**
	 * @see PlayerIdentity#isLevelUpReady()
	 */
	public boolean isLevelUpReady() {
		return identity.isLevelUpReady();
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
	/**
	 * 
	 * @see PlayerStats#getMaxWitchMp()
	 */
	public int getMaxWitchMp(int level) {
		return Math.max((getScore(BruceScore.intelligently)-level)*4, 0);
	}
	/**
	 * 
	 * @see PlayerStats#getMaxPriestMp()
	 */
	public int getMaxPriestMp(int level) {
		return Math.max((getScore(BruceScore.godly)-level)*4, 0);
	}
	
	/**
	 * @see PlayerStats#getWitchMp(int)
	 */
	public int getWitchMp(int level) {
		return stats.getWitchMp(level);
	}
	/**
	 * @see PlayerStats#getPriestMp(int)
	 */
	public int getPriestMp(int level) {
		return stats.getPriestMp(level);
	}

	/**
	 * @param equipment to equip outside battle
	 */
	public void fieldEquip(Equipment equipment, Inventory inventory) {
		equipment.removeFrom(inventory);
		equipment.equipTo(new FieldLoadoutFacade(getLoadout(), stats));
	}
	
	/**
	 * @param equipment to unequip outside battle
	 */
	public void fieldUnequip(Equipment equipment, Inventory inventory) {
		equipment.addTo(inventory);
		equipment.unequipFrom(new FieldLoadoutFacade(getLoadout(), stats));
	}
	/**
	 * @param add equipment to the battle equip queue
	 */
	public void queueEquipment(Equipment equipment, Inventory inventory) {
		equipment.removeFrom(inventory);
		battleEquipQueue.add(equipment);
	}
	/**
	 * @param remove equipment from the battle equip queue
	 */
	public void dequeueEquipment(Equipment equipment, Inventory inventory) {
		equipment.addTo(inventory);
		battleEquipQueue.remove(equipment);
	}
	/**
	 * equip next equipment in the battle equip queue
	 */
	public void advanceBattleQueue() {
		battleEquipQueue.pop().equipTo(getLoadout());
	}
	/**
	 * @param equipment to unequip
	 */
	public void battleUnequip(Equipment equipment, Inventory inventory) {
		equipment.addTo(inventory);
		equipment.unequipFrom(getLoadout());
	}
	
	public Utility[] getAutoEquip() {
		return stats.getAutoEquip();
	}
	
	public void startBattle() {
		
	}
	public void endBattle() {
		
	}
	
	public int getScore(BruceScore score) {
		return identity.getScores(score)+stats.getBonusScore(score);
	}
	public int getHitCount() {
		return identity.getHitCount();
	}

	public int getMaxHealth() {
		return identity.getMaxHealth()+(getScore(BruceScore.healthily)/3);
	}

	public int getInitiative() {
		int initiativeMin = getScore(BruceScore.quickly);
		int initiativeRange = getScore(BruceScore.luckily);
		
		return initiativeMin+(new Random()).nextInt(initiativeRange);
	}
	
	public int getAttackMod() {
		return getScore(BruceScore.mightily)/3;
	}
	
	public int getAccuracyMod() {
		return getScore(BruceScore.luckily)/3;
	}
	public int getEvasion() {
		return getScore(BruceScore.quickly);
	}
	public void selectAnyBattleBehavior(BattleController controller) {
		getHand().select(controller);
	}
	
	public void incExperience(int amount) {
		identity.incExperience(amount);
	}
	public int getExperience() {
		return identity.getExperience();
	}
	
	
	public PlayerActorMemento getTransfer() {
		PlayerActorMemento transfer = new PlayerActorMemento(getNameTag(), getHealth(), getStatus(), identity);
		getLoadout().addTransferData(transfer);
		stats.addTransferData(transfer);
		
		return transfer;
	}
}
