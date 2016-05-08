package com.example.yunus.trakyadepo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yunus.trakyadepo.R;

/**
 * Created by yunus on 13.04.2016.
 */
public class PaylasimlarFragment extends Fragment {

    private View view;

    private String title;//String for tab title

    /*

     private ImageView image;

     private ArrayList<Soru> a;
     private static RecyclerView recyclerView;
     List<String> control;
   //  ProgressDialog progress;
     Context context;
   //  private List<Soru> pliste= new ArrayList<>();
 */
    public PaylasimlarFragment() {
        // image.setImageResource(R.drawable.trakya);
    }

    public PaylasimlarFragment(String title) {
        this.title = title;//Setting tab title
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // progress = ProgressDialog.show(getActivity(), "", "Bilgiler Alınıyor...", true);

        view = inflater.inflate(R.layout.twofragment, container, false);



/*
        setRecyclerView();

        IOgetValue service= ws.getwsValue();
        Call<List<Soru>> control = service.groupList(Mainapp.UserPrefs.LogedInUser().get().getUserID());
        control.enqueue(new Callback<List<Soru>>() {
            @Override
            public void onResponse(Response<List<Soru>> response) {

                pliste = response.body();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        progress.dismiss();
        */
        return view;
    }
    //Setting recycler view
    private void setRecyclerView() {
/*
        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items




        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), pliste);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }
*/
        /*
    @OnClick(R.id.fab)
    public void submit(View view) {
        //Implementing tab selected listener over tablayout
        int a;

        a = MainActivity.viewPager.getCurrentItem();
        switch (a) {
            case 0:
                Intent intt = new Intent(getActivity(), newpostActivity.class);
                startActivity(intt);
                break;
            case 1:
                Intent inlt = new Intent(getActivity(), soruActivity.class);
                startActivity(inlt);
                break;
            case 2:
                Intent inlst = new Intent(getActivity(), etkinlikActivity.class);
                startActivity(inlst);
                break;
        }*/
    }
}