package designprojekt.Entities;

import java.time.LocalDate;

public class QA {
    private String question;
    private String answer;
    private LocalDate date;

    public QA(String question, String answer, LocalDate date) {
        this.question = question;
        this.answer = answer;
        this.date = date;
    }

    public QA() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
