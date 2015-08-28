package datamanagement;
public class ListUnitsCTL {
    
    private UnitManager unitManager;

    // Constructor for the ListUnitsCTL class. It retrieves
    // the UnitManager instance.
    public ListUnitsCTL() {
        unitManager = UnitManager.UM();
}
    
     // The listUnits method will take a list of units (unitLister) and
     // initially empty it. It then adds all units to the unitLister.
    public void listUnits( IUnitLister unitLister ) {

        unitLister.clearUnits();
        UnitMap units = unitManager.getUnits();
        for (String unitCode : units.keySet() )
            unitLister.addUnit(units.get(unitCode));}}
