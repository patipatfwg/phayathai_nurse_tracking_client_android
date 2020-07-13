package me.kevinvista.bluetoothscanner

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freewill.phayathaidetect.MainActivity
import com.freewill.phayathaidetect.R
import me.kevinvista.bluetoothscanner.DeviceAdapter.DeviceHolder

class DeviceAdapter(var mDeviceList: ArrayList<Device>) : RecyclerView.Adapter<DeviceAdapter.DeviceHolder>() {

    internal var usePercentage: Boolean = false

    class DeviceHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textDeviceName: TextView
        var textDeviceAddress: TextView
        var textDeviceSignal: TextView
        var textDevicePaired: TextView

        init {
            textDeviceName = itemView.findViewById(R.id.text_name) as TextView
            textDeviceAddress = itemView.findViewById(R.id.text_address) as TextView
            textDeviceSignal = itemView.findViewById(R.id.text_signal) as TextView
            textDevicePaired = itemView.findViewById(R.id.text_paired) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.device_item, parent, false)
        return DeviceHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceHolder, position: Int) {
        val device = mDeviceList[position]
        holder.textDeviceName.text = device.name
        holder.textDeviceAddress.text = "MAC ADDRESS: " + device.address
        //val applicationContext = MainActivity.getContextOfApplication()

       // val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
       // usePercentage = sharedPreferences.getBoolean("key_settings_use_percentage", false)
        if (usePercentage) {
            holder.textDeviceSignal.text = (device.signal + 100).toString() + "%"
        } else {
            holder.textDeviceSignal.text = device.signal.toString() + "dBm"
        }

        //holder.textDevicePaired.setText(device.isPaired() + "");
    }

    override fun getItemCount(): Int {
        return mDeviceList.size
    }
}