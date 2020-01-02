package com.example.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.example.ui.datamodel.CustomDataModel;
import com.example.ui.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.ui.LoginActivity.preferencesHelperImp;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnlineDateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OnlineDateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnlineDateFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private CustomDataModel customDataModel;
    private SearchViewModel searchViewModel;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView online_date_recycleview;
    private OnFragmentInteractionListener mListener;

    public OnlineDateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OnlineDateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OnlineDateFragment newInstance(String param1, String param2) {
        OnlineDateFragment fragment = new OnlineDateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_online_date, container, false);
        online_date_recycleview=view.findViewById(R.id.fragment_online_date_recycleview);
        // Inflate the layout for this fragment
        String custom_name = getArguments().getString("edttext");
        String token =preferencesHelperImp.getStringData();
        String mo_id=getArguments().getString("edttext");
        Log.d("123", "strtextw: "+custom_name+token);


        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        online_date_recycleview.setLayoutManager(layoutManager);

        searchViewModel= ViewModelProviders.of(this).get(SearchViewModel.class);
       // searchViewModel.getCustomNames(custom_name,token);
        searchViewModel.getManufactureId(mo_id,token);
//        List<String> list=new ArrayList<>();
//        list.add("456");
//        list.add("456");
//        list.add("789");
//
//        Online_Date_Adapter online_date_adapter=new Online_Date_Adapter(list);
//        online_date_recycleview.setAdapter(online_date_adapter);
//        online_date_adapter.notifyDataSetChanged();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
