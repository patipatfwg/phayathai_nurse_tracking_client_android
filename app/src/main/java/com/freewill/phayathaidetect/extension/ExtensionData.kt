package com.freewill.phayathaidetect.extension

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.TELEPHONY_SERVICE
import android.content.res.Resources
import android.os.Build
import android.os.Handler
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import java.text.SimpleDateFormat
import java.util.*

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes,this,attachToRoot)
}


fun String.toDate(dateFormat: String = "dd/MM/yyyy", timeZone: TimeZone =  TimeZone.getDefault()): Date {
    val parser = SimpleDateFormat(dateFormat,  Resources.getSystem().configuration.locale)
    parser.timeZone = timeZone
    return parser.parse(this)
}


fun Date?.toDateTimeStandard(): String {
    val pattern = "dd MMMM yyyy HH:mm:ss"

    return dateAsString(this, pattern)
}

fun Date?.toDateTimeStandardIn12Hours(): String {
    val pattern = "dd MMMM yyyy h:mm:ss a"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeStandardInDigits(): String {
    val pattern = "dd-MM-yyyy HH:mm:ss"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeStandardInDigitsAnd12Hours(): String {
    val pattern = "dd-MM-yyyy h:mm:ss a"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeStandardConcise(): String {
    val pattern = "dd MMM yyyy HH:mm:ss"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeStandardConciseIn12Hours(): String {
    val pattern = "dd MMM yyyy h:mm:ss a"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeYY(): String {
    val pattern = "dd MMMM yy HH:mm:ss"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeYYIn12Hours(): String {
    val pattern = "dd MMMM yy h:mm:ss a"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeYYInDigits(): String {
    val pattern = "dd-MM-yy HH:mm:ss"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeYYInDigitsAnd12Hours(): String {
    val pattern = "dd-MM-yy h:mm:ss a"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeYYConcise(): String {
    val pattern = "dd MMM yy HH:mm:ss"
    return dateAsString(this, pattern)
}

fun Date?.toDateTimeYYConciseIn12Hours(): String {
    val pattern = "dd MMM yy h:mm:ss a"
    return dateAsString(this, pattern)
}

// -------------------------- Time --------------------------

fun Date?.toTimeStandard(): String {
    val pattern = "HH:mm:ss"
    return dateAsString(this, pattern)
}

fun Date?.toTimeStandardWithoutSeconds(): String {
    val pattern = "HH:mm"
    return dateAsString(this, pattern)
}

fun Date?.toTimeStandardIn12Hours(): String {
    val pattern = "h:mm:ss a"
    return dateAsString(this, pattern)
}

fun Date?.toTimeStandardIn12HoursWithoutSeconds(): String {
    val pattern = "h:mm a"
    return dateAsString(this, pattern)
}

// -------------------------- Date --------------------------

fun Date?.toDateStandard(): String {
    val pattern = "dd MMMM YYYY"
    return dateAsString(this, pattern)
}

fun Date?.toDateStandardConcise(): String {
    val pattern = "dd MMM yyyy"
    return dateAsString(this, pattern)
}

fun Date?.toDateStandardInDigits(): String {
    val pattern = "dd-MM-yyyy"
    return dateAsString(this, pattern)
}

fun Date?.toDateYY(): String {
    val pattern = "dd MMMM yy"
    return dateAsString(this, pattern)
}

fun Date?.toDateYYConcise(): String {
    val pattern = "dd MMM yy"
    return dateAsString(this, pattern)
}

fun Date?.toDateYYInDigits(): String {
    val pattern = "dd-MM-yy"
    return dateAsString(this, pattern)
}

// -------------------------- Day --------------------------

fun Date?.toDay(): String {
    val pattern = "EEEE"
    return dateAsString(this, pattern)
}
// ---------------------------------------------------------

private fun dateAsString(date: Date?, pattern: String): String {
   var simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    if (date != null)
        return simpleDateFormat.format(date)
    else
        throw NullPointerException("Date can't be null")
}


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("MissingPermission", "HardwareIds")
fun getIMEI(context: Context) : String {

    var details: String? = null
    val manager = context.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
    details = ("DeviceSoftwareVersion : " + manager.deviceSoftwareVersion + "\n"
            + "GroupIdLevel1 : " + manager.groupIdLevel1 + "\n"
            + "Line1Number : " + manager.line1Number + "\n"
            + "MmsUAProfUrl : " + manager.mmsUAProfUrl + "\n"
            + "MmsUserAgent : " + manager.mmsUserAgent + "\n"
            + "DeviceId : " + manager.deviceId + "\n"
            + "imei : " + manager.imei + "\n"
            + "SimSerialNumber : " + manager.simSerialNumber + "\n"
            + "SimCountryIso : " + manager.simCountryIso + "\n"
            + "NetworkOperator() : " + manager.networkOperator + "\n"
            + "NetworkCountryIso : " + manager.networkCountryIso + "\n"
            + "NetworkOperatorName : " + manager.networkOperatorName + "\n"
            + "NetworkType : " + manager.networkType + "\n"
            + "VoiceMailNumber : " + manager.voiceMailNumber)
    Log.e("TeleInfo", details)

    val m_androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)

    Log.e("m_androidId", m_androidId)



  //  return manager.deviceId?: ""
    return m_androidId


}


fun delayFunction(function: ()-> Unit, delay: Long) {
    Handler().postDelayed(function, delay)
}

//@SuppressLint("MissingPermission")
//fun getIMEI(context: Context): String {
//
//    val mngr = context.getSystemService(context.TELEPHONY_SERVICE) as TelephonyManager
//    return mngr.deviceId
//
//}