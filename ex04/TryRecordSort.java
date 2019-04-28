import java.util.Arrays;

public class TryRecordSort {
  public static void main(String[] args) {
	  SortableRecord[] recrds = {
		      new SortableRecord("s5000001",90, 85, 60),
		      new SortableRecord("s5000002",50, 75, 85),
		      new SortableRecord("s5000003",85, 65, 75),
		      new SortableRecord("s5000004",75, 80, 90),
		      new SortableRecord("s5000005",60, 64, 100),
		      new SortableRecord("s5000006",80, 75, 80),
		      new SortableRecord("s5000007",95, 67, 70)
	    };

    
    System.out.println("Original Order: ");
    for (Record v : recrds) System.out.println(v);

    Arrays.sort(recrds);

    System.out.println("\nOrder after sorting using Comparable method: ");
    for (Record v : recrds) System.out.println(v);
 }

}
