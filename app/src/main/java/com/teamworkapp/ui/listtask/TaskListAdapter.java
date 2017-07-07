package com.teamworkapp.ui.listtask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamworkapp.R;
import com.teamworkapp.data.model.Task;
import com.teamworkapp.data.model.TodoItem;
import com.teamworkapp.ui.edittask.EditTaskActivity;
import com.teamworkapp.util.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Tosin Onikute.
 */

public class TaskListAdapter
        extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private final Logger logger = Logger.getLogger(getClass());
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private ArrayList<TodoItem> mTodoItem;
    private Context mContext;


    private String cProjectName;
    private String ctitle;
    private String cDesc;
    private String ctag;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView projectName;
        public final TextView title;
        public final TextView description;
        public final TextView tag;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            projectName = (TextView) view.findViewById(R.id.project_name);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            tag = (TextView) view.findViewById(R.id.tag);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public String getValueAt(int position) {
        return String.valueOf("");
    }

    public TaskListAdapter(Context context, ArrayList<TodoItem> todoItems) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mContext = context;
        mBackground = mTypedValue.resourceId;
        this.mTodoItem = todoItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_task, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        /* Set your values */
        final TodoItem model = (TodoItem) mTodoItem.get(position);

        cProjectName = "";
        ctitle = "";
        cDesc = "";
        ctag = "";

        if (model.getProjectName() != null) {
            cProjectName = model.getProjectName();
        }

        if (model.getContent() != null) {
            ctitle = model.getContent();
        }

        if (model.getDescription() != null) {
            cDesc = model.getContent();
        }

        if (model.getTags() != null) {
            //ctag = model.getTags();
        }

        holder.projectName.setText(cProjectName);
        holder.title.setText(ctitle);
        holder.description.setText(cDesc);
        holder.tag.setText(ctag);

        // launch the edit task activity to show Task information
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, EditTaskActivity.class);
                intent.putExtra("position", holder.getAdapterPosition());
                intent.putExtra("mTodoItem", mTodoItem);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != mTodoItem ? mTodoItem.size() : 0);
    }

    public void addAll(List<TodoItem> data){
        //mTodoItem.addAll(data);
        notifyDataSetChanged();
    }

    public void add(TodoItem data){
        //mTodoItem.addAll(data);
        notifyDataSetChanged();
        mTodoItem.add(data);
    }


    public TodoItem getItemPos(int pos){
        return mTodoItem.get(pos);
    }

    public void clear(){
        mTodoItem.clear();
    }

}

