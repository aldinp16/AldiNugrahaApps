package dev.aldi.aldiapps

/**
 * @author: aldinp16
 * nim: 10119908
 * kelas: IF10K
 */

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menu = listOf("Phone", "Mail", "Instagram", "Github", "Find Me", "About")
        val listMenu: ListView = view.findViewById(R.id.list_menu)
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.menu_list, R.id.text_menu, menu)
        listMenu.adapter = arrayAdapter

        listMenu.onItemClickListener = AdapterView.OnItemClickListener() { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position)
            when (selectedItem) {
                "Phone" -> onPhone()
                "Mail" -> onMail()
                "Instagram" -> onInstagram()
                "Github" -> onGithub()
                "Find Me" -> onMap()
                "About" -> onDialog()
            }
        }
    }

    private fun onPhone() {
        val url = "https://wa.me/6281316114140"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun onMail() {
        val url = "mailto:aldi.10119908@mahasiswa.unikom.ac.id"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun onInstagram() {
        val url = "https://instagram.com/aldinp16"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun onGithub() {
        val url = "https://github.com/aldinp16"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun onMap() {
        val url = "https://goo.gl/maps/mP5bGGknNyrMMon96"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun onDialog() {
        val alertDialog: AlertDialog = AlertDialog.Builder(requireActivity()).create()
        alertDialog.setTitle("About Apps")
        alertDialog.setMessage("Apps v0.1.0")
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
        alertDialog.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}