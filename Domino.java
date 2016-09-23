import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Domino
{
	private Tile[] tiles;
	private Random random;

	public Domino()
	{
		tiles = new Tile[28];

		int k = 0;
		for(int i = 0; i <= 6; i++)
			for(int j = 0; j <= i; j++, k++)
				tiles[k] = new Tile(j, i);

		random = new Random();
	}

	public Tile getTile(int top, int bottom)
	{
		Tile t = new Tile(top, bottom);

		for(Tile tile : tiles)
			if(tile.isEqual(t)) return t;

		return null;
	}

	public Tile getTile(Tile t)
	{
		for(Tile tile : tiles)
			if(tile.isEqual(t)) return t;

		return null;
	}

	public int getIndexOf(int top, int bottom)
	{
		Tile t = new Tile(top, bottom);
		int start = 0, end = tiles.length - 1;
		boolean found = false;
		int position = -1, pos = 0;

		while((start <= end) && !found)
		{
			pos = (start + end) / 2;
			if(tiles[pos].isEqual(t))
			{
				found = true;
				position = pos;
			}
			else if(t.isGreater(tiles[pos])) start = pos + 1;
			else end = pos - 1;
		}

		return position;
	}

	public int getIndexOf(Tile t)
	{
		int start = 0, end = tiles.length - 1;
		boolean found = false;
		int position = -1, pos = 0;

		while((start <= end) && !found)
		{
			pos = (start + end) / 2;
			if(tiles[pos].isEqual(t))
			{
				found = true;
				position = pos;
			}
			else if(t.isGreater(tiles[pos])) start = pos + 1;
			else end = pos - 1;
		}

		return position;
	}

	public void messUp()
	{
		Tile[] messed = new Tile[tiles.length];
		int r = 0;
		for(int i = 0; i < tiles.length; i++)
		{
			do {
				r = random.nextInt(tiles.length);
			} while (messed[r] != null);

			messed[r] = tiles[i];
		}

		tiles = null;
		tiles = messed;
	}

	public Tile getAt(int i)
	{
		return (i >= 0 && i < tiles.length) ? tiles[i] : null;
	}

	public Tile getRandomTile()
	{
		return tiles[random.nextInt(tiles.length)];
	}

	public Tile getRandomTile(Tile.Side side, int i)
	{
		List<Tile> possible = new ArrayList<Tile>();

		switch(side)
		{
			case top:
				for(Tile tile : tiles)
					if(tile.getTop() == i)
						possible.add(tile);
				break;
			case bottom:
				for(Tile tile : tiles)
					if(tile.getBottom() == i)
						possible.add(tile);
				break;
		}

		return possible.get(random.nextInt(possible.size()));
	}

	public Tile[] getRandomTiles(int n)
	{
		if(n > 0 && n <= 28)
		{
			Tile[] array = new Tile[n];
			boolean[] used = new boolean[tiles.length];
			for(int i = 0; i < used.length; i++) used[i] = false;

			for(int i = 0; i < n; i++)
			{
				int index;
				do {
					index = random.nextInt(28);
				} while(used[index]);
				array[i] = tiles[index];
			}

			return array;
		}
		else return null;
	}

	public Tile[][] distribute(int n)
	{
		boolean[] used = new boolean[tiles.length];
		for(int i = 0; i < used.length; i++) used[i] = false;

		int amount = tiles.length / n, r = 0;
		Tile[][] distribution = new Tile[n][amount];

		for(int i = 0; i < n; i++)
		{
			Tile[] tilesDist = new Tile[amount];
			for(int j = 0; j < amount; j++)
			{
				do {
					r = random.nextInt(tiles.length);
				} while (used[r]);
				used[r] = true;
				tilesDist[j] = tiles[r];
			}

			distribution[i] = tilesDist;
			tilesDist = null;
		}

		return distribution;
	}

	public Tile[] verifyMissing(Tile[][] distrib)
	{
		List<Tile> missing = new ArrayList<Tile>();
		for(Tile t : tiles)
		{
			boolean found = false;
			for(int i = 0; i < distrib.length; i++)
			{
				for(int j = 0; j < distrib[i].length; j++)
				{
					if(distrib[i][j].isEqual(t))
						found = true;
				}
			}

			if(!found) missing.add(t);
		}

		Tile[] array = new Tile[missing.size()];
		for(int i = 0; i < missing.size(); i++) array[i] = missing.get(i);
		return array;
	}

	public Tile[] verifyMissing(Tile[] distrib)
	{
		List<Tile> missing = new ArrayList<Tile>();
		for(Tile t : tiles)
		{
			boolean found = false;
			for(int i = 0; i < distrib.length; i++)
			{
				if(distrib[i].isEqual(t))
					found = true;
			}

			if(!found) missing.add(t);
		}

		Tile[] array = new Tile[missing.size()];
		for(int i = 0; i < missing.size(); i++) array[i] = missing.get(i);
		return array;
	}

	public Tile[] getTiles()
	{
		return tiles;
	}

	public void show()
	{
		for(Tile t : tiles) System.out.println(t);
	}
}