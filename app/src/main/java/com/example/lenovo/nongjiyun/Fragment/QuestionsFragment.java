package com.example.lenovo.nongjiyun.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lenovo.nongjiyun.Adapter.QuestionAdapter;
import com.example.lenovo.nongjiyun.Model.Question;
import com.example.lenovo.nongjiyun.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends Fragment {
    private ListView question;
    private List<Question> questions;


    public QuestionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        question = (ListView) view.findViewById(R.id.lv);
        questions = new ArrayList<>();
        Question qq = new Question("雨荨","连云港市巴拉巴拉","江苏省吧啦吧啦","参观吧啦吧啦吧啦吧啦吧啦吧啦","技术人员","其他","2018.05.06","已回答",R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        questions.add(qq);
        QuestionAdapter adapter = new QuestionAdapter(getActivity(),questions);
        question.setAdapter(adapter);

        return view;
    }

}
