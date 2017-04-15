package rebecafulller.mathquiz;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mLeftAdder;
    private TextView mRightAdder;
    private TextView mTextView;
    private TextView mTextViewOther;

    private int randomNum;
    private String leftNum;
    private String rightNum;
    private String correctAnswer;
    private String firstIncorrectAnswer;
    private String secondIncorrectAnswer;


    private RadioGroup mRadioGroup;
    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;

    private Button mSubmit;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    public int index;
    private int quizLength;
    private String radioText;
    private boolean isCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final QuestionBank bank = new QuestionBank();
        final Random random = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftAdder = (TextView) findViewById(R.id.leftAdder);
        mRightAdder = (TextView) findViewById(R.id.rightAdder);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextViewOther = (TextView) findViewById(R.id.textView3);

        mSubmit = (Button) findViewById(R.id.submitButton);

        mRadioGroup = (RadioGroup) findViewById(R.id.choiceGroup);
        mChoice1 = (RadioButton) findViewById(R.id.radioButtonChoice1);
        mChoice2 = (RadioButton) findViewById(R.id.radioButtonChoice2);
        mChoice3 = (RadioButton) findViewById(R.id.radioButtonChoice3);

        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mProgress.setProgress(mProgressStatus);

        index = 0;
        quizLength = bank.quizLength;
        mProgress.setMax(quizLength);
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
                int i = mRadioGroup.getCheckedRadioButtonId();
                if (i == -1) {
                    Toast.makeText(MainActivity.this, "Please pick a number!", Toast.LENGTH_SHORT).show();
                } else {
                    if (mChoice1.isChecked()) {
                        //get button text
                        radioText = (String) mChoice1.getText();
                    } else if (mChoice2.isChecked()) {
                        //get button text
                        radioText = (String) mChoice2.getText();
                    } else if (mChoice3.isChecked()) {
                        //get button text
                        radioText = (String) mChoice3.getText();
                    }

                    //see if it is correct
                    if (radioText == correctAnswer) {
                        Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        isCorrect = true;
                    } else {
                        Toast.makeText(MainActivity.this, "Try again.", Toast.LENGTH_SHORT).show();
                        isCorrect = false;
                        mRadioGroup.clearCheck();
                    }
                }

                if (isCorrect) {
                    mRadioGroup.clearCheck();
                    mProgressStatus++;
                    mProgress.setProgress(mProgressStatus);
                    //move the index up 1
                    index++;
                    //move the length of the quiz down 1
                    quizLength -= 1;
                    //as long as there is more quiz left
                    if (quizLength > 0) {
                        //set the new numbers up
                        leftNum = Integer.toString(bank.leftAdder(index));
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
                    } else {
                        mProgressStatus = 0;
                        mProgress.setProgress(mProgressStatus);
                        quizLength = bank.quizLength;
                        index = 0;
                        //set the new numbers up
                        leftNum = Integer.toString(bank.leftAdder(index));
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
            }
        };
        mSubmit.setOnClickListener(listener);
    }
}
