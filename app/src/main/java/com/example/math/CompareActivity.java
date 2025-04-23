package com.example.math;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CompareActivity extends AppCompatActivity {

    private int currentQuestion = 0;
    private CompareQuestion[] questions;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        questions = new CompareQuestion[]{
                new CompareQuestion(R.drawable.number2, R.drawable.number5, "Сравни!", new int[] {2, 5}, 0),
                new CompareQuestion(R.drawable.number12,R.drawable.number8, "Сравни!", new int[] {12, 8}, 1),
                new CompareQuestion(R.drawable.number5,R.drawable.number5, "Сравни!", new int[] {5, 5}, 2),
                new CompareQuestion(R.drawable.elefants3,R.drawable.elefants5, "Сравни!", new int[] {3, 5}, 0),
                new CompareQuestion(R.drawable.cups4,R.drawable.cups2, "Сравни!", new int[] {4, 2}, 1),
                new CompareQuestion(R.drawable.lamps3,R.drawable.lamps4, "Сравни!", new int[] {3, 4}, 0),
                new CompareQuestion(R.drawable.icecream3,R.drawable.strawberry3, "Сравни!", new int[] {3, 3}, 2)
        };


        buttons = new Button[]{
                findViewById(R.id.buttonLess),
                findViewById(R.id.buttonGreater),
                findViewById(R.id.buttonEqual)
        };

        displayQuestion();

        View.OnClickListener listener = v -> {
            for (int i = 0; i < buttons.length; i++) {
                if (v == buttons[i]) {
                    checkAnswer(i);
                    break;
                }
            }
        };

        for (Button button : buttons) {
            button.setOnClickListener(listener);
        }
    }

    private void displayQuestion() {
        if (currentQuestion >= questions.length) {
            finish();
            return;
        }
        CompareQuestion question = questions[currentQuestion];
        ((ImageView) findViewById(R.id.compareImage1)).setImageResource(question.getImage1());
        ((ImageView) findViewById(R.id.compareImage2)).setImageResource(question.getImage2());
        ((TextView) findViewById(R.id.compareTextView)).setText(question.getQuestion());
    }


    private void checkAnswer(int answerIndex) {
        CompareQuestion question = questions[currentQuestion];
        if (answerIndex == question.getCorrectAnswerIndex()) {
            Toast.makeText(this, "Молодец, правильно!", Toast.LENGTH_SHORT).show();
            currentQuestion++;
            displayQuestion();
        } else {
            Toast.makeText(this, "Неправильно, попробуй еще!", Toast.LENGTH_SHORT).show();
        }
    }
}

class CompareQuestion {
    private int image1;
    private int image2;
    private String question;
    private int[] numbers;
    private int correctAnswerIndex;

    public CompareQuestion(int image1, int image2, String question, int[] numbers, int correctAnswerIndex) {
        this.image1 = image1;
        this.image2 = image2;
        this.question = question;
        this.numbers = numbers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public int getImage1() { return image1; }
    public int getImage2() { return image2; }
    public String getQuestion() { return question; }
    public int getNum1() { return numbers[0]; }
    public int getNum2() { return numbers[1]; }
    public int[] getNumbers() { return numbers; }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
}