package units;
import exceptions.MaxCapacityException;
import units.Army;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import units.Status;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import exceptions.FriendlyFireException;
import units.Archer;

import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class Scout extends Unit {
	public Scout(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
		
	}
	public void Hire (Army army) throws MaxCapacityException
	{
		if (army.getUnits().size()>=10)
		{
			throw new MaxCapacityException();
		}
		else  if (army.getUnits().size()>5)
		{
			Archer a = new Archer(2, 60, 0.4, 0.5, 0.6);
			a.setParentArmy(army);
			
		}
		
			
		
	}
	
}
