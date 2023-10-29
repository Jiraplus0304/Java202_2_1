package sit.int202.simpletue.simpletue;

public class CalcGrade {
    private int score;

    public CalcGrade(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        if (score>=80) {
            return "A";
        } else if (score>=70) {
            return "B";
        } else if (score>=60) {
            return  "C";
        } else {
            return "F";
        }
    }
}
