package com.sargis.kh.android_architecture;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.sargis.kh.android_architecture.databinding.ListItemRecyclerViewBinding;
import com.sargis.kh.android_architecture.model.Person;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {

    private ArrayList<Person> people;

    public RecyclerViewAdapter() {
        people = new ArrayList<>();
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemRecyclerViewBinding listItemRecyclerViewBinding = ListItemRecyclerViewBinding.inflate(layoutInflater, parent, false);
        RecyclerViewViewHolder viewHolder = new RecyclerViewViewHolder(listItemRecyclerViewBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        holder.listItemRecyclerViewBinding.textViewFirstName.setText(people.get(position).getFirstName());
        holder.listItemRecyclerViewBinding.textViewLastName.setText(people.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void updatePeopleList(ArrayList<Person> people) {
        this.people = people;
    }

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        public ListItemRecyclerViewBinding listItemRecyclerViewBinding;
        public RecyclerViewViewHolder(ListItemRecyclerViewBinding listItemRecyclerViewBinding) {
            super(listItemRecyclerViewBinding.getRoot());
            this.listItemRecyclerViewBinding = listItemRecyclerViewBinding;
        }
    }

}
