package kr.co.company.smart_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context, mContext;
    DBHelper dbHelper;

    public MyAdapter(Context context, ArrayList name_id, ArrayList amount_id, ArrayList caution_id)
    {
        this.context = context;
        this.name_id = name_id;
        this.amount_id = amount_id;
        this.caution_id = caution_id;
    }

    private ArrayList name_id, amount_id, caution_id;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        dbHelper = new DBHelper(mContext);
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameId.setText(String.valueOf(name_id.get(position)));
        holder.amountId.setText(String.valueOf(amount_id.get(position)));
        holder.cautionId.setText(String.valueOf(caution_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameId, amountId, cautionId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameId = itemView.findViewById(R.id.textname);
            amountId=itemView.findViewById(R.id.textamount);
            cautionId = itemView.findViewById(R.id.textcaution);


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int currentPos = getAdapterPosition();
                    String name = (String) name_id.get(currentPos);
                    PopupMenu popup = new PopupMenu(context.getApplicationContext(), view);
                    popup.getMenuInflater().inflate(R.menu.list_menu, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()){
                                case R.id.action_delete:
                                    name_id.remove(currentPos);
                                    amount_id.remove(currentPos);
                                    caution_id.remove(currentPos);
                                    notifyItemRemoved(currentPos);
                                    notifyItemChanged(currentPos, name_id.size());
                                    dbHelper.deleteList(name);
                            }
                            return false;
                        }
                    });
                    popup.show();
                    return true;
                }
            });

        }
    }
}
