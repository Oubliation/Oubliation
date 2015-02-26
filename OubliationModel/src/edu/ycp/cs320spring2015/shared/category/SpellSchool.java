package edu.ycp.cs320spring2015.shared.category;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpellSchool implements Category {
	ArrayList<Integer>[] spells;
	
	public List<Integer> getSpellLevel(int spellLevel, int expLevel) {
		return spells[spellLevel].subList(0, expLevel);
	}
	
	public List<Integer> getAllSpells(int expLevel) {
		LinkedList<Integer> spellList = new LinkedList<Integer>();
		for (ArrayList<Integer> spellLv : spells) {
			List<Integer> spellSublist = spellLv.subList(0, expLevel);
			spellList.addAll(spellSublist);
		}
		return spellList;
	}
	
}
