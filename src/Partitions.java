import java.util.ArrayList;
import java.util.List;

public class Partitions {
	public static List<String> getPartitions(int n) {
		List<String> list = new ArrayList<String>();
		List<Integer> line = new ArrayList<Integer>();
		list.add(String.valueOf(n));
		line.add(n);
		int pos = n;
		while(line.get(0) > 1) {
			pos = 0;
			// Revisar de derecha a izquierda para que posicion i, line_i > 1
			for(int i = line.size()-1; i >= 0 & pos == 0; i--) {
				if(line.get(i) > 1) {
					pos = i;
				}
			}
			// Se copian todos los elementos a_j, j < i para crear una nueva secuencia
			List<Integer> newLine = new ArrayList<Integer>();
			newLine.addAll(line.subList(0, pos));
			// Se agrega un elemento b_i = a_i-1 al final de la nueva secuencia
			newLine.add(line.get(pos)-1);
			// Se agregan elementos a la secuencia de izquierda a derecha,
			// buscando agregar un b_j tal que sea el maaximo posible y b_j >= b_{j+1}
			int sum = newLine.stream().mapToInt(Integer::intValue).sum();
			while(newLine.stream().mapToInt(Integer::intValue).sum() < n) {
				sum = newLine.stream().mapToInt(Integer::intValue).sum();
				newLine.add(Integer.min(newLine.get(newLine.size()-1), n-sum));
			}
			line = newLine;
			String s = "";
			for(int i = 0; i < line.size(); i++) {
				s += String.valueOf(line.get(i))+",";
			}
			list.add(s.substring(0,s.length()-1));
		}
		return list;
	}
}
