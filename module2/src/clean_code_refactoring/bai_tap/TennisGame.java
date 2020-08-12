package clean_code_refactoring.bai_tap;

public class TennisGame {
    public static final String DASH = "-";
    public static final int ZEROSCORE = 0;
    public static final int FIRSTSCORE = 1;
    public static final int SECONDSCORE = 2;
    public static final int THIRDSCORE = 3;

//Bắt đầu
    public static String getNormalScore(int score) {
        switch (score) {
            case ZEROSCORE:
                return "Love-All";
            case FIRSTSCORE:
                return "Fifteen-All";
            case SECONDSCORE:
                return "Thirty-All";
            case THIRDSCORE:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
//Trường hợp đặc biệt
    public static String getSpecialScore(int m_score1, int m_score2) {
        int minusResult = m_score1 - m_score2;
        boolean isAdvantagePlayer1 = minusResult == 1;
        boolean isAdvantagePlayer2 = minusResult == -1;
        boolean isWin = minusResult >= 2;
        if (isAdvantagePlayer1) return  "Advantage player1";
        else if (isAdvantagePlayer2) return  "Advantage player2";
        else {
            if (isWin) return  "Win for player1";
            else return  "Win for player2";
        }
    }

//Trường hợp khác
    public static String getDifferentScore(int m_score1, int m_score2) {
        String scoreDifferent="";
        int tempScore = 0;
        if (m_score1>0){
            scoreDifferent+=getNormalScore(m_score1);
        }else {
            scoreDifferent=DASH;
            if (m_score2>0){
                scoreDifferent+=getNormalScore(m_score2);
            }
        }
        return scoreDifferent;
    }
//Điểm của trận đấu
    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score="";
        boolean isStart = m_score1 == m_score2;
        boolean isWin = m_score1 >= 4 || m_score2 >= 4;
        if (isStart) score=getNormalScore(m_score1);
        else if (isWin)
            score=getSpecialScore(m_score1, m_score2);
        else score=getDifferentScore(m_score1, m_score2);
        return score;
    }
}
