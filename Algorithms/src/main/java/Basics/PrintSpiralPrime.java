package Basics;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

enum Direction {
	RIGHT(0),
	TOP(1),
	LEFT(2),
	BOTTOM(3);

	int i;

	Direction(int i) {
		this.i = i;
	}

	Map<Integer, Direction> getMap() {
		return Arrays.stream(Direction.values()).collect(Collectors.toMap(Direction::getValue, direction -> direction));
	}

	int getValue() {
		return i;
	}
}

public class PrintSpiralPrime {
	public static void main(String[] args) {
		int spiralWidth = 15;
		int[][] spiralBoard = new int[spiralWidth][spiralWidth];
		int x = spiralWidth % 2 == 0 ? spiralWidth / 2 - 1 : spiralWidth / 2;
		int y = spiralWidth / 2;
		int stepCounter = 0;
		boolean switchCounter = true;
		Direction direction = Direction.RIGHT;
		Map<Integer, Direction> map = direction.getMap();
		spiralBoard[x][y] = 1;

		for(int i = 2; i < spiralWidth * spiralWidth - 1; ) {
			if(switchCounter) stepCounter++;
			for(int j = 0; j < stepCounter && i<= spiralWidth * spiralWidth; j++) {
				switch(direction) {
					case RIGHT:
						spiralBoard[x][++y] = i++;
						break;
					case TOP:
						spiralBoard[--x][y] = i++;
						break;
					case LEFT:
						spiralBoard[x][--y] = i++;
						break;
					case BOTTOM:
						spiralBoard[++x][y] = i++;
						break;
				}
			}
			direction = map.get(((direction.getValue() + 1) % 4));
			switchCounter = !switchCounter;
		}

		printSpiralBoard(spiralBoard);
	}

	private static void printSpiralBoard(int[][] spiralBoard) {
		for(int i = 0; i < spiralBoard.length; i++) {
			for(int j = 0; j < spiralBoard[i].length; j++) {
				System.out.printf("%5d", spiralBoard[i][j]);
			}
			System.out.println();
		}
	}
}
