package com.example.toes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import kotlinx.coroutines.Job;

public class JobSeletionActivity extends AppCompatActivity {
    int j = 0;
    Spinner spinnerCity;
    CheckBox chkboxJob1, chkboxJob2, chkboxJob3, chkboxJob4, chkboxJob5, chkboxJob6, chkboxOther;
    EditText etOtherJob;
    Button btnStart;
    int flag = 0;
    String job1 = "",job2 = "",job3 = "";
    String temp ="";
    // String job[] = new String[3];
    ArrayList<String> job = new ArrayList<>();
    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seletion);


        chkboxJob1 = (CheckBox) findViewById(R.id.chkboxJob1);
        chkboxJob2 = (CheckBox) findViewById(R.id.chkboxJob2);
        chkboxJob3 = (CheckBox) findViewById(R.id.chkboxJob3);
        chkboxJob4 = (CheckBox) findViewById(R.id.chkboxJob4);
        chkboxJob5 = (CheckBox) findViewById(R.id.chkboxJob5);
        chkboxJob6 = (CheckBox) findViewById(R.id.chkboxJob6);
        chkboxOther = (CheckBox) findViewById(R.id.chkboxOther);

        etOtherJob = (EditText) findViewById(R.id.etOtherJob);

        btnStart = (Button) findViewById(R.id.btnStart);

        spinnerCity = findViewById(R.id.spinnerCity);

        String[] jobTitles = new String[]{"Select Your City", "Satara", "Pune", "Mumbai", "Nagpur", "Solapur"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.style_select_job_titles, jobTitles);
        spinnerCity.setAdapter(arrayAdapter);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag > 3){
                    Toast.makeText(JobSeletionActivity.this,"Maximum 3 jobs are allowed ! ",Toast.LENGTH_SHORT).show();
                }else if(flag ==0){
                    Toast.makeText(JobSeletionActivity.this,"You have to select at least 1 job ! ",Toast.LENGTH_SHORT).show();
                }else if (chkboxOther.isChecked()){
                    if(etOtherJob.getText().toString().equals("")){
                        Toast.makeText(JobSeletionActivity.this,"Please enter your other profession !",Toast.LENGTH_SHORT).show();
                    }else{
                        if (spinnerCity.getSelectedItem().toString().equals("Select Your City")){
                            Toast.makeText(JobSeletionActivity.this,"Please select city!",Toast.LENGTH_SHORT).show();
                        }else{
                            System.out.println("---------eiiiiiiii--------"+job);
                    /*for (int j = 0 ; j < job.size(); j++){
                        System.out.println(job.get(j));
                    }*/ temp = etOtherJob.getText().toString();
                            job.add(temp);
                            System.out.println("---------eiiiiiiii--------"+job);

                            Intent intent = new Intent(JobSeletionActivity.this,VisitingChargesActivity.class);
                            intent.putExtra("arrl",job);
                            intent.putExtra("f",flag);
                            startActivity(intent);
                        }

                    }
                }else if (spinnerCity.getSelectedItem().toString().equals("Select Your City")){
                    Toast.makeText(JobSeletionActivity.this,"Please select city!",Toast.LENGTH_SHORT).show();
                }
                else{

                    Intent intent = new Intent(JobSeletionActivity.this,VisitingChargesActivity.class);
                    intent.putExtra("arrl",job);
                    intent.putExtra("f",flag);
                    startActivity(intent);
                }
            }
        });



    }

    public void onCheck(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.chkboxJob1:
                if (checked) {
                    ++flag;
                    //job[i] = chkboxJob2.getText().toString();
                    job.add(i,chkboxJob1.getText().toString());
                    i++;
                    System.out.println("----------ch2-Checked-------------+++++-" + flag);
                } else {
                    flag = --flag;
                    //  job.remove(i);
                    job.remove(chkboxJob1.getText().toString());
                    i--;
                    System.out.println("------------------------" + flag);
                }

                break;

            case R.id.chkboxJob2:


                if (checked) {
                    ++flag;
                    //job[i] = chkboxJob2.getText().toString();
                    job.add(i,chkboxJob2.getText().toString());
                    i++;
                    System.out.println("----------ch2-Checked-------------+++++-" + flag);
                } else {
                    flag = --flag;
                    //  job.remove(i);
                    job.remove(chkboxJob2.getText().toString());
                    i--;
                    System.out.println("------------------------" + flag);
                }

                break;
            case R.id.chkboxJob3:
                if (checked) {
                    ++flag;
                    job.add(i,chkboxJob3.getText().toString());
                    //  job[i] = chkboxJob3.getText().toString();
                    i++;
                    System.out.println("-----------------------+++++-" + flag);
                } else {
                    flag = --flag;
                    job.remove(chkboxJob3.getText().toString());
                    i--;
                    System.out.println("------------------------" + flag);
                }
                break;
            case R.id.chkboxJob5:
                if (checked) {
                    ++flag;
                    // job[i] = chkboxJob5.getText().toString();
                    job.add(i,chkboxJob5.getText().toString());
                    i++;
                    System.out.println("-----------------------+++++-" + flag);
                } else {
                    flag = --flag;
                    job.remove(chkboxJob5.getText().toString());
                    // job.remove(i);
                    i--;
                    System.out.println("------------------------" + flag);
                }
                break;
            case R.id.chkboxJob4:
                if (checked) {
                    ++flag;
                    job.add(i,chkboxJob4.getText().toString());
                    //job[i] = chkboxJob4.getText().toString();
                    i++;
                    System.out.println("-----------------------+++++-" + flag);
                } else {
                    flag = --flag;
                    job.remove(chkboxJob4.getText().toString());
                    //  job.remove(i);
                    i--;
                    System.out.println("------------------------" + flag);
                }
                break;
            case R.id.chkboxJob6:
                if (checked) {
                    ++flag;
                    job.add(i,chkboxJob6.getText().toString());
                    //  job[i] = chkboxJob6.getText().toString();
                    i++;
                    System.out.println("-----------------------+++++-" + flag);
                } else {
                    flag = --flag;
                    job.remove(chkboxJob6.getText().toString());
                    i--;
                    System.out.println("------------------------" + flag);
                }


                break;


            case R.id.chkboxOther:

                if (checked) {
                    chkboxOther.setClickable(true);
                    etOtherJob.setVisibility(View.VISIBLE);

                   temp = etOtherJob.getText().toString();
                     System.out.println("SSSSSSS ----- "+temp);
                    // chkboxOther.setText(temp);
                    ++flag;
                   // job.add(i,chkboxOther.getText().toString());
                    // job[i] = chkboxOther.getText().toString();
                    i++;
                    System.out.println("-----------------------+++++-" + flag);
                } else {
                    chkboxOther.setClickable(true);
                    etOtherJob.setVisibility(View.INVISIBLE);
                    etOtherJob.setText("");
                    flag = --flag;
                    job.remove(temp);
                    i--;
                    System.out.println("------------------------" + flag);
                }

                break;

        }
    }



}