
// no package name
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SquarePatterns {
	private SquarePatterns() {
	};

	private static final Map<Integer, List<Rectangle2D>> patterns = new HashMap<>();

	public static void createSquarePatterns(Random rnd, double patternArea, long nYears, double lsHeight, double lsWidth,
			double interYearVisits) {
		patterns.clear();
		double patternDim = Math.sqrt(patternArea);
		double lsArea = lsHeight * lsWidth;
		double targetPatternSum = (lsArea * nYears) / interYearVisits;
//		int totalFires = (int) Math.round(targetPatternSum / patternDim);
		double sum = 0;
		while (sum < targetPatternSum) {
			int year = rnd.nextInt((int) nYears);
			List<Rectangle2D> patternRects = patterns.get(year);
			if (!patterns.containsKey(year)) {
				patternRects = new ArrayList<>();
				patterns.put(year, patternRects);
			}
			double x = rnd.nextDouble() * (lsWidth - patternDim);
			double y = rnd.nextDouble() * (lsHeight - patternDim);

			Rectangle2D r = new Rectangle2D.Double(x, y, patternDim, patternDim);
			patternRects.add(r);
			sum += patternArea;
		}
	}

	public static boolean canBurn(int year, double x, double y) {
				List<Rectangle2D> yearlyPatterns = patterns.get(year);
		if (yearlyPatterns == null)
			return false;
		for (Rectangle2D square : yearlyPatterns) {
			if (square.contains(x, y))
				return true;
		}
		return false;
	}
}
