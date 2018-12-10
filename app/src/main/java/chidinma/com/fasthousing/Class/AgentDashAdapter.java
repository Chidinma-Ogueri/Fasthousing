package chidinma.com.fasthousing.Class;

/**
 * Created by chidinma on 12/6/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import chidinma.com.fasthousing.R;


public class AgentDashAdapter extends RecyclerView.Adapter<AgentDashAdapter.ViewHolder> {

    private String[] text = {"Post A House", "Client Requests",
            "My Properties", "My Today's Lead", "My Lead On this Month", "Total Lead On Accont",
            "My Profile", "My Subscription"};
    private int[] image = {R.drawable.ic_home_black_24dp, R.drawable.fee, R.drawable.home,
            R.drawable.ic_adjust, R.drawable.home, R.drawable.people, R.drawable.account,
            R.drawable.fee};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //this inflates a layout for agent dash board
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.agent_dash_page_menu,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(text[position]);
        holder.image.setImageResource(image[position]);

    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private Context context;
        public TextView text;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            text = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //switch statement goes here
                    //  final Intent intent;

//                    if (getAdapterPosition()==0){
//                        Toast.makeText((context), "Contacts selected",
//                                Toast.LENGTH_LONG).show();
//                    }
//                    if (getAdapterPosition()==1){
//                        Intent radio = new Intent(context, LiveRadio.class);
//                        context.startActivity(radio);
//                        Toast.makeText((context), "Live Radio", Toast.LENGTH_LONG).show();
//                    }
//
//                    if (getAdapterPosition()==2){
//                        Toast.makeText((context), "Live Service", Toast.LENGTH_LONG).show();
//                    }
//
//
//                    if (getAdapterPosition()==3){
//                        Intent bible = new Intent(context, Bible.class);
//                        context.startActivity(bible);
//                        Toast.makeText((context), "Bible", Toast.LENGTH_LONG).show();
//                    }
//
//                    if (getAdapterPosition()==4){
//                        Intent notes = new Intent(context, NotesPad.class);
//                        context.startActivity(notes);
//                        Toast.makeText((context), "Notes", Toast.LENGTH_LONG).show();
//                    }
//
//                    if (getAdapterPosition()==5){
//                        Toast.makeText((context), "About us", Toast.LENGTH_LONG).show();
//                    }
//
//                    if (getAdapterPosition()==6){
//                        Toast.makeText((context), "Givings", Toast.LENGTH_LONG).show();
//                    }
//
//                    if (getAdapterPosition()==7){
//                        Toast.makeText((context), "Messages & Musics", Toast.LENGTH_LONG).show();
//                    }



                }
            });
        }
    }
}
