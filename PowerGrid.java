import java.util.Scanner;

/**
 * Created by chris on 4/29/2016.
 */

public class PowerGrid {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int cases = reader.nextInt();
		for(int i = 0; i < cases; i++) {
			int rows = reader.nextInt();
			int cols = reader.nextInt();
			int oper = reader.nextInt();
			int[][] grid = new int[rows][cols];
			reader.nextLine();
			for(int j = 0; j < rows; j++) {
				String tmp = reader.nextLine();
				for(int k = 0; k < cols; k++) {
					grid[j][k] = tmp.charAt(k) - '0';
				}
			}
			for(int j = 0; j < oper; j++) {
				grid = command(grid, reader.nextLine());
			}
			for(int j = 0; j < grid.length; j++) {
				for(int k = 0; k < grid[j].length; k++) {
					System.out.print(grid[j][k]);
				}
				System.out.println();
			}
		}
	}

	private static int[][] command(int[][] grid, String comm) {
		String[] tmp = comm.split(" ");
		if(tmp[0].equalsIgnoreCase("R")) {
			int rInt=  Integer.parseInt(tmp[1]);
			for(int row = 0; row < grid.length; row++) {
				if(row % rInt == 0) {
					for(int i = 0; i < grid[row].length; i++) {
						if(grid[row][i] == 0) {
							grid[row][i] = 1;
						}
						else {
							grid[row][i] = 0;
						}
					}
				}
			}
			return grid;
		}
		else {
			int cInt = Integer.parseInt(tmp[1]);
			for(int col = 0; col < grid[0].length; col++) {
				if(col % cInt == 0) {
					for(int i = 0; i < grid.length; i++) {
						if(grid[i][col] == 0) {
							grid[i][col] = 1;
						}
						else {
							grid[i][col] = 0;
						}
					}
				}
			}
			return grid;
		}
	}
}
