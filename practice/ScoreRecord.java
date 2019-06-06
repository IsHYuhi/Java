import java.util.*;

public class ScoreRecord implements Comparable<ScoreRecord>{
  public String name;
  public int japanese;
  public int mathematics;
  public int english;
  public int science;
  public int submit_order;

  public ScoreRecord(String n, int j, int m, int e, int s, int so){
    this.name = n;
    this.japanese = j;
    this.mathematics = m;
    this.english = e;
    this.science = s;
    this.submit_order = so;
  }

  @Override
  public int compareTo(ScoreRecord o){
    if(japanese != o.japanese){
      return (japanese < o.japanese) ? 1:-1;
    }
    if(mathematics != o.mathematics){
      return (mathematics < o.mathematics) ? 1:-1;
    }
    if(english  != o.english){
      return (english < o.english) ? 1:-1;
    }
    if(science != o.science){
      return (science < o.science) ? 1:-1;
    }
    return 0;
  }
  public String toString(){
    return String.format("%2s, %3d, %3d, %3d, %3d, %3d", name, japanese, mathematics, english, science, submit_order);
  }

  public static void main(String[] args){
    ScoreRecord[] data = {
      new ScoreRecord("A", 60, 75, 60, 75, 1),
      new ScoreRecord("B", 60, 85, 80, 73, 2),
      new ScoreRecord("C", 85, 95, 66, 90, 3),
      new ScoreRecord("D", 95, 65, 65, 70, 4),
      new ScoreRecord("E", 90, 80, 60, 85, 5),
      new ScoreRecord("F", 85, 85, 65, 75, 6),
    };
    System.out.println("名前 国語 数学 英語 理科 提出");
    System.out.println("Original Order: ");
    for(ScoreRecord m : data)System.out.println(m);
    Arrays.sort(data);
    System.out.println("New Order");
    for(ScoreRecord m : data)System.out.println(m);
  }
}