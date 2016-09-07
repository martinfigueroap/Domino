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
		if(top <= bottom)
		{
			this.top = top;
			this.bottom = bottom;
		}
		else
		{
			this.top = bottom;
			this.bottom = top;
		}
	}

	public boolean isGreater(Tile f)
	{
		if(bottom > f.getBottom() || (bottom == f.getBottom() && top > f.getTop()))
			return true;
		else return false;
	}

	public boolean isSmaller(Tile f)
	{
		if(bottom < f.getBottom() || (bottom == f.getBottom() && top < f.getTop()))
			return true;
		else return false;
	}

	public boolean isEqual(Tile f)
	{
		if(bottom == f.getBottom() && top == f.getTop())
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
		return top + " / " + bottom;
	}

	public String toGraphic()
	{
		String[] graphics = {" ", ".", ":", ".:", "::", ":.:", ":::"};
		return graphics[top] + "|" + graphics[bottom];
	}
}