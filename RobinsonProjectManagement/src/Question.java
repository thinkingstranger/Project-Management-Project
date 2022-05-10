/**James Robinson
 * 5/6/22
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jarob3698
 */
class Question {
    private int correctAns;
    private String[] answers = new String[4];
    private String question;
    
    public Question(){
        correctAns = 0;
        answers[0] = "";
        answers[1] = "";
        answers[2] = "";
        answers[3] = "";
        question = "";
    }
    
    public Question(String strQuestion, String ans0, String ans1, String ans2, String ans3, int intAns){
        correctAns = intAns;
        question = strQuestion;
        answers[0] = ans0;
        answers[1] = ans1;
        answers[2] = ans2;
        answers[3] = ans3;
    }
    public Question(String strQuestion, String[] ans, int intAns){
        question = strQuestion;
        answers = ans;
        correctAns = intAns;
    }
    public void setQuestion(String quest){
        question = quest;
    }
    public void setAnswer(String ans, int i){
        answers[i] = ans;
    }
    public void setCorrectAnswer(int i){
        correctAns = i;
    }
    public int getCorrectAns(){
        return correctAns;
    }
    public String getAnswer(int i){
        return answers[i];
    }
    public String getQuestion(){
        return question;
    }
    public Question clone(){
        Question temp = new Question(question, answers, correctAns);
        return temp;
    }
    
    public boolean equals(Question comp){
        return (answers.equals(comp.answers))&&(correctAns==(comp.correctAns))&&(question.equals(comp.question));
    }
    public String toString(){
        String str = "Question: " + question + "\nAnswers: ";
        for (int i = 0; i < 4; i++) {
            str += "\n" + answers[i];
        }
        str += "\nCorrect Answer: " + "(" + (correctAns+1) + ") " + answers[correctAns];
        return str;
    }
}
