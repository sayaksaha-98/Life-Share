package com.lifeshare.www.lifeshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GiveDetailsActivity extends AppCompatActivity {


    private EditText patientName, patientPhone, patientHospital;
    private Spinner patientBlood, patientState, patientDistrict;
    private Button upDet;



    String pName, pPhone, pHospital, pBlood, pState, pDistrict;

    public String patientReqState, patientReqBlood;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_details);

        patientName = (EditText)findViewById(R.id.etPatientName);
        patientPhone = (EditText)findViewById(R.id.etPatientPhone);
        patientHospital = (EditText)findViewById(R.id.etHospitalName);
        patientBlood = (Spinner)findViewById(R.id.spSlectBloodReq);
        patientState = (Spinner)findViewById(R.id.spSelectState);
        patientDistrict = (Spinner)findViewById(R.id.spSelectDistrict);
        upDet = (Button)findViewById(R.id.btnSendReq);


        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();


        //Districts Selection
        patientState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String stateSelect = patientState.getSelectedItem().toString();

                //None Selected
                if(stateSelect.equals("Select State...")){
                    ArrayAdapter<CharSequence> adapterNone = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_none,android.R.layout.simple_spinner_item);
                    adapterNone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterNone);
                }

                //Andaman
                else if(stateSelect.equals("Andaman and Nicobar Islands")){
                    ArrayAdapter<CharSequence> adapterAndaman = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Andaman,android.R.layout.simple_spinner_item);
                    adapterAndaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterAndaman);
                }

                //AndhraPradesh
                else if(stateSelect.equals("Andhra Pradesh")){
                    ArrayAdapter<CharSequence> adapterAndhra = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_AndhraPradesh,android.R.layout.simple_spinner_item);
                    adapterAndhra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterAndhra);
                }

                //Arunachal Pradesh
                else if(stateSelect.equals("Arunachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterArunachal = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_ArunachalPradesh,android.R.layout.simple_spinner_item);
                    adapterArunachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterArunachal);
                }

                //Assam
                else if(stateSelect.equals("Assam")){
                    ArrayAdapter<CharSequence> adapterAssam = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Assam,android.R.layout.simple_spinner_item);
                    adapterAssam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterAssam);
                }

                //Bihar
                else if(stateSelect.equals("Bihar")){
                    ArrayAdapter<CharSequence> adapterBihar = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Bihar,android.R.layout.simple_spinner_item);
                    adapterBihar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterBihar);
                }

                //Chandigarh
                else if(stateSelect.equals("Chandigarh")){
                    ArrayAdapter<CharSequence> adapterChandi = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Chandigarh,android.R.layout.simple_spinner_item);
                    adapterChandi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterChandi);
                }

                //Chhattisgarh
                else if(stateSelect.equals("Chhattisgarh")){
                    ArrayAdapter<CharSequence> adapterChhattisgarh = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Chhattisgarh,android.R.layout.simple_spinner_item);
                    adapterChhattisgarh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterChhattisgarh);
                }

                //Dadra and Nagar Haveli
                else if(stateSelect.equals("Dadra and Nagar Haveli")){
                    ArrayAdapter<CharSequence> adapterDadra = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Dadra,android.R.layout.simple_spinner_item);
                    adapterDadra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterDadra);
                }

                //Daman and Diu
                else if(stateSelect.equals("Daman and Diu")){
                    ArrayAdapter<CharSequence> adapterDaman = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Daman,android.R.layout.simple_spinner_item);
                    adapterDaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterDaman);
                }

                //Delhi
                else if(stateSelect.equals("Delhi")){
                    ArrayAdapter<CharSequence> adapterDelhi = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Delhi,android.R.layout.simple_spinner_item);
                    adapterDelhi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterDelhi);
                }

                //Goa
                else if(stateSelect.equals("Goa")){
                    ArrayAdapter<CharSequence> adapterGoa = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Goa,android.R.layout.simple_spinner_item);
                    adapterGoa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterGoa);
                }

                //Gujarat
                else if(stateSelect.equals("Gujarat")){
                    ArrayAdapter<CharSequence> adapterGujarat = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Gujarat,android.R.layout.simple_spinner_item);
                    adapterGujarat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterGujarat);
                }

                //Haryana
                else if(stateSelect.equals("Haryana")){
                    ArrayAdapter<CharSequence> adapterHaryana = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Haryana,android.R.layout.simple_spinner_item);
                    adapterHaryana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterHaryana);
                }

                //Himachal
                else if(stateSelect.equals("Himachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterHimachal = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Himachal,android.R.layout.simple_spinner_item);
                    adapterHimachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterHimachal);
                }

                //Jammu and Kashmir
                else if(stateSelect.equals("Jammu and Kashmir")){
                    ArrayAdapter<CharSequence> adapterJammu = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Jammu,android.R.layout.simple_spinner_item);
                    adapterJammu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterJammu);
                }

                //Jharkhand
                else if(stateSelect.equals("Jharkhand")){
                    ArrayAdapter<CharSequence> adapterJharkhand = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Jharkhand,android.R.layout.simple_spinner_item);
                    adapterJharkhand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterJharkhand);
                }

                //Karnataka
                else if(stateSelect.equals("Karnataka")){
                    ArrayAdapter<CharSequence> adapterKarnataka = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Karnataka,android.R.layout.simple_spinner_item);
                    adapterKarnataka.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterKarnataka);
                }

                //Kerala
                else if(stateSelect.equals("Kerala")){
                    ArrayAdapter<CharSequence> adapterKerala = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Kerala,android.R.layout.simple_spinner_item);
                    adapterKerala.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterKerala);
                }

                //Lakshadweep
                else if(stateSelect.equals("Lakshadweep")){
                    ArrayAdapter<CharSequence> adapterLaksh = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Laksh,android.R.layout.simple_spinner_item);
                    adapterLaksh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterLaksh);
                }

                //Madhya Pradesh
                else if(stateSelect.equals("Madhya Pradesh")){
                    ArrayAdapter<CharSequence> adapterMadhya = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Madhya,android.R.layout.simple_spinner_item);
                    adapterMadhya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterMadhya);
                }

                //Maharashtra
                else if(stateSelect.equals("Maharashtra")){
                    ArrayAdapter<CharSequence> adapterMaharashtra = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Maharashtra,android.R.layout.simple_spinner_item);
                    adapterMaharashtra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterMaharashtra);
                }

                //Manipur
                else if(stateSelect.equals("Manipur")){
                    ArrayAdapter<CharSequence> adapterManipur = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Manipur,android.R.layout.simple_spinner_item);
                    adapterManipur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterManipur);
                }

                //Meghalaya
                else if(stateSelect.equals("Meghalaya")){
                    ArrayAdapter<CharSequence> adapterMeghalaya = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Meghalaya,android.R.layout.simple_spinner_item);
                    adapterMeghalaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterMeghalaya);
                }

                //Mizoram
                else if(stateSelect.equals("Mizoram")){
                    ArrayAdapter<CharSequence> adapterMizoram = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Mizoram,android.R.layout.simple_spinner_item);
                    adapterMizoram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterMizoram);
                }

                //Nagaland
                else if(stateSelect.equals("Nagaland")){
                    ArrayAdapter<CharSequence> adapterNagaland = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Nagaland,android.R.layout.simple_spinner_item);
                    adapterNagaland.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterNagaland);
                }

                //Odisha
                else if(stateSelect.equals("Odisha")){
                    ArrayAdapter<CharSequence> adapterOdisha = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Odisha,android.R.layout.simple_spinner_item);
                    adapterOdisha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterOdisha);
                }

                //Puducherry
                else if(stateSelect.equals("Puducherry")){
                    ArrayAdapter<CharSequence> adapterPuducherry = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Puducherry,android.R.layout.simple_spinner_item);
                    adapterPuducherry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterPuducherry);
                }

                //Punjab
                else if(stateSelect.equals("Punjab")){
                    ArrayAdapter<CharSequence> adapterPunjab = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Punjab,android.R.layout.simple_spinner_item);
                    adapterPunjab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterPunjab);
                }

                //Rajasthan
                else if(stateSelect.equals("Rajasthan")){
                    ArrayAdapter<CharSequence> adapterRajasthan = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Rajasthan,android.R.layout.simple_spinner_item);
                    adapterRajasthan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterRajasthan);
                }

                //Sikkim
                else if(stateSelect.equals("Sikkim")){
                    ArrayAdapter<CharSequence> adapterSikkim = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Sikkim,android.R.layout.simple_spinner_item);
                    adapterSikkim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterSikkim);
                }

                //Tamil Nadu
                else if(stateSelect.equals("Tamil Nadu")){
                    ArrayAdapter<CharSequence> adapterTamil = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Tamil,android.R.layout.simple_spinner_item);
                    adapterTamil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterTamil);
                }

                //Telangana
                else if(stateSelect.equals("Telangana")){
                    ArrayAdapter<CharSequence> adapterTelan = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Telan,android.R.layout.simple_spinner_item);
                    adapterTelan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterTelan);
                }

                //Tripura
                else if(stateSelect.equals("Tripura")){
                    ArrayAdapter<CharSequence> adapterTripura = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Tripura,android.R.layout.simple_spinner_item);
                    adapterTripura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterTripura);
                }

                //Uttar Pradesh
                else if(stateSelect.equals("Uttar Pradesh")){
                    ArrayAdapter<CharSequence> adapterUPradesh = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_UPradesh,android.R.layout.simple_spinner_item);
                    adapterUPradesh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterUPradesh);
                }

                //Uttarakhand
                else if(stateSelect.equals("Uttarakhand")){
                    ArrayAdapter<CharSequence> adapterUttara = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Uttara,android.R.layout.simple_spinner_item);
                    adapterUttara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterUttara);
                }

                //West Bengal
                else if(stateSelect.equals("West Bengal")){
                    ArrayAdapter<CharSequence> adapterBengal = ArrayAdapter.createFromResource(GiveDetailsActivity.this,R.array.district_Bengal,android.R.layout.simple_spinner_item);
                    adapterBengal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    patientDistrict.setAdapter(adapterBengal);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        upDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(GiveDetailsActivity.this,"after Click",Toast.LENGTH_LONG).show();
                if(valid()){

                  //  sendRequest();
             //       Toast.makeText(GiveDetailsActivity.this,"under validate If statement",Toast.LENGTH_SHORT).show();

                    if(upDate()==true){
                        Toast.makeText(GiveDetailsActivity.this, "Request Updated Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        Toast.makeText(GiveDetailsActivity.this, "Request Failed",Toast.LENGTH_SHORT).show();
                    }




                /*    Log.d("Error", "DatabaseReference Error");
                    UserRequest userRequest = new UserRequest(pName,pPhone,pHospital);
                    Log.d("Error2", "DatabaseReference Error");
                    databaseRequests.child(pState).child(pBlood).child(id).setValue(userRequest);

                    Toast.makeText(GiveDetailsActivity.this,"Data uploaded Successfully",Toast.LENGTH_SHORT).show();

                    databaseRequests
                    Intent intent = new Intent(GiveDetailsActivity.this,RegistrationActivity.class);
                    startActivity(intent);
                    //  finish();
                //    startActivity(new Intent(GiveDetailsActivity.this,RegistrationActivity.class));
*/
                }
                else{
                    Toast.makeText(GiveDetailsActivity.this,"Nope",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private Boolean valid(){
        Boolean res = false;
        pName = patientName.getText().toString().trim();
        pPhone = patientPhone.getText().toString().trim();
        pHospital = patientHospital.getText().toString().trim();
        pBlood = patientBlood.getSelectedItem().toString();
        pState = patientState.getSelectedItem().toString();
        pDistrict = patientDistrict.getSelectedItem().toString();

        int flagB=0;
        if(pBlood.equals("BloodGroup")){
            flagB=0;
        }
        else{
            flagB=1;

        }

        int flagS=0;
        if(pState.equals("Select State...")){
            flagS=0;
        }
        else{
            flagS=1;

        }

        int flagDist=0;
        if(pDistrict.equals("Select District")){
      //      Toast.makeText(this,"Please enter valid district", Toast.LENGTH_SHORT).show();
            flagDist=0;
        }
        else{
            flagDist=1;
            //  Toast.makeText(this,"example:A+,B-,etc", Toast.LENGTH_LONG).show();
        }

        if(pName.isEmpty() || pPhone.isEmpty() || pHospital.isEmpty() || flagB==0 || flagS==0 || flagDist==0){
            Toast.makeText(this,"Please Enter All The Details", Toast.LENGTH_SHORT).show();
        }
        else
            res=true;

        return res;

    }


    private Boolean upDate(){
        Boolean complete = false;


        firebaseDatabase = FirebaseDatabase.getInstance();

        String id = firebaseAuth.getCurrentUser().getUid();

        Log.d("No Error", "DatabaseReference Error");
        //    DatabaseReference databaseRequests = firebaseDatabase.getReference("requests");
        DatabaseReference databaseRequests = FirebaseDatabase.getInstance().getReference().child("requests");
        DatabaseReference databaseState = databaseRequests.child(pState);
        DatabaseReference databaseDistrict = databaseState.child(pDistrict);
        DatabaseReference databaseBlood = databaseDistrict.child(pBlood);
        DatabaseReference databaseUid = databaseBlood.child(id);

        //   UserRequest userRequest = new UserRequest(pName,pPhone,pHospital);
        //   databaseUid.setValue(userRequest);

        if(true) {
            databaseUid.child("pName").setValue(pName);
            databaseUid.child("pPhone").setValue(pPhone);
            databaseUid.child("pHospital").setValue(pHospital);

            complete = true;
        }

        return complete;
    }

}
