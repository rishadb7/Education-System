/**
 * Copyright 2015, KyoSherlock
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pk.edu.bisedik.Contect_us;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kyo.expandablelayout.ExpandableLayout;

import java.util.ArrayList;
import java.util.List;

import pk.edu.bisedik.R;

public class RecyclerViewExample extends Activity {

	//private static final int TYPE_IMAGE_VIEW = 0;
	//private static final int TYPE_TEXT_VIEW = 1;
	private static final int EXPANDABLE_LAYOUT =1;
	private List<Item> mItems;
	private RecyclerView mRecyclerView;
	private MyAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_recyclerview);

		mItems = new ArrayList<>();
		//Item title = new Item()
		for (int i = 0; i < 10; i++) {
			//mItems.add(new Item("Chairman",true));
			Item titel = new Item("This is Title"+(i+1),true);
			mItems.add(titel);
		}
		mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerview);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mAdapter = new MyAdapter(mItems);
		mRecyclerView.setAdapter(mAdapter);
	}

	private OnClickListener mOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			//if (v.getTag() instanceof MyViewHolder) { //View Holder expanded
				MyViewHolder holder = (MyViewHolder) v.getTag();
				boolean result = holder.expandableLayout.toggleExpansion();
				Item item = mItems.get(holder.getAdapterPosition());
				item.isExpand = result ? !item.isExpand : item.isExpand;

			/*} else if (v.getTag() instanceof TextViewHolder) {  //TextView Expand
				TextViewHolder holder = (TextViewHolder) v.getTag();
				boolean result = holder.expandableLayout.toggleExpansion();
				Item item = mItems.get(holder.getAdapterPosition());
				item.isExpand = result ? !item.isExpand : item.isExpand;
			}*/
		}
	};

	private ExpandableLayout.OnExpandListener mOnExpandListener = new ExpandableLayout.OnExpandListener() {

		private boolean isScrollingToBottom = false;

		@Deprecated
		@Override
		public void onToggle(ExpandableLayout view, View child,
                             boolean isExpanded) {
		}

		@Override
		public void onExpandOffset(ExpandableLayout view, View child,
                                   float offset, boolean isExpanding) {
			if (view.getTag() instanceof MyViewHolder) {
				final MyViewHolder holder = (MyViewHolder) view.getTag();
				if (holder.getAdapterPosition() == mItems.size() - 1) {
					if (!isScrollingToBottom) {
						isScrollingToBottom = true;
						mRecyclerView.postDelayed(new Runnable() {
							@Override
							public void run() {
								isScrollingToBottom = false;
								mRecyclerView.scrollToPosition(holder
									.getAdapterPosition());
							}
						}, 100);
					}
				}
			}
		}
	};

	private class MyAdapter extends
		RecyclerView.Adapter<ViewHolder> {
		private List<Item> items;

		public MyAdapter(List<Item> infos) {
			this.items = infos;
		}

		@Override
		public int getItemCount() {
			return items.size();
		}

		/*@Override
		public int getItemViewType(int position) {
			*//*if (position == 1) {
				return TYPE_TEXT_VIEW;
			} else {
				return TYPE_IMAGE_VIEW;
			}*//*
			if (position == 1){
				return EXPANDABLE_LAYOUT;
			}else {
				return 0;
			}
		}*/

		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
			//if (viewType == TYPE_IMAGE_VIEW) {
				LayoutInflater inflater = LayoutInflater.from(parent
					.getContext());
				View itemView = inflater.inflate(R.layout.contectlist_row,
					parent, false);
				MyViewHolder holder = new MyViewHolder(itemView);
				//holder.imageView.setOnClickListener(mOnClickListener);
				//holder.imageView.setTag(holder);
			holder.textView.setOnClickListener(mOnClickListener);
			holder.textView.setTag(holder);
				holder.expandableLayout.setTag(holder);
				holder.expandableLayout.setOnExpandListener(mOnExpandListener);
				return holder;
			/*} else {
				LayoutInflater inflater = LayoutInflater.from(parent
					.getContext());
				View itemView = inflater.inflate(
					R.layout.item_expandable_textview, parent, false);
				TextViewHolder holder = new TextViewHolder(itemView);
				holder.textView.setOnClickListener(mOnClickListener);
				holder.textView.setTag(holder);
				holder.expandableLayout.setTag(holder);
				holder.expandableLayout.setOnExpandListener(mOnExpandListener);
				return holder;
			}*/
		}

		@Override
		public void onBindViewHolder(ViewHolder holder,
									 int position) {
			//if (holder instanceof MyViewHolder) {
				MyViewHolder viewHolder = (MyViewHolder) holder;
				Item item = items.get(position);
				viewHolder.setIsRecyclable(false);
				viewHolder.textView.setText(item.getTitle());

				//viewHolder.expandableLayout.
				viewHolder.expandableLayout.setExpanded(item.isExpand, false);
			/*} else {
				TextViewHolder viewHolder = (TextViewHolder) holder;
				Item item = items.get(position);
				viewHolder.expandableLayout.setExpanded(item.isExpand, false);
				viewHolder.textView
					.setText("TextView Example\nTextView Example\nTextView Example\nTextView Example");
				viewHolder.expandableTextView
					.setText("TextView Example\nTextView Example\nTextView Example\nTextView Example");
			}*/
		}
	}

	static class MyViewHolder extends ViewHolder {
		ExpandableLayout expandableLayout;
		//ImageView imageView;
		TextView textView;

		public MyViewHolder(View itemView) {
			super(itemView);
			expandableLayout = (ExpandableLayout) itemView
				.findViewById(R.id.expandablelayout);
			//imageView = (ImageView) itemView.findViewById(R.id.imageview);
			textView = (TextView)itemView.findViewById(R.id.txtChairmain);
		}
	}

	/*static class TextViewHolder extends ViewHolder {
		ExpandableLayout expandableLayout;
		TextView textView;
		TextView expandableTextView;

		public TextViewHolder(View itemView) {
			super(itemView);
			expandableLayout = (ExpandableLayout) itemView
				.findViewById(R.id.expandablelayout);
			textView = (TextView) itemView.findViewById(R.id.textview);
			expandableTextView = (TextView) itemView
				.findViewById(R.id.expandable_textview);
		}
	}*/

	static class Item {

		private String title;
		boolean isExpand;

		public Item(String title, boolean isExpand) {
			this.title = title;
			this.isExpand = isExpand;

		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean isExpand() {
			return isExpand;
		}

		public void setExpand(boolean expand) {
			isExpand = expand;
		}
	}

}