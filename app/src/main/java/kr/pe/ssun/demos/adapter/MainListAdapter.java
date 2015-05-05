package kr.pe.ssun.demos.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.demos.Library;
import kr.pe.ssun.demos.R;

/**
 * Created by x1210x on 15. 5. 5..
 */
public class MainListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.card_main_list, parent, false);

		return new RecyclerView.ViewHolder(view) { };
	}

	@Override
	public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
		final View itemView = holder.itemView;

		AppCompatTextView actvTitle = (AppCompatTextView) itemView.findViewById(R.id.actvTitle);

		actvTitle.setText(Library.values()[position].getTitle());

		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getLayoutPosition();
				Context context = itemView.getContext();
				Intent i = new Intent(context, Library.values()[position].getClazz());
				context.startActivity(i);
			}
		});
	}

	@Override
	public int getItemCount() {
		return Library.values().length;
	}
}
