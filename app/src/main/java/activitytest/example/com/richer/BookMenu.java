package activitytest.example.com.richer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookMenu extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_menu);
        initBooks();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final BookAdapter adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);
        final Button button = (Button) findViewById(R.id.button_add);
        editText = (EditText) findViewById(R.id.edit_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookList.add(0,new Book(editText.getText().toString()));
                Toast.makeText(BookMenu.this,"successfully add",Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(adapter);
            }
        });
    }
    private void initBooks(){
        bookList.add(new Book("Jane Eyre"));
        bookList.add(new Book("The Adventures of Pinocchio"));
        bookList.add(new Book("Sherlock Holmes"));
        bookList.add(new Book("The Little Prince"));
        bookList.add(new Book("Around the World in Eighty Days"));
        bookList.add(new Book("Reynard the Fox"));
        bookList.add(new Book("Wind in the Willows"));
        bookList.add(new Book("The Essays of Francis Bacon"));
        bookList.add(new Book("The Sorrows of Young Werther"));
        bookList.add(new Book("Three Days to See"));
    }
}
