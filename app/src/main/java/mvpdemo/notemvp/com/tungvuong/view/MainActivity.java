package mvpdemo.notemvp.com.tungvuong.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import mvpdemo.notemvp.com.tungvuong.R;
import mvpdemo.notemvp.com.tungvuong.models.Note;
import mvpdemo.notemvp.com.tungvuong.Adapters.NotesAdapter;
import mvpdemo.notemvp.com.tungvuong.presenter.MainPresenter;
import mvpdemo.notemvp.com.tungvuong.presenter.Presenter;

public class MainActivity extends AbstractActivity implements MainActivityView {
    Button btnAddNote;
    EditText edtNote;
    RecyclerView recyclerViewNote;

    MainPresenter mPresenter = new MainPresenter(this);
    NotesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddNote = findViewById(R.id.btnAddNote);
        edtNote = findViewById(R.id.edtNote);
        recyclerViewNote = findViewById(R.id.recyclerViewNote);
        initListener();
        initRecyclerView();
        mPresenter.onCreate(getIntent());

    }

    @Override
    Presenter getPresenter() {
        return mPresenter;
    }

    private void initListener() {


        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addNote(edtNote.getText().toString());
            }
        });
    }

    private void initRecyclerView() {
        recyclerViewNote.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NotesAdapter(new ArrayList<Note>(), mPresenter);
        recyclerViewNote.setAdapter(mAdapter);
    }

    @Override
    public void setAdapter(List<Note> noteList) {
        mAdapter.updateAdapter(noteList);
    }

    @Override
    public void clearEdittext() {
        edtNote.setText("");
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }



}
