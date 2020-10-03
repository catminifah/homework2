package th.ac.su.homework2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.homework2.model.worditem;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter();
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        //เข้าถึง RecycleView ใน layout
        RecyclerView rv = findViewById(R.id.word_list_recycle_view);
        rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecycleView
        rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecycleView

    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        worditem[] items ={
                new worditem(R.drawable.zero,"ZERO","ศูนย์"),
                new worditem(R.drawable.one,"ONE","หนึ่ง"),
                new worditem(R.drawable.two,"TWO","สอง"),
                new worditem(R.drawable.three,"THREE","สาม"),
                new worditem(R.drawable.four,"FOUR","สี่"),
                new worditem(R.drawable.five,"FIVE","ห้า"),
                new worditem(R.drawable.six,"SIX","หก"),
                new worditem(R.drawable.seven,"SEVEN","เจ็ด"),
                new worditem(R.drawable.eight,"EIGHT","แปด"),
                new worditem(R.drawable.nine,"NINE","เก้า")



        };
        // WordItem item2;

        public MyAdapter(){
            /*item = new WordItem(R.drawable.cat,"CAT");
            item2 = new WordItem(R.drawable.dog,"DOG");*/

        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout1, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.imageView.setImageResource(items[position].imageResId);
            holder.wordTextView.setText(items[position].word);
            holder.wordTextView2.setText(items[position].word2);


        }


        public int getItemCount(){
            // return 10;
            return items.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView wordTextView;
            TextView wordTextView2;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                wordTextView = itemView.findViewById(R.id.textView1);
                wordTextView2 = itemView.findViewById(R.id.textView2);
            }
        }
    }
}