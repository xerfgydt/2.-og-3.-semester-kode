package designprojekt.Repositories;

import designprojekt.Entities.Material;
import designprojekt.Entities.QA;

import java.util.ArrayList;
import java.util.List;

public class QARepository {

    private List<QA> qaList = new ArrayList<>();

    public void create(QA qa) {
        qaList.add(qa);
    }

    public QA read(QA qa) {
        return qa;
    }

    public List<QA> readAll() {
        return qaList;
    }

    public QA update(QA qa) {
        for (QA qas: qaList) {
            qaList.set(qaList.indexOf(qas), qas);
        }
        return qa;
    }

    public QA delete(QA qa) {
        qaList.remove(qa);
        return qa;
    }

}
