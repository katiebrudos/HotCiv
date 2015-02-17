package hotciv.framework;

public interface HotCivFactory {
	
	public ActionStrategy getActionStrategy(); 
	public AgeStrategy getAgeStrategy(); 
	public SetupStrategy getSetupStrategy(); 
	public WinnerStrategy getWinnerStrategy(); 
	public AttackStrategy getAttackStrategy();
	public GrowthStrategy getGrowthStrategy();
	public ProductionStrategy getProductionStrategy();
}
