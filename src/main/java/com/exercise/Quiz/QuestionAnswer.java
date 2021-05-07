package com.exercise.Quiz;

public class QuestionAnswer {

    private String[] questions = {
            "3,1,4,1,5", //pi
            "1,1,2,3,5", //fibonacci
            "1,4,9,16,25", //squares
            "2,3,5,7,11", //primes
            "1,2,4,8,16" //powers of 2
    };

    private String[] answers = {"9", "8", "36", "13", "32"};
    private int score;
    private String userAns;
    private int index;

    public QuestionAnswer() {
        this.score = 0;
        this.userAns = "";
        this.index=0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuestions(int index) {
        return questions[index];
    }

    public String getAnswers(int index) {
        return answers[index];
    }

    public String getUserAns() {
        return userAns;
    }

    public void setUserAns(String userAns) {
        this.userAns = userAns;
    }

    private int generateIndex() {
        int min = 0;
        int max = questions.length - 1;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
