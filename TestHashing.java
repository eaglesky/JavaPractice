import java.util.*;

public class TestHashing {

	public enum MediaConditionRuleMatchEventType {
	    PageView("pageView"),
	    AdView("adView"),
	    AdClick("adClick"),
	    AdRequest("adRequest"),
	    BeaconAdView("beaconAdView"),
	    BeaconAdClick("beaconAdClick"),
	    ConversionAction("conversionAction");

	    private final String _expressionValueName;
	    private static final MediaConditionRuleMatchEventType[] kVALUES = values();

	    MediaConditionRuleMatchEventType(String expressionValueName) {
	        _expressionValueName = expressionValueName;
	    }
	}

	static class MatchValue {
		private final Long id;
		private final MediaConditionRuleMatchEventType type;
		public MatchValue(Long id, MediaConditionRuleMatchEventType type) {
			this.id = id;
			this.type = type;
		}

		public void printHashCode() {
			System.out.println(id.hashCode());
			System.out.println(type.hashCode());
		}
	}

	public static void main(String[] args) {
		MatchValue mv = new MatchValue(100L, MediaConditionRuleMatchEventType.PageView);
		mv.printHashCode();
	}
}