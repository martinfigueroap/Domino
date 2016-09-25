public class Tile
{
	private int top, bottom;

	public enum Side
	{
		top,
		bottom
	};

	public Tile(int top, int bottom)
	{
		this.top = top;
		this.bottom = bottom;
	}

	public void upsidedown()
	{
		int temp = top;
		top = bottom;
		bottom = temp;
	}

	public boolean isGreater(Tile t)
	{
		int topA = (top <= bottom) ? top : bottom,
			bottomA = (top <= bottom) ? bottom : top;
		int topB = (t.getTop() < t.getBottom()) ? t.getTop() : t.getBottom(),
			bottomB = (t.getTop() < t.getBottom()) ? t.getBottom() : t.getTop();

		if(bottomA > bottomB || (bottomA == bottomB && topA > topB))
			return true;
		else return false;
	}

	public boolean isSmaller(Tile t)
	{
		int topA = (top <= bottom) ? top : bottom,
			bottomA = (top <= bottom) ? bottom : top;
		int topB = (t.getTop() < t.getBottom()) ? t.getTop() : t.getBottom(),
			bottomB = (t.getTop() < t.getBottom()) ? t.getBottom() : t.getTop();

		if(bottomA < bottomB || (bottomA == bottomB && topA < topB))
			return true;
		else return false;
	}

	public boolean isEqual(Tile t)
	{
		int topA = (top <= bottom) ? top : bottom,
			bottomA = (top <= bottom) ? bottom : top;
		int topB = (t.getTop() < t.getBottom()) ? t.getTop() : t.getBottom(),
			bottomB = (t.getTop() < t.getBottom()) ? t.getBottom() : t.getTop();

		if(bottomA == bottomB && topA == topB)
			return true;
		else return false;
	}

	public int getTop()
	{
		return top;
	}

	public int getBottom()
	{
		return bottom;
	}

	public String toString()
	{
		return "[" + top + " / " + bottom +  "]";
	}

	public String toGraphic()
	{
		String[] graphics = {"   ", " . ", " : ", " .:", " ::", ":.:", ":::"};
		return "[" + graphics[top] + "|" + graphics[bottom] + "]";
	}
}