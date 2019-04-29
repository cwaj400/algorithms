public class FloodFill {
  public static void main(String[] args) {

    int row = 1;
    int column = 1;
    Color nColor = Color.BLUE;

    Color[][] colors = new Color[][]{
            {Color.BLUE, Color.GREEN},
            {Color.GREEN, Color.RED}
    };


    floodFill(colors, row, column, nColor);
    //System.out.println(colors);
  }

  static boolean floodFill(Color[][] screen, int row, int column, Color newColor) {
    if (screen[row][column] == newColor) return false;
    return paintFill(screen, row, column, screen[row][column], newColor);
  }

  static boolean paintFill(Color[][] colors, int row, int column, Color oldColor, Color newColor) {
    // doing checks, base case:
    if (row < 0 || row >= colors.length || column < 0 || column >= colors[0].length) {
      return false;
    }

    if (colors[row][column] == oldColor) {
      colors[row][column] = newColor;
      paintFill(colors, row - 1, column, oldColor, newColor);
      paintFill(colors, row + 1, column, oldColor, newColor);
      paintFill(colors, row, column - 1, oldColor, newColor);
      paintFill(colors, row, column + 1, oldColor, newColor);
    }
    return true;
  }

  enum Color {BLUE, RED, YELLOW, GREEN}
}
