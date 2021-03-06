import java.util.Arrays;

public class IceCreamParlor {
	public static int[] findChoices(int[] menu, int money) {
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		for(int i=0;i< sortedMenu.length;i++) {
			int complement = money - sortedMenu[i];
			int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, complement);
			if(location >=0 && location < sortedMenu.length && sortedMenu[location] == complement) {
				int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
				return indices;
			}
		}
		return null;
	}

	private static int[] getIndicesFromValues(int[] menu, int ivalue1, int ivalue2) {
		int index1 = indexOf(menu, ivalue1 , -1);
		int index2 = indexOf(menu, ivalue2, index1);
		int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
		return indices;
	}

	private static int indexOf(int[] menu, int value, int excludeThis) {
		for(int i = 0; i< menu.length;i++) {
			if(menu[i] == value && i != excludeThis) {
				return i;
			}	
		}
		return -1;
	}
}
