import java.util.*;

public class ColumnNumberInExcel {

	int countAtoZ = 26;
	static int columnIndex = 0;
	static double temp;

	private static void getColumnIndex(String columnName) {
		int stringLength = columnName.length();
		int count;
		int i;
		for (i = 0, count = (stringLength - 1); i < stringLength; i++, count--) {
			temp = getAlphabetValue(columnName.charAt(i));

			if (count != 0)
				temp *= (Math.pow(26, count));
			columnIndex += temp;

		}
		if (columnIndex <= 16384)
			System.out.println("Column Index is: " + (columnIndex));
		else
			System.out.println("Column does not exist in Microsoft Excel");
	}

	private static int getAlphabetValue(char i) {
		if (i == 'A')
			return 1;
		if (i == 'B')
			return 2;
		if (i == 'C')
			return 3;
		if (i == 'D')
			return 4;
		if (i == 'E')
			return 5;
		if (i == 'F')
			return 6;
		if (i == 'G')
			return 7;
		if (i == 'H')
			return 8;
		if (i == 'I')
			return 9;
		if (i == 'J')
			return 10;
		if (i == 'K')
			return 11;
		if (i == 'L')
			return 12;
		if (i == 'M')
			return 13;
		if (i == 'N')
			return 14;
		if (i == 'O')
			return 15;
		if (i == 'P')
			return 16;
		if (i == 'Q')
			return 17;
		if (i == 'R')
			return 18;
		if (i == 'S')
			return 19;
		if (i == 'T')
			return 20;
		if (i == 'U')
			return 21;
		if (i == 'V')
			return 22;
		if (i == 'W')
			return 23;
		if (i == 'X')
			return 24;
		if (i == 'Y')
			return 25;
		if (i == 'Z')
			return 26;
		else
			return -1;
	}

	public static void main(String args[]) {
		Scanner sc;
		String columnName;
		sc = new Scanner(System.in);
		System.out.println("Enter Column name: ");
		columnName = sc.nextLine();
		columnName = columnName.toUpperCase();
		sc.close();
		System.out.println("Column name is: " + columnName);
		getColumnIndex(columnName);
	}
}
