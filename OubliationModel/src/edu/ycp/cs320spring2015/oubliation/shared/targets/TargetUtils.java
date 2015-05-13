package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.util.Arrays;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Corpse;

public abstract class TargetUtils {

	static public Actor[][] splitUnits(Actor[] targets, int max) {
		Actor[][] results = new Actor[targets.length][1];
		int resultIndex = 0;
		for (int count=0; count<Math.min(max, targets.length); count += 1) {
			Actor target = targets[count];
			if (target.getStatusClass() != Corpse.class) {
				results[resultIndex] = new Actor[] { target };
				resultIndex += 1;
			}
		}
		return Arrays.copyOfRange(results, 0, resultIndex-1);
	}
	
	static public Actor[][] splitRows(Actor[] targets, int max) {
		LinkedList<Actor[]> result = new LinkedList<Actor[]>();
		LinkedList<Actor> row1 = new LinkedList<Actor>();
		LinkedList<Actor> row2 = new LinkedList<Actor>();
		LinkedList<Actor> row = row1;
		for (int count=0; count<Math.min(max, targets.length); count += 1) {
			if (count == 3) {
				row = row2;
			}
			Actor target = targets[count];
			if (target.getStatusClass() != Corpse.class) {
				row.add(target);
			}
		}
		if (row1.size() > 0) {
			result.add(row1.toArray(new Actor[row1.size()]));
		}
		if (row2.size() > 0) {
			result.add(row2.toArray(new Actor[row2.size()]));
		}
		
		return result.toArray(new Actor[result.size()][]);
	}
	static public Actor[][] splitColumns(Actor[] targets) {
		LinkedList<Actor[]> result = new LinkedList<Actor[]>();
		LinkedList<Actor> col1 = new LinkedList<Actor>();
		LinkedList<Actor> col2 = new LinkedList<Actor>();
		LinkedList<Actor> col3 = new LinkedList<Actor>();
		for (int count=0; count<targets.length; count += 1) {
			Actor target = targets[count];
			if (target.getStatusClass() != Corpse.class) {
				if (count%3 == 0) {
					col1.add(target);
				} else if (count%3 == 1) {
					col2.add(target);
				} else if (count%3 == 2) {
					col3.add(target);
				} else {
					throw new IllegalStateException();
				}
			}
		}
		if (col1.size() > 0) {
			result.add(col1.toArray(new Actor[col1.size()]));
		}
		if (col2.size() > 0) {
			result.add(col2.toArray(new Actor[col2.size()]));
		}
		if (col3.size() > 0) {
			result.add(col3.toArray(new Actor[col3.size()]));
		}
		
		return result.toArray(new Actor[result.size()][]);
	}
	
	static public Actor[][] splitGroup(Actor[] targets) {
		LinkedList<Actor> results = new LinkedList<Actor>();
		for (int count=0; count<targets.length; count += 1) {
			Actor target = targets[count];
			if (target.getStatusClass() != Corpse.class) {
				results.add(target);
			}
		}
		return new Actor[][] { results.toArray(new Actor[results.size()]) };
	}
}
