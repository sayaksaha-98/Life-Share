package com.lifeshare.www.lifeshare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegistrationActivity extends AppCompatActivity {


    private EditText userName, userPassword, userEmail, userAge, userPhone;
    private Button regButton;
    private TextView userLogin;
    private Spinner userBlood, userState, userDistrict;

    private FirebaseAuth firebaseAuth;
    String email, name, password, bloodGr, bld, phone, state, district  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();


        //State Adapter
        ArrayAdapter<CharSequence> adapterState = ArrayAdapter.createFromResource(this,R.array.state_names,android.R.layout.simple_spinner_item);
        adapterState.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userState.setAdapter(adapterState);

        //Districts Selection
        userState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String stateSelect = userState.getSelectedItem().toString();

                //None Selected
                if(stateSelect.equals("Select State...")){
                    ArrayAdapter<CharSequence> adapterNone = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_none,android.R.layout.simple_spinner_item);
                    adapterNone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterNone);
                }
                //Andaman
                else if(stateSelect.equals("Andaman and Nicobar Islands")){
                    ArrayAdapter<CharSequence> adapterAndaman = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Andaman,android.R.layout.simple_spinner_item);
                    adapterAndaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterAndaman);
                }

                //AndhraPradesh
                else if(stateSelect.equals("Andhra Pradesh")){
                    ArrayAdapter<CharSequence> adapterAndhra = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_AndhraPradesh,android.R.layout.simple_spinner_item);
                    adapterAndhra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterAndhra);
                }

                //Arunachal Pradesh
                else if(stateSelect.equals("Arunachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterArunachal = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_ArunachalPradesh,android.R.layout.simple_spinner_item);
                    adapterArunachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterArunachal);
                }

                //Assam
                else if(stateSelect.equals("Assam")){
                    ArrayAdapter<CharSequence> adapterAssam = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Assam,android.R.layout.simple_spinner_item);
                    adapterAssam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterAssam);
                }

                //Bihar
                else if(stateSelect.equals("Bihar")){
                    ArrayAdapter<CharSequence> adapterBihar = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Bihar,android.R.layout.simple_spinner_item);
                    adapterBihar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterBihar);
                }

                //Chandigarh
                else if(stateSelect.equals("Chandigarh")){
                    ArrayAdapter<CharSequence> adapterChandi = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Chandigarh,android.R.layout.simple_spinner_item);
                    adapterChandi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterChandi);
                }

                //Chhattisgarh
                else if(stateSelect.equals("Chhattisgarh")){
                    ArrayAdapter<CharSequence> adapterChhattisgarh = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Chhattisgarh,android.R.layout.simple_spinner_item);
                    adapterChhattisgarh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterChhattisgarh);
                }

                //Dadra and Nagar Haveli
                else if(stateSelect.equals("Dadra and Nagar Haveli")){
                    ArrayAdapter<CharSequence> adapterDadra = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Dadra,android.R.layout.simple_spinner_item);
                    adapterDadra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterDadra);
                }

                //Daman and Diu
                else if(stateSelect.equals("Daman and Diu")){
                    ArrayAdapter<CharSequence> adapterDaman = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Daman,android.R.layout.simple_spinner_item);
                    adapterDaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterDaman);
                }

                //Delhi
                else if(stateSelect.equals("Delhi")){
                    ArrayAdapter<CharSequence> adapterDelhi = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Delhi,android.R.layout.simple_spinner_item);
                    adapterDelhi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterDelhi);
                }

                //Goa
                else if(stateSelect.equals("Goa")){
                    ArrayAdapter<CharSequence> adapterGoa = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Goa,android.R.layout.simple_spinner_item);
                    adapterGoa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterGoa);
                }

                //Gujarat
                else if(stateSelect.equals("Gujarat")){
                    ArrayAdapter<CharSequence> adapterGujarat = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Gujarat,android.R.layout.simple_spinner_item);
                    adapterGujarat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterGujarat);
                }

                //Haryana
                else if(stateSelect.equals("Haryana")){
                    ArrayAdapter<CharSequence> adapterHaryana = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Haryana,android.R.layout.simple_spinner_item);
                    adapterHaryana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterHaryana);
                }

                //Himachal
                else if(stateSelect.equals("Himachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterHimachal = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Himachal,android.R.layout.simple_spinner_item);
                    adapterHimachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterHimachal);
                }

                //Jammu and Kashmir
                else if(stateSelect.equals("Jammu and Kashmir")){
                    ArrayAdapter<CharSequence> adapterJammu = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Jammu,android.R.layout.simple_spinner_item);
                    adapterJammu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterJammu);
                }

                //Jharkhand
                else if(stateSelect.equals("Jharkhand")){
                    ArrayAdapter<CharSequence> adapterJharkhand = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Jharkhand,android.R.layout.simple_spinner_item);
                    adapterJharkhand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterJharkhand);
                }

                //Karnataka
                else if(stateSelect.equals("Karnataka")){
                    ArrayAdapter<CharSequence> adapterKarnataka = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Karnataka,android.R.layout.simple_spinner_item);
                    adapterKarnataka.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterKarnataka);
                }

                //Kerala
                else if(stateSelect.equals("Kerala")){
                    ArrayAdapter<CharSequence> adapterKerala = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Kerala,android.R.layout.simple_spinner_item);
                    adapterKerala.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterKerala);
                }

                //Lakshadweep
                else if(stateSelect.equals("Lakshadweep")){
                    ArrayAdapter<CharSequence> adapterLaksh = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Laksh,android.R.layout.simple_spinner_item);
                    adapterLaksh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterLaksh);
                }

                //Madhya Pradesh
                else if(stateSelect.equals("Madhya Pradesh")){
                    ArrayAdapter<CharSequence> adapterMadhya = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Madhya,android.R.layout.simple_spinner_item);
                    adapterMadhya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterMadhya);
                }

                //Maharashtra
                else if(stateSelect.equals("Maharashtra")){
                    ArrayAdapter<CharSequence> adapterMaharashtra = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Maharashtra,android.R.layout.simple_spinner_item);
                    adapterMaharashtra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterMaharashtra);
                }

                //Manipur
                else if(stateSelect.equals("Manipur")){
                    ArrayAdapter<CharSequence> adapterManipur = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Manipur,android.R.layout.simple_spinner_item);
                    adapterManipur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterManipur);
                }

                //Meghalaya
                else if(stateSelect.equals("Meghalaya")){
                    ArrayAdapter<CharSequence> adapterMeghalaya = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Meghalaya,android.R.layout.simple_spinner_item);
                    adapterMeghalaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterMeghalaya);
                }

                //Mizoram
                else if(stateSelect.equals("Mizoram")){
                    ArrayAdapter<CharSequence> adapterMizoram = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Mizoram,android.R.layout.simple_spinner_item);
                    adapterMizoram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterMizoram);
                }

                //Nagaland
                else if(stateSelect.equals("Nagaland")){
                    ArrayAdapter<CharSequence> adapterNagaland = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Nagaland,android.R.layout.simple_spinner_item);
                    adapterNagaland.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterNagaland);
                }

                //Odisha
                else if(stateSelect.equals("Odisha")){
                    ArrayAdapter<CharSequence> adapterOdisha = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Odisha,android.R.layout.simple_spinner_item);
                    adapterOdisha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterOdisha);
                }

                //Puducherry
                else if(stateSelect.equals("Puducherry")){
                    ArrayAdapter<CharSequence> adapterPuducherry = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Puducherry,android.R.layout.simple_spinner_item);
                    adapterPuducherry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterPuducherry);
                }

                //Punjab
                else if(stateSelect.equals("Punjab")){
                    ArrayAdapter<CharSequence> adapterPunjab = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Punjab,android.R.layout.simple_spinner_item);
                    adapterPunjab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterPunjab);
                }

                //Rajasthan
                else if(stateSelect.equals("Rajasthan")){
                    ArrayAdapter<CharSequence> adapterRajasthan = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Rajasthan,android.R.layout.simple_spinner_item);
                    adapterRajasthan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterRajasthan);
                }

                //Sikkim
                else if(stateSelect.equals("Sikkim")){
                    ArrayAdapter<CharSequence> adapterSikkim = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Sikkim,android.R.layout.simple_spinner_item);
                    adapterSikkim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterSikkim);
                }

                //Tamil Nadu
                else if(stateSelect.equals("Tamil Nadu")){
                    ArrayAdapter<CharSequence> adapterTamil = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Tamil,android.R.layout.simple_spinner_item);
                    adapterTamil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterTamil);
                }

                //Telangana
                else if(stateSelect.equals("Telangana")){
                    ArrayAdapter<CharSequence> adapterTelan = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Telan,android.R.layout.simple_spinner_item);
                    adapterTelan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterTelan);
                }

                //Tripura
                else if(stateSelect.equals("Tripura")){
                    ArrayAdapter<CharSequence> adapterTripura = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Tripura,android.R.layout.simple_spinner_item);
                    adapterTripura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterTripura);
                }

                //Uttar Pradesh
                else if(stateSelect.equals("Uttar Pradesh")){
                    ArrayAdapter<CharSequence> adapterUPradesh = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_UPradesh,android.R.layout.simple_spinner_item);
                    adapterUPradesh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterUPradesh);
                }

                //Uttarakhand
                else if(stateSelect.equals("Uttarakhand")){
                    ArrayAdapter<CharSequence> adapterUttara = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Uttara,android.R.layout.simple_spinner_item);
                    adapterUttara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterUttara);
                }

                //West Bengal
                else if(stateSelect.equals("West Bengal")){
                    ArrayAdapter<CharSequence> adapterBengal = ArrayAdapter.createFromResource(RegistrationActivity.this,R.array.district_Bengal,android.R.layout.simple_spinner_item);
                    adapterBengal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    userDistrict.setAdapter(adapterBengal);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //upload data to database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                sendUserData();
                                sendEmailVerification();
                            }
                            else {
                                Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });
    }

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUserName);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        regButton = (Button)findViewById(R.id.btnRegister);
        userLogin = (TextView)findViewById(R.id.tvUserLogin);
     //   userAge = (EditText)findViewById(R.id.etAge);
     //   userBlood = (EditText)findViewById(R.id.etBlood);
        userPhone = (EditText)findViewById(R.id.etUserPhone);
        userBlood = (Spinner)findViewById(R.id.spUserBloodGroup);
        userState = (Spinner)findViewById(R.id.spUserState);
        userDistrict = (Spinner)findViewById(R.id.spUserDistrict);
    }

    private Boolean validate(){
        Boolean result = false;

        name = userName.getText().toString();
        password = userPassword.getText().toString();
        email = userEmail.getText().toString();
      //  age = userAge.getText().toString();
       // bld = userBlood.getText().toString().toUpperCase();
        phone = userPhone.getText().toString();
        bld = userBlood.getSelectedItem().toString();
        state = userState.getSelectedItem().toString();
        district = userDistrict.getSelectedItem().toString();

        int flag=0;

        if(bld.equals("A+") || bld.equals("B+")|| bld.equals("AB+")|| bld.equals("O+")|| bld.equals("A-")|| bld.equals("B-")|| bld.equals("AB-")|| bld.equals("O-")){
            bloodGr = bld;
            flag=1;
        }
        else{
            Toast.makeText(this,"Please enter valid blood group", Toast.LENGTH_SHORT).show();
          //  Toast.makeText(this,"example:A+,B-,etc", Toast.LENGTH_LONG).show();
        }


        int flagS=0;

        if(state.equals("Select State...")){
            Toast.makeText(this,"Please enter valid state", Toast.LENGTH_SHORT).show();
            flagS=0;
        }
        else{
            flagS=1;
            //  Toast.makeText(this,"example:A+,B-,etc", Toast.LENGTH_LONG).show();
        }

        int flagDist=0;
        if(district.equals("Select District")){
            Toast.makeText(this,"Please enter valid district", Toast.LENGTH_SHORT).show();
            flagDist=0;
        }
        else{
            flagDist=1;
            //  Toast.makeText(this,"example:A+,B-,etc", Toast.LENGTH_LONG).show();
        }

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()  || flag==0 ||flagS==0|| flagDist==0 ||phone.isEmpty()){
            Toast.makeText(this,"Please Enter All The Details", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        String id = firebaseAuth.getUid();
        DatabaseReference databaseUsers = firebaseDatabase.getReference("users");
        UserProfile userProfile = new UserProfile( state, district, email, name, bloodGr, phone);
        databaseUsers.child(id).setValue(userProfile);
    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegistrationActivity.this, "Successfully Registered, Verification mail sent",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this, "Verification Mail not Sent",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


}
