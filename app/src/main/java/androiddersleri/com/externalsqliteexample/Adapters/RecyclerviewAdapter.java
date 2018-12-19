package androiddersleri.com.externalsqliteexample.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androiddersleri.com.externalsqliteexample.Modals.Country;
import androiddersleri.com.externalsqliteexample.R;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Country> mData;

    public RecyclerviewAdapter(Context mContext, List<Country> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.recyclerview_item_design, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.country.setText(mData.get(position).getCountry());
            holder.capital.setText(mData.get(position).getCapital());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView country;
        ImageView countryImage;
        TextView capital;
        ImageView capitalImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.countryText_id);
            countryImage = itemView.findViewById(R.id.countryImage_id);
            capital = itemView.findViewById(R.id.capitalText_id);
            capitalImage = itemView.findViewById(R.id.capitalImage_id);

        }
    }
}
