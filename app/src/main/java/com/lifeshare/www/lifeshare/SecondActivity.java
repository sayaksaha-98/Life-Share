package com.lifeshare.www.lifeshare;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SecondActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    private Switch swAvail;
    private Button btnViewAvail;
    private Button btnViewReq;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    String aState;
    String aDistrict;
    String aName;

    String aBlood;
    String aPhone;
    String aEmail;



    private int flagAvail = 0;
    int flagA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        btnViewAvail = (Button)findViewById(R.id.btnAvailableDonors);
        btnViewReq = (Button)findViewById(R.id.btnRequests);
        swAvail = (Switch)findViewById(R.id.swAvailable);

        swAvail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                    flagA = 1;
                    Toast.makeText(SecondActivity.this,"You are Available",Toast.LENGTH_SHORT).show();
                    makeAvailable();
                }

                else{
                    flagA = 0;
                    makeNotAvailable();
                    Toast.makeText(SecondActivity.this,"You are Not Available",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //ToSeeAvailableDonors
        btnViewAvail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,ViewDonorsActivity.class));
            }
        });

        //To See Nearby requests
        btnViewReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,ViewRequestsActivity.class));
            }
        });

        //getting switchstate
/*        String switchFlag="";
        if(savedInstanceState!=null && savedInstanceState.containsKey("Switch state")){
            switchFlag=savedInstanceState.getString("Switch state");
            if(switchFlag.equals("ON")){
        //        swAvail.setOnCheckedChangeListener(null);
                swAvail.setChecked(true);
        //        swAvail.setOnCheckedChangeListener();
            }
            else if(switchFlag.equals("OFF")){
                swAvail.setChecked(false);
            }
        }
*/



        //getting user details
        DatabaseReference dDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference databaseReference = dDatabase.child("users");
        DatabaseReference uidData = databaseReference.child(firebaseAuth.getCurrentUser().getUid());

        uidData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                aName = userProfile.getUserName();
                aState = userProfile.getUserState();
                aDistrict = userProfile.getUserDistrict();
                aEmail = userProfile.getUserEmail();
                aBlood = userProfile.getUserBlood();
                aPhone = userProfile.getUserPhone();

                checkSwitchState();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    //Saving switchState
    @Override
    public void onSaveInstanceState(Bundle outState) {
        /*if(flagA==1){
            outState.putString("SwitchState","ON");
        }
        else{
            outState.putString("SwitchState","OFF");
        }*/
        outState.putBoolean("SwitchState",((Switch)findViewById(R.id.swAvailable)).isChecked());

        super.onSaveInstanceState(outState);
    }
    //getting switchstate
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        /*String switchFlag="";
        if(savedInstanceState!=null && savedInstanceState.containsKey("SwitchState")){
            switchFlag=savedInstanceState.getString("SwitchState");
            if(switchFlag.equals("ON")){
                //        swAvail.setOnCheckedChangeListener(null);
                swAvail.setChecked(true);
                //        swAvail.setOnCheckedChangeListener();
            }
            else if(switchFlag.equals("OFF")){
                swAvail.setChecked(false);
            }
        }*/
        ((Switch)findViewById(R.id.swAvailable)).setChecked(savedInstanceState.getBoolean("SwitchState"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.logoutMenu:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(SecondActivity.this,LoginActivity.class));
                break;
            }
            case R.id.viewDetails:{
                startActivity(new Intent(SecondActivity.this,ViewProfileActivity.class));
                break;
            }
            case R.id.editProfile:{
                startActivity(new Intent(SecondActivity.this,EditProfileActivity.class));
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(),"Press back again to Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }


    public void fillDetails(View view){
        startActivity(new Intent(this,GiveDetailsActivity.class));
    }




    private void makeAvailable(){
        String id = firebaseAuth.getCurrentUser().getUid();
     //   Toast.makeText(this,aState,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"You are Available for Donation",Toast.LENGTH_SHORT).show();
        DatabaseReference databaseAvail = FirebaseDatabase.getInstance().getReference().child("available");
        DatabaseReference availState = databaseAvail.child(aState);
        DatabaseReference availDist = availState.child(aDistrict);
        DatabaseReference availBlood = availDist.child(aBlood);
        DatabaseReference availUid = availBlood.child(id);

    /*    availUid.child("Available Name").setValue(aName);
        availUid.child("Available Email").setValue(aEmail);
        availUid.child("Available Phone").setValue(aPhone);
    */

        availUid.child("aName").setValue(aName);
        availUid.child("aEmail").setValue(aEmail);
        availUid.child("aPhone").setValue(aPhone);
    }

/*    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(flagAvail,flagA.getText());
        super.onSaveInstanceState(savedInstanceState);
    }*/
    private void makeNotAvailable(){
    String id = firebaseAuth.getCurrentUser().getUid();
    //   Toast.makeText(this,aState,Toast.LENGTH_SHORT).show();
    Toast.makeText(this,"You are not Available for Donation",Toast.LENGTH_SHORT).show();
    DatabaseReference databaseNotAvail = FirebaseDatabase.getInstance().getReference().child("available");
    DatabaseReference availNotState = databaseNotAvail.child(aState);
    DatabaseReference availNotDist = availNotState.child(aDistrict);
    DatabaseReference availNotBlood = availNotDist.child(aBlood);
    DatabaseReference availNotUid = availNotBlood.child(id);

    /*    availUid.child("Available Name").setValue(aName);
        availUid.child("Available Email").setValue(aEmail);
        availUid.child("Available Phone").setValue(aPhone);
    */

    availNotUid.removeValue();

    }

    //Setting Switvh from Database
    private void checkSwitchState(){

        DatabaseReference swAvialableRef=FirebaseDatabase.getInstance().getReference().child("available");
        DatabaseReference swStateRef=swAvialableRef.child(aState);
        DatabaseReference swDistRef=swStateRef.child(aDistrict);
        DatabaseReference swBloodRef=swDistRef.child(aBlood);
        DatabaseReference swUidRef = swBloodRef.child(firebaseAuth.getCurrentUser().getUid());

        //    swUidRef.child("Name").setValue(aName);

        swUidRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    swAvail.setChecked(true);
                }
                else{
                    swAvail.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                swAvail.setChecked(false);
            }
        });

    }

}
