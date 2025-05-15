package com.example.math;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CountActivity extends AppCompatActivity {

    private int currentQuestion = 0;
    private Question[] questions;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        questions = new Question[]{
                new Question(R.drawable.pizza7, "Сколько помидоров на пицце?", new int[] { 8, 7, 6 }, 1),
                new Question(R.drawable.numbers12, "Продолжи ряд цифр", new int[] { 5, 3, 0 }, 1),
                new Question(R.drawable.apples, "Сколько яблок на картинке?", new int[] { 6, 9, 7 }, 2),
                new Question(R.drawable.strawberry3, "Сколько клубники на картинке?", new int[] { 4, 2, 3 }, 2),
                new Question(R.drawable.icecream3, "Сколько рожков мороженого на картинке?", new int[] { 1, 3, 5 }, 1),
                new Question(R.drawable.dolls, "Сколько игрушек на картинке?", new int[] { 8, 9, 5 }, 0),
                new Question(R.drawable.baloondoge5, "Сколько шариков на картинке?", new int[] { 7, 4, 5 }, 2)
        };


        buttons = new Button[]{
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8)
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
        Question question = questions[currentQuestion];
        ((ImageView) findViewById(R.id.pizzaImage)).setImageResource(question.getImage());
        ((TextView) findViewById(R.id.questionTextView)).setText(question.getQuestion());
        for (int i = 0; i < question.getAnswers().length && i < buttons.length; i++) {
            buttons[i].setText(String.valueOf(question.getAnswers()[i]));
        }
    }

    private void checkAnswer(int answerIndex) {
        Question question = questions[currentQuestion];
        if (answerIndex == question.getCorrectAnswerIndex()) {
            Toast.makeText(this, "Молодец, правильно!", Toast.LENGTH_SHORT).show();
            currentQuestion++;
            displayQuestion();
        } else {
            Toast.makeText(this, "Неправильно, попробуй еще!", Toast.LENGTH_SHORT).show();
        }
    }
}

class Question {
    private int image;
    private String question;
    private int[] answers;
    private int correctAnswerIndex;


    public Question(int image, String question, int[] answers, int correctAnswerIndex) {
        this.image = image;
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }
    public int getImage() { return image; }
    public String getQuestion() { return question; }
    public int[] getAnswers() { return answers; }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
}