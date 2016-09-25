public class Example
{
	public static void main(String[] args)
	{
		Domino domino = new Domino();

		System.out.println("Tile 1: " + domino.getTile(3, 2)); // Output > Tile 1: [2 | 3]
		System.out.println("Tile 2: " + domino.getTile(new Tile(2, 3))); // Output > Tile 2: [2 | 3]
		System.out.println("Tile 3: " + domino.getTile(1, 7)); // Output > Tile 3: null
		System.out.println("Tile 4: " + domino.getIndexOf(3, 2)); // Output > Tile 4: 8
		System.out.println("Tile 5: " + domino.getIndexOf(new Tile(2, 3))); // Output > Tile 5: 8
		System.out.println("Tile 6: " + domino.getAt(8)); // Output > Tile 6: [2 | 3]
		System.out.println("Tile 7: " + domino.getAt(30)); // Output > Tile 7: null

		System.out.println("\nDomino:");
		domino.show(); // Prints all the domino tiles
		domino.messUp(); // Randomly shuffles the domino tiles
		System.out.println("\nMessed up domino:");
		domino.show(); // Prints all the tiles of the scrambled domino
		domino.sort(); // Order the domino
		System.out.println("\nReordered domino:");
		domino.showGraphic(); // Prints the sorted domino with graphic tiles

		Tile rndTile1 = domino.getRandomTile(); // Get a random tile from the domino
		Tile rndTile2 = domino.getRandomTile(Tile.Side.top, 0); // Get a random tile from the domino with the top value = 0
		Tile rndTile3 = domino.getRandomTile(Tile.Side.bottom, 4); // Get a random tile from the domino with the top value = 0
		System.out.println("\nRandom Tile 1: " + rndTile1);
		System.out.println("\nRandom Tile 2: " + rndTile2);
		System.out.println("\nRandom Tile 3: " + rndTile3);

		Tile[] rndTiles = domino.getRandomTiles(5); // Returns an array with 5 random tiles

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

		Tile[] missing = domino.verifyMissing(players); // Returns the missing tiles in an array of distributed tiles
		System.out.println("\nMissing Tiles:");
		for(int i = 0; i < missing.length; i++) System.out.println(missing[i]);

		Tile[] myTiles = new Tile[3];
		myTiles[0] = new Tile(2, 3);
		myTiles[1] = new Tile(5, 2);
		myTiles[2] = new Tile(1, 6);
		Tile[] missingFromArray = domino.verifyMissing(myTiles); // Returns missing tiles from an array of tiles
		System.out.println("\nMissing Tiles From Array:");
		for(int i = 0; i < missingFromArray.length; i++)
				System.out.println(missingFromArray[i]);
	}
}