package kr.pe.ssun.demos.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.pe.ssun.demos.Category;
import kr.pe.ssun.demos.Library;
import kr.pe.ssun.demos.R;

/**
 * Created by x1210x on 15. 5. 5..
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private Category mCategory = null;
	private Library[] mLibraries = Library.values();

	public void setCategory(Category category) {
		mCategory = category;

		if (category == null) {
			mLibraries = Library.values();
		} else {
			ArrayList<Library> libraries = new ArrayList<>();
			for (int i=0; i<Library.values().length; i++) {
				if (Library.values()[i].getCategory().equals(category)) {
					libraries.add(Library.values()[i]);
				}
			}
			mLibraries = libraries.toArray(new Library[libraries.size()]);
		}
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.card_main, parent, false);

		return new RecyclerView.ViewHolder(view) {
		};
	}

	@Override
	public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
		final View itemView = holder.itemView;

		final TextView tvPrimaryText = (TextView) itemView.findViewById(R.id.tvPrimaryText);
		TextView tvSubText = (TextView) itemView.findViewById(R.id.tvSubText);
		TextView tvSupportingText = (TextView) itemView.findViewById(R.id.tvSupportingText);
		Button btnShowDemo = (Button) itemView.findViewById(R.id.btnShowDemo);
		Button btnOpenGitHub = (Button) itemView.findViewById(R.id.btnOpenGitHub);

		tvPrimaryText.setText(mLibraries[position].getTitle());
		tvSubText.setText(mLibraries[position].getCategory().getTitle());
		tvSupportingText.setText(itemView.getContext().getString(mLibraries[position].getDesc()));

		btnShowDemo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getLayoutPosition();
				Context context = itemView.getContext();
				Intent i = new Intent(context, mLibraries[position].getClazz());
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					context.startActivity(i, ActivityOptions.makeSceneTransitionAnimation((Activity) context, null).toBundle());
				} else {
					context.startActivity(i);
				}
			}
		});

		btnOpenGitHub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Context context = itemView.getContext();
				String url = context.getString(mLibraries[position].getUrl());
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				context.startActivity(i);
			}
		});
	}

	@Override
	public int getItemCount() {
		return mLibraries.length;
	}
}
