package myappaledone.myappale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private String[] numberWord;
    private int[] numberImage;

    public MainAdapter(Context c,String[] numberWord,int[] numberImage) {
        context = c;
        this.numberWord = numberWord;
        this.numberImage = numberImage;
    }


    @Override
    public int getCount() {
        return numberWord.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       //added line
        View itemView;
        //
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rowsgrid, null);
        }else {
            //added line
            //itemView = convertView;

        }

        ImageView imageView = convertView.findViewById(R.id.imageviewgrid);
        TextView textView = convertView.findViewById(R.id.textviewgrid);


        imageView.setImageResource(numberImage[position]);
        textView.setText(numberWord[position]);



        return convertView;
    }
}























