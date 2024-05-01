package com.example.courswork_1

import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.json.JSONObject
import java.util.concurrent.TimeUnit


class GuessCountryActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            GuessCountryApp(intent.getBooleanExtra("countdownEnabled",false))
        }
    }
}

data class Country(val name: String, val code:String)


fun loadCountriesFromJson(jsonString: String): List<Country>{  //function to get country name and code from json file
    val countries = mutableListOf<Country>()
    val jsonObject = JSONObject(jsonString)
    val keys = jsonObject.keys()
    while (keys.hasNext()){
        val code=keys.next()
        val name = jsonObject.getString(code)
        countries.add(Country(name, code))
    }
    return countries

}

@Composable
fun GuessCountryApp(countdownEnabled: Boolean){
    MaterialTheme{
        val jsonString = """
            {"AD": "Andorra",
            "AE": "United Arab Emirates",
            "AF": "Afghanistan",
            "AG": "Antigua and Barbuda",
            "AI": "Anguilla",
            "AL": "Albania",
            "AM": "Armenia",
            "AO": "Angola",
            "AQ": "Antarctica",
            "AR": "Argentina",
            "AS": "American Samoa",
            "AT": "Austria",
            "AU": "Australia",
            "AW": "Aruba",
            "AX": "\u00c5land Islands",
            "AZ": "Azerbaijan",
            "BA": "Bosnia and Herzegovina",
            "BB": "Barbados",
            "BD": "Bangladesh",
            "BE": "Belgium",
            "BF": "Burkina Faso",
            "BG": "Bulgaria",
            "BH": "Bahrain",
            "BI": "Burundi",
            "BJ": "Benin",
            "BL": "Saint Barthélemy",
            "BM": "Bermuda",
            "BN": "Brunei Darussalam",
            "BO": "Bolivia, Plurinational State of",
            "BQ": "Caribbean Netherlands",
            "BR": "Brazil",
            "BS": "Bahamas",
            "BT": "Bhutan",
            "BV": "Bouvet Island",
            "BW": "Botswana",
            "BY": "Belarus",
            "BZ": "Belize",
            "CA": "Canada",
            "CC": "Cocos (Keeling) Islands",
            "CD": "Congo, the Democratic Republic of the",
            "CF": "Central African Republic",
            "CG": "Republic of the Congo",
            "CH": "Switzerland",
            "CI": "C\u00f4te d'Ivoire",
            "CK": "Cook Islands",
            "CL": "Chile",
            "CM": "Cameroon",
            "CN": "China (People's Republic of China)",
            "CO": "Colombia",
            "CR": "Costa Rica",
            "CU": "Cuba",
            "CV": "Cape Verde",
            "CW": "Cura\u00e7ao",
            "CX": "Christmas Island",
            "CY": "Cyprus",
            "CZ": "Czech Republic",
            "DE": "Germany",
            "DJ": "Djibouti",
            "DK": "Denmark",
            "DM": "Dominica",
            "DO": "Dominican Republic",
            "DZ": "Algeria",
            "EC": "Ecuador",
            "EE": "Estonia",
            "EG": "Egypt",
            "EH": "Western Sahara",
            "ER": "Eritrea",
            "ES": "Spain",
            "ET": "Ethiopia",
            "EU": "Europe",
            "FI": "Finland",
            "FJ": "Fiji",
            "FK": "Falkland Islands (Malvinas)",
            "FM": "Micronesia, Federated States of",
            "FO": "Faroe Islands",
            "FR": "France",
            "GA": "Gabon",
            "GB-ENG": "England",
            "GB-NIR": "Northern Ireland",
            "GB-SCT": "Scotland",
            "GB-WLS": "Wales",
            "GB": "United Kingdom",
            "GD": "Grenada",
            "GE": "Georgia",
            "GF": "French Guiana",
            "GG": "Guernsey",
            "GH": "Ghana",
            "GI": "Gibraltar",
            "GL": "Greenland",
            "GM": "Gambia",
            "GN": "Guinea",
            "GP": "Guadeloupe",
            "GQ": "Equatorial Guinea",
            "GR": "Greece",
            "GS": "South Georgia and the South Sandwich Islands",
            "GT": "Guatemala",
            "GU": "Guam",
            "GW": "Guinea-Bissau",
            "GY": "Guyana",
            "HK": "Hong Kong",
            "HM": "Heard Island and McDonald Islands",
            "HN": "Honduras",
            "HR": "Croatia",
            "HT": "Haiti",
            "HU": "Hungary",
            "ID": "Indonesia",
            "IE": "Ireland",
            "IL": "Israel",
            "IM": "Isle of Man",
            "IN": "India",
            "IO": "British Indian Ocean Territory",
            "IQ": "Iraq",
            "IR": "Iran, Islamic Republic of",
            "IS": "Iceland",
            "IT": "Italy",
            "JE": "Jersey",
            "JM": "Jamaica",
            "JO": "Jordan",
            "JP": "Japan",
            "KE": "Kenya",
            "KG": "Kyrgyzstan",
            "KH": "Cambodia",
            "KI": "Kiribati",
            "KM": "Comoros",
            "KN": "Saint Kitts and Nevis",
            "KP": "Korea, Democratic People's Republic of",
            "KR": "Korea, Republic of",
            "KW": "Kuwait",
            "KY": "Cayman Islands",
            "KZ": "Kazakhstan",
            "LA": "Laos (Lao People's Democratic Republic)",
            "LB": "Lebanon",
            "LC": "Saint Lucia",
            "LI": "Liechtenstein",
            "LK": "Sri Lanka",
            "LR": "Liberia",
            "LS": "Lesotho",
            "LT": "Lithuania",
            "LU": "Luxembourg",
            "LV": "Latvia",
            "LY": "Libya",
            "MA": "Morocco",
            "MC": "Monaco",
            "MD": "Moldova, Republic of",
            "ME": "Montenegro",
            "MF": "Saint Martin",
            "MG": "Madagascar",
            "MH": "Marshall Islands",
            "MK": "North Macedonia",
            "ML": "Mali",
            "MM": "Myanmar",
            "MN": "Mongolia",
            "MO": "Macao",
            "MP": "Northern Mariana Islands",
            "MQ": "Martinique",
            "MR": "Mauritania",
            "MS": "Montserrat",
            "MT": "Malta",
            "MU": "Mauritius",
            "MV": "Maldives",
            "MW": "Malawi",
            "MX": "Mexico",
            "MY": "Malaysia",
            "MZ": "Mozambique",
            "NA": "Namibia",
            "NC": "New Caledonia",
            "NE": "Niger",
            "NF": "Norfolk Island",
            "NG": "Nigeria",
            "NI": "Nicaragua",
            "NL": "Netherlands",
            "NO": "Norway",
            "NP": "Nepal",
            "NR": "Nauru",
            "NU": "Niue",
            "NZ": "New Zealand",
            "OM": "Oman",
            "PA": "Panama",
            "PE": "Peru",
            "PF": "French Polynesia",
            "PG": "Papua New Guinea",
            "PH": "Philippines",
            "PK": "Pakistan",
            "PL": "Poland",
            "PM": "Saint Pierre and Miquelon",
            "PN": "Pitcairn",
            "PR": "Puerto Rico",
            "PS": "Palestine",
            "PT": "Portugal",
            "PW": "Palau",
            "PY": "Paraguay",
            "QA": "Qatar",
            "RE": "Réunion",
            "RO": "Romania",
            "RS": "Serbia",
            "RU": "Russian Federation",
            "RW": "Rwanda",
            "SA": "Saudi Arabia",
            "SB": "Solomon Islands",
            "SC": "Seychelles",
            "SD": "Sudan",
            "SE": "Sweden",
            "SG": "Singapore",
            "SH": "Saint Helena, Ascension and Tristan da Cunha",
            "SI": "Slovenia",
            "SJ": "Svalbard and Jan Mayen Islands",
            "SK": "Slovakia",
            "SL": "Sierra Leone",
            "SM": "San Marino",
            "SN": "Senegal",
            "SO": "Somalia",
            "SR": "Suriname",
            "SS": "South Sudan",
            "ST": "Sao Tome and Principe",
            "SV": "El Salvador",
            "SX": "Sint Maarten (Dutch part)",
            "SY": "Syrian Arab Republic",
            "SZ": "Swaziland",
            "TC": "Turks and Caicos Islands",
            "TD": "Chad",
            "TF": "French Southern Territories",
            "TG": "Togo",
            "TH": "Thailand",
            "TJ": "Tajikistan",
            "TK": "Tokelau",
            "TL": "Timor-Leste",
            "TM": "Turkmenistan",
            "TN": "Tunisia",
            "TO": "Tonga",
            "TR": "Turkey",
            "TT": "Trinidad and Tobago",
            "TV": "Tuvalu",
            "TW": "Taiwan (Republic of China)",
            "TZ": "Tanzania, United Republic of",
            "UA": "Ukraine",
            "UG": "Uganda",
            "UM": "US Minor Outlying Islands",
            "US": "United States",
            "UY": "Uruguay",
            "UZ": "Uzbekistan",
            "VA": "Holy See (Vatican City State)",
            "VC": "Saint Vincent and the Grenadines",
            "VE": "Venezuela, Bolivarian Republic of",
            "VG": "Virgin Islands, British",
            "VI": "Virgin Islands, U.S.",
            "VN": "Vietnam",
            "VU": "Vanuatu",
            "WF": "Wallis and Futuna Islands",
            "WS": "Samoa",
            "XK": "Kosovo",
            "YE": "Yemen",
            "YT": "Mayotte",
            "ZA": "South Africa",
            "ZM": "Zambia",
            "ZW": "Zimbabwe"
            }
        """.trimIndent()  //load countries from json file

        //varables to manage state
        val countries = remember { loadCountriesFromJson(jsonString) }
        var randomCountry by remember { mutableStateOf(countries.random()) } // Pick random country from list }

        var selectedCountry by remember { mutableStateOf<Country?>(null) }
        var isAnswerCorrect by remember { mutableStateOf(false) }
        var isSubmitClicked by remember { mutableStateOf(false) }
        var buttonLable by remember { mutableStateOf("Submit") }
        var timerValue by remember { mutableStateOf(10)}

        //countdown timer start if enabled
        if(countdownEnabled) {
            val timer = remember {  //intiallization timer
                object : CountDownTimer(10000, 1000) { //timer runs for 10 seconds with 1 second interval
                    override fun onTick(millisUntilFinished: Long) {        //call every tick of the timer
                        timerValue = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished).toInt()   //convert remaining time to miliseconds and update
                    }

                    //when timer finished
                    override fun onFinish() {
                        isSubmitClicked = true  //
                        isAnswerCorrect = selectedCountry == randomCountry   //check selected country match thr random country
                        buttonLable = "Next"  //set submit button label to next
                    }

                }
            }
            DisposableEffect(Unit) {
                timer.start()
                onDispose {
                    timer.cancel()
                }
            }
            //display countdown timer
            Text(
                text = "Timer : $timerValue",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp))
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ){
            Text(
                text = "Guess The Country",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            //Display the Country image
            //val flagDrawable = painterResource(id = R.drawable.ad) // ADD Randomize flag
            Image(
                painter = painterResource(id = getResourceId(randomCountry.code)),
                contentDescription = "flag image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))

            //Display country List in buttons
            LazyColumn (
                modifier = Modifier
                    .weight(1f)

            ){
                items(countries){country ->
                    Button(
                        onClick = {
                            selectedCountry = country //when user select button store it in selected country

                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(country.name)

                    }
                }
            }


            //Spacer(modifier = Modifier.height(16.dp))

            if (buttonLable == "Submit") {  //if button label is submit then user will allow to submit the answer and see the result
                Button(
                    onClick = {
                        if (selectedCountry != null) {
                            isSubmitClicked = true
                            isAnswerCorrect = selectedCountry == randomCountry //set

                        } else {
                            isSubmitClicked = false
                            selectedCountry = null

                        }
                    },
                    modifier = Modifier.align(CenterHorizontally)
                ) {
                    Text(text = buttonLable)
                }

            }else{  // when button change to "Next"
                Button(onClick = {

                    randomCountry = countries.random()  //select a random country
                    selectedCountry = null   //reset values
                    isAnswerCorrect = false  //reset values
                    isSubmitClicked = false  //reset values
                    buttonLable = "Submit"   //reset values
                    timerValue = 10
                },
                    modifier = Modifier.align(Alignment.CenterHorizontally) //Button align to the center
                ){

                    Text(text = buttonLable)  //button named as "Submit"
                }
            }

            // Display message only after the user submits an answer
            if (isSubmitClicked || timerValue == 0) { //Check if the submit button clicked
                //val message = if (isAnswerCorrect) "CORRECT! " else "WRONG! "
                if(isAnswerCorrect) {
                    buttonLable = "Next"
                    //val color = if (isAnswerCorrect) MaterialTheme.colors.primary else MaterialTheme.colors.error
                    Text(
                        text = "CORRECT!",
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)

                    )
                }else{
                    val correctCountryName = randomCountry.name //Assign Randomly Selected country name to the correctCountry name variable
                    buttonLable = "Next"
                    val message = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Red)){
                            append("WRONG!") //Display the "Wrong" in red
                        }
                        withStyle(style = SpanStyle(color = Color.Blue)){
                            append(correctCountryName) //Display the correct country name in blue
                        }
                    }
                    Text(
                        text = message,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }

        }
    }
}


fun getResourceId(code: String): Int{
    //Assuming image filename match the country code
    return when(code){
        "AD" -> R.drawable.ad
        "AE" -> R.drawable.af
        "AF" -> R.drawable.af
        "AG" -> R.drawable.ag
        "AI" -> R.drawable.ai
        "AL" -> R.drawable.al
        "AM" -> R.drawable.am
        "AO" -> R.drawable.ao
        "AQ" -> R.drawable.aq
        "AR" -> R.drawable.ar
        "AS" -> R.drawable.`as`
        "AT" -> R.drawable.at
        "AU" -> R.drawable.au
        "AW" -> R.drawable.aw
        "AX" -> R.drawable.ax
        "AZ" -> R.drawable.az
        "BA" -> R.drawable.ba
        "BB" -> R.drawable.bb
        "BD" -> R.drawable.bd
        "BE" -> R.drawable.be
        "BF" -> R.drawable.bf
        "BG" -> R.drawable.bg
        "BH" -> R.drawable.bh
        "BI" -> R.drawable.bi
        "BJ" -> R.drawable.bj
        "BL" -> R.drawable.bl
        "BM" -> R.drawable.bm
        "BN" -> R.drawable.bn
        "BO" -> R.drawable.bo
        "BQ" -> R.drawable.bq
        "BR" -> R.drawable.br
        "BS" -> R.drawable.bs
        "BT" -> R.drawable.bt
        "BV" -> R.drawable.bv
        "BW" -> R.drawable.bw
        "BY" -> R.drawable.by
        "BZ" -> R.drawable.bz
        "CA" -> R.drawable.ca
        "CC" -> R.drawable.cc
        "CD" -> R.drawable.cd
        "CF" -> R.drawable.cf
        "CG" -> R.drawable.cg
        "CH" -> R.drawable.ch
        "CI" -> R.drawable.ci
        "CK" -> R.drawable.ck
        "CL" -> R.drawable.cl
        "CM" -> R.drawable.cm
        "CN" -> R.drawable.cn
        "CO" -> R.drawable.co
        "CR" -> R.drawable.cr
        "CU" -> R.drawable.cu
        "CV" -> R.drawable.cv
        "CW" -> R.drawable.cw
        "CX" -> R.drawable.cx
        "CY" -> R.drawable.cy
        "CZ" -> R.drawable.cz
        "DE" -> R.drawable.de
        "DJ" -> R.drawable.dj
        "DK" -> R.drawable.dk
        "DM" -> R.drawable.dm
        "DZ" -> R.drawable.dz
        "EC" -> R.drawable.ec
        "EE" -> R.drawable.ee
        "EG" -> R.drawable.eg
        "EH" -> R.drawable.eh
        "ER" -> R.drawable.er
        "ES" -> R.drawable.es
        "ET" -> R.drawable.et
        "EU" -> R.drawable.eu
        "FI" -> R.drawable.fi
        "FJ" -> R.drawable.fj
        "FK" -> R.drawable.fk
        "FM" -> R.drawable.fm
        "FO" -> R.drawable.fo
        "FR" -> R.drawable.fr
        "GA" -> R.drawable.ga
        "GB-ENG" -> R.drawable.gb_eng
        "GB" -> R.drawable.gb
        "GD" -> R.drawable.gd
        "GE" -> R.drawable.ge
        "GF" -> R.drawable.gf
        "GG" -> R.drawable.gg
        "GH" -> R.drawable.gh
        "GI" -> R.drawable.gi
        "GL" -> R.drawable.gl
        "GM" -> R.drawable.gm
        "GN" -> R.drawable.gn
        "GP" -> R.drawable.gp
        "GQ" -> R.drawable.gq
        "GR" -> R.drawable.gr
        "GS" -> R.drawable.gs
        "GT" -> R.drawable.gt
        "GU" -> R.drawable.gu
        "GW" -> R.drawable.gw
        "GY" -> R.drawable.gy
        "HK" -> R.drawable.hk
        "HM" -> R.drawable.hm
        "HN" -> R.drawable.hn
        "HR" -> R.drawable.hr
        "HT" -> R.drawable.ht
        "HU" -> R.drawable.hu
        "ID" -> R.drawable.id
        "IE" -> R.drawable.ie
        "IL" -> R.drawable.il
        "IM" -> R.drawable.im
        "IN" -> R.drawable.`in`
        "IO" -> R.drawable.io
        "IQ" -> R.drawable.iq
        "IR" -> R.drawable.ir
        "IS" -> R.drawable.`is`
        "IT" -> R.drawable.it
        "JE" -> R.drawable.je
        "JM" -> R.drawable.jm
        "JO" -> R.drawable.jo
        "JP" -> R.drawable.jp
        "KE" -> R.drawable.ke
        "KG" -> R.drawable.kg
        "KH" -> R.drawable.kh
        "KI" -> R.drawable.ki
        "KM" -> R.drawable.km
        "KN" -> R.drawable.kn
        "KP" -> R.drawable.kp
        "KR" -> R.drawable.kr
        "KW" -> R.drawable.kw
        "KY" -> R.drawable.ky
        "KZ" -> R.drawable.kz
        "LA" -> R.drawable.la
        "LB" -> R.drawable.lb
        "LC" -> R.drawable.lc
        "LI" -> R.drawable.li
        "LK" -> R.drawable.lk
        "LR" -> R.drawable.lr
        "LS" -> R.drawable.ls
        "LT" -> R.drawable.lt
        "LU" -> R.drawable.lu
        "LV" -> R.drawable.lv
        "LY" -> R.drawable.ly
        "MA" -> R.drawable.ma
        "MC" -> R.drawable.mc
        "MD" -> R.drawable.md
        "ME" -> R.drawable.me
        "MF" -> R.drawable.mf
        "MG" -> R.drawable.mg
        "MH" -> R.drawable.mh
        "MK" -> R.drawable.mk
        "ML" -> R.drawable.ml
        "MM" -> R.drawable.mm
        "MN" -> R.drawable.mn
        "MO" -> R.drawable.mo
        "MP" -> R.drawable.mp
        "MQ" -> R.drawable.mq
        "MR" -> R.drawable.mr
        "MS" -> R.drawable.ms
        "MT" -> R.drawable.mt
        "MU" -> R.drawable.mu
        "MV" -> R.drawable.mv
        "MW" -> R.drawable.mw
        "MX" -> R.drawable.mx
        "MY" -> R.drawable.my
        "MZ" -> R.drawable.mz
        "NA" -> R.drawable.na
        "NC" -> R.drawable.nc
        "NE" -> R.drawable.ne
        "NF" -> R.drawable.nf
        "NG" -> R.drawable.ng
        "NI" -> R.drawable.ni
        "NL" -> R.drawable.nl
        "NO" -> R.drawable.no
        "NP" -> R.drawable.np
        "NR" -> R.drawable.nr
        "NU" -> R.drawable.nu
        "NZ" -> R.drawable.nz
        "OM" -> R.drawable.om
        "PA" -> R.drawable.pa
        "PE" -> R.drawable.pe
        "PF" -> R.drawable.pf
        "PG" -> R.drawable.pg
        "PH" -> R.drawable.ph
        "PK" -> R.drawable.pk
        "PL" -> R.drawable.pl
        "PM" -> R.drawable.pm
        "PN" -> R.drawable.pn
        "PR" -> R.drawable.pr
        "PS" -> R.drawable.ps
        "PT" -> R.drawable.pt
        "PW" -> R.drawable.pw
        "PY" -> R.drawable.py
        "QA" -> R.drawable.qa
        "RE" -> R.drawable.re
        "RO" -> R.drawable.ro
        "RS" -> R.drawable.rs
        "RU" -> R.drawable.ru
        "RW" -> R.drawable.rw
        "SA" -> R.drawable.sa
        "SB" -> R.drawable.sb
        "SC" -> R.drawable.sc
        "SD" -> R.drawable.sd
        "SE" -> R.drawable.se
        "SG" -> R.drawable.sg
        "SH" -> R.drawable.sh
        "SI" -> R.drawable.si
        "SJ" -> R.drawable.sj
        "SK" -> R.drawable.sk
        "SL" -> R.drawable.sl
        "SM" -> R.drawable.sm
        "SN" -> R.drawable.sn
        "SO" -> R.drawable.so
        "SR" -> R.drawable.sr
        "SS" -> R.drawable.ss
        "ST" -> R.drawable.st
        "SV" -> R.drawable.sv
        "SX" -> R.drawable.sx
        "SY" -> R.drawable.sy
        "SZ" -> R.drawable.sz
        "TC" -> R.drawable.tc
        "TD" -> R.drawable.td
        "TF" -> R.drawable.tf
        "TG" -> R.drawable.tg
        "TH" -> R.drawable.th
        "TJ" -> R.drawable.tj
        "TK" -> R.drawable.tk
        "TL" -> R.drawable.tl
        "TM" -> R.drawable.tm
        "TN" -> R.drawable.tn
        "TO" -> R.drawable.to
        "TR" -> R.drawable.tr
        "TT" -> R.drawable.tt
        "TV" -> R.drawable.tv
        "TW" -> R.drawable.tw
        "TZ" -> R.drawable.tz
        "UA" -> R.drawable.ua
        "UG" -> R.drawable.ug
        "UM" -> R.drawable.um
        "US" -> R.drawable.us
        "UY" -> R.drawable.uy
        "UZ" -> R.drawable.uz
        "VA" -> R.drawable.va
        "VC" -> R.drawable.vc
        "VE" -> R.drawable.ve
        "VG" -> R.drawable.vg
        "VI" -> R.drawable.vi
        "VN" -> R.drawable.vn
        "VU" -> R.drawable.vu
        "WF" -> R.drawable.wf
        "WS" -> R.drawable.ws
        "XK" -> R.drawable.xk
        "YE" -> R.drawable.ye
        "YT" -> R.drawable.yt
        "ZA" -> R.drawable.za
        "ZM" -> R.drawable.zm
        "ZW" -> R.drawable.zw


        else -> R.drawable.ao
    }
}

/*@Preview
@Composable
fun display(){
    GuessCountryApp()
}*/