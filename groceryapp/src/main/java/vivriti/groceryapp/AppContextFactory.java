package vivriti.groceryapp;


public class AppContextFactory {

// factory class that would create the AppContext object, can be called per request/thread

		
	public static AppContext getAppContext() {
		
		AppContext ctx = new AppContext();
		ctx.setDiscountStrats(DiscStrategyList.getInstance().getStrategies());
		return ctx;
		
	}

}
