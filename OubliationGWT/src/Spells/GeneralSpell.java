package Spells;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.category.SpellSchool;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;

public class GeneralSpell extends EntityClass {
	private static final long serialVersionUID = 3828314878850697072L;

	Effect effect;
	Target target;
	int spellLevel;
	SpellSchool school;
	
	public GeneralSpell() {
		
	}
	
	public void apply(PartyController controller) {
		
	}
}
