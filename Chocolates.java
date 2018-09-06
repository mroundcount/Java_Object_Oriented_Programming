import java.util.Arrays;
import java.util.stream.IntStream;

public class ChocolatePieces {

	public static void main(String[] args) {

		int arr[][] = { { 6, 8, 9, 7, 4 }, { 0, 0, 8, 0, 5 }, { 5, 7, 4, 5, 10 }, { 4, 2, 0, 6, 9 } };

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// we need this to determine the center
		int rowsEven = ((arr.length & 1) == 0) ? 1 : 0;
		int columnsEven = ((arr[0].length & 1) == 0) ? 1 : 0;
		int total = 0;
		int x = 0;
		int y = 0;
		int y1 = 0;
		int maxValue = 0;
		int sum = 0;

		// Actually calculating the center and consuming the chocolate
		// Row and column even values
		
		/* if (rowsEven == 0 && columnsEven == 0) {
			x = (arr[0].length - 1) / 2;
			y = (arr.length - 1) / 2;
			total = arr[y][x];
			arr[y][x] = 0;
		} 
		Row even and column odd
		else if (rowsEven == 0 && columnsEven == 1) {
			x = (arr[0].length - 1) / 2;
			y = (arr.length) / 2;
			total = arr[y][x];
			arr[y][x] = 0; 
		} */
		
		
		//Row odd and column even
		if (rowsEven == 1 && columnsEven == 0) {
			x = (arr[0].length) / 2;
			y = (arr.length) / 2;
			y1 = (arr.length -1) / 2;
			if(y>y1) {
				total = arr[y][x];
				arr[y][x] = 0;
			}
			else {
				total = arr[y1][x];
				arr[y1][x] = 0;
			}
			
		} 
		//Row and column odd values
		else {
			x = (arr[0].length) / 2;
			y = (arr.length) / 2;
			total = arr[y][x];
			arr[y][x] = 0;
		}

		// How to identify the surrounding cells
		int surroundingCells[] = { arr[y + 1][x], arr[y][x + 1], arr[y - 1][x], arr[y - 1][x] };

		// Adding the cells
		int sumArray = IntStream.of(surroundingCells).sum();
		
		// If they are not all 0s then there is still chocolate to eat
		while (sumArray > 0) {
			// finding the chocolate we will eat
			maxValue = Arrays.stream(surroundingCells).max().getAsInt();
			// find the index of the max value
			int j = 1;
			int maxIndex = 0;
			while (j < surroundingCells.length) {
				if (surroundingCells[maxIndex] < surroundingCells[j]) {
					maxIndex = j;
				}
				j++;
			}

			// move x and y to that cell
			switch (maxIndex) {
			case 0:
				y = y + 1;
				break;
			case 1:
				x = x + 1;
				break;
			case 2:
				y = y - 1;
				break;
			case 3:
				x = x - 1;
				break;

			}

			// eat the chocolate
			if(total!=0) {
			total = arr[y][x];
			arr[y][x] = 0;
			System.out.println("Value: " + total);
			sum = sum + total;
			}
			else {
				System.out.println("Done! Total: " + sum);
				return;
			}
			

			// find surrounding cells
			surroundingCells[0] = arr[y < arr[0].length ? y + 1 : y][x];
			surroundingCells[1] = arr[y][x < arr.length ? x + 1 : x];
			surroundingCells[2] = arr[y > 0 ? y - 1 : y][x];
			surroundingCells[3] = arr[y][x > 0 ? x - 1 : y];
		}

		// calculate sum
		sumArray = IntStream.of(surroundingCells).sum();
		
		System.out.println("sumArray: " + sumArray);

		return;
		
	
	}
}
