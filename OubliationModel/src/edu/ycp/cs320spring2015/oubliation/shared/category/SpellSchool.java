package edu.ycp.cs320spring2015.oubliation.shared.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SpellSchool extends CategoryClass {
	final List<List<Integer>> spells;
	
	public SpellSchool(String name, String description, int[][] spells) {
		super(name, description);
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

	public Integer[] getSpellLevel(int spellLevel, int expLevel) {
		List<Integer> spellLevelList = spells.get(spellLevel).subList(0, expLevel);
		return spellLevelList.toArray(new Integer[spellLevelList.size()]);
	}
	
	public Integer[] getAllSpells(int expLevel) {
		LinkedList<Integer> allSpells = new LinkedList<Integer>();
		for (List<Integer> spellLv : spells) {
			List<Integer> spellSublist = spellLv.subList(0, expLevel);
			allSpells.addAll(spellSublist);
		}
		return allSpells.toArray(new Integer[allSpells.size()]);
	}
	
}
