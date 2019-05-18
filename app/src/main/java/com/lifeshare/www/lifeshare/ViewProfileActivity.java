package com.lifeshare.www.lifeshare;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewProfileActivity extends AppCompatActivity {

    private TextView profileName, profileAge, profileBlood, profilePhone, profileEmail, profileState, profileDistrict;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    private DatabaseReference uDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        profileName = (TextView)findViewById(R.id.tvUserName);

        profileBlood = (TextView)findViewById(R.id.tvUserBlood);
        profilePhone = (TextView)findViewById(R.id.tvUserPhone);
        profileEmail = (TextView)findViewById(R.id.tvUserEmail);
        profileState = (TextView)findViewById(R.id.tvUserState);
        profileDistrict = (TextView)findViewById(R.id.tvUserDistrict);

        firebaseAuth = FirebaseAuth.getInstance();


        uDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference dDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference databaseReference = dDatabase.child("users");

        DatabaseReference uidData = databaseReference.child(firebaseAuth.getUid());


        uidData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                profileName.setText("Name: "+userProfile.getUserName());

                profileBlood.setText("Blood Group: "+userProfile.getUserBlood());
                profilePhone.setText("Phone: "+userProfile.getUserPhone());
                profileEmail.setText("Email: "+userProfile.getUserEmail());
                profileState.setText("State: "+userProfile.getUserState());
                profileDistrict.setText("District: "+userProfile.getUserDistrict());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewProfileActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
