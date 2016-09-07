public class Example
{
	public static void main(String[] args)
	{
		Domino domino = new Domino();

		System.out.println("Tile 1: " + domino.getTile(3, 2)); // Output > Tile 1: 2 / 3
		System.out.println("Tile 2: " + domino.getTile(new Tile(2, 3))); // Output > Tile 2: 2 / 3
		System.out.println("Tile 3: " + domino.getTile(1, 7)); // Output > Tile 3: null
		System.out.println("Tile 4: " + domino.getIndexOf(3, 2)); // Output > Tile 4: 8
		System.out.println("Tile 5: " + domino.getIndexOf(new Tile(2, 3))); // Output > Tile 5: 8
		System.out.println("Tile 6: " + domino.getAt(8)); // Output > Tile 6: 2 / 3
		System.out.println("Tile 7: " + domino.getAt(30)); // Output > Tile 7: null

		System.out.println("\nGraphic Tile: " + domino.getTile(4, 6).toGraphic()); // Output > ::|:::

		System.out.println("\nDomino:");
		domino.show(); // Prints all the domino tiles
		domino.messUp(); // Randomly shuffles the domino tiles
		System.out.println("\nMessed up domino:");
		domino.show(); // Prints the messed up domino

		Tile rndTile1 = domino.getRandomTile(); // Get a random tile from the domino
		Tile rndTile2 = domino.getRandomTile(Tile.Side.top, 0); // Get a random tile from the domino with the top value = 0
		Tile rndTile3 = domino.getRandomTile(Tile.Side.bottom, 4); // Get a random tile from the domino with the top value = 0
		System.out.println("\nRandom Tile 1: " + rndTile1);
		System.out.println("\nRandom Tile 2: " + rndTile2);
		System.out.println("\nRandom Tile 3: " + rndTile3);

		Tile[][] players = domino.distribute(3); // Distribute the domino tiles to 3 players (this does not follow the dominos rules)
		// The amount of tiles for every player is the same; if tiles remain, they are ignored
		for(int i = 0; i < players.length; i++)
		{
			System.out.println("\nPlayer " + (i + 1));
			for(int j = 0; j < players[i].length; j++)
			{
				System.out.println(players[i][j]);
			}
		}
	}
}
