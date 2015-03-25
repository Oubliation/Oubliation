package edu.ycp.cs320spring2015.oubliation.shared.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

/**
 * 
 * Describes spells learnt within a school of magic
 *
 */
public class SpellSchool extends CategoryClass {
	private static final long serialVersionUID = -4878500979571572536L;
	public SpellSchool() {}
	
	private List<List<Integer>> spells;
	
	public SpellSchool(NameTag nameTag, int[][] spells) {
		super(nameTag);
		ArrayList<List<Integer>> spellsArray = new ArrayList<List<Integer>>();
		for (int[] spellLevel : spells) {
			ArrayList<Integer> spellLevelArray = new ArrayList<Integer>();
			for (int spell : spellLevel) {
				spellLevelArray.add(spell);
			}
			spellsArray.add(Collections.unmodifiableList(spellLevelArray));
		}
		this.spells = Collections.unmodifiableList(spellsArray);
	}
	//TODO: these formulas are wrong (should be expLevel-spellLevel). also: expLevel should be schoolMastery
	
	/**
	 * @param spellLevel category of spell difficulty
	 * @param expLevel  job adjusted experience level
	 * @return list of spells for spell level x known at experience level y
	 */
	public Integer[] getSpellLevel(int spellLevel, int expLevel) {
		List<Integer> spellLevelList = spells.get(spellLevel-1).subList(0, expLevel-1);
		return spellLevelList.toArray(new Integer[spellLevelList.size()]);
	}
	
	/**
	 * 
	 * @param expLevel expLevel job adjusted experience level
	 * @return list of all spells known at experience level x
	 */
	public Integer[] getAllSpells(int expLevel) {
		LinkedList<Integer> allSpells = new LinkedList<Integer>();
		for (List<Integer> spellLv : spells) {
			List<Integer> spellSublist = spellLv.subList(0, expLevel-1);
			allSpells.addAll(spellSublist);
		}
		return allSpells.toArray(new Integer[allSpells.size()]);
	}
	
}
