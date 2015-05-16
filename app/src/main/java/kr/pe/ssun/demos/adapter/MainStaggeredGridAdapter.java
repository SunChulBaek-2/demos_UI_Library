package kr.pe.ssun.demos.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.pe.ssun.demos.Library;
import kr.pe.ssun.demos.R;

/**
 * Created by x1210x on 15. 5. 5..
 */
public class MainStaggeredGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.card_main_staggered_grid, parent, false);

		return new RecyclerView.ViewHolder(view) {
		};
	}

	@Override
	public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
		final View itemView = holder.itemView;

		final TextView actvTitle = (TextView) itemView.findViewById(R.id.actvTitle);
		TextView actvDesc = (TextView) itemView.findViewById(R.id.actvDesc);

		actvTitle.setText(Library.values()[position].getTitle());
		actvDesc.setText(itemView.getContext().getString(Library.values()[position].getDesc()));

		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getLayoutPosition();
				Context context = itemView.getContext();
				Intent i = new Intent(context, Library.values()[position].getClazz());
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					context.startActivity(i, ActivityOptions.makeSceneTransitionAnimation((Activity) context, actvTitle, "title").toBundle());
				} else {
					context.startActivity(i);
				}
			}
		});
	}

	@Override
	public int getItemCount() {
		return Library.values().length;
	}
}
