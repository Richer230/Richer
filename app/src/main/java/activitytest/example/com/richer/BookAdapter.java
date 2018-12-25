package activitytest.example.com.richer;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mBookList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookName;
        public ViewHolder(View view){
            super(view);
            bookName = (TextView) view.findViewById(R.id.book_name);
        }
    }
    public BookAdapter(List<Book> bookList){
        mBookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBookList.get(position);
        holder.bookName.setText(book.getName());
        if(position%2==0){
            holder.bookName.setBackgroundColor(Color.parseColor("#fff0f5"));
        }
        else{
            holder.bookName.setBackgroundColor(Color.parseColor("#ffdead"));
        }
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }
}
