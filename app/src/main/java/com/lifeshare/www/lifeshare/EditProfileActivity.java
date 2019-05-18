package com.lifeshare.www.lifeshare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileActivity extends AppCompatActivity {

    private EditText etEditPhone;
    private Spinner spEditState, spEditDistrict;
    private Button btnCancelEdit, btnApplyEdit;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    String editState, editDistrict, editPhone, prevName, prevEmail, prevBlood, prevState, prevDistrict;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        etEditPhone = (EditText)findViewById(R.id.etEditPhone);
        spEditState = (Spinner)findViewById(R.id.spEditState);
        spEditDistrict = (Spinner)findViewById(R.id.spEditDistrict);
        btnApplyEdit = (Button)findViewById(R.id.btnApplyChanges);
        btnCancelEdit = (Button)findViewById(R.id.btnCancelChanges);

        firebaseAuth = FirebaseAuth.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        //State Adapter
        ArrayAdapter<CharSequence> adapterState = ArrayAdapter.createFromResource(this,R.array.state_names,android.R.layout.simple_spinner_item);
        adapterState.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEditState.setAdapter(adapterState);

        //Districts Selection
        spEditState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String stateSelect = spEditState.getSelectedItem().toString();

                //None Selected
                if(stateSelect.equals("Select State...")){
                    ArrayAdapter<CharSequence> adapterNone = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_none,android.R.layout.simple_spinner_item);
                    adapterNone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterNone);
                }
                //Andaman
                else if(stateSelect.equals("Andaman and Nicobar Islands")){
                    ArrayAdapter<CharSequence> adapterAndaman = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Andaman,android.R.layout.simple_spinner_item);
                    adapterAndaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterAndaman);
                }

                //AndhraPradesh
                else if(stateSelect.equals("Andhra Pradesh")){
                    ArrayAdapter<CharSequence> adapterAndhra = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_AndhraPradesh,android.R.layout.simple_spinner_item);
                    adapterAndhra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterAndhra);
                }

                //Arunachal Pradesh
                else if(stateSelect.equals("Arunachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterArunachal = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_ArunachalPradesh,android.R.layout.simple_spinner_item);
                    adapterArunachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterArunachal);
                }

                //Assam
                else if(stateSelect.equals("Assam")){
                    ArrayAdapter<CharSequence> adapterAssam = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Assam,android.R.layout.simple_spinner_item);
                    adapterAssam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterAssam);
                }

                //Bihar
                else if(stateSelect.equals("Bihar")){
                    ArrayAdapter<CharSequence> adapterBihar = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Bihar,android.R.layout.simple_spinner_item);
                    adapterBihar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterBihar);
                }

                //Chandigarh
                else if(stateSelect.equals("Chandigarh")){
                    ArrayAdapter<CharSequence> adapterChandi = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Chandigarh,android.R.layout.simple_spinner_item);
                    adapterChandi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterChandi);
                }

                //Chhattisgarh
                else if(stateSelect.equals("Chhattisgarh")){
                    ArrayAdapter<CharSequence> adapterChhattisgarh = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Chhattisgarh,android.R.layout.simple_spinner_item);
                    adapterChhattisgarh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterChhattisgarh);
                }

                //Dadra and Nagar Haveli
                else if(stateSelect.equals("Dadra and Nagar Haveli")){
                    ArrayAdapter<CharSequence> adapterDadra = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Dadra,android.R.layout.simple_spinner_item);
                    adapterDadra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterDadra);
                }

                //Daman and Diu
                else if(stateSelect.equals("Daman and Diu")){
                    ArrayAdapter<CharSequence> adapterDaman = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Daman,android.R.layout.simple_spinner_item);
                    adapterDaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterDaman);
                }

                //Delhi
                else if(stateSelect.equals("Delhi")){
                    ArrayAdapter<CharSequence> adapterDelhi = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Delhi,android.R.layout.simple_spinner_item);
                    adapterDelhi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterDelhi);
                }

                //Goa
                else if(stateSelect.equals("Goa")){
                    ArrayAdapter<CharSequence> adapterGoa = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Goa,android.R.layout.simple_spinner_item);
                    adapterGoa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterGoa);
                }

                //Gujarat
                else if(stateSelect.equals("Gujarat")){
                    ArrayAdapter<CharSequence> adapterGujarat = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Gujarat,android.R.layout.simple_spinner_item);
                    adapterGujarat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterGujarat);
                }

                //Haryana
                else if(stateSelect.equals("Haryana")){
                    ArrayAdapter<CharSequence> adapterHaryana = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Haryana,android.R.layout.simple_spinner_item);
                    adapterHaryana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterHaryana);
                }

                //Himachal
                else if(stateSelect.equals("Himachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterHimachal = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Himachal,android.R.layout.simple_spinner_item);
                    adapterHimachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterHimachal);
                }

                //Jammu and Kashmir
                else if(stateSelect.equals("Jammu and Kashmir")){
                    ArrayAdapter<CharSequence> adapterJammu = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Jammu,android.R.layout.simple_spinner_item);
                    adapterJammu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterJammu);
                }

                //Jharkhand
                else if(stateSelect.equals("Jharkhand")){
                    ArrayAdapter<CharSequence> adapterJharkhand = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Jharkhand,android.R.layout.simple_spinner_item);
                    adapterJharkhand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterJharkhand);
                }

                //Karnataka
                else if(stateSelect.equals("Karnataka")){
                    ArrayAdapter<CharSequence> adapterKarnataka = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Karnataka,android.R.layout.simple_spinner_item);
                    adapterKarnataka.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterKarnataka);
                }

                //Kerala
                else if(stateSelect.equals("Kerala")){
                    ArrayAdapter<CharSequence> adapterKerala = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Kerala,android.R.layout.simple_spinner_item);
                    adapterKerala.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterKerala);
                }

                //Lakshadweep
                else if(stateSelect.equals("Lakshadweep")){
                    ArrayAdapter<CharSequence> adapterLaksh = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Laksh,android.R.layout.simple_spinner_item);
                    adapterLaksh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterLaksh);
                }

                //Madhya Pradesh
                else if(stateSelect.equals("Madhya Pradesh")){
                    ArrayAdapter<CharSequence> adapterMadhya = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Madhya,android.R.layout.simple_spinner_item);
                    adapterMadhya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterMadhya);
                }

                //Maharashtra
                else if(stateSelect.equals("Maharashtra")){
                    ArrayAdapter<CharSequence> adapterMaharashtra = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Maharashtra,android.R.layout.simple_spinner_item);
                    adapterMaharashtra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterMaharashtra);
                }

                //Manipur
                else if(stateSelect.equals("Manipur")){
                    ArrayAdapter<CharSequence> adapterManipur = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Manipur,android.R.layout.simple_spinner_item);
                    adapterManipur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterManipur);
                }

                //Meghalaya
                else if(stateSelect.equals("Meghalaya")){
                    ArrayAdapter<CharSequence> adapterMeghalaya = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Meghalaya,android.R.layout.simple_spinner_item);
                    adapterMeghalaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterMeghalaya);
                }

                //Mizoram
                else if(stateSelect.equals("Mizoram")){
                    ArrayAdapter<CharSequence> adapterMizoram = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Mizoram,android.R.layout.simple_spinner_item);
                    adapterMizoram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterMizoram);
                }

                //Nagaland
                else if(stateSelect.equals("Nagaland")){
                    ArrayAdapter<CharSequence> adapterNagaland = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Nagaland,android.R.layout.simple_spinner_item);
                    adapterNagaland.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterNagaland);
                }

                //Odisha
                else if(stateSelect.equals("Odisha")){
                    ArrayAdapter<CharSequence> adapterOdisha = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Odisha,android.R.layout.simple_spinner_item);
                    adapterOdisha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterOdisha);
                }

                //Puducherry
                else if(stateSelect.equals("Puducherry")){
                    ArrayAdapter<CharSequence> adapterPuducherry = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Puducherry,android.R.layout.simple_spinner_item);
                    adapterPuducherry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterPuducherry);
                }

                //Punjab
                else if(stateSelect.equals("Punjab")){
                    ArrayAdapter<CharSequence> adapterPunjab = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Punjab,android.R.layout.simple_spinner_item);
                    adapterPunjab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterPunjab);
                }

                //Rajasthan
                else if(stateSelect.equals("Rajasthan")){
                    ArrayAdapter<CharSequence> adapterRajasthan = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Rajasthan,android.R.layout.simple_spinner_item);
                    adapterRajasthan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterRajasthan);
                }

                //Sikkim
                else if(stateSelect.equals("Sikkim")){
                    ArrayAdapter<CharSequence> adapterSikkim = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Sikkim,android.R.layout.simple_spinner_item);
                    adapterSikkim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterSikkim);
                }

                //Tamil Nadu
                else if(stateSelect.equals("Tamil Nadu")){
                    ArrayAdapter<CharSequence> adapterTamil = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Tamil,android.R.layout.simple_spinner_item);
                    adapterTamil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterTamil);
                }

                //Telangana
                else if(stateSelect.equals("Telangana")){
                    ArrayAdapter<CharSequence> adapterTelan = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Telan,android.R.layout.simple_spinner_item);
                    adapterTelan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterTelan);
                }

                //Tripura
                else if(stateSelect.equals("Tripura")){
                    ArrayAdapter<CharSequence> adapterTripura = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Tripura,android.R.layout.simple_spinner_item);
                    adapterTripura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterTripura);
                }

                //Uttar Pradesh
                else if(stateSelect.equals("Uttar Pradesh")){
                    ArrayAdapter<CharSequence> adapterUPradesh = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_UPradesh,android.R.layout.simple_spinner_item);
                    adapterUPradesh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterUPradesh);
                }

                //Uttarakhand
                else if(stateSelect.equals("Uttarakhand")){
                    ArrayAdapter<CharSequence> adapterUttara = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Uttara,android.R.layout.simple_spinner_item);
                    adapterUttara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterUttara);
                }

                //West Bengal
                else if(stateSelect.equals("West Bengal")){
                    ArrayAdapter<CharSequence> adapterBengal = ArrayAdapter.createFromResource(EditProfileActivity.this,R.array.district_Bengal,android.R.layout.simple_spinner_item);
                    adapterBengal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spEditDistrict.setAdapter(adapterBengal);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnCancelEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(EditProfileActivity.this,SecondActivity.class));
            }
        });


        //Getting Previous Details & deleting previous data under users node
        getPreviousDets();

        btnApplyEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validChanges()){

                    //Checking if available in previous data if present delete
                    checkIfAvailable();

                    //Create new Users node
                    saveNewData();

                    finish();
                    startActivity(new Intent(EditProfileActivity.this,SecondActivity.class));

                }
            }
        });
    }

    private Boolean validChanges(){
        Boolean ret=false;

        editState = spEditState.getSelectedItem().toString();
        editDistrict = spEditDistrict.getSelectedItem().toString();
        editPhone = etEditPhone.getText().toString();

        int flagES=0;
        if(editState.equals("Select State...")){
            flagES=0;
        }
        else{
            flagES=1;
        }

        int flagED=0;
        if(editDistrict.equals("Select District")){
            flagED=0;
        }
        else{
            flagED=1;
        }

        int flagEP=0;
        if(editPhone.isEmpty()){
            flagEP=0;
        }
        else{
            flagEP=1;
        }

        if(flagES==1 && flagED==1 && flagEP==1){
            ret=true;
        }
        else{
            Toast.makeText(this,"Please Enter all Details", Toast.LENGTH_SHORT).show();
        }

        return ret;
    }

    private void getPreviousDets(){

        DatabaseReference dbusers = databaseReference.child("users");
        DatabaseReference dbuid = dbusers.child(userId);
        dbuid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                prevName = userProfile.getUserName();
                prevEmail = userProfile.getUserEmail();
                prevBlood = userProfile.getUserBlood();
                prevState = userProfile.getUserState();
                prevDistrict = userProfile.getUserDistrict();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void checkIfAvailable(){


        DatabaseReference databaseNotAvailEdit = databaseReference.child("available");
        DatabaseReference availNotStateEdit = databaseNotAvailEdit.child(prevState);
        DatabaseReference availNotDistEdit = availNotStateEdit.child(prevDistrict);
        DatabaseReference availNotBloodEdit = availNotDistEdit.child(prevBlood);
        DatabaseReference availNotUidEdit = availNotBloodEdit.child(userId);

        availNotUidEdit.removeValue();
    }

    private void saveNewData(){


        DatabaseReference newUser = databaseReference.child("users");
        UserProfile userProfile = new UserProfile( editState, editDistrict, prevEmail, prevName, prevBlood, editPhone);
        newUser.child(userId).setValue(userProfile);
    }
}
