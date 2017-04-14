package rebecafulller.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private TextView mLeftAdder;
    private TextView mRightAdder;

    private int randomNum;
    String leftNum;
    private String rightNum;
    private String correctAnswer;
    private String firstIncorrectAnswer;
    private String secondIncorrectAnswer;


    private RadioGroup mRadioGroup;
    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;

    public int index;
    private int quizLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final QuestionBank bank = new QuestionBank();
        final Random random = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftAdder = (TextView) findViewById(R.id.leftAdder);
        mRightAdder = (TextView) findViewById(R.id.rightAdder);

        Button mNextButton = (Button) findViewById(R.id.nextButton);

        mRadioGroup = (RadioGroup) findViewById(R.id.choiceGroup);
        mChoice1 = (RadioButton) findViewById(R.id.radioButtonChoice1);
        mChoice2 = (RadioButton) findViewById(R.id.radioButtonChoice2);
        mChoice3 = (RadioButton) findViewById(R.id.radioButtonChoice3);

        index = 0;
        quizLength = bank.quizLength;
        leftNum = Integer.toString(bank.leftAdder(index));
        rightNum = Integer.toString(bank.rightAdder(index));

        correctAnswer = Integer.toString(bank.correctAnswer(index));
        firstIncorrectAnswer = Integer.toString(bank.firstWrong(index));
        secondIncorrectAnswer = Integer.toString(bank.secondWrong(index));

        mLeftAdder.setText(leftNum);
        mRightAdder.setText(rightNum);

        randomNum = random.nextInt(3);
        if (randomNum == 0) {
            mChoice1.setText(correctAnswer);
            mChoice2.setText(firstIncorrectAnswer);
            mChoice3.setText(secondIncorrectAnswer);
        } else if (randomNum == 1) {
            mChoice1.setText(firstIncorrectAnswer);
            mChoice2.setText(correctAnswer);
            mChoice3.setText(secondIncorrectAnswer);
        } else {
            mChoice1.setText(firstIncorrectAnswer);
            mChoice2.setText(secondIncorrectAnswer);
            mChoice3.setText(correctAnswer);
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //move the index up 1
                index++;
                //move the length of the quiz down 1
                quizLength -= 1;
                //as long as there is more quiz left
                if (quizLength > 0) {
                    //set the new numbers up
                    leftNum = Integer.toString(bank.leftAdder(index));
                    Toast.makeText(MainActivity.this, "Left Adder is " + leftNum, Toast.LENGTH_SHORT).show();
                    rightNum = Integer.toString(bank.rightAdder(index));

                    correctAnswer = Integer.toString(bank.correctAnswer(index));
                    firstIncorrectAnswer = Integer.toString(bank.firstWrong(index));
                    secondIncorrectAnswer = Integer.toString(bank.secondWrong(index));

                    //set the new math problem up
                    mLeftAdder.setText(leftNum);
                    mRightAdder.setText(rightNum);

                    //choose a random number
                    randomNum = random.nextInt(3);
                    //set the correct number according to the random number
                    if (randomNum == 0) {
                        mChoice1.setText(correctAnswer);
                        mChoice2.setText(firstIncorrectAnswer);
                        mChoice3.setText(secondIncorrectAnswer);
                    } else if (randomNum == 1) {
                        mChoice1.setText(firstIncorrectAnswer);
                        mChoice2.setText(correctAnswer);
                        mChoice3.setText(secondIncorrectAnswer);
                    } else {
                        mChoice1.setText(firstIncorrectAnswer);
                        mChoice2.setText(secondIncorrectAnswer);
                        mChoice3.setText(correctAnswer);
                    }
                }



            }
        };
        mNextButton.setOnClickListener(listener);

        View.OnClickListener rListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        mChoice1.setOnClickListener(rListener1);

        View.OnClickListener rListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        mChoice2.setOnClickListener(rListener2);

        View.OnClickListener rListener3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        mChoice3.setOnClickListener(rListener3);


    }
}
