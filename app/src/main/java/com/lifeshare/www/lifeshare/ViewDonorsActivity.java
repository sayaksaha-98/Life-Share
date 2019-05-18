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

public class ViewDonorsActivity extends AppCompatActivity {

    private Spinner spChooseState;
    private Spinner spChooseDistrict;
    private Spinner spChooseBlood;
    private Button btnApplyFilter;
    private ListView listDonors;

    ArrayList<String> listName;
    ArrayAdapter<String> adapterName;

/*    ArrayList<String> listEmail;
    ArrayAdapter<String> adapterEmail;

    ArrayList<String> listPhone;
    ArrayAdapter<String> adapterPhone;
*/
    availableUser availuser;
    FirebaseDatabase firebaseDatabase;
  //  DatabaseReference refAvail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donors);

        availuser = new availableUser();

        spChooseState = (Spinner)findViewById(R.id.spChState);
        spChooseDistrict = (Spinner)findViewById(R.id.spChDistrict);
        spChooseBlood = (Spinner)findViewById(R.id.spChBlood);
        btnApplyFilter = (Button)findViewById(R.id.btnApply);
        listDonors = (ListView)findViewById(R.id.liDonors);

        //Districts Selection
        spChooseState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String stateSelect = spChooseState.getSelectedItem().toString();

                //None Selected
                if (stateSelect.equals("Select State...")) {
                    ArrayAdapter<CharSequence> adapterNone = ArrayAdapter.createFromResource(ViewDonorsActivity.this, R.array.district_none, android.R.layout.simple_spinner_item);
                    adapterNone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterNone);
                }

                //Andaman
                else if(stateSelect.equals("Andaman and Nicobar Islands")){
                    ArrayAdapter<CharSequence> adapterAndaman = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Andaman,android.R.layout.simple_spinner_item);
                    adapterAndaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterAndaman);
                }

                    //AndhraPradesh
                else if (stateSelect.equals("Andhra Pradesh")) {
                    ArrayAdapter<CharSequence> adapterAndhra = ArrayAdapter.createFromResource(ViewDonorsActivity.this, R.array.district_AndhraPradesh, android.R.layout.simple_spinner_item);
                    adapterAndhra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterAndhra);
                }

                    //Arunachal Pradesh
                else if (stateSelect.equals("Arunachal Pradesh")) {
                    ArrayAdapter<CharSequence> adapterArunachal = ArrayAdapter.createFromResource(ViewDonorsActivity.this, R.array.district_ArunachalPradesh, android.R.layout.simple_spinner_item);
                    adapterArunachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterArunachal);
                }

                    //Assam
                else if (stateSelect.equals("Assam")) {
                    ArrayAdapter<CharSequence> adapterAssam = ArrayAdapter.createFromResource(ViewDonorsActivity.this, R.array.district_Assam, android.R.layout.simple_spinner_item);
                    adapterAssam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterAssam);
                }

                    //Bihar
                else if (stateSelect.equals("Bihar")) {
                    ArrayAdapter<CharSequence> adapterBihar = ArrayAdapter.createFromResource(ViewDonorsActivity.this, R.array.district_Bihar, android.R.layout.simple_spinner_item);
                    adapterBihar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterBihar);
                }

                //Chandigarh
                else if(stateSelect.equals("Chandigarh")){
                    ArrayAdapter<CharSequence> adapterChandi = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Chandigarh,android.R.layout.simple_spinner_item);
                    adapterChandi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterChandi);
                }

                //Chhattisgarh
                else if(stateSelect.equals("Chhattisgarh")){
                    ArrayAdapter<CharSequence> adapterChhattisgarh = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Chhattisgarh,android.R.layout.simple_spinner_item);
                    adapterChhattisgarh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterChhattisgarh);
                }

                //Dadra and Nagar Haveli
                else if(stateSelect.equals("Dadra and Nagar Haveli")){
                    ArrayAdapter<CharSequence> adapterDadra = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Dadra,android.R.layout.simple_spinner_item);
                    adapterDadra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterDadra);
                }

                //Daman and Diu
                else if(stateSelect.equals("Daman and Diu")){
                    ArrayAdapter<CharSequence> adapterDaman = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Daman,android.R.layout.simple_spinner_item);
                    adapterDaman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterDaman);
                }

                //Delhi
                else if(stateSelect.equals("Delhi")){
                    ArrayAdapter<CharSequence> adapterDelhi = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Delhi,android.R.layout.simple_spinner_item);
                    adapterDelhi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterDelhi);
                }

                //Goa
                else if(stateSelect.equals("Goa")){
                    ArrayAdapter<CharSequence> adapterGoa = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Goa,android.R.layout.simple_spinner_item);
                    adapterGoa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterGoa);
                }

                //Gujarat
                else if(stateSelect.equals("Gujarat")){
                    ArrayAdapter<CharSequence> adapterGujarat = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Gujarat,android.R.layout.simple_spinner_item);
                    adapterGujarat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterGujarat);
                }

                //Haryana
                else if(stateSelect.equals("Haryana")){
                    ArrayAdapter<CharSequence> adapterHaryana = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Haryana,android.R.layout.simple_spinner_item);
                    adapterHaryana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterHaryana);
                }

                //Himachal
                else if(stateSelect.equals("Himachal Pradesh")){
                    ArrayAdapter<CharSequence> adapterHimachal = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Himachal,android.R.layout.simple_spinner_item);
                    adapterHimachal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterHimachal);
                }

                //Jammu and Kashmir
                else if(stateSelect.equals("Jammu and Kashmir")){
                    ArrayAdapter<CharSequence> adapterJammu = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Jammu,android.R.layout.simple_spinner_item);
                    adapterJammu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterJammu);
                }

                //Jharkhand
                else if(stateSelect.equals("Jharkhand")){
                    ArrayAdapter<CharSequence> adapterJharkhand = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Jharkhand,android.R.layout.simple_spinner_item);
                    adapterJharkhand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterJharkhand);
                }

                //Karnataka
                else if(stateSelect.equals("Karnataka")){
                    ArrayAdapter<CharSequence> adapterKarnataka = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Karnataka,android.R.layout.simple_spinner_item);
                    adapterKarnataka.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterKarnataka);
                }

                //Kerala
                else if(stateSelect.equals("Kerala")){
                    ArrayAdapter<CharSequence> adapterKerala = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Kerala,android.R.layout.simple_spinner_item);
                    adapterKerala.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterKerala);
                }

                //Lakshadweep
                else if(stateSelect.equals("Lakshadweep")){
                    ArrayAdapter<CharSequence> adapterLaksh = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Laksh,android.R.layout.simple_spinner_item);
                    adapterLaksh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterLaksh);
                }

                //Madhya Pradesh
                else if(stateSelect.equals("Madhya Pradesh")){
                    ArrayAdapter<CharSequence> adapterMadhya = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Madhya,android.R.layout.simple_spinner_item);
                    adapterMadhya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterMadhya);
                }

                //Maharashtra
                else if(stateSelect.equals("Maharashtra")){
                    ArrayAdapter<CharSequence> adapterMaharashtra = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Maharashtra,android.R.layout.simple_spinner_item);
                    adapterMaharashtra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterMaharashtra);
                }

                //Manipur
                else if(stateSelect.equals("Manipur")){
                    ArrayAdapter<CharSequence> adapterManipur = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Manipur,android.R.layout.simple_spinner_item);
                    adapterManipur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterManipur);
                }

                //Meghalaya
                else if(stateSelect.equals("Meghalaya")){
                    ArrayAdapter<CharSequence> adapterMeghalaya = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Meghalaya,android.R.layout.simple_spinner_item);
                    adapterMeghalaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterMeghalaya);
                }

                //Mizoram
                else if(stateSelect.equals("Mizoram")){
                    ArrayAdapter<CharSequence> adapterMizoram = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Mizoram,android.R.layout.simple_spinner_item);
                    adapterMizoram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterMizoram);
                }

                //Nagaland
                else if(stateSelect.equals("Nagaland")){
                    ArrayAdapter<CharSequence> adapterNagaland = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Nagaland,android.R.layout.simple_spinner_item);
                    adapterNagaland.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterNagaland);
                }

                //Odisha
                else if(stateSelect.equals("Odisha")){
                    ArrayAdapter<CharSequence> adapterOdisha = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Odisha,android.R.layout.simple_spinner_item);
                    adapterOdisha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterOdisha);
                }

                //Puducherry
                else if(stateSelect.equals("Puducherry")){
                    ArrayAdapter<CharSequence> adapterPuducherry = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Puducherry,android.R.layout.simple_spinner_item);
                    adapterPuducherry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterPuducherry);
                }

                //Punjab
                else if(stateSelect.equals("Punjab")){
                    ArrayAdapter<CharSequence> adapterPunjab = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Punjab,android.R.layout.simple_spinner_item);
                    adapterPunjab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterPunjab);
                }

                //Rajasthan
                else if(stateSelect.equals("Rajasthan")){
                    ArrayAdapter<CharSequence> adapterRajasthan = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Rajasthan,android.R.layout.simple_spinner_item);
                    adapterRajasthan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterRajasthan);
                }

                //Sikkim
                else if(stateSelect.equals("Sikkim")){
                    ArrayAdapter<CharSequence> adapterSikkim = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Sikkim,android.R.layout.simple_spinner_item);
                    adapterSikkim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterSikkim);
                }

                //Tamil Nadu
                else if(stateSelect.equals("Tamil Nadu")){
                    ArrayAdapter<CharSequence> adapterTamil = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Tamil,android.R.layout.simple_spinner_item);
                    adapterTamil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterTamil);
                }

                //Telangana
                else if(stateSelect.equals("Telangana")){
                    ArrayAdapter<CharSequence> adapterTelan = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Telan,android.R.layout.simple_spinner_item);
                    adapterTelan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterTelan);
                }

                //Tripura
                else if(stateSelect.equals("Tripura")){
                    ArrayAdapter<CharSequence> adapterTripura = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Tripura,android.R.layout.simple_spinner_item);
                    adapterTripura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterTripura);
                }

                //Uttar Pradesh
                else if(stateSelect.equals("Uttar Pradesh")){
                    ArrayAdapter<CharSequence> adapterUPradesh = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_UPradesh,android.R.layout.simple_spinner_item);
                    adapterUPradesh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterUPradesh);
                }

                //Uttarakhand
                else if(stateSelect.equals("Uttarakhand")){
                    ArrayAdapter<CharSequence> adapterUttara = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Uttara,android.R.layout.simple_spinner_item);
                    adapterUttara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterUttara);
                }

                //West Bengal
                else if(stateSelect.equals("West Bengal")){
                    ArrayAdapter<CharSequence> adapterBengal = ArrayAdapter.createFromResource(ViewDonorsActivity.this,R.array.district_Bengal,android.R.layout.simple_spinner_item);
                    adapterBengal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spChooseDistrict.setAdapter(adapterBengal);
                }
            }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                }
        });

            firebaseDatabase=FirebaseDatabase.getInstance();

        listName = new ArrayList<>();
        adapterName =new ArrayAdapter<String>(this,R.layout.donors_info,R.id.tvDonorName,listName);
        adapterName.notifyDataSetChanged();
    /*    listEmail = new ArrayList<>();
        adapterEmail =new ArrayAdapter<String>(this,R.layout.donors_info,R.id.tvDonorEmail,listEmail);

        listPhone = new ArrayList<>();
        adapterPhone =new ArrayAdapter<String>(this,R.layout.donors_info,R.id.tvDonorPhone,listPhone);
*/

        btnApplyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterName.clear();
                adapterName.notifyDataSetChanged();
                if(validFilter()){

                    String rState=spChooseState.getSelectedItem().toString();
                    String rDistrict = spChooseDistrict.getSelectedItem().toString();
                    String rBlood=spChooseBlood.getSelectedItem().toString();





                    DatabaseReference refAvail = FirebaseDatabase.getInstance().getReference().child("available");
                    DatabaseReference refState = refAvail.child(rState);
                    DatabaseReference refDistrict = refState.child(rDistrict);
                    DatabaseReference refBloodName = refDistrict.child(rBlood);
                   refBloodName.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds: dataSnapshot.getChildren()){
                                availuser = ds.getValue(availableUser.class);
                                listName.add(availuser.getaName().toString() +"\n"+availuser.getaPhone().toString()+"\n"+availuser.getaEmail().toString());

                            }
                            listDonors.setAdapter(adapterName);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(ViewDonorsActivity.this, "No Donors available at this location", Toast.LENGTH_SHORT).show();
                        }
                    });


                }


            }
        });
    }

    private Boolean validFilter(){
        Boolean val = false;

        String rState=spChooseState.getSelectedItem().toString();
        String rDistrict = spChooseDistrict.getSelectedItem().toString();
        String rBlood=spChooseBlood.getSelectedItem().toString();

        int flagB=0;
        if(rBlood.equals("BloodGroup")){
            flagB=0;
        }
        else{
            flagB=1;
        }

        int flagS=0;
        if(rState.equals("Select State...")){
            flagS=0;
        }
        else{
            flagS=1;
        }

        int flagDist=0;
        if(rDistrict.equals("Select District")){
            Toast.makeText(this,"Please enter valid district", Toast.LENGTH_SHORT).show();
            flagDist=0;
        }
        else{
            flagDist=1;
            //  Toast.makeText(this,"example:A+,B-,etc", Toast.LENGTH_LONG).show();
        }

        if(flagB==0 || flagS==0 ||flagDist==0){
            Toast.makeText(this,"Please enter valid filter", Toast.LENGTH_SHORT).show();
        }
        else{
            val=true;
        }

        return val;
    }
}
