package sf.com.itsp.tasks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import sf.com.itsp.R;
import sf.com.itsp.domain.Task;

public class TaskItemView extends LinearLayout{
    private TextView addressValueTextView;

    public TaskItemView(Context context) {
        super(context);
        initUi();
    }

    public TaskItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public TaskItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initUi();
    }

    private void initUi() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.task_item, this, true);

        addressValueTextView = (TextView) findViewById(R.id.address_name);
    }

    public void setModel(Task task) {
        addressValueTextView.setText(task.getAddress());
    }
}
