package com.nkdroid.listview.demo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView lvProfiles;
    private MyAppAdapter myAppAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileModelArrayList=new ArrayList<>();
        profileModelArrayList.add(new ProfileModel("Nirav","India",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Surabhi","India",R.drawable.female));
        profileModelArrayList.add(new ProfileModel("Martins","Nigeria",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Steven","USA",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Akeba","USA",R.drawable.female));
        profileModelArrayList.add(new ProfileModel("Ravi","India",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Nirav","India",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Surabhi","India",R.drawable.female));
        profileModelArrayList.add(new ProfileModel("Martins","Nigeria",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Steven","USA",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Akeba","USA",R.drawable.female));
        profileModelArrayList.add(new ProfileModel("Ravi","India",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Nirav","India",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Surabhi","India",R.drawable.female));
        profileModelArrayList.add(new ProfileModel("Martins","Nigeria",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Steven","USA",R.drawable.male));
        profileModelArrayList.add(new ProfileModel("Akeba","USA",R.drawable.female));
        profileModelArrayList.add(new ProfileModel("Ravi","India",R.drawable.male));


        lvProfiles= (ListView)findViewById(R.id.lvProfiles);
        myAppAdapter=new MyAppAdapter(profileModelArrayList,MainActivity.this);
        lvProfiles.setAdapter(myAppAdapter);


    }

    public class MyAppAdapter extends BaseAdapter {

        public class ViewHolder {
            TextView username,country;
            ImageView profilePic;

        }

        public ArrayList<ProfileModel> profileList;

        public Context context;


        private MyAppAdapter(ArrayList<ProfileModel> apps, Context context) {
            this.profileList = apps;
            this.context = context;

        }

        @Override
        public int getCount() {
            return profileList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;
            ViewHolder viewHolder;

            if (rowView == null) {
                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.item_profile, parent,false);
                // configure view holder
                viewHolder = new ViewHolder();
//                viewHolder.copy = (ImageView) rowView.findViewById(R.id.copy);
//                viewHolder.share = (ImageView) rowView.findViewById(R.id.share);
                viewHolder.profilePic = (ImageView) rowView.findViewById(R.id.imgProfile);
                viewHolder.username = (TextView) rowView.findViewById(R.id.txtUsername);
                viewHolder.country = (TextView) rowView.findViewById(R.id.txtCountry);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.username.setText(profileList.get(position).getUsername()+"");
            viewHolder.country.setText(profileList.get(position).getCountry()+"");
            Glide.with(MainActivity.this).load(profileList.get(position).getProfilePic()).into(viewHolder.profilePic);

            return rowView;


        }


    }
}
