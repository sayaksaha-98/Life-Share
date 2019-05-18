package com.lifeshare.www.lifeshare;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewRequestsActivity extends AppCompatActivity {

    private Spinner spChooseStateReq;
    private Spinner spChooseDistrictReq;
    private Spinner spChooseBloodReq;
    private Button btnApplyFilterReq;
    private ListView listRequest;

    ArrayList<String> listReq;
    ArrayAdapter<String> adapterReq;


    FirebaseDatabase firebaseDatabase;
    nearbyRequest nearReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_requests);

        nearReq= new nearbyRequest();

        spChooseStateReq = (Spinner)findViewById(R.id.spChStateReq);
        spChooseDistrictReq = (Spinner)findViewById(R.id.spChDistrictReq);
        spChooseBloodReq = (Spinner)findViewById(R.id.spChBloodReq);
        btnApplyFilterReq = (Button)findViewById(R.id.btnApplyReq);
        listRequest = (ListView)findViewById(R.id.liRequests);

        firebaseDatabase=FirebaseDatabase.getInstance();


        //Districts Selection
        spChooseStateReq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String stateSelect = spChooseStateReq.getSelectedItem().toString();

                //None Selected
                if(stateSelect.equals("Select State...")){
                    ArrayAdapter<CharSequence> adapterNone = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_none,android.R.layout.simple_spinner_item);
                    adapterNone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterNone);
                }

                //Andaman
                else if(stateSelect.equals("Andaman and Nicobar Islands")){
                    ArrayAdapter<CharSequence> adapterAndaman = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Andaman,android.R.layout.simple_spinner_item);
                    adapterAndaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterAndaman);
                }

                //AndhraPradesh
                else if(stateSelect.equals("Andhra Pradesh")){
                    ArrayAdapter<CharSequence> adapterAndhra = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_AndhraPradesh,android.R.layout.simple_spinner_item);
                    adapterAndhra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterAndhra);
                }

                //Arunachal Pradesh
                else if(stateSelect.equals("Arunachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterArunachal = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_ArunachalPradesh,android.R.layout.simple_spinner_item);
                    adapterArunachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterArunachal);
                }

                //Assam
                else if(stateSelect.equals("Assam")){
                    ArrayAdapter<CharSequence> adapterAssam = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Assam,android.R.layout.simple_spinner_item);
                    adapterAssam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterAssam);
                }

                //Bihar
                else if(stateSelect.equals("Bihar")){
                    ArrayAdapter<CharSequence> adapterBihar = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Bihar,android.R.layout.simple_spinner_item);
                    adapterBihar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterBihar);
                }

                //Chandigarh
                else if(stateSelect.equals("Chandigarh")){
                    ArrayAdapter<CharSequence> adapterChandi = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Chandigarh,android.R.layout.simple_spinner_item);
                    adapterChandi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterChandi);
                }

                //Chhattisgarh
                else if(stateSelect.equals("Chhattisgarh")){
                    ArrayAdapter<CharSequence> adapterChhattisgarh = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Chhattisgarh,android.R.layout.simple_spinner_item);
                    adapterChhattisgarh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterChhattisgarh);
                }

                //Dadra and Nagar Haveli
                else if(stateSelect.equals("Dadra and Nagar Haveli")){
                    ArrayAdapter<CharSequence> adapterDadra = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Dadra,android.R.layout.simple_spinner_item);
                    adapterDadra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterDadra);
                }

                //Daman and Diu
                else if(stateSelect.equals("Daman and Diu")){
                    ArrayAdapter<CharSequence> adapterDaman = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Daman,android.R.layout.simple_spinner_item);
                    adapterDaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterDaman);
                }

                //Delhi
                else if(stateSelect.equals("Delhi")){
                    ArrayAdapter<CharSequence> adapterDelhi = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Delhi,android.R.layout.simple_spinner_item);
                    adapterDelhi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterDelhi);
                }

                //Goa
                else if(stateSelect.equals("Goa")){
                    ArrayAdapter<CharSequence> adapterGoa = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Goa,android.R.layout.simple_spinner_item);
                    adapterGoa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterGoa);
                }

                //Gujarat
                else if(stateSelect.equals("Gujarat")){
                    ArrayAdapter<CharSequence> adapterGujarat = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Gujarat,android.R.layout.simple_spinner_item);
                    adapterGujarat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterGujarat);
                }

                //Haryana
                else if(stateSelect.equals("Haryana")){
                    ArrayAdapter<CharSequence> adapterHaryana = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Haryana,android.R.layout.simple_spinner_item);
                    adapterHaryana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterHaryana);
                }

                //Himachal
                else if(stateSelect.equals("Himachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterHimachal = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Himachal,android.R.layout.simple_spinner_item);
                    adapterHimachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterHimachal);
                }

                //Jammu and Kashmir
                else if(stateSelect.equals("Jammu and Kashmir")){
                    ArrayAdapter<CharSequence> adapterJammu = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Jammu,android.R.layout.simple_spinner_item);
                    adapterJammu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterJammu);
                }

                //Jharkhand
                else if(stateSelect.equals("Jharkhand")){
                    ArrayAdapter<CharSequence> adapterJharkhand = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Jharkhand,android.R.layout.simple_spinner_item);
                    adapterJharkhand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterJharkhand);
                }

                //Karnataka
                else if(stateSelect.equals("Karnataka")){
                    ArrayAdapter<CharSequence> adapterKarnataka = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Karnataka,android.R.layout.simple_spinner_item);
                    adapterKarnataka.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterKarnataka);
                }

                //Kerala
                else if(stateSelect.equals("Kerala")){
                    ArrayAdapter<CharSequence> adapterKerala = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Kerala,android.R.layout.simple_spinner_item);
                    adapterKerala.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterKerala);
                }

                //Lakshadweep
                else if(stateSelect.equals("Lakshadweep")){
                    ArrayAdapter<CharSequence> adapterLaksh = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Laksh,android.R.layout.simple_spinner_item);
                    adapterLaksh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterLaksh);
                }

                //Madhya Pradesh
                else if(stateSelect.equals("Madhya Pradesh")){
                    ArrayAdapter<CharSequence> adapterMadhya = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Madhya,android.R.layout.simple_spinner_item);
                    adapterMadhya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterMadhya);
                }

                //Maharashtra
                else if(stateSelect.equals("Maharashtra")){
                    ArrayAdapter<CharSequence> adapterMaharashtra = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Maharashtra,android.R.layout.simple_spinner_item);
                    adapterMaharashtra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterMaharashtra);
                }

                //Manipur
                else if(stateSelect.equals("Manipur")){
                    ArrayAdapter<CharSequence> adapterManipur = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Manipur,android.R.layout.simple_spinner_item);
                    adapterManipur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterManipur);
                }

                //Meghalaya
                else if(stateSelect.equals("Meghalaya")){
                    ArrayAdapter<CharSequence> adapterMeghalaya = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Meghalaya,android.R.layout.simple_spinner_item);
                    adapterMeghalaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterMeghalaya);
                }

                //Mizoram
                else if(stateSelect.equals("Mizoram")){
                    ArrayAdapter<CharSequence> adapterMizoram = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Mizoram,android.R.layout.simple_spinner_item);
                    adapterMizoram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterMizoram);
                }

                //Nagaland
                else if(stateSelect.equals("Nagaland")){
                    ArrayAdapter<CharSequence> adapterNagaland = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Nagaland,android.R.layout.simple_spinner_item);
                    adapterNagaland.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterNagaland);
                }

                //Odisha
                else if(stateSelect.equals("Odisha")){
                    ArrayAdapter<CharSequence> adapterOdisha = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Odisha,android.R.layout.simple_spinner_item);
                    adapterOdisha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterOdisha);
                }

                //Puducherry
                else if(stateSelect.equals("Puducherry")){
                    ArrayAdapter<CharSequence> adapterPuducherry = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Puducherry,android.R.layout.simple_spinner_item);
                    adapterPuducherry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterPuducherry);
                }

                //Punjab
                else if(stateSelect.equals("Punjab")){
                    ArrayAdapter<CharSequence> adapterPunjab = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Punjab,android.R.layout.simple_spinner_item);
                    adapterPunjab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterPunjab);
                }

                //Rajasthan
                else if(stateSelect.equals("Rajasthan")){
                    ArrayAdapter<CharSequence> adapterRajasthan = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Rajasthan,android.R.layout.simple_spinner_item);
                    adapterRajasthan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterRajasthan);
                }

                //Sikkim
                else if(stateSelect.equals("Sikkim")){
                    ArrayAdapter<CharSequence> adapterSikkim = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Sikkim,android.R.layout.simple_spinner_item);
                    adapterSikkim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterSikkim);
                }

                //Tamil Nadu
                else if(stateSelect.equals("Tamil Nadu")){
                    ArrayAdapter<CharSequence> adapterTamil = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Tamil,android.R.layout.simple_spinner_item);
                    adapterTamil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterTamil);
                }

                //Telangana
                else if(stateSelect.equals("Telangana")){
                    ArrayAdapter<CharSequence> adapterTelan = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Telan,android.R.layout.simple_spinner_item);
                    adapterTelan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterTelan);
                }

                //Tripura
                else if(stateSelect.equals("Tripura")){
                    ArrayAdapter<CharSequence> adapterTripura = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Tripura,android.R.layout.simple_spinner_item);
                    adapterTripura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterTripura);
                }

                //Uttar Pradesh
                else if(stateSelect.equals("Uttar Pradesh")){
                    ArrayAdapter<CharSequence> adapterUPradesh = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_UPradesh,android.R.layout.simple_spinner_item);
                    adapterUPradesh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterUPradesh);
                }

                //Uttarakhand
                else if(stateSelect.equals("Uttarakhand")){
                    ArrayAdapter<CharSequence> adapterUttara = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Uttara,android.R.layout.simple_spinner_item);
                    adapterUttara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterUttara);
                }

                //West Bengal
                else if(stateSelect.equals("West Bengal")){
                    ArrayAdapter<CharSequence> adapterBengal = ArrayAdapter.createFromResource(ViewRequestsActivity.this,R.array.district_Bengal,android.R.layout.simple_spinner_item);
                    adapterBengal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrictReq.setAdapter(adapterBengal);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        listReq = new ArrayList<>();
        adapterReq =new ArrayAdapter<String>(this,R.layout.requests_info,R.id.tvRequestName,listReq);
        adapterReq.notifyDataSetChanged();


        btnApplyFilterReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterReq.clear();
                adapterReq.notifyDataSetChanged();
                if(validFilterReq()){

                    String doState=spChooseStateReq.getSelectedItem().toString();
                    String doDistrict=spChooseDistrictReq.getSelectedItem().toString();
                    String doBlood=spChooseBloodReq.getSelectedItem().toString();

                    DatabaseReference refRequest = FirebaseDatabase.getInstance().getReference().child("requests");
                    DatabaseReference refStateReq = refRequest.child(doState);
                    DatabaseReference refDistrictReq = refStateReq.child(doDistrict);
                    DatabaseReference refBloodReq = refDistrictReq.child(doBlood);
                    refBloodReq.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds: dataSnapshot.getChildren()){
                                nearReq = ds.getValue(nearbyRequest.class);
                                listReq.add(nearReq.getpName().toString() +"\n"+nearReq.getpPhone().toString()+"\n"+nearReq.getpHospital().toString());

                            }
                            listRequest.setAdapter(adapterReq);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(ViewRequestsActivity.this, "No Donors available at this location", Toast.LENGTH_SHORT).show();
                        }
                    });


                }


            }
        });
    }

    private Boolean validFilterReq(){
        Boolean val = false;

        String dState=spChooseStateReq.getSelectedItem().toString();
        String dDistrict=spChooseDistrictReq.getSelectedItem().toString();
        String dBlood=spChooseBloodReq.getSelectedItem().toString();

        int flagB=0;
        if(dBlood.equals("BloodGroup")){
            flagB=0;
        }
        else{
            flagB=1;
        }

        int flagS=0;
        if(dState.equals("Select State...")){
            flagS=0;
        }
        else{
            flagS=1;
        }

        int flagDist=0;
        if(dDistrict.equals("Select District")){
            Toast.makeText(this,"Please enter valid district", Toast.LENGTH_SHORT).show();
            flagDist=0;
        }
        else{
            flagDist=1;
            //  Toast.makeText(this,"example:A+,B-,etc", Toast.LENGTH_LONG).show();
        }

        if(flagB==0 || flagS==0 || flagDist==0){
            Toast.makeText(this,"Please enter valid filter", Toast.LENGTH_SHORT).show();
        }
        else{
            val=true;
        }
        return val;
    }
}
