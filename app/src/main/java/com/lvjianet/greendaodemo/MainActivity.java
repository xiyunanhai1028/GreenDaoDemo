package com.lvjianet.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.lvjianet.greendaodemo.bean.greendao.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText age;
    private EditText sex;
    private EditText salary;
    private ListView listView;
    private UserDao userDao;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        userDao = MyApplication.getApplication().getmDaoSession().getUserDao();
    }

    private void addData() {
        String name = this.name.getText().toString().trim();
        String age = this.age.getText().toString().trim();
        String sex = this.sex.getText().toString().trim();
        String salary = this.salary.getText().toString().trim();
        User user = new User(null, name, sex, age, salary);
        userDao.insert(user);
    }

    private void delete(Long id) {
        userDao.deleteByKey(id);
    }

    private void updata(int i) {
        List<User> users = userDao.loadAll();
        String name = this.name.getText().toString().trim();
        String age = this.age.getText().toString().trim();
        String sex = this.sex.getText().toString().trim();
        String salary = this.salary.getText().toString().trim();
        userDao.update(new User(users.get(i).getId(), name, sex, age, salary));
    }

    private void query() {
        List<User> users = userDao.loadAll();
        Log.e("df", "query: " + users);
        myAdapter.addData(users);
    }

    private void initView() {
        name = ((EditText) findViewById(R.id.name));
        age = ((EditText) findViewById(R.id.age));
        sex = ((EditText) findViewById(R.id.sex));
        salary = ((EditText) findViewById(R.id.salary));
        listView = ((ListView) findViewById(R.id.list_view));

        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.updata).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);
        myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                addData();
                break;
            case R.id.delete:
                List<User> users = userDao.loadAll();
                delete(users.get(0).getId());
                break;
            case R.id.updata:
                updata(2);
                break;
            case R.id.query:
                query();
                break;
        }
    }
}
