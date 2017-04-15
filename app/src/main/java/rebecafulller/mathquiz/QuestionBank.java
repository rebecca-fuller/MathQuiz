package rebecafulller.mathquiz;

import android.graphics.Color;

public class QuestionBank {
    private int[] leftAdders = {3,16,45,17,6,52,16,45,68,54,12,36,25,19,61,84,52,22,29,5,13,15,62,24,7,3,5,81,64};
    private int[] rightAdders = {4,32,12,16,14,46,65,35,19,85,63,58,32,94,13,49,74,14,18,19,15,47,15,93,6,9,55,17,46};
    private int[] correctAnswers = {7,48,57,33,20,98,81,80,87,139,75,94,57,113,74,133,126,36,47,24,28,62,77,117,13,12,60,98,110};
    private int[] firstIncorrectAnswers = {8,52,63,23,18,106,79,75,88,128,79,90,59,103,68,123,122,30,43,25,26,60,79,119,12,11,50,88,112};
    private int[] secondIncorrectAnswers = {10,61,55,43,22,88,68,70,97,140,70,84,62,116,72,135,136,42,53,34,30,72,89,127,15,16,70,95,100};

    public int quizLength = correctAnswers.length;

    //set the adders
    public int leftAdder(int index) {
        return leftAdders[index];
    }

    public int rightAdder(int index) {
        return rightAdders[index];
    }

    //set the correct answer
    public int correctAnswer(int index) {
        return correctAnswers[index];
    }

    //set the first wrong answer
    public int firstWrong(int index) {
        return firstIncorrectAnswers[index];
    }

    //set the second wrong answer
    public int secondWrong(int index) {
        return secondIncorrectAnswers[index];
    }
}
