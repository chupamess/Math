package com.example.math;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TasksActivity extends AppCompatActivity {

    private int currentQuestion = 0;
    private Question[] countQuestions;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);


        countQuestions = new Question[]{
                new Question(R.drawable.fishers, "Миша поймал 5 рыбок, а его папа на 2 больше, сколько рыбок поймал папа?", new int[] { 8, 7, 6 }, 1),
                new Question(R.drawable.dolls, "На полках стояли пять кукол и три неваляшки. Сколько всего игрушек стояло на полках?", new int[] { 6, 8, 9 }, 1),
                new Question(R.drawable.baloondoge, "У собачки было 5 шариков. Один шарик лопнул. Сколько шариков осталось у собачки?", new int[] { 4,5, 6 }, 0),
                new Question(R.drawable.birds_task, "В гнезде сидели семь птичек. Три птички улетели. Сколько птичек осталось?", new int[] { 3, 5, 4 }, 2),
                new Question(R.drawable.mushrooms_task, "Около ёлки росло восемь грибов. Четыре из них несъедобные. Сколько съедобных грибов росло под ёлкой?", new int[] { 4, 8, 5 }, 0),
                new Question(R.drawable.sandwtch_task, "Мама сделала к завтраку 2 бутерброда с сыром, а с колбасой — на 3 больше. Сколько бутербродов с колбасой приготовила мама?", new int[] { 2, 8, 5 }, 2),
                new Question(R.drawable.zveri_task, "Зайчик решил 3 примера, а белочка — 4. Сколько примеров решили зверята вместе?", new int[] { 6, 7, 5 }, 1)
        };



        buttons = new Button[]{
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3)
        };

        if (countQuestions.length > 0) {
            displayCountQuestion();
        } else {
            Toast.makeText(this, "Нет вопросов для подсчета!", Toast.LENGTH_SHORT).show();
        }


        View.OnClickListener listener = v -> {
            for (int i = 0; i < buttons.length; i++) {
                if (v == buttons[i]) {
                    checkCountAnswer(i);
                    break;
                }
            }
        };

        for (Button button : buttons) {
            button.setOnClickListener(listener);
        }
    }


    private void displayCountQuestion() {
        if (currentQuestion >= countQuestions.length) {
            finish();
            return;
        }
        Question question = countQuestions[currentQuestion];
        ((ImageView) findViewById(R.id.taskImage)).setImageResource(question.getImage());
        ((TextView) findViewById(R.id.questionTextView)).setText(question.getQuestion());
        for (int i = 0; i < question.getAnswers().length && i < buttons.length; i++) {
            buttons[i].setText(String.valueOf(question.getAnswers()[i]));
        }
    }


    private void checkCountAnswer(int answerIndex) {
        Question question = countQuestions[currentQuestion];
        if (answerIndex == question.getCorrectAnswerIndex()) {
            Toast.makeText(this, "Молодец, правильно!", Toast.LENGTH_SHORT).show();
            currentQuestion++;
            displayCountQuestion();
        } else {
            Toast.makeText(this, "Неправильно, попробуй еще!", Toast.LENGTH_SHORT).show();
        }
    }

    public static class Question {
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
}