package com.iptv.usatv.usalivetv.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.iptv.usatv.usalivetv.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [M3U_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class M3U_Fragment : Fragment() {
    private val searchView: SearchView? = null
    private val queryTextListener: SearchView.OnQueryTextListener? = null
    var buildRecycleView: RecyclerView? = null
    private var progressDialog: ProgressDialog? = null
    var referenceBuild: DatabaseReference? = null
    var buildModelList: List<BuildModel>? = null
    var adapter: M3uAdpater? = null
    private val mAdView: AdView? = null

    private var adContainerView: FrameLayout? = null
    var adView: AdView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_m3_u_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FirebaseApp.initializeApp(activity!!)
        //   buildViewModel = new ViewModelProvider(this).get(BuildViewModel.class);

        //   buildViewModel = new ViewModelProvider(this).get(BuildViewModel.class);
        buildModelList = ArrayList<BuildModel>()
        buildRecycleView = view.findViewById(R.id.buildRecycleID)
        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage("Received data. Please wait....")
        progressDialog.setCancelable(false)
        progressDialog.show()
        referenceBuild = FirebaseDatabase.getInstance().getReference("mm")


        loadData()

        Fun(activity, activity)

        adContainerView = view.findViewById(R.id.ad_view_container)
        // Step 1 - Create an AdView and set the ad unit ID on it.
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = AdView(activity)
        adView!!.adUnitId = activity!!.getString(R.string.admob_banner_id)
        adContainerView.addView(adView)
        loadBanner()
    }
}