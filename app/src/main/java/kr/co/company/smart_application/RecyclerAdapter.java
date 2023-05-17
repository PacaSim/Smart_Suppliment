package kr.co.company.smart_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.co.company.smart_application.data.Item;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Item> mItems;
    private Context context;

    public RecyclerAdapter(Context context, List<Item> mItems) {
        this.mItems = mItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Item items = mItems.get(position);

        holder.tv_name.setText("제품명 : " + items.getItem().getPrdlstNm()+"\n");
        holder.tv_bssh_nm.setText("제조사 : "+ items.getItem().getBsshNm()+"\n");
        holder.tv_dispos.setText("성상 : " +items.getItem().getDispos()+"\n");
        holder.tv_amount.setText("섭취량/섭취방법 : " +items.getItem().getNtkMthd()+"\n");
        holder.tv_caution.setText("주의사항 : " +items.getItem().getIftknAtntMatrCn()+"\n");
        holder.tv_function.setText("기능성내용 : "+ items.getItem().getPrimaryFnclty()+"\n");
    }

    @Override
    public int getItemCount() {
        if(mItems==null) {
            return 0;
        }else {
            return mItems.size();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_dispos, tv_amount, tv_caution, tv_function, tv_bssh_nm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_dispos = (TextView)itemView.findViewById(R.id.tv_dispos);
            tv_amount = (TextView)itemView.findViewById(R.id.tv_amount);
            tv_caution = (TextView)itemView.findViewById(R.id.tv_caution);
            tv_function = (TextView)itemView.findViewById(R.id.tv_function);
            tv_bssh_nm = (TextView)itemView.findViewById(R.id.tv_bssh_nm);
        }
    }
}
