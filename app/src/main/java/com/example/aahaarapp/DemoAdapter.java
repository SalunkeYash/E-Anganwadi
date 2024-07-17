package com.example.aahaarapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoVH> {
    private final List<String> items;
    int position = 0; // Example position, replace with your desired position
    String newName = "New Name";
    String newAge = "New Age";
    String newMobile = "New Mobile";
    DemoAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public DemoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new DemoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoVH holder, int position) {
        // Bind data here if needed
        String currentItem = items.get(position);

        // Split the item to get name, age, and mobile
        String[] data = currentItem.split(",");

        // Update the text of TextViews with name, age, and mobile
        holder.name.setText(data[0]); // Assuming name is at index 0
        holder.age.setText(data[1]); // Assuming age is at index 1
        holder.mobile.setText(data[2]); // Assuming mobile is at index 2
    }
    public void updateItemText(int position, String newName, String newAge, String newMobile) {
        if (position >= 0 && position < items.size()) {
            // Update the data in the list
            String newData = newName + "," + newAge + "," + newMobile;
            items.set(position, newData);
            // Notify the adapter that the item has changed
            notifyItemChanged(position);
        }
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addNewLayout() {
        // Add new item to the list and notify adapter
        items.add("New Item");
        notifyItemInserted(items.size() - 1);
    }

    public static class DemoVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView age;
        TextView mobile;

        public DemoVH(@NonNull View itemView)
        {

            super(itemView);
            TextView nameTextView;
            TextView ageTextView;
            TextView mobileTextView;



            nameTextView = itemView.findViewById(R.id.name);
            ageTextView = itemView.findViewById(R.id.a1);
            mobileTextView = itemView.findViewById(R.id.m1);
        }


    }
}
