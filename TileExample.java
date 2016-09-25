public class TileExample
{
	public static void main(String[] args)
	{
		Tile tile = new Tile(2, 5);
		System.out.println("Tile: " + tile); // Output > [2 / 5]
		System.out.println("Graphic Tile: " + tile.toGraphic()); // Output > [ : |:.:]
		
		System.out.println("Top: " + tile.getTop()); // Output > Top: 2
		System.out.println("Bottom: " + tile.getBottom()); // Output > Bottom: 5

		System.out.println("Verify if is greater than [5 / 1]: " + tile.isGreater(new Tile(5, 1))); // Output > true
		System.out.println("Verify if is smaller than [5 / 1]: " + tile.isSmaller(new Tile(5, 1))); // Output > false
		System.out.println("Verify if is equal to [5 / 2]: " + tile.isEqual(new Tile(5, 2))); // Output > true

		tile.upsidedown(); // Turns the tile upside down
		System.out.println("Upside Down Tile: " + tile);
	}
}