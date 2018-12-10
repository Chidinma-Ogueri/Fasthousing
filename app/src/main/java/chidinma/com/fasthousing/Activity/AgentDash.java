package chidinma.com.fasthousing.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import chidinma.com.fasthousing.Class.AgentDashAdapter;
import chidinma.com.fasthousing.R;

public class AgentDash extends AppCompatActivity {

    RecyclerView recyclerView;
    AgentDashAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dash);

        recyclerView = (RecyclerView) findViewById(R.id.agentRecycler);
        layoutManager = new GridLayoutManager(getApplication(),3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AgentDashAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


    }

}
