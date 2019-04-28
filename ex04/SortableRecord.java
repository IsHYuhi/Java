import java.util.*;

public class SortableRecord extends Record implements Comparable<SortableRecord>{

  public SortableRecord(String id, int m, int j, int e){
    super(id,m,j,e);
  }

  public int compareTo(SortableRecord v)
  {
    if(v.score_total < score_total) return -1;
    else if(v.score_total > score_total) return 1;
    if(v.score_math < score_math) return -1;
    else if(v.score_math > score_math) return 1;
    if(v.score_Japanese < score_Japanese) return 1;
    else if(v.score_Japanese > score_Japanese)return 1;
    if(v.score_English < score_English) return 1;
    else if(v.score_English > score_English) return 1;
    else return 0;
  }

}