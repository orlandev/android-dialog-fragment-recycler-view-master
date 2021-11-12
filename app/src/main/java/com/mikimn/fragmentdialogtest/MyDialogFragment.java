package com.mikimn.fragmentdialogtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

public class MyDialogFragment extends DialogFragment {

    private RecyclerView recyclerView;


    private RecyclerView.Adapter<ViewHolder> adapter = new RecyclerView.Adapter<ViewHolder>() {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = getLayoutInflater().inflate(R.layout.item_recycler_view, parent, false);

            return new ViewHolder(view);
            //return new ViewHolder(getLayoutInflater().inflate(R.layout.item_recycler_view, parent, false));

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String value = String.format(Locale.getDefault(), "I am item %d", position);
            holder.tv.setText(value);
            holder.tv.setOnClickListener(v -> {
                Toast.makeText(v.getContext(), value, Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_dialog, container, false);

        recyclerView = v.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        (v.findViewById(R.id.close_button)).setOnClickListener((view) -> dismiss());

        return v;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv = itemView.findViewById(R.id.rv_text_view);
        }
    }
}
