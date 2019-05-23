package mvpdemo.notemvp.com.tungvuong.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import mvpdemo.notemvp.com.tungvuong.MainContract;
import mvpdemo.notemvp.com.tungvuong.R;
import mvpdemo.notemvp.com.tungvuong.adapters.NotesAdapter;
import mvpdemo.notemvp.com.tungvuong.models.Note;
import mvpdemo.notemvp.com.tungvuong.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.MainActivityView {
    private Button btnAddNote;
    private EditText edtNote;
    private RecyclerView recyclerViewNote;
    private MainPresenter mPresenter = new MainPresenter(this);
    private NotesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddNote = findViewById(R.id.btnAddNote);
        edtNote = findViewById(R.id.edtNote);
        recyclerViewNote = findViewById(R.id.recyclerViewNote);
        initListener();
        initRecyclerView();
        mPresenter.onCreate();
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
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_blue));
        recyclerViewNote.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void setAdapter(List<Note> noteList) {
        mAdapter.updateAdapter(noteList);
    }

    @Override
    public void clearEdittext() {
        edtNote.setText("");
    }

}
