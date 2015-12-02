import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Matching
{
	private static final int SHAPE_INDEX = 0;
	private static final int COLOR_INDEX = 1;
	private static final int PATTERN_INDEX = 2;
	private static final int NUMBER_INDEX = 3;
	
	public static void main(String args[])
	{
		 System.out.println(Arrays.toString(Matching.findMatch(new String[]{"DIAMOND","BLUE","SOLID","ONE"} , new String[]{"DIAMOND","GREEN","SOLID","TWO"} )));
		 System.out.println(Arrays.toString(Matching.findMatch(new String[]{"CIRCLE","GREEN","EMPTY","TWO"} , new String[]{"DIAMOND","BLUE","STRIPED","ONE"} )));
		 System.out.println(Arrays.toString(Matching.findMatch(new String[]{"DIAMOND","RED","SOLID","ONE"} , new String[]{"SQUIGGLE","BLUE","SOLID","TWO"})));
		 System.out.println(Arrays.toString(Matching.findMatch(new String[]{"SQUIGGLE","RED","STRIPED","ONE"} , new String[]{"SQUIGGLE","RED","STRIPED","ONE"} )));
	}

	public static String[] findMatch(String[] first, String[] second) {
		String[] returnMe = new String[4];

		Shape shape1 = Shape.getInstance(first[Matching.SHAPE_INDEX]);
		Shape shape2 = Shape.getInstance(second[Matching.SHAPE_INDEX]);
		Color color1 = Color.getInstance(first[Matching.COLOR_INDEX]);
		Color color2 = Color.getInstance(second[Matching.COLOR_INDEX]);
		Number number1 = Number.getInstance(first[Matching.NUMBER_INDEX]);
		Number number2 = Number.getInstance(second[Matching.NUMBER_INDEX]);
		Pattern pattern1 = Pattern.getInstance(first[Matching.PATTERN_INDEX]);
		Pattern pattern2 = Pattern.getInstance(second[Matching.PATTERN_INDEX]);

		if (shape1 == shape2) {
			if (color1 == color2) {
				returnMe[Matching.SHAPE_INDEX] = first[Matching.SHAPE_INDEX];
				returnMe[Matching.COLOR_INDEX] = first[Matching.COLOR_INDEX];
				returnMe[Matching.PATTERN_INDEX] = first[Matching.PATTERN_INDEX];
				returnMe[Matching.NUMBER_INDEX] = first[Matching.NUMBER_INDEX];
			} else {
				returnMe[Matching.SHAPE_INDEX] = first[Matching.SHAPE_INDEX];
				returnMe[Matching.COLOR_INDEX] = Color.getOddOneOut(color1, color2).name().toUpperCase();
				returnMe[Matching.PATTERN_INDEX] = first[Matching.PATTERN_INDEX];
				returnMe[Matching.NUMBER_INDEX] = Number.getOddOneOut(number1, number2).name().toUpperCase();
			}
		} else {
			if (pattern1 == pattern2) {
				returnMe[Matching.SHAPE_INDEX] = Shape.getOddOneOut(shape1, shape2).name().toUpperCase();
				returnMe[Matching.COLOR_INDEX] = Color.getOddOneOut(color1, color2).name().toUpperCase();
				returnMe[Matching.PATTERN_INDEX] = first[Matching.PATTERN_INDEX];
				returnMe[Matching.NUMBER_INDEX] = Number.getOddOneOut(number1, number2).name().toUpperCase();
			} else {
				returnMe[Matching.SHAPE_INDEX] = Shape.getOddOneOut(shape1, shape2).name();
				returnMe[Matching.COLOR_INDEX] = Color.getOddOneOut(color1, color2).name();
				returnMe[Matching.PATTERN_INDEX] = Pattern.getOddOneOut(pattern1, pattern2).name();
				returnMe[Matching.NUMBER_INDEX] = Number.getOddOneOut(number1, number2).name();
			}
		}
		return returnMe;
	}

	// wrapper classes for each enum that extend one class for inheritance would be better for code reusability
	enum Shape {
		CIRCLE, SQUIGGLE, DIAMOND;

		public static Shape getInstance(String input) {
			for (Shape currentShape : Shape.values())
				if (input.compareToIgnoreCase(currentShape.name()) == 0)
					return currentShape;
			return CIRCLE;
		}

		public static Shape getOddOneOut(Shape shape1, Shape shape2) {
			HashSet<Shape> set = new HashSet<Shape>();
			Collections.addAll(set, Shape.values());
			set.remove(shape1);
			set.remove(shape2);
			return (Shape) set.toArray()[0];
		}
	}

	enum Color {
		RED, BLUE, GREEN;

		public static Color getInstance(String input) {
			for (Color currentColor : Color.values())
				if (input.compareToIgnoreCase(currentColor.name()) == 0)
					return currentColor;
			return RED;
		}

		public static Color getOddOneOut(Color color1, Color color2) {
			HashSet<Color> set = new HashSet<Color>();
			Collections.addAll(set, Color.values());
			set.remove(color1);
			set.remove(color2);
			return (Color) set.toArray()[0];
		}
	}

	enum Number {
		ONE, TWO, THREE;

		public static Number getInstance(String input) {
			for (Number currentNumber : Number.values())
				if (input.compareToIgnoreCase(currentNumber.name()) == 0)
					return currentNumber;
			return ONE;
		}

		public static Number getOddOneOut(Number number1, Number number2) {
			HashSet<Number> set = new HashSet<Number>();
			Collections.addAll(set, Number.values());
			set.remove(number1);
			set.remove(number2);
			return (Number) set.toArray()[0];
		}
	}

	enum Pattern {
		SOLID, STRIPED, EMPTY;

		public static Pattern getInstance(String input) {
			for (Pattern currentPattern : Pattern.values())
				if (input.compareToIgnoreCase(currentPattern.name()) == 0)
					return currentPattern;
			return SOLID;
		}

		public static Pattern getOddOneOut(Pattern pattern1, Pattern pattern2) {
			HashSet<Pattern> set = new HashSet<Pattern>();
			Collections.addAll(set, Pattern.values());
			set.remove(pattern1);
			set.remove(pattern2);
			return (Pattern) set.toArray()[0];
		}
	}
}