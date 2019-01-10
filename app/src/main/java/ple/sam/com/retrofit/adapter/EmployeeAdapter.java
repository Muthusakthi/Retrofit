package ple.sam.com.retrofit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ple.sam.com.retrofit.R;
import ple.sam.com.retrofit.model.Apires;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private List<Apires> dataList;
    private List<Apires> items, listData, dataFilter;
    public EmployeeAdapter(List<Apires> dataList) {
        this.dataList = dataList;
    }
    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.result, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.txtEmpName.setText(dataList.get(position).getName());
        holder.txtEmpEmail.setText(dataList.get(position).getEmail());
        holder.txtEmpPhone.setText(dataList.get(position).getUid());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public Filter getFilter() {
       return new Filter(){
           /**
            *
            * @param constraint CharSequence
            * @return results
            */
           @Override
           protected FilterResults performFiltering(CharSequence constraint) {
               FilterResults results = new FilterResults();
               ArrayList<Apires> filteredArrList = new ArrayList<Apires>();

               if (listData == null) {
                   listData = new ArrayList<Apires>(items);
               }

               if (constraint == null || constraint.length() == 0) {
                   results.count = dataFilter.size();
                   results.values = dataFilter;
               } else {
                   constraint = constraint.toString().toLowerCase(Locale.UK);
                   for (int i = 0; i < dataFilter.size(); i++) {
                       Apires data = dataFilter.get(i);

                       if (data.getName().toLowerCase(Locale.UK).contains(constraint.toString()) || data.getCode().contains(constraint.toString())) {
                           filteredArrList.add(data);
                       }
                   }

                   results.count = filteredArrList.size();
                   results.values = filteredArrList;
               }
               return results;
           }

           /**
            *
            * @param constraint CharSequence
            * @param results FilterResults
            */
           @Override
           protected void publishResults(CharSequence constraint, FilterResults results) {
               items = (ArrayList<Apires>) results.values;
               notifyDataSetChanged();
           }
        };
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpName, txtEmpEmail, txtEmpPhone;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            txtEmpName = (TextView) itemView.findViewById(R.id.txt_employee_name);
            txtEmpEmail = (TextView) itemView.findViewById(R.id.txt_employee_email);
            txtEmpPhone = (TextView) itemView.findViewById(R.id.txt_employee_phone);
        }
    }
}
