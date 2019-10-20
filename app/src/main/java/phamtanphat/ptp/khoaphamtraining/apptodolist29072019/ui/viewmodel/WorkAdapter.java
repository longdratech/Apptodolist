package phamtanphat.ptp.khoaphamtraining.apptodolist29072019.ui.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.R;
import phamtanphat.ptp.khoaphamtraining.apptodolist29072019.model.response.Message;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkHolder> {

    ArrayList<Message> mMangCongViec;

    public WorkAdapter(ArrayList<Message> mMangCongViec) {
        this.mMangCongViec = mMangCongViec;
    }

    @NonNull
    @Override
    public WorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_work, parent, false);
        return new WorkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkHolder holder, int position) {
        Message message = mMangCongViec.get(position);
        holder.itemView.setTag(position);

        holder.txtTenCongViec.setText(message.getWorkname());
        holder.txtThoiGian.setText(message.getTime());

    }

    @Override
    public int getItemCount() {
        return mMangCongViec.size() > 0 ? mMangCongViec.size() : 0;
    }

    class WorkHolder extends RecyclerView.ViewHolder {
        TextView txtTenDangNhap, txtTenCongViec, txtThoiGian;

        public WorkHolder(@NonNull View itemView) {
            super(itemView);
            txtTenCongViec = itemView.findViewById(R.id.txtTenCongViec);
            txtThoiGian = itemView.findViewById(R.id.txtThoiGian);
        }

        /*public void addCongViec(Message message) {
            mMangCongViec.add(message.);
            notifyDataSetChanged();
        }*/
    }
}
