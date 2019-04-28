public class Record {
  public final String student_id;
  public final int score_total;
  public final int score_math;
  public final int score_Japanese;
  public final int score_English;

  public Record  (String id, int m, int j, int e) {
	  student_id = id;
	  score_total = m + j + e;
	  score_math = m;
	  score_Japanese = j;
	  score_English = e;
  }

  public String toString() {
    return new StringBuffer(128).append("ID: ").append(student_id)
    		.append(", total: ").append(score_total)
    		.append(", math: ").append(score_math)
    		.append(", Japanese: ").append(score_Japanese)
    		.append(", English: ").append(score_English)
    		.toString();
  }
}
